/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Struttura dati per l'oggetto Movie
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date october 2013
 */

package popt.data;

public class Movie {

	private int id;
	private String title;
	private int duration;
	private String date;
	private Genre genre;
	private boolean pg;

	public Movie() {

	}

	public Movie(String name, int dur, String d, Genre g, boolean pg) {
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
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
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
