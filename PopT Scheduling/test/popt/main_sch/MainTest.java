package popt.main_sch;

import org.junit.Before;
import org.junit.Test;

import popt.gui_sch.MovieInfoDialog;
import popt.gui_sch.SearchMovieDialog;

public class MainTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		Main.main(null);
		new SearchMovieDialog();
		new MovieInfoDialog();
	}

}
