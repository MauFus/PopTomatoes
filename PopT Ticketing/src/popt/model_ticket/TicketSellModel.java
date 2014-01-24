package popt.model_ticket;

import java.util.LinkedList;

import popt.data.Row;
import popt.data.Showtime;

public class TicketSellModel {
	
	Showtime currentShowtime;
	LinkedList<Row> rowList;
	int totSeats;
	
	public TicketSellModel() {
		currentShowtime = null;
		rowList = new LinkedList<Row>();
		totSeats = 0;
	}

	public Showtime getCurrentShowtime() {
		return currentShowtime;
	}

	public LinkedList<Row> getRowList() {
		return rowList;
	}

	public int getTotSeats() {
		return totSeats;
	}
	
	

}
