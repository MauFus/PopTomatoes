package popt.main_ticket;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import popt.data.CinemaHall;
import popt.data.Genre;
import popt.data.Movie;
import popt.data.Seat;
import popt.data.Showtime;

public class MainTicketingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testMain() {
		MainTicketing.main(null);
	}

	@Test
	public final void testGetCurrentShowtimeList() {
		assertNotNull(MainTicketing.getCurrentShowtimeList());
	}

	@Test
	public final void testGetShowtimeTicketing() {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		assertNotNull(MainTicketing.getShowtimeTicketing(s));
	}

	@Test
	public final void testSearchRaccomendedSeats() {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		assertNotNull(MainTicketing.searchRaccomendedSeats(s, 2));
	}

	@Test
	public final void testSearchSpecialSeats() {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		assertNotNull(MainTicketing.searchSpecialSeats(s, 2));
	}

	@Test
	public final void testSellSeats() {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		Seat[] seats = {new Seat(1, 2), new Seat(1, 3)};
		MainTicketing.sellSeats(s, seats);
	}

	@Test
	public final void testSellSPecialSeat() {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		MainTicketing.sellSpecialSeat(s, 1);
	}

}
