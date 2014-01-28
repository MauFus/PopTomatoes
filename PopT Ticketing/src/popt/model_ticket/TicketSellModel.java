package popt.model_ticket;

import java.util.LinkedList;

import popt.data.Movie;
import popt.data.Row;
import popt.data.Seat;
import popt.data.Showtime;

public class TicketSellModel {
	
	private LinkedList<Showtime> comingShowtimes;
	private Showtime currentShowtime;
	private LinkedList<Row> rowList;
	private LinkedList<Movie> comingMovies;
	private int totSeats;
	private int specialSeats;
	
	private int solutionIndex; // The active solution (0 = none)
	private Seat[] solution1;
	private Seat[] solution2;
	private LinkedList<Seat> solutionCustom;
	private int[] specialSolution;
	
	public TicketSellModel() {
		comingShowtimes = new LinkedList<>();
		currentShowtime = new Showtime();
		rowList = new LinkedList<>();
		totSeats = 0;
		specialSeats = 0;
		solutionIndex = 0;
		solution1 = null;
		solution2 = null;
		solutionCustom = new LinkedList<>();
		specialSolution = null;
	}
	
	public LinkedList<Movie> findCurrentMovies() {
		LinkedList<Movie> movies = new LinkedList<>();
		if (!comingShowtimes.isEmpty()) {
			for (Showtime show : comingShowtimes) {
				Movie m = show.getMovie();
				boolean alreadyInserted = false;
				for (Movie movie : movies) {
					if (movie.equals(m)) {
						alreadyInserted = true;
						break;
					}
				}
				if (!alreadyInserted)
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

	/**
	 * @return the solutionIndex
	 */
	public int getSolutionIndex() {
		return solutionIndex;
	}

	/**
	 * @param solutionIndex the solutionIndex to set
	 */
	public void setSolutionIndex(int solutionIndex) {
		this.solutionIndex = solutionIndex;
	}

	/**
	 * @return the solution1
	 */
	public Seat[] getSolution1() {
		return solution1;
	}

	/**
	 * @param solution1 the solution1 to set
	 */
	public void setSolution1(Seat[] solution1) {
		this.solution1 = solution1;
	}

	/**
	 * @return the solution2
	 */
	public Seat[] getSolution2() {
		return solution2;
	}

	/**
	 * @param solution2 the solution2 to set
	 */
	public void setSolution2(Seat[] solution2) {
		this.solution2 = solution2;
	}

	/**
	 * @return the solutionCustom
	 */
	public LinkedList<Seat> getSolutionCustom() {
		return solutionCustom;
	}

	/**
	 * @param solutionCustom the solutionCustom to set
	 */
	public void setSolutionCustom(LinkedList<Seat> solutionCustom) {
		this.solutionCustom = solutionCustom;
	}

	/**
	 * @return the specialSeats
	 */
	public int getSpecialSeats() {
		return specialSeats;
	}

	/**
	 * @param specialSeats the specialSeats to set
	 */
	public void setSpecialSeats(int special) {
		specialSeats = special;
	}

	/**
	 * @return the specialSolution
	 */
	public int[] getSpecialSolution() {
		return specialSolution;
	}

	/**
	 * @param specialSolution the specialSolution to set
	 */
	public void setSpecialSolution(int[] specialSolution) {
		this.specialSolution = specialSolution;
	}
}
