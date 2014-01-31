package popt.ctrl_sch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import popt.gui_sch.InsertMovieView;
import popt.model_sch.InsertMovieModel;

public class InsertMovieControllerTest {
	
	InsertMovieController ctrl;

	@Before
	public void setUp() throws Exception {
		ctrl = new InsertMovieController(new InsertMovieView(), new InsertMovieModel());
	}

	@Test
	public final void testIsDate() {
		assertTrue(ctrl.isDate("12-12-2013"));
	}

	@Test
	public final void testIsNotDate1() {
		assertFalse(ctrl.isDate("12-13-2013"));
	}

	@Test
	public final void testIsNotDate2() {
		assertFalse(ctrl.isDate("30-02-2013"));
	}

	@Test
	public final void testIsNotDate3() {
		assertFalse(ctrl.isDate("31-04-2013"));
	}

}
