/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Struttura dati per l'oggetto Movie
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date october 2013
 */

import java.util.Date;

enum Genre {
	ACTION, ADVENTURE, ANIMATION, BIOGRAPHY, COMEDY, CRIME, DOCUMENTARY, 
	DRAMA, FANTASY, NOIR, HISTORY, HORROR, MUSICAL, MYSTERY, ROMANCE, 
	SCI_FI, SPORT, THRILLER, WAR, WESTERN
}

public class Movie {

	private int id;
	private String title;
	private int duration;
	private Date date;
	private Genre genre;
	private boolean pg;

	public Movie() {

	}

	public Movie(String name, int dur, Date d, Genre g, boolean pg) {
		setID(0);
		setTitle(name);
		setDuration(dur);
		setDate(d);
		setGenre(g);
		setPG(pg);
	}

	/**
	 * @return the id
	 */
	public int getID() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * @return the pg
	 */
	public boolean isPG() {
		return pg;
	}

	/**
	 * @param pg the pg to set
	 */
	public void setPG(boolean pg) {
		this.pg = pg;
	}
}
