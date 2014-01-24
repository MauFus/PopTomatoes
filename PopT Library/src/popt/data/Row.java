/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe che rappresenta una fila di poltrone in una sala
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.data;

import java.io.Serializable;

public class Row implements Serializable{
	
	private static final long serialVersionUID = -8884714821692120231L;
	private int number;
	private int seats;
	private SeatStatus[] status;
	
	public Row() {
		
	}
	
	public Row(int n, int s) {
		number = n;
		seats = s;
		status = new SeatStatus[seats];
		for (int k = 0; k < status.length; k++) {
			status[k] = SeatStatus.LIBERO;
		}
	}
	
	public Row(int n, int s, SeatStatus[] p) {
		number = n;
		seats = s;
		status = new SeatStatus[seats];
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

	public SeatStatus[] getStatus() {
		return status;
	}

	public void setStatus(int seat, SeatStatus status) {
		this.status[seat] = status;
	}

}
