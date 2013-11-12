/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Interfaccia remota per comunicare con il DB via RMI
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date october 2013
 */

package popt.dbaccess;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import popt.data.*;
import popt.rmi.DBReceiver;

public class DBReceiverImpl extends UnicastRemoteObject implements DBReceiver {

	private static final long serialVersionUID = -3198085858632777108L;
	private boolean isWorking;
	private String statusMessage;
	
	public DBReceiverImpl() throws RemoteException{
		super();
		statusMessage = "";
		isWorking = false;
	}

	@Override
	public boolean insertMovie(Movie movie) throws RemoteException {
		MySQLAccess dba = new MySQLAccess();
		try {
			isWorking = true;
			statusMessage = "Inserimento in DB in corso...";
			
			dba.readDB();
			dba.insertMovie(movie.getTitle(), movie.getDuration(),
					movie.getDate(), movie.getGenre().toString(), movie.isPG());
			dba.closeDB();
			
			statusMessage = "Inserimento in DB eseguito con successo!\n";
			isWorking = false;
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			dba.closeDB();
			
			statusMessage = "Errore: inserimento in DB non riuscito\n";
			isWorking = false;
			return false;
		}
	}

	@Override
	public boolean isAvailable() throws RemoteException {
		return !(isWorking);
	}

	@Override
	public String getStatus() throws RemoteException {
		return statusMessage;
	}

}
