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
	
	private int seats;
	private Seat[] status;
	
	public Row() {
		
	}
	
	public Row(int  n) {
		seats = n;
		status = new Seat[seats];
		for (int s = 0; s < status.length; s++) {
			status[s] = Seat.LIBERO;
		}
	}
	
	public Row(int n, Seat[] s) {

		seats = n;
		status = new Seat[seats];
		if (s.length == n) {
			for (int i = 0; i < status.length; i++)
				status[i] = s[i];
		}
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
