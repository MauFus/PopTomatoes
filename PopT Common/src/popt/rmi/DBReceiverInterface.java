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

public interface DBReceiverInterface extends Remote {

	public boolean insertMovie(Movie movie) throws RemoteException;

	public boolean isAvailable() throws RemoteException;

	public String getStatus() throws RemoteException;
}
