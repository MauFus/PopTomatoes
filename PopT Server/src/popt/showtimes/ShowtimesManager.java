/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Main Component to manage Showtimes updates
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.showtimes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import popt.data.Showtime;
import popt.dbaccess.MySQLAccess;

public class ShowtimesManager {

	public ShowtimesManager() {
		
	}
	
	public void generateShowtimesList() {
		
		DateFormat onlyDate = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + 86400000);
		Date afterTomorrow = new Date(tomorrow.getTime() + 86400000);
		
		LinkedList<Showtime> comingShowtimes = new LinkedList<>();
		
		MySQLAccess dba = new MySQLAccess();
		try {
			dba.readDB();
			// add to the list all the showtimes scheduled in the next 3 days
			comingShowtimes.addAll(dba.searchShowtimes(0, null, 0, onlyDate.format(today), ""));
			comingShowtimes.addAll(dba.searchShowtimes(0, null, 0, onlyDate.format(tomorrow), ""));
			comingShowtimes.addAll(dba.searchShowtimes(0, null, 0, onlyDate.format(afterTomorrow), ""));
			dba.closeDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ShowtimesManager sh = new ShowtimesManager();
		sh.generateShowtimesList();
	}
}
