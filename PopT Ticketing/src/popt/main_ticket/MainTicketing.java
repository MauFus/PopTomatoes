/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe Main per il Clinet di Ticketing
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.main_ticket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.LinkedList;

import popt.ctrl_ticket.TicketSellController;
import popt.data.Row;
import popt.data.Seat;
import popt.data.Showtime;
import popt.gui_ticket.MainView;
import popt.model_ticket.TicketSellModel;
import popt.rmi.SeatsAllocator;

public class MainTicketing {

	public static final String POLICY_FILE_NAME = "security.policy";
	public static final String SERVER_IP = "server_ip.file";
	private static SeatsAllocator allocator;

	public static void main(String[] args) {
		
		initRmiConnection();
		
		// Create the view
		MainView view = new MainView();
		// Create the model
		TicketSellModel model = new TicketSellModel();
		// Create the controller
		new TicketSellController(model, view.getTicketSellView());
	}

	/**
	 * Inizializza la connessione con il server tramite RMI
	 */
	private static void initRmiConnection() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(SERVER_IP));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line + "\n");
				line = br.readLine();
			}
			String ipServer = sb.toString().trim();
			br.close();

			LocateRegistry.getRegistry();
			System.setProperty("java.security.policy", POLICY_FILE_NAME);
			// Nel file ipServer c'e' "<IP>/xampp"
			System.setProperty("java.rmi.server.codebase", "http://" + ipServer + "/popt-common.jar");
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			// considera solo l'IP
			allocator = (SeatsAllocator) Naming.lookup("rmi://" + ipServer.substring(0, ipServer.indexOf("/")) 
					+ "/" + SeatsAllocator.SERVICE_NAME);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the Showtime List through RMI
	 * @return a LinkedList of Showtime objects
	 */
	public static LinkedList<Showtime> getCurrentShowtimeList() {
		try {
			return allocator.getComingShowtimesList();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get the ticketing status of a showtime through RMI
	 * @param show is the showtime
	 * @return a LinkedList of Row objects
	 */
	public static LinkedList<Row> getShowtimeTicketing(Showtime show) {
		try {
			return allocator.getTicketingStatus(show);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Seat[] searchRaccomendedSeats(Showtime show, int number) {
		try {
			return allocator.searchAvailableSeats(show, number);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
