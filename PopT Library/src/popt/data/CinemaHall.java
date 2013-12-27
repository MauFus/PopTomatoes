/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Struttura dati per l'oggetto CinemaHall
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.data;

public class CinemaHall {

	private char id;
	private String name;
	private int nRows;
	private int maxSeats;
	private int specialSeats;
	
	public CinemaHall() {
		
	}
	
	public CinemaHall(char i, String n, int r, int t, int s) {
		id = i;
		name = n;
		nRows = r;
		maxSeats = t;
		specialSeats = s;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getnRows() {
		return nRows;
	}

	public void setnRows(int nRows) {
		this.nRows = nRows;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public int getSpecialSeats() {
		return specialSeats;
	}

	public void setSpecialSeats(int specialSeats) {
		this.specialSeats = specialSeats;
	}
}
