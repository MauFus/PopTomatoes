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

import popt.data.Row;
import popt.data.Seat;
import popt.data.Showtime;
import popt.dbaccess.MySQLAccess;

public class ShowtimeTicketing {

	private Showtime show;
	private LinkedList<Row> seatsStatus;
	private int seatsValue[][];
	
	public ShowtimeTicketing() {
		
	}
	
	public ShowtimeTicketing(Showtime showtime) {
		show = showtime;
		findAvailableSeats();
		seatsValue = new int[show.getHall().getnRows()][maxSeatsPerRow(seatsStatus)];
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
			setSeatsStatus(foundRows);
			for (Row row : seatsStatus) {
				for (int r = 0; r < row.getSeats(); r++)
					row.setStatus(r, Seat.LIBERO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		for (Row row : rows) {
			if (row.getSeats() > max)
				max = row.getSeats();
		}
		return max;
	}

	public Showtime getShow() {
		return show;
	}

	public void setShow(Showtime show) {
		this.show = show;
	}

	public LinkedList<Row> getSeatsStatus() {
		return seatsStatus;
	}

	public void setSeatsStatus(LinkedList<Row> seatStatus) {
		this.seatsStatus = seatStatus;
	}
	
	public Row getSeatsRow(int number) {
		for (Row row : seatsStatus) {
			if (row.getNumber() == number)
				return row;
		}
		return null;
	}
	
	/**
	 * setta lo stato di un posto particolare
	 * @param row - fila
	 * @param seat - posto
	 * @param status - stato da settare
	 */
	public void setSeat(int row, int seat, Seat status) {
		for (Row r : seatsStatus) {
			if (r.getNumber() == row && seat < r.getSeats()) {
				r.setStatus(seat, status);
				return;
			}
		}
		System.out.println("Errore: Posto non trovato");
	}

	public int[][] getSeatsValue() {
		return seatsValue;
	}
	
	public void setSeatValue(int row, int seat, int value) {
		seatsValue[row][seat] = value;
	}
}
