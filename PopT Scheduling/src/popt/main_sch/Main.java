package popt.main_sch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;

import popt.ctrl_sch.InsertMovieController;
import popt.data.Movie;
import popt.gui_sch.*;
import popt.model_sch.InsertMovieModel;
import popt.rmi.DBReceiver;

public class Main {

	public static final String POLICY_FILE_NAME = "security.policy";
	public static final String SERVER_IP = "192.168.106.1"; // TODO settare con file

	public static void main(String[] args) {

		// Create the view
		MainView mainView = new MainView();

		// Create the models
		InsertMovieModel im_model = new InsertMovieModel();

		// Create the Controllers
		InsertMovieController im_ctrl = new InsertMovieController(
				mainView.getInsertMovieView(), im_model);

	}

	/**
	 * Produce la richiesta di inserimento in DB tramite RMI
	 * 
	 * @param m
	 *            - Movie to be inserted in DB
	 * @return success
	 */
	public static boolean RequestInsert(Movie m) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(POLICY_FILE_NAME));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line + "\n");
				line = br.readLine();
			}
			String policy = sb.toString();
			br.close();

			System.setProperty("java.security.policy", policy);
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			DBReceiver dbr = (DBReceiver) Naming.lookup("rmi://" + SERVER_IP + "/" + DBReceiver.SERVICE_NAME);
			
			return dbr.insertMovie(m);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
