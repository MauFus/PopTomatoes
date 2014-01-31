package popt.ctrl_ticket;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import popt.data.Row;
import popt.data.SeatStatus;
import popt.gui_ticket.TicketSellView;
import popt.model_ticket.TicketSellModel;

public class TicketSellControllerTest {
	
	TicketSellController ctr;

	@Before
	public void setUp() throws Exception {
		TicketSellModel model = new TicketSellModel();
		TicketSellView view = new TicketSellView();
		ctr = new TicketSellController(model, view);
	}

	@Test
	public final void testOrderRows() {
		LinkedList<Row> rows = new LinkedList<>();
		rows.add(new Row(2, 5));
		rows.add(new Row(1, 5));
		LinkedList<Row> ordered = ctr.orderRows(rows);
		assertEquals(1, ordered.getFirst().getNumber());
	}

	@Test
	public final void testMaxNumber() {
		LinkedList<Row> rows = new LinkedList<>();
		rows.add(new Row(2, 5));
		rows.add(new Row(1, 5));
		assertEquals(2, ctr.maxNumber(rows));
	}

	@Test
	public final void testResetInterface() {
		assertTrue(ctr.resetInterface());
	}

	@Test
	public final void testGetModel() {
		assertNotNull(ctr.getModel());
	}

	@Test
	public final void testGetView() {
		assertNotNull(ctr.getView());
	}
	
	@Test
	public final void diplayTicketingStatusTest() {
		SeatStatus[] status = {SeatStatus.LIBERO, SeatStatus.OCCUPATO, SeatStatus.OCCUPATO, SeatStatus.LIBERO, SeatStatus.LIBERO};
		SeatStatus[] status2 = {SeatStatus.LIBERO, SeatStatus.LIBERO, SeatStatus.OCCUPATO, SeatStatus.OCCUPATO, SeatStatus.LIBERO};
		LinkedList<Row> rows = new LinkedList<>();
		rows.add(new Row(2, 5, status));
		rows.add(new Row(1, 5, status2));
		assertTrue(ctr.diplayTicketingStatus(rows));
	}

}
