/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe per rappresentare la lista di posti con stato (venduto, libero, prenotato) e relativo valore (per assegnamento)
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.showtimes;

import java.util.LinkedList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import popt.data.Row;
import popt.data.SeatStatus;
import popt.data.Showtime;
import popt.dbaccess.MySQLAccess;

public class ShowtimeTicketing {

	private Showtime show;
	private LinkedList<Row> sellingStatus;
	private SeatStatus[] specialSeatsStatus;
	private int valueMatrix[][];
	
	public ShowtimeTicketing() {
		
	}
	
	public ShowtimeTicketing(Showtime showtime) {
		show = showtime;
		findAvailableSeats();
		valueMatrix = new int[show.getHall().getnRows()][maxSeatsPerRow(sellingStatus)];
		specialSeatsStatus = new SeatStatus[show.getHall().getSpecialSeats()];
		for (int s = 0; s < specialSeatsStatus.length; s++)
			specialSeatsStatus[s] = SeatStatus.LIBERO;
		computeValueMatrix();
	}

	/**
	 * Trova informazioni su disposizione dei posti nella sala (file, etc.)
	 */
	private void findAvailableSeats() {
		MySQLAccess dba = new MySQLAccess();
		try {
			// search in DB the rows that belong to the cinemaHall
			dba.readDB();
			LinkedList<Row> foundRows = dba.searchHallSeats(show.getHall().getId());
			dba.closeDB();
			
			// save available seats found
			setSellingStatus(foundRows);
			if (!sellingStatus.isEmpty()) {
				for (Row row : sellingStatus) {
					for (int r = 0; r < row.getSeats(); r++)
						row.setStatus(r, SeatStatus.LIBERO);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Trova la fila con più posti
	 * @param rows le file di posti di una sala
	 * @return il numero di posti massimi in una fila
	 */
	private int maxSeatsPerRow(LinkedList<Row> rows) {
		int max = 0;
		if (!rows.isEmpty()) {
			for (Row row : rows) {
				if (row.getSeats() > max)
					max = row.getSeats();
			}
		}
		return max;
	}

	public Showtime getShow() {
		return show;
	}

	public void setShow(Showtime show) {
		this.show = show;
	}

	public LinkedList<Row> getSellingStatus() {
		return sellingStatus;
	}

	public void setSellingStatus(LinkedList<Row> seatStatus) {
		this.sellingStatus = seatStatus;
	}
	
	public Row getSeatsRow(int number) {
		if (!sellingStatus.isEmpty()) {
			for (Row row : sellingStatus) {
				if (row.getNumber() == number)
					return row;
			}
		}
		return null;
	}
	
	public SeatStatus[] getSpecialSeatsStatus() {
		return specialSeatsStatus;
	}

	/**
	 * Setta lo stato di uno dei posti speciali
	 * @param specialSeat - indice del posto nel vettore (Numero Posto -1)
	 * @param status - stato LIBERO o OCCUPATO
	 */
	public void setSpecialSeatsStatus(int specialSeat, SeatStatus status) {
		this.specialSeatsStatus[specialSeat] = status;
	}

	/**
	 * setta lo stato di un posto particolare
	 * @param row - fila
	 * @param seat - posto (indice all'interno del vettore = Numero di Posto -1)
	 * @param status - stato da settare
	 */
	public void setSeat(int row, int seat, SeatStatus status) {
		if (!sellingStatus.isEmpty()) {
			for (Row r : sellingStatus) {
				if (r.getNumber() == row && seat < r.getSeats()) {
					r.setStatus(seat, status);
					updateSeatValue(row-1, seat, status);
					return;
				}
			}
		}
		System.out.println("Errore: Posto non trovato");
	}

	public int[][] getValueMatrix() {
		return valueMatrix;
	}
	
	/**
	 * Aggiorna il valore di un posto e dei 2 adiacenti
	 * @param row - Il numero di fila - 1
	 * @param seat - Il numero del posto - 1
	 * @param value - stato LIBERO o OCCUPATO
	 */
	public void updateSeatValue(int row, int seat, SeatStatus value) {
		if (value.equals(SeatStatus.OCCUPATO)) {
			valueMatrix[row][seat] = 0;
			if (seat != 0)
				valueMatrix[row][seat-1] *= 1.2;
			if (seat != valueMatrix[row].length)
				valueMatrix[row][seat+1] *= 1.2;
		} else if (value.equals(SeatStatus.LIBERO)) {
			computeValueMatrix();
		}
	}
	
	/**
	 * Funzione che calcola la matrice dei valori dei posti in sala
	 * Nota - Il valore dei singoli posti è necessario per determinare la soluzione
	 * migliore in fase di assegnamento degli stessi ai clienti.
	 * Il valore è calcolato secondo criteri empiri, basati sulla posizione in sala di 
	 * ciascun posto e sulla posizione dei posti già venduti.
	 */
	private void computeValueMatrix() {
		// Numero di file in sala (anche righe in matrice)
		int nRows = sellingStatus.size();
		// Numero posti per ciascuna file (colonne utili per riga della matrice)
		int[] seatsPerRow = new int[nRows];
		for (int i = 0; i < nRows; i++)
			seatsPerRow[i] = sellingStatus.get(i).getSeats();
		
		// Assegnamento valore 1 a posti liberi, 0 a posti occupati (o inesistenti)
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < valueMatrix[i].length; j++) {
				if (j < seatsPerRow[i]) {
					if (sellingStatus.get(i).getStatus()[j].equals(SeatStatus.LIBERO))
						valueMatrix[i][j] = 1;
					else
						valueMatrix[i][j] = 0;
				} else
					valueMatrix[i][j] = 0;
			}
		}
		
		// Moltiplicazione del valore in base alla fila
		// Utilizza la funzione y = x*sin(2.3*x)
		for (int i = 0; i < nRows; i++) {
			double relPos = (i + 1) / nRows;
			int fact = (int) (20 * relPos * Math.sin(relPos * 2.3));
			for (int j = 0; j < seatsPerRow[i]; j++)
				valueMatrix[i][j] *= fact;
		}
		
		// Moltiplicazione del valore in base alla posizione in fila (centrale ha valore maggiore)
		// Utilizza la funzione y = sin(x)
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < seatsPerRow[i]; j++) {
				double relPos = ((Math.PI - 1) * j / (seatsPerRow[i] - 1)) + 0.5;
				int fact = (int) (20 * Math.sin(relPos));
				valueMatrix[i][j] *= fact;
			}
		}
		
		// Bonus di valore a posti adiacenti a posti già venduti
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < seatsPerRow[i]; j++) {
				if (valueMatrix[i][j] == 0){
					if (j != 0)
						valueMatrix[i][j-1] *= 1.2; // Abbondo
					if (j != (seatsPerRow[i] - 1))
						valueMatrix[i][j+1] *= 1.2;
				}
			}
		}
		
		// Test
		System.out.println(valueMatrix);
	}
	
	/**
	 * Calculate the number of occupied seats
	 * @return that number
	 */
	public int getAuditors() {
		int auditors = 0;
		if (!sellingStatus.isEmpty()) {
			for (Row row : sellingStatus) {
				for (int i = 0; i < row.getStatus().length; i++) {
					if (row.getStatus()[i].equals(SeatStatus.OCCUPATO))
						auditors++;
				}
			}
		}
		if (specialSeatsStatus.length > 0) {
			for (int j = 0; j < specialSeatsStatus.length; j++) {
				if (specialSeatsStatus[j].equals(SeatStatus.OCCUPATO))
					auditors++;
			}
		}
		return auditors;
	}

	/**
	 * Crea un elemento DOM dell'oggetto, per essere inserito in un file XML
	 * @param document - il documento dom in cui viene costruito l'oggetto DOM
	 * @return l'elemento generato
	 */
	public Element getXMLform(Document document) {
		Element showTickets = document.createElement("ShowtimeTickets");
		showTickets.appendChild(document.createElement("Showtime")).setTextContent(Long.toString(show.getId()));
		
		Element rowList = document.createElement("RowList");
		if (!sellingStatus.isEmpty()) {
			for (Row row : sellingStatus) {
				Element rowElement = document.createElement("Row");
				rowElement.setAttribute("number", Integer.toString(row.getNumber()));
				rowElement.setAttribute("seats", Integer.toString(row.getSeats()));
				for (int i = 0; i < row.getSeats(); i++)
					rowElement.appendChild(document.createElement("Seat")).setTextContent(row.getStatus()[i].toString());

				rowList.appendChild(rowElement);
			}
		}
		showTickets.appendChild(rowList);
		
		Element specialSeats = document.createElement("SpecialList");
		if (specialSeatsStatus.length > 0) {
			for (int i = 0; i < specialSeatsStatus.length; i++)
				specialSeats.appendChild(document.createElement("SpecialSeat")).setTextContent(specialSeatsStatus[i].toString());
		}
		showTickets.appendChild(specialSeats);
		
		return showTickets;
	}
}
