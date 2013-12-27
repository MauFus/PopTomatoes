/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe che rappresenta una fila di poltrone in una sala
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.data;

public class Row {
	
	private int number;
	private int seats;
	private Seat[] status;
	
	public Row() {
		
	}
	
	public Row(int n, int s) {
		number = n;
		seats = s;
		status = new Seat[seats];
		for (int k = 0; k < status.length; k++) {
			status[k] = Seat.LIBERO;
		}
	}
	
	public Row(int n, int s, Seat[] p) {
		number = n;
		seats = s;
		status = new Seat[seats];
		if (p.length == n) {
			for (int i = 0; i < status.length; i++)
				status[i] = p[i];
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Seat[] getStatus() {
		return status;
	}

	public void setStatus(Seat[] status) {
		this.status = status;
	}

}
