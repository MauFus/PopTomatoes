/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe per gestire la ricerca dei posti da vendere e la successiva registrazione della vendita
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.showtimes;

import popt.data.Row;
import popt.data.Seat;
import popt.data.SeatStatus;
import popt.data.Showtime;

public class SeatsAllocator {
	
	ShowtimesManager manager;

	public SeatsAllocator(ShowtimesManager mngr) {
		manager = mngr;
	}
	
	/**
	 * Ricerca posti da vendere per una proiezione
	 * @param show - Proiezione per cui si vogliono ottenere dei posti
	 * @param qta - numero di posti (adiacenti) da ricercare
	 * @return la lista di posti selezionati
	 */
	public Seat[] searchAvailableSeats(Showtime show, int qta) {

		Seat[] seatList = null;
		//ShowtimeTicketing ticketing = manager.getTicketSelling(show);
		// TODO ricerca posti tramite algoritmo
		return seatList;
	}
	
	/**
	 * registra la vendita di una serie di posto
	 * @param show
	 * @param seats
	 */
	public void sellSeat(Showtime show, Seat[] seats) {
		for (Seat s : seats) {
			manager.getTicketSelling(show).setSeat(s.getRow(), s.getSeat(), SeatStatus.OCCUPATO);
		}
	}
	
	/**
	 * registra la prenotazione di una serie di posti
	 * @param show
	 * @param seats
	 */
	public void reserveSeat(Showtime show, Seat[] seats) {
		for (Seat s : seats) {
			manager.getTicketSelling(show).setSeat(s.getRow(), s.getSeat(), SeatStatus.PRENOTATO);
		}
	}
	
	/**
	 * registra la vendita di posti precedentemente prenotati
	 * @param show
	 * @param seats
	 */
	public void withdrawSeat(Showtime show, Seat[] seats) {
		for (Seat s : seats) {
			if (manager.getTicketSelling(show).getSeatsRow(s.getRow()).getStatus()[s.getSeat()].equals(SeatStatus.PRENOTATO))
				manager.getTicketSelling(show).setSeat(s.getRow(), s.getSeat(), SeatStatus.OCCUPATO);
		}
	}
	
	/**
	 * elimina tutte le prenotazioni non ritirate
	 * @param show
	 */
	public void removeReservations(Showtime show) {
		for (Row r : manager.getTicketSelling(show).getSeatsStatus()) {
			for (int i = 0; i < r.getStatus().length; i++)
				if (r.getStatus()[i].equals(SeatStatus.PRENOTATO))
					r.getStatus()[i] = SeatStatus.LIBERO;
		}
		
	}
}
