/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe atta alla lettura ed al salvataggio della configurazione iniziale.
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date october 2013
 */

package popt.dbaccess;

import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLInitialConfig {

	public XMLInitialConfig() {

	}

	/**
	 * Carica un file XML e ne restituisce un riferimento per DOM
	 * 
	 * @param path
	 *            - path to xml file
	 * @return reference to xml document
	 */
	private Document loadDocument(String path) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// dbf.setValidating(true);
		// dbf.setNamespaceAware(false);
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(new File(path));
			return d;

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
			System.exit(10);
		} catch (SAXException sxe) {
			sxe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	/**
	 * Restituisce la lista delle sale specificate nel file di configurazione
	 * 
	 * @param d
	 *            - riferimento al file XML
	 * @return NodeList degli oggetti hall
	 */
	private static NodeList findCinemaHall(Document d) {
		return d.getElementsByTagName("hall");
	}

	/**
	 * Fornisce dati relativi alle file di una particolare sala nel config.xml
	 * 
	 * @param hall
	 *            - sala del cinema
	 * @return la lista delle file di posti in hall
	 */
	private static NodeList readRows(Element hall) {
		return hall.getElementsByTagName("row");
	}

	/**
	 * Metodo per la lettura e il salvataggio in DB dei dati relativi alla prima
	 * configurazione del cinema multisala
	 * 
	 * @throws Exception
	 */
	public static void readInitialConfig() throws Exception {
		// Lettura del file config.xml
		MySQLAccess msa = new MySQLAccess();
		msa.readDB();
		XMLInitialConfig reader = new XMLInitialConfig();
		Document config = reader.loadDocument("config.xml");

		// Creazione della lista di sale
		NodeList cinemaHalls = findCinemaHall(config);
		for (int i = 0; i < cinemaHalls.getLength(); i++) {
			NamedNodeMap attr = cinemaHalls.item(i).getAttributes();
			String[] s = attr.getNamedItem("id").toString().split("\"");
			// ID della sala i
			char id = s[1].toCharArray()[0];
			s = attr.getNamedItem("name").toString().split("\"");
			// Nome sala i
			String name = s[1];
			s = attr.getNamedItem("specialseat").toString().split("\"");
			// Numero posti speciali
			int specialSeats = Integer.parseInt(s[1]);
			NodeList rows = readRows((Element) cinemaHalls.item(i));
			// Numero file della sala i
			int n_rows = rows.getLength();

			// Numero posti totali
			int seats = 0;
			for (int j = 0; j < n_rows; j++) {
				// Numero posti della fila j
				int r_seats = Integer.parseInt(rows.item(j).getTextContent()
						.toString().trim());
				seats += r_seats;
			}

			// Invoca l'inserimento in DB
			msa.insertCinemaHall(id, name, n_rows, seats, specialSeats);

			for (int j = 0; j < n_rows; j++) {
				NamedNodeMap r_attr = rows.item(j).getAttributes();
				s = r_attr.getNamedItem("number").toString().split("\"");
				int number = Integer.parseInt(s[1]);
				// Numero posti della fila j
				int r_seats = Integer.parseInt(rows.item(j).getTextContent()
						.toString().trim());
				msa.insertRow(id, number, r_seats);
			}

		}
		msa.closeDB();
	}
}
