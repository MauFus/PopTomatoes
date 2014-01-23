package popt.model_ticket;

import java.util.LinkedList;

import popt.data.Movie;
import popt.data.Row;
import popt.data.Showtime;

public class TicketSellModel {
	
	LinkedList<Showtime> comingShowtimes;
	Showtime currentShowtime;
	LinkedList<Row> rowList;
	LinkedList<Movie> comingMovies;
	int totSeats;
	
	public TicketSellModel() {
		comingShowtimes = new LinkedList<>();
		currentShowtime = null;
		rowList = new LinkedList<>();
		totSeats = 0;
	}
	
	public LinkedList<Movie> findCurrentMovies() {
		LinkedList<Movie> movies = new LinkedList<>();
		if (!comingShowtimes.isEmpty()) {
			for (Showtime show : comingShowtimes) {
				Movie m = show.getMovie();
				if (!movies.contains(m))
					movies.add(m);
			}
		}
		return movies;
	}

	/**
	 * @return the comingShowtimes
	 */
	public LinkedList<Showtime> getComingShowtimes() {
		return comingShowtimes;
	}

	/**
	 * @param comingShowtimes the comingShowtimes to set
	 */
	public void setComingShowtimes(LinkedList<Showtime> comingShowtimes) {
		this.comingShowtimes = comingShowtimes;
	}

	/**
	 * @return the currentShowtime
	 */
	public Showtime getCurrentShowtime() {
		return currentShowtime;
	}

	/**
	 * @param currentShowtime the currentShowtime to set
	 */
	public void setCurrentShowtime(Showtime currentShowtime) {
		this.currentShowtime = currentShowtime;
	}

	/**
	 * @return the rowList
	 */
	public LinkedList<Row> getRowList() {
		return rowList;
	}

	/**
	 * @param rowList the rowList to set
	 */
	public void setRowList(LinkedList<Row> rowList) {
		this.rowList = rowList;
	}

	/**
	 * @return the comingMovies
	 */
	public LinkedList<Movie> getComingMovies() {
		return comingMovies;
	}

	/**
	 * @param comingMovies the comingMovies to set
	 */
	public void setComingMovies(LinkedList<Movie> comingMovies) {
		this.comingMovies = comingMovies;
	}

	/**
	 * @return the totSeats
	 */
	public int getTotSeats() {
		return totSeats;
	}

	/**
	 * @param totSeats the totSeats to set
	 */
	public void setTotSeats(int totSeats) {
		this.totSeats = totSeats;
	}
}
