package popt.showtimes;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import popt.data.CinemaHall;
import popt.data.Genre;
import popt.data.Movie;
import popt.data.Row;
import popt.data.SeatStatus;
import popt.data.Showtime;

public class ShowtimeTicketingTest {

	ShowtimeTicketing st;

	@Before
	public void setUp() throws Exception {
		st = new ShowtimeTicketing(new Showtime(253, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
					new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40"));
	}
	
	@Test
	public final void testGetShow() {
		assertEquals(((Showtime)st.getShow()).getId(), 253);
	}

	@Test
	public final void testSetShow() {
		st.setShow(null);
		assertNull(st.getShow());
	}

	@Test
	public final void testSetSellingStatus() {
		LinkedList<Row> status = new LinkedList<>();
		for (int i = 0; i < 5; i++)
			status.add(new Row(i+1, 8));
		st.setSellingStatus(status);
		assertEquals(5, st.getSellingStatus().size());
	}

	@Test
	public final void testGetSellingStatus() {
		assertNotEquals(0, st.getSellingStatus().size());
	}

	@Test
	public final void testGetSeatsRow() {
		assertNotNull(st.getSeatsRow(1));
	}

	@Test
	public final void testGetSpecialSeatsStatus() {
		assertNotEquals(0, st.getSpecialSeatsStatus().length);
	}

	@Test
	public final void testSetSpecialSeatsStatus() {
		assertTrue(st.setSpecialSeatsStatus(1, SeatStatus.LIBERO));
	}

	@Test
	public final void testSetSeat() {
		assertFalse(st.setSeat(0, 2, SeatStatus.LIBERO));
	}

	@Test
	public final void testGetValueMatrix() {
		assertNotNull(st.getValueMatrix());
	}

	@Test
	public final void testUpdateSeatValue() {
		st.updateSeatValue(0, 0, SeatStatus.OCCUPATO);
		assertEquals(0, st.getValueMatrix()[0][0]);
	}

	@Test
	public final void testGetAuditors() {
		assertEquals(0, st.getAuditors());
	}

}
