/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe per la stampa del biglietto
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.main_ticket;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import popt.data.Seat;
import popt.data.Showtime;

public class TicketPrinter {
	
	private static Showtime showtime;
	private static Seat seat;
	private static Writer writer;
	
	public TicketPrinter(Showtime show, Seat seat) {
		showtime = show;
		TicketPrinter.seat = seat;
		writer = null;
	}
	
	public void print() {
		DateFormat timeStamp = new SimpleDateFormat("ddMMyy_HHmmssSSS");
		Date now = new Date();
		
		String output = new String("");
		output = output.concat(showtime.getMovie().getTitle() + "\n");
		output = output.concat(showtime.getHall().getName() + "\n");
		output = output.concat("Fila: " + seat.getRow() + " \t Posto: " + seat.getSeat() + "\n");
		output = output.concat("Data: " + showtime.getDate() + " \t Ora: " + showtime.getTime() + "\n");
		
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") 
					+ "/tickets/" + timeStamp.format(now) + "_" + seat.getSeat() + ".txt"), "utf-8"));
			writer.write(output);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
