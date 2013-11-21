package popt.model_sch;

import java.util.LinkedList;

import popt.data.Movie;

public class MovieListModel {

	private LinkedList<Movie> movieList;
	
	public MovieListModel() {
		movieList = new LinkedList<>();
	}

	public LinkedList<Movie> getMovieList() {
		return movieList;
	}
	
	/**
	 * 
	 * @param m the movie to be inserted
	 */
	public void insertMovie(Movie m) {
		for (Movie e : movieList) {
			// Se il film è già in lista -> skip
			if (m.equals(e))
				return;
		}
		movieList.push(m);
	}
	
	/**
	 * 
	 * @param m the movie to be removed from the list
	 */
	public void removeMovie(Movie m) {
		for (Movie e : movieList) {
			if (e.equals(m))
				movieList.remove(e);
		}
	}
}
