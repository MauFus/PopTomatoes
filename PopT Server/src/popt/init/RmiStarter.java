package popt.init;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import popt.dbaccess.DBReceiverImpl;
import popt.rmi.DBReceiver;

public class RmiStarter {

	public RmiStarter() throws UnknownHostException, RemoteException {
		
		// Set hostname and codebase
		InetAddress ia = InetAddress.getLocalHost();
		System.setProperty("java.rmi.server.hostname", ia.getHostAddress());
		System.setProperty("java.rmi.server.codebase",
				"http://" + ia.getHostAddress() + "/popt-common.jar");
		
		// Register services
		Registry reg = LocateRegistry.createRegistry(1099);
		reg.rebind(DBReceiver.SERVICE_NAME, new DBReceiverImpl());
	}
}
