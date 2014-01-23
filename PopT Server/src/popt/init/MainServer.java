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

public class MainServer {

	public static void main(String[] args) {
		try {
			// Read the initial configuration and save it in DataBase
			XMLInitialConfig.readInitialConfig();
			// Start RMI services
			RmiStarter.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
