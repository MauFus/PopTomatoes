package popt.main_ticket;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import popt.data.CinemaHall;
import popt.data.Genre;
import popt.data.Movie;
import popt.data.Seat;
import popt.data.Showtime;

public class TicketPrinterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testTicketPrinter() {
		
	}

	@Test
	public final void testPrint() {
		Showtime s = new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40");
		TicketPrinter printer = new TicketPrinter(s, new Seat(1, 2));
		assertTrue(printer.print());
	}

}
