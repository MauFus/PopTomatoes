package popt.model_sch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InsertMovieModelTest {

	InsertMovieModel model;
	
	@Before
	public void setUp() throws Exception {
		model = new InsertMovieModel();
	}

	@Test
	public final void testGetMovie() {
		assertNotNull(model.getMovie());
	}

}
