/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Main Component to manage Showtimes updates
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.showtimes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import popt.data.Showtime;
import popt.dbaccess.MySQLAccess;

public class ShowtimesManager {
	
	private LinkedList<Showtime> comingShowtimes;
	private LinkedList<ShowtimeTicketing> ticketSelling;

	public ShowtimesManager() {
		comingShowtimes = new LinkedList<>();
		ticketSelling = new LinkedList<>();
		
		// initialize comingShowtimes
		generateShowtimesList();
	}
	
	/**
	 * Crea la lista degli spettacoli dei 3 giorni successivi
	 */
	private void generateShowtimesList() {
		
		DateFormat onlyDate = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + 86400000);
		Date afterTomorrow = new Date(tomorrow.getTime() + 86400000);
		
		MySQLAccess dba = new MySQLAccess();
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
		instantiateTicketSelling();
	}
	
	/**
	 * Crea, se necessario, le liste dei posti venduti per ogni proiezione
	 */
	private void instantiateTicketSelling() {
		for (Showtime show : comingShowtimes) {
			boolean isShowtimeAlreadyProcessed = false;
			for (ShowtimeTicketing ticketing : ticketSelling) {
				if (show.equals(ticketing.getShow())) {
					isShowtimeAlreadyProcessed = true;
					break;
				}
			}
			// if not already processed, create a ShowtimeTicketing object for the new Showtime
			if (!isShowtimeAlreadyProcessed) {
				ticketSelling.add(new ShowtimeTicketing(show));
			}
		}
	}

	/**
	 * Seleziona l'oggetto ShowtimeTicketing richiesto
	 * @param show - Proiezione di cui si vogliono trovare i dati di vendita
	 * @return i dati di vendita posti della proiezione (oggetto ShowtimeTicketing)
	 */
	public ShowtimeTicketing getTicketSelling(Showtime show) {
		ShowtimeTicketing selected = null;
		for (ShowtimeTicketing st : ticketSelling) {
			if (st.getShow().equals(show));
				selected = st;
		}
		return selected;
	}
}
