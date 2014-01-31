package popt.model_ticket;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import popt.data.CinemaHall;
import popt.data.Genre;
import popt.data.Movie;
import popt.data.Row;
import popt.data.Seat;
import popt.data.Showtime;

public class TicketSellModelTest {
	
	TicketSellModel model;

	@Before
	public void setUp() throws Exception {
		model = new TicketSellModel();
	}

	@Test
	public final void testGetComingShowtimes() {
		assertEquals(0, model.getComingShowtimes().size());
	}

	@Test
	public final void testSetComingShowtimes() {
		LinkedList<Showtime> list = new LinkedList<>();
		list.add(new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40"));
		model.setComingShowtimes(list);
		assertEquals(1, model.getComingShowtimes().size());
	}

	@Test
	public final void testGetCurrentShowtime() {
		assertNotNull(model.getCurrentShowtime());
	}

	@Test
	public final void testSetCurrentShowtime() {
		model.setCurrentShowtime(new Showtime(10001, new Movie("Gattaca", 125, "25-10-2005", Genre.SCI_FI, false),
				new CinemaHall('B', "Sala MANDRA", 15, 236, 4), "26-01-2014", "18:40"));
		assertEquals(model.getCurrentShowtime().getId(), 10001);
	}

	@Test
	public final void testGetRowList() {
		assertEquals(0, model.getRowList().size());
	}

	@Test
	public final void testSetRowList() {
		LinkedList<Row> rows = new LinkedList<>();
		rows.add(new Row());
		model.setRowList(rows);
		assertEquals(1, model.getRowList().size());
	}

	@Test
	public final void testGetTotSeats() {
		assertEquals(0, model.getTotSeats());
	}

	@Test
	public final void testSetTotSeats() {
		model.setTotSeats(5);
		assertEquals(5, model.getTotSeats());
	}

	@Test
	public final void testGetSolutionIndex() {
		assertEquals(0, model.getSolutionIndex());
	}

	@Test
	public final void testSetSolutionIndex() {
		model.setSolutionIndex(3);
		assertEquals(3, model.getSolutionIndex());
	}

	@Test
	public final void testGetSolution1() {
		assertNull(model.getSolution1());
	}

	@Test
	public final void testSetSolution1() {
		Seat[] seats = {new Seat(1, 2), new Seat(1, 3)};
		model.setSolution1(seats);
		assertEquals(3, model.getSolution1()[1].getSeat());
	}

	@Test
	public final void testGetSolution2() {
		assertNull(model.getSolution2());
	}

	@Test
	public final void testSetSolution2() {
		Seat[] seats = {new Seat(1, 4), new Seat(1, 5)};
		model.setSolution2(seats);
		assertEquals(5, model.getSolution2()[1].getSeat());
	}

	@Test
	public final void testGetSolutionCustom() {
		assertEquals(0, model.getSolutionCustom().size());
	}

	@Test
	public final void testSetSolutionCustom() {
		LinkedList<Seat> list = new LinkedList<>();
		list.add(new Seat(1,2));
		model.setSolutionCustom(list);
		assertEquals(1, model.getSolutionCustom().size());
	}

	@Test
	public final void testGetSpecialSeats() {
		assertEquals(0, model.getSpecialSeats());
	}

	@Test
	public final void testSetSpecialSeats() {
		model.setSpecialSeats(2);
		assertEquals(2, model.getSpecialSeats());
	}

	@Test
	public final void testGetSpecialSolution() {
		assertNull(model.getSpecialSolution());
	}

	@Test
	public final void testSetSpecialSolution() {
		int[] s = {1};
		model.setSpecialSolution(s);
		assertEquals(1, model.getSpecialSolution().length);
	}

}
