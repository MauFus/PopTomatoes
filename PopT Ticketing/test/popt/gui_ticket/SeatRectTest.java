package popt.gui_ticket;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import popt.model_ticket.RectStatus;

public class SeatRectTest {
	
	SeatRect rect;

	@Before
	public void setUp() throws Exception {
		rect = new SeatRect(4, 3);
	}

	@Test
	public final void testSeatRect() {
		assertNotNull(new SeatRect(2, 1));
		assertNotNull(new RowPanel());
	}

	@Test
	public final void testGetStatus() {
		assertEquals(RectStatus.BUSY, rect.getStatus());
	}

	@Test
	public final void testSetStatus() {
		rect.setStatus(RectStatus.SUGGESTED);
		rect.setStatus(RectStatus.CHECKED);
		rect.setStatus(RectStatus.BUSY);
		rect.setStatus(RectStatus.FREE);
		assertEquals(RectStatus.FREE, rect.getStatus());
	}

	@Test
	public final void testIsSuggest() {
		assertFalse(rect.isSuggest());
	}

	@Test
	public final void testSetSuggest() {
		rect.setSuggest(true);
		assertTrue(rect.isSuggest());
	}

	@Test
	public final void testGetRowNumber() {
		assertEquals(4, rect.getRowNumber());
	}

	@Test
	public final void testGetSeatNumber() {
		assertEquals(3, rect.getSeatNumber());
	}

}
