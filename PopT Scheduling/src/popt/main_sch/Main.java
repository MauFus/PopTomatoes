package popt.main_sch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.LinkedList;

import popt.ctrl_sch.InsertMovieController;
import popt.ctrl_sch.MovieListController;
import popt.ctrl_sch.SchedulerController;
import popt.data.*;
import popt.gui_sch.*;
import popt.model_sch.InsertMovieModel;
import popt.model_sch.MovieListModel;
import popt.model_sch.SchedulerModel;
import popt.rmi.DBReceiver;

public class Main {

	public static final String POLICY_FILE_NAME = "security.policy";
	public static final String SERVER_IP = "server_ip.file";
	private static DBReceiver dbr;
	private static SchedulerController sc_ctrl;

	public static void main(String[] args) {
		
		boolean ok = initRmiConnection();

		// Create the view
		final MainView mainView = new MainView();
		mainView.setInterface(ok);
		mainView.getInsertMovieButt().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				mainView.getCards().show(mainView.getCardPanel(), "IM");
			}
		});
		
		mainView.getMovieListButt().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainView.getCards().show(mainView.getCardPanel(), "ML");
			}
		});
		
		mainView.getSchedulingButt().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				SchedulerController.uploadMovieList();
				mainView.getCards().show(mainView.getCardPanel(), "SCH");
				if (sc_ctrl != null)
					sc_ctrl.resetCardMovieList();
			}
		});

		// Create the models
		InsertMovieModel im_model = new InsertMovieModel();
		MovieListModel ml_model = new MovieListModel();
		SchedulerModel sc_model = new SchedulerModel();

		// Create the Controllers
		new InsertMovieController(mainView.getInsertMovieView(), im_model);
		new MovieListController(mainView.getMovieListView(), ml_model);
		sc_ctrl = new SchedulerController(mainView.getSchedulingView(), sc_model);
	}
	/**
	 * Inizializza RMI lato Client ed istanzia DBReceiver
	 */
	private static boolean initRmiConnection() {
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
			dbr = (DBReceiver) Naming.lookup("rmi://" + ipServer.substring(0, ipServer.indexOf("/")) 
					+ "/" + DBReceiver.SERVICE_NAME);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Produce la richiesta di inserimento in DB tramite RMI
	 * 
	 * @param m
	 *            - Movie to be inserted in DB
	 * @return success
	 */
	public static boolean requestInsert(Movie m) {

		try {
			// Se il server sta processando altre richieste: abort
			if (!dbr.isAvailable())
				return false;
			else {
				return dbr.insertMovie(m);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Invoca la ricerca di film nel DB (tramite RMI)
	 * @param m
	 * @return lista dei film compatibili
	 */
	public static LinkedList<Movie> searchMovie(Movie m) {
		
		try {
			// Se il server sta processando altre richieste: wait
			while (!dbr.isAvailable()) {
				
			}
			return dbr.searchMovie(m);
				
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Invoca la ricerca di sale nel DB (tramite RMI)
	 * @param hall
	 * @return lista di sale compatibili
	 */
	public static LinkedList<CinemaHall> searchCinemaHalls() {
		
		try {
			// Se il server sta processando altre richieste: wait
			while (!dbr.isAvailable()) {
				
			}
			return dbr.searchCinemaHalls();
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Invoca la ricerca di proiezioni nel DB (tramite RMI)
	 * @param show
	 * @return lista di proiezioni compatibili
	 */
	public static LinkedList<Showtime> searchShowtimes(Showtime show) {
		
		try {
			// Se il server sta processando altre richieste: wait
			while (!dbr.isAvailable()) {
				
			}
			return dbr.searchShowtime(show);
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Invoca l'inserimento in DB di una proiezione
	 * @param show
	 * @return
	 */
	public static boolean insertShowtime(Showtime show) {

		try {
			// Se il server sta processando altre richieste: abort
			if (!dbr.isAvailable())
				return false;
			else {
				return dbr.insertShowtime(show);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * richiede il delete da DB delle proiezioni di una giornata
	 * @param date
	 * @return
	 */
	public static boolean deleteShowtimes(String date) {

		try {
			// Se il server sta processando altre richieste: abort
			if (!dbr.isAvailable())
				return false;
			else {
				return dbr.deleteShowtimes(date);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Chiede al server il suo stato corrente
	 * @return un messaggio sullo stato del server
	 */
	public static String getServerStatus() {
		try {
			return dbr.getStatus();
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Server non raggiungibile";
		}
	}
}
