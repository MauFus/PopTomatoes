/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Struttura dati per identificazione di un posto <row, seat>
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.data;

import java.io.Serializable;

public class Seat implements Serializable{

	private static final long serialVersionUID = 5268790147909878835L;
	private int row;
	private int seat;
	
	public Seat() {
		
	}
	
	public Seat(int row, int seat) {
		this.row = row;
		this.seat = seat;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public boolean equals(Seat a) {
		return (this.getRow() == a.getRow() && this.getSeat() == a.getSeat());
	}
}
