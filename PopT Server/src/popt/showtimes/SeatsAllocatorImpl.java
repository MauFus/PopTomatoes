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

import popt.data.Row;
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
		OptimalSeatsAlgorithm algo = new OptimalSeatsAlgorithm();
		LinkedList<Seat> result = algo.execute(manager.getTicketSelling(show).getValueMatrix(), qta);
		manager.getTicketSelling(show).computeValueMatrix();
		Seat[] seatList = new Seat[result.size()];
		for (int i = 0; i < result.size(); i++)
			seatList[i] = result.get(i);
		return seatList;
	}

	@Override
	public int[] searchAvailableSpecialSeats(Showtime show, int qta) throws RemoteException {
		SeatStatus[] status = manager.getTicketSelling(show).getSpecialSeatsStatus();
		int[] result = new int[qta];
		int count = 0;
		for (int i = 0; i < status.length; i++) {
			if (status[i].equals(SeatStatus.LIBERO)) {
				result[count] = i+1;
				count++;
				if (count == qta)
					return result;
			}
		}
		return null;
	}
	
	@Override
	public boolean sellSeat(Showtime show, Seat[] seats) throws RemoteException {
		for (Seat s : seats) {
			manager.getTicketSelling(show).setSeat(s.getRow(), s.getSeat() - 1, SeatStatus.OCCUPATO);
		}
		manager.saveTicketingList();
		return true;
	}

	@Override
	public boolean sellSpecialSeat(Showtime show, int seat) throws RemoteException {
		if (seat < show.getHall().getSpecialSeats()+1)
			manager.getTicketSelling(show).setSpecialSeatsStatus(seat, SeatStatus.OCCUPATO);
		manager.saveTicketingList();
		return true;
	}

	@Override
	public LinkedList<Showtime> getComingShowtimesList() throws RemoteException {
		return manager.getComingShowtimes();
	}

	@Override
	public LinkedList<Row> getTicketingStatus(Showtime showtime)
			throws RemoteException {
		return manager.getTicketSelling(showtime).getSellingStatus();
	}
}
