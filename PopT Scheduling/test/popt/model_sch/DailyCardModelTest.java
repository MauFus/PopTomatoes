package popt.model_sch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DailyCardModelTest {
	
	DailyCardModel card;

	@Before
	public void setUp() throws Exception {
		card = new DailyCardModel();
	}

	@Test
	public final void testGetValidated() {
		card.setValidated(1);
		assertEquals(1, card.getValidated());
	}

	@Test
	public final void testGetGap() {
		card.setGap(30);
		assertEquals(30, card.getGap());
	}

	@Test
	public final void testGetOpening() {
		card.setOpening(15);
		assertEquals(15, card.getOpening());
	}

	@Test
	public final void testGetClosing() {
		card.setClosing(23);
		assertEquals(23, card.getClosing());
	}

	@Test
	public final void testGetDate() {
		card.setDate("10-10-2010");
		assertEquals("10-10-2010", card.getDate());
	}

	@Test
	public final void testGetMovieList() {
		assertNotNull(card.getMovieList());
	}

	@Test
	public final void testGetHallList() {
		assertNotNull(card.getHallList());
	}

	@Test
	public final void testGetShowList() {
		assertNotNull(card.getShowList());
	}

}
