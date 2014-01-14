package popt.model_sch;

import java.util.LinkedList;

import popt.data.CinemaHall;
import popt.data.Movie;
import popt.data.Showtime;

public class DailyCardModel {

	private boolean isValidated;
	private int gap;
	private int opening;
	private int closing;
	private String date;
	private LinkedList<Movie> movieList;
	private LinkedList<CinemaHall> hallList;
	private LinkedList<Showtime> showList;
	
	public DailyCardModel() {
		isValidated = false;
		gap = 45;
		opening = 14;
		closing = 2;
		movieList = new LinkedList<>();
		hallList = new LinkedList<>();
		showList = new LinkedList<>();
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public int getOpening() {
		return opening;
	}

	public void setOpening(int opening) {
		this.opening = opening;
	}

	public int getClosing() {
		return closing;
	}

	public void setClosing(int closing) {
		if (closing < 22 && closing > opening)
			this.closing = closing;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public LinkedList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(LinkedList<Movie> movieList) {
		this.movieList = movieList;
	}

	public LinkedList<CinemaHall> getHallList() {
		return hallList;
	}

	public void setHallList(LinkedList<CinemaHall> hallList) {
		this.hallList = hallList;
	}

	public LinkedList<Showtime> getShowList() {
		return showList;
	}

	public void setShowList(LinkedList<Showtime> showList) {
		this.showList = showList;
	}
}
