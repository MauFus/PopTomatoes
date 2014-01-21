/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe per gestire la ricerca dei posti da vendere e la successiva registrazione della vendita
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.showtimes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

import popt.data.Seat;
import popt.data.SeatStatus;
import popt.data.Showtime;
import popt.rmi.SeatsAllocator;

public class SeatsAllocatorImpl extends UnicastRemoteObject implements SeatsAllocator {
	
	private static final long serialVersionUID = -2720010284538434871L;
	private ShowtimesManager manager;

	public SeatsAllocatorImpl(ShowtimesManager mngr) throws RemoteException {
		super();
		manager = mngr;
	}
	
	@Override
	public Seat[] searchAvailableSeats(Showtime show, int qta) throws RemoteException{
		
		LinkedList<Seat> result = OptimalSeatsAlgorithm.execute(manager.getTicketSelling(show).getSeatsValue(), qta);
		Seat[] seatList = new Seat[result.size()];
		for (int i = 0; i < result.size(); i++)
			seatList[i] = result.get(i);
		return seatList;
	}
	
	@Override
	public void sellSeat(Showtime show, Seat[] seats) throws RemoteException {
		for (Seat s : seats) {
			manager.getTicketSelling(show).setSeat(s.getRow(), s.getSeat()-1, SeatStatus.OCCUPATO);
		}
	}
}
