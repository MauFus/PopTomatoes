package popt.ctrl_sch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import popt.gui_sch.SchedulerView;
import popt.model_sch.SchedulerModel;

public class SchedulerControllerTest {
	
	SchedulerController sch;

	@Before
	public void setUp() throws Exception {
		sch = new SchedulerController(new SchedulerView(), new SchedulerModel());
	}

	@Test
	public final void testResetCardMovieList() {
		assertTrue(sch.resetCardMovieList());
	}

	@Test
	public final void testResetButtonColors() {
		assertTrue(SchedulerController.resetButtonColors());
	}

	@Test
	public final void testMarkupValuatedStatus() {
		assertTrue(SchedulerController.markupValuatedStatus());
	}

}
