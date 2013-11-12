package popt.main_sch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import popt.ctrl_sch.InsertMovieController;
import popt.data.Movie;
import popt.gui_sch.*;
import popt.model_sch.InsertMovieModel;
import popt.rmi.DBReceiver;

public class Main {

	public static final String POLICY_FILE_NAME = "security.policy";
	public static final String SERVER_IP = "server_ip.file";
	private static DBReceiver dbr;

	public static void main(String[] args) {

		// Create the view
		MainView mainView = new MainView();

		// Create the models
		InsertMovieModel im_model = new InsertMovieModel();

		// Create the Controllers
		InsertMovieController im_ctrl = new InsertMovieController(
				mainView.getInsertMovieView(), im_model);
		im_ctrl.initListeners();
		initRmiConnection();
	}
	
	/**
	 * Inizializza RMI lato Client ed istanzia DBReceiver
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
			String ipServer = sb.toString();
			br.close();

			LocateRegistry.getRegistry();
			System.setProperty("java.security.policy", POLICY_FILE_NAME);
			// Nel file ipServer vi c'e' "<IP>/xampp"
			System.setProperty("java.rmi.server.codebase", "http://" + ipServer
					+ "/popt-common.jar");
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			dbr = (DBReceiver) Naming.lookup("rmi://" + ipServer + "/"
					+ DBReceiver.SERVICE_NAME);

		} catch (Exception e) {
			e.printStackTrace();
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
