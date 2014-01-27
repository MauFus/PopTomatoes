/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Main Component to manage Showtimes updates
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.showtimes;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import popt.data.Row;
import popt.data.SeatStatus;
import popt.data.Showtime;
import popt.dbaccess.MySQLAccess;

public class ShowtimesManager {
	
	private LinkedList<Showtime> comingShowtimes;
	private LinkedList<ShowtimeTicketing> ticketSelling;

	public static final String TICKET_SELLING = "ticketselling.xml";

	public ShowtimesManager() {
		comingShowtimes = new LinkedList<>();
		ticketSelling = new LinkedList<>();

		// carica da file lo stato della vendita biglietti
		loadTicketingList();
		// initialize comingShowtimes
		updateComingShowtimes();
	}
	
	/**
	 * Crea la lista degli spettacoli dei 3 giorni successivi
	 * ed invoca l'aggiornamento delle tabelle di vendita dei biglietti
	 * per i singoli spettacoli
	 */
	private void updateComingShowtimes() {
		MySQLAccess dba = new MySQLAccess();
		
		DateFormat onlyDate = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + 86400000);
		Date afterTomorrow = new Date(tomorrow.getTime() + 86400000);
		
		// Azzera la lista
		comingShowtimes = new LinkedList<>();
		
		try {
			dba.readDB();
			// add to the list all the showtimes scheduled in the next 3 days
			comingShowtimes.addAll(dba.searchShowtimes(0, null, null, onlyDate.format(today), ""));
			comingShowtimes.addAll(dba.searchShowtimes(0, null, null, onlyDate.format(tomorrow), ""));
			comingShowtimes.addAll(dba.searchShowtimes(0, null, null, onlyDate.format(afterTomorrow), ""));
			dba.closeDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// update ticketSelling w/ new showtimes
		updateSellingList();
		
		// Delay corrisponde al tempo mancante alle ore 3:00 del giorno successivo
		long delay = 86400000 - (today.getTime() % 86400000) + 1080000;
		// Rischedula l'update per il giorno successivo alla 3:00
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				updateComingShowtimes();
			}
		}, delay);
	}
	
	/**
	 * Aggiorna la lista delle tabelle di ticketing per le prossime proiezioni
	 */
	public void updateSellingList() {
		// Crea, se necessario, le liste dei posti venduti per ogni proiezione
		if (!comingShowtimes.isEmpty()) {
			for (Showtime show : comingShowtimes) {
				boolean isShowtimeAlreadyProcessed = false;
				if (!ticketSelling.isEmpty()) {
					for (ShowtimeTicketing ticketing : ticketSelling) {
						if (show.equals(ticketing.getShow())) {
							isShowtimeAlreadyProcessed = true;
							break;
						}
					}
				}
				// if not already processed, create a ShowtimeTicketing object for the new Showtime
				if (!isShowtimeAlreadyProcessed)
					ticketSelling.add(new ShowtimeTicketing(show));
			}
		}
		
		// Elimina le liste non più necessarie
		if (!ticketSelling.isEmpty()) {
			for (ShowtimeTicketing iterator : ticketSelling) {
				boolean isComingShow = false;
				if (!comingShowtimes.isEmpty()) {
					for (Showtime show : comingShowtimes) {
						if (show.equals(iterator.getShow())) {
							isComingShow = true;
							break;
						}
					}
				}
				if (!isComingShow) {
					MySQLAccess dba = new MySQLAccess();
					try {
						dba.readDB();
						dba.updateShowtimeAuditors(iterator.getShow().getId(), iterator.getAuditors());
						dba.closeDB();
					} catch (Exception e) {
						e.printStackTrace();
					}
					ticketSelling.remove(iterator);
				}
			}
		}
		
		// Fa backup su file XML delle liste
		saveTicketingList();
	}
	
	/**
	 * Salva su file XML l'attuale stato di vendita dei biglietti per tutte le proiezioni
	 * la cui vendita dei biglietti è attivata
	 * @return true se l'operazione ha successo, false altrimenti
	 */
	public boolean saveTicketingList() {
		try {
			// create a new xml document
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);
			dbf.setNamespaceAware(false);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.newDocument();
			Element radix = document.createElement("Ticketing");
			
			if (!ticketSelling.isEmpty()) {
				for (ShowtimeTicketing show : ticketSelling) {
					radix.appendChild(show.getXMLform(document));
				}
			}
			document.appendChild(radix);
			
			// save the document to file
	        DOMImplementationLS ls = (DOMImplementationLS)document.getImplementation();
	        LSOutput lso = ls.createLSOutput();
			LSSerializer lss = ls.createLSSerializer();
			lso.setCharacterStream(new FileWriter(TICKET_SELLING));
			lso.setEncoding("ISO-8859-1");
			// Formatta l'output aggiungendo spazi per produrre una stampa
			// "graziosa" (pretty-print) e indentata
			lss.getDomConfig().setParameter("format-pretty-print", true);
			lss.write(document, lso);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Carica in memoria lo stato della vendita di biglietti per ciascuna proiezione
	 * di cui è attiva la vendita
	 * @return true se non ci sono errori
	 */
	private boolean loadTicketingList() {
		try {
			ticketSelling = new LinkedList<>();
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(false);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(new File(TICKET_SELLING));
			
			NodeList temp = document.getElementsByTagName("ShowtimeTickets");
			for (int j = 0; j < temp.getLength(); j++) {
				try {
					ShowtimeTicketing ticketing = new ShowtimeTicketing();
					MySQLAccess dba = new MySQLAccess();
					long id = Long.parseLong(((Element) temp.item(j)).getElementsByTagName("Showtime").item(0).getTextContent());
					dba.readDB();
					ticketing.setShow(dba.searchShowtimes(id, null, null, "", "").getFirst());
					dba.closeDB();
					
					NodeList rows = ((Element) temp.item(j)).getElementsByTagName("Row");
					for (int r = 0; r < rows.getLength(); r++) {
						Row newRow = new Row();
						newRow.setNumber(Integer.parseInt(((Element)rows.item(r)).getAttribute("number")));
						newRow.setSeats(Integer.parseInt(((Element)rows.item(r)).getAttribute("seat")));
						NodeList seats = ((Element)rows.item(r)).getElementsByTagName("Seat");
						for (int s = 0; s < seats.getLength(); s++) {
							newRow.setStatus(s, SeatStatus.valueOf(((Element)seats.item(s)).getTextContent()));
						}
						ticketing.getSellingStatus().add(newRow);
					}
					
					NodeList specials = ((Element)temp.item(j)).getElementsByTagName("SpecialList");
					SeatStatus[] specialStatus = new SeatStatus[ticketing.getShow().getHall().getSpecialSeats()];
					for (int s = 0; s < specialStatus.length; s++)
						ticketing.setSpecialSeatsStatus(s, SeatStatus.valueOf(((Element)specials.item(s)).getTextContent()));
					
					ticketSelling.add(ticketing);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return true;
		} catch (Exception e) {
			System.out.println("Loading not executed");
			return false;
		}
	}

	/**
	 * Seleziona l'oggetto ShowtimeTicketing richiesto
	 * @param show - Proiezione di cui si vogliono trovare i dati di vendita
	 * @return i dati di vendita posti della proiezione (oggetto ShowtimeTicketing)
	 */
	public ShowtimeTicketing getTicketSelling(Showtime show) {
		System.out.println(show.getId() + " " + show.getMovie().getTitle());
		ShowtimeTicketing selected = null;
		if (!ticketSelling.isEmpty()) {
			System.out.println("entro");
			for (ShowtimeTicketing st : ticketSelling) {
				System.out.println(st.getShow().getId());
				if (st.getShow().equals(show)){
				System.out.println("selected");
				selected = st;}
			}
		}
		System.out.println("Ticketing richiesto: " + selected.getShow().getId() + " " + selected.getShow().getMovie().getTitle());
		return selected;
	}

	/**
	 * @return the comingShowtimes
	 */
	public LinkedList<Showtime> getComingShowtimes() {
		return comingShowtimes;
	}
}
