/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Interfaccia remota per comunicare con l'algoritmo via RMI
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date January 2014
 */

package popt.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import popt.data.Seat;
import popt.data.Showtime;

public interface SeatsAllocator extends Remote {

	public static final String SERVICE_NAME = "SeatsAllocator";
	
	/**
	 * Ricerca posti da vendere per una proiezione
	 * @param show - Proiezione per cui si vogliono ottenere dei posti
	 * @param qta - numero di posti (adiacenti) da ricercare
	 * @return la lista di posti selezionati
	 */
	public Seat[] searchAvailableSeats(Showtime show, int qta) throws RemoteException;
	
	/**
	 * registra la vendita di una serie di posto
	 * @param show
	 * @param seats
	 */
	public void sellSeat(Showtime show, Seat[] seats) throws RemoteException;

}
