package popt.ctrl_sch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import popt.gui_sch.MovieListView;
import popt.model_sch.MovieListModel;

public class MovieListControllerTest {
	
	MovieListController ctrl;

	@Before
	public void setUp() throws Exception {
		ctrl = new MovieListController(new MovieListView(), new MovieListModel());
	}

	@Test
	public final void testWriteMovieList() {
		assertTrue(ctrl.writeMovieList());
	}

}
