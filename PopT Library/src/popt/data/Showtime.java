/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Struttura dati per l'oggetto Showtime
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.data;

public class Showtime {

	private long id;
	private Movie movie;
	private CinemaHall hall;
	private String date;
	private String time;
	private int auditors;
	
	public Showtime() {
		
	}
	
	public Showtime(long i, Movie m, CinemaHall h, String d, String t) {
		id = i;
		movie = m;
		hall = h;
		date = d;
		time = t;
		auditors = 0;
	}
	
	public Showtime(long i, Movie m, CinemaHall h, String d, String t, int a) {
		id = i;
		movie = m;
		hall = h;
		date = d;
		time = t;
		auditors = a;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public CinemaHall getHall() {
		return hall;
	}

	public void setHall(CinemaHall hall) {
		this.hall = hall;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getAuditors() {
		return auditors;
	}

	public void setAuditors(int auditors) {
		this.auditors = auditors;
	}

	public boolean equals(Showtime s) {
		return this.id == s.getId();
	}

}
