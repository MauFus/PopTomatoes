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
import java.util.LinkedList;

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
	public LinkedList<Movie> searchMovie(Movie movie) throws RemoteException {
		MySQLAccess dba = new MySQLAccess();
		try {
			isWorking = true;
			statusMessage = "Ricerca in DB in corso...";
			LinkedList<Movie> result = new LinkedList<>();

			dba.readDB();
			result = dba.searchMovie(movie.getID(), movie.getTitle(), movie.getDuration(),
					movie.getDate(), movie.getGenre(), movie.isPG());
			dba.closeDB();
			
			statusMessage = "Ricerca in DB eseguita con successo!\n";
			isWorking = false;
			return result;
			
		} catch (Exception e) {
			dba.closeDB();
			
			statusMessage = "Errore: Ricerca in DB fallita\n";
			isWorking = false;
			return null;
		}
	}

	@Override
	public boolean insertShowtime(Showtime show) throws RemoteException {
		MySQLAccess dba = new MySQLAccess();
		try {
			isWorking = true;
			statusMessage = "Inserimento in DB in corso...";
			
			dba.readDB();
			dba.insertShowtime(show.getMovie(), show.getHall(), show.getDate(), show.getTime());
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
	public boolean deleteShowtimes(String date) throws RemoteException {
		MySQLAccess dba = new MySQLAccess();
		try {
			isWorking = true;
			statusMessage = "Cancellazione da DB in corso...";

			dba.readDB();
			dba.deleteShowtimes(date);
			dba.closeDB();

			statusMessage = "cancellazione da DB eseguita con successo!\n";
			isWorking = false;
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			dba.closeDB();
			
			statusMessage = "Errore: Cancellazione in DB non riuscita\n";
			isWorking = false;
			return false;
		}
	}

	@Override
	public LinkedList<Showtime> searchShowtime(Showtime show) throws RemoteException {
		MySQLAccess dba = new MySQLAccess();
		try {
			isWorking = true;
			statusMessage = "Ricerca in DB in corso...";
			LinkedList<Showtime> result = new LinkedList<>();

			dba.readDB();
			result = dba.searchShowtimes(show.getId(), show.getMovie(), 
					show.getHall(), show.getDate(), show.getTime());
			dba.closeDB();
			
			statusMessage = "Ricerca in DB eseguita con successo!\n";
			isWorking = false;
			return result;
			
		} catch (Exception e) {
			dba.closeDB();
			
			statusMessage = "Errore: Ricerca in DB fallita\n";
			isWorking = false;
			return null;
		}
	}

	@Override
	public LinkedList<CinemaHall> searchCinemaHalls() throws RemoteException {
		MySQLAccess dba = new MySQLAccess();
		try {
			isWorking = true;
			statusMessage = "Ricerca in DB in corso...";
			LinkedList<CinemaHall> result = new LinkedList<>();

			dba.readDB();
			result = dba.searchHalls();
			dba.closeDB();
			
			statusMessage = "Ricerca in DB eseguita con successo!\n";
			isWorking = false;
			return result;
			
		} catch (Exception e) {
			dba.closeDB();
			
			statusMessage = "Errore: Ricerca in DB fallita\n";
			isWorking = false;
			return null;
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
