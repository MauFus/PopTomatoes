package popt.showtimes;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import popt.data.CinemaHall;
import popt.data.Genre;
import popt.data.Movie;
import popt.data.Seat;
import popt.data.Showtime;

public class SeatsAllocatorImplTest {
	
	ShowtimesManager manager;
	SeatsAllocatorImpl allocator;

	@Before
	public void setUp() throws Exception {
		manager = new ShowtimesManager();
		allocator = new SeatsAllocatorImpl(manager);
	}

	@Test
	public final void testSearchAvailableSeats() throws RemoteException {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		assertNotNull(allocator.searchAvailableSeats(s, 2));
	}

	@Test
	public final void testSearchAvailableSpecialSeats() throws RemoteException {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		assertNotNull(allocator.searchAvailableSpecialSeats(s, 2));
	}

	@Test
	public final void testSellSeat() throws RemoteException {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		Seat[] seats = {new Seat(1, 1), new Seat(1, 2)};
		assertTrue(allocator.sellSeat(s, seats));
	}

	@Test
	public final void testSellSpecialSeat() throws RemoteException {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		assertTrue(allocator.sellSpecialSeat(s, 1));
	}

	@Test
	public final void testGetComingShowtimesList() throws RemoteException {
		assertEquals(3, allocator.getComingShowtimesList().size());
	}

	@Test
	public final void testGetTicketingStatus() throws RemoteException {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		assertNotNull(allocator.getTicketingStatus(s));
	}

}
