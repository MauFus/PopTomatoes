package popt.model_sch;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import popt.data.Genre;
import popt.data.Movie;

public class MovieListModelTest {
	
	MovieListModel model;

	@Before
	public void setUp() throws Exception {
		model = new MovieListModel();
	}

	@Test
	public final void testGetSearchList() {
		LinkedList<Movie> list = new LinkedList<>();
		list.add(new Movie(1, "Prova", 10, "", Genre.ACTION, false));
		list.add(new Movie(2, "Prova2", 10, "", Genre.ACTION, false));
		model.setSearchList(list);
		assertEquals(2, model.getSearchList().size());
	}

	@Test
	public final void testRemoveMovie() {
		Movie m = new Movie(1, "Prova", 10, "", Genre.ACTION, false);
		Movie n = new Movie(1, "Prova2", 10, "", Genre.ACTION, false);
		model.getMovieList().add(m);
		model.getMovieList().add(n);
		model.removeMovie(m);
		assertEquals(1, model.getMovieList().size());
	}

}
