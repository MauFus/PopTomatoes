/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Interfaccia remota per comunicare con il DB via RMI
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date Novemebr 2013
 */

package popt.init;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import popt.dbaccess.DBReceiverImpl;
import popt.rmi.DBReceiver;

public class RmiStarter {

	public RmiStarter() {

	}

	/**
	 * Start the RMI services
	 */
	public static void start() {

		try {
			// Set hostname and codebase
			InetAddress ia;
			ia = InetAddress.getLocalHost();
			System.setProperty("java.rmi.server.hostname", ia.getHostAddress());
			System.setProperty("java.rmi.server.codebase",
					"http://" + ia.getHostAddress() + "/popt-common.jar");

			// Register services
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind(DBReceiver.SERVICE_NAME, new DBReceiverImpl());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
