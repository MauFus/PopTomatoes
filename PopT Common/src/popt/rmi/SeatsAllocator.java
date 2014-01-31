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
import java.util.LinkedList;

import popt.data.Row;
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
	 * Ricerca il numero di posti speciali disponibili
	 * @param show
	 * @return
	 * @throws RemoteException
	 */
	public int[] searchAvailableSpecialSeats(Showtime show, int qta) throws RemoteException;
	/**
	 * Registra la vendita di una serie di posto
	 * @param show
	 * @param seats
	 */
	public boolean sellSeat(Showtime show, Seat[] seats) throws RemoteException;

	/**
	 * Registra la vendita di un posto riservato a portatori di handicap
	 * @param show
	 * @param seats
	 */
	public boolean sellSpecialSeat(Showtime show, int seat) throws RemoteException;

	/**
	 * Richiede la lista delle proiezioni di cui è aperta la vendita dei biglietti
	 * @return una lista di oggetti SHowtime
	 * @throws RemoteException
	 */
	public LinkedList<Showtime> getComingShowtimesList() throws RemoteException;
	
	/**
	 * Richiede lo stato della vendita dei biglietti per una data proiezione
	 * @param showtime - La proiezione in questione
	 * @return una lista di Row, che rappresentano lo stato della vendita per tutti i posti della sala
	 * @throws RemoteException
	 */
	public LinkedList<Row> getTicketingStatus(Showtime showtime) throws RemoteException;
}
