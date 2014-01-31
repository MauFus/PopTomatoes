/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Interfaccia remota per comunicare con il DB via RMI
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date Novemebr 2013
 */

package popt.init;

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import popt.dbaccess.DBReceiverImpl;
import popt.rmi.DBReceiver;
import popt.rmi.SeatsAllocator;
import popt.showtimes.SeatsAllocatorImpl;
import popt.showtimes.ShowtimesManager;

public class RmiStarter {

	public static final String SERVER_IP = "server_ip.file";

	/**
	 * Start the RMI services
	 */
	public static boolean start() {

		try {
			BufferedReader br = new BufferedReader(new FileReader(SERVER_IP));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line + "\n");
				line = br.readLine();
			}
			String ipServer = sb.toString().trim();
			br.close();
			
			
			// Set hostname and codebase
			System.setProperty("java.rmi.server.hostname", ipServer.split("/")[0]);
			System.setProperty("java.rmi.server.codebase", "http://" + ipServer + "/popt-common.jar");

			// Register services
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind(DBReceiver.SERVICE_NAME, new DBReceiverImpl());
			reg.rebind(SeatsAllocator.SERVICE_NAME, new SeatsAllocatorImpl(new ShowtimesManager()));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
