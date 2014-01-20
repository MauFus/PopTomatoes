/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Interfaccia remota per comunicare con il DB via RMI
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date october 2013
 */

package popt.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

import popt.data.*;

public interface DBReceiver extends Remote {

	public static final String SERVICE_NAME = "DBReceiver";
	
	/**
	 * Invoca l'inserimento in DB del film
	 * @param movie
	 * @return il successo o meno dell'azione
	 * @throws RemoteException
	 */
	public boolean insertMovie(Movie movie) throws RemoteException;
	
	/**
	 * Avvia la ricerca in DB di un dato film
	 * @param movie oggetto contenente parametri del film da ricercare
	 * @return una list di film compatibili con la ricerca
	 * @throws RemoteException
	 */
	public LinkedList<Movie> searchMovie(Movie movie) throws RemoteException;

	/**
	 * Invoca l'inserimento di una proiezione in DB
	 * @param show
	 * @return il successo o meno dell'azione
	 * @throws RemoteException
	 */
	public boolean insertShowtime(Showtime show) throws RemoteException;
	
	/**
	 * Elimina tutti le proiezioni di una determinata data
	 * @param date
	 * @return il successo o meno dell'azione
	 * @throws RemoteException
	 */
	public boolean deleteShowtimes(String date) throws RemoteException;
	
	/**
	 * Avvia la ricerca in DB di proiezioni, dati certi dati
	 * @param show
	 * @return una lista di proiezioni compatibili con la ricerca
	 * @throws RemoteException
	 */
	public LinkedList<Showtime> searchShowtime(Showtime show) throws RemoteException;
	
	/**
	 * Avvia la ricerca in DB di tutte le sale
	 * @return una lista di tutte le sale del cinema
	 * @throws RemoteException
	 */
	public LinkedList<CinemaHall> searchCinemaHalls() throws RemoteException;
	
	/**
	 * Comunica se il DBReceiver è occupato o disponibile
	 * @return lo stato occupato o meno
	 * @throws RemoteException
	 */
	public boolean isAvailable() throws RemoteException;

	/**
	 * Fornisce il messaggio relativo allo stato del Receiver
	 * @return lo stato del Receiver
	 * @throws RemoteException
	 */
	public String getStatus() throws RemoteException;
}
