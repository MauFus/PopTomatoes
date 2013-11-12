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

import popt.data.Movie;

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
