/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Modello per l'interfaccia di Insert Movie
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date october 2013
 */

package popt.model_sch;

import popt.data.Movie;

public class InsertMovieModel {
	
	private Movie currentMovie;
	
	public InsertMovieModel() {
		currentMovie = new Movie();
	}
	
	/**
	 * Restituisce un riferimento al Movie in inserimento
	 * @return the currentMovie
	 */
	public Movie getMovie() {
		return currentMovie;
	}
}
