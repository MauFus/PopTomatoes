/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Interfaccia remota per comunicare con il DB via RMI
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date Novemebr 2013
 */

package popt.init;

import popt.dbaccess.XMLInitialConfig;
import popt.showtimes.ShowtimesManager;

public class MainServer {

	public static void main(String[] args) {
		try {
			// Read the initial configuration and save it in DataBase
			XMLInitialConfig.readInitialConfig();
			// Start RMI services
			RmiStarter.start();
			// Create a new instance of Showtimes Manager 
			new ShowtimesManager();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
