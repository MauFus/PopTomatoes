package popt.ctrl_sch;

import java.io.*;
import java.util.LinkedList;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.w3c.dom.ls.*;
import org.xml.sax.SAXException;

import popt.data.*;
import popt.model_sch.MovieListModel;

public class MovieListController {

	// TODO uncomment everything related to MovieListView when it is implemented
	private MovieListModel model;
	// private MovieListView view;

	public static final String MOVIE_LIST = "movielist.xml";

	public MovieListController(MovieListModel m/* , MovieListView v */) {
		model = m;
		// view = v;
	}
	
	/**
	 * it initializes all the listeners on the view
	 */
	private void initListeners() {
		// TODO implementare i listener sull'interfaccia qui
	}

	/**
	 * Writes the movieList.xml file
	 * @return success
	 */
	private boolean writeMovieList() {
		try {
			LinkedList<Movie> movies = model.getMovieList();
			Document d;
			d = createDocument();
			Element radice = d.createElement("MovieList");

			for (Movie m : movies) {
				Element mChild = createMovieElement(d, m);
				radice.appendChild(mChild);
			}
			saveDocument(d, new FileWriter(MOVIE_LIST));
			return true;
		} catch (ParserConfigurationException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Reads movieList.xml file
	 * @return success
	 */
	private boolean uploadListInModel() {

		try {
			Document fileList;
			fileList = loadDocument(MOVIE_LIST);
			NodeList moviesFromFile = fileList.getElementsByTagName("Movie");
			for (int i = 0; i < moviesFromFile.getLength(); i++) {
				Movie mTemp = createMovieFromFile((Element) moviesFromFile
						.item(i));
				model.insertMovie(mTemp);
			}
			return true;
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Carica un file XML e ne restituisce un riferimento per DOM
	 * 
	 * @param path
	 *            - path to xml file
	 * @return reference to xml document
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	private static Document loadDocument(String path) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.parse(new File(path));
		return d;
	}

	/**
	 * 
	 * @return a new empty DOM document
	 * @throws ParserConfigurationException 
	 */
	private Document createDocument() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		dbf.setNamespaceAware(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.newDocument();
		return d;
	}
	
	private void saveDocument(Document d, Writer w) {
        
        DOMImplementationLS ls = (DOMImplementationLS)d.getImplementation();
        LSOutput lso = ls.createLSOutput();
		LSSerializer lss = ls.createLSSerializer();
		lso.setCharacterStream(w);
		lso.setEncoding("ISO-8859-1");
		// Formatta l'output aggiungendo spazi per produrre una stampa
		// "graziosa" (pretty-print) e indentata
		lss.getDomConfig().setParameter("format-pretty-print", true);
		lss.write(d, lso);
    }

	/**
	 * 
	 * @param d the DOM document in use
	 * @param m the movie to be insert in the file
	 * @return the movie in xml format
	 */
	private Element createMovieElement(Document d, Movie m) {
		Element movie = d.createElement("Movie");
		movie.setAttribute("id", Integer.toString(m.getID()));
		if (m.isPG())
			movie.setAttribute("pg", "true");
		
		Element title = d.createElement("title");
		title.setTextContent(m.getTitle());
		Element date = d.createElement("releaseDate");
		date.setTextContent(m.getDate());
		Element duration = d.createElement("duration");
		duration.setTextContent(Integer.toString(m.getDuration()));
		Element genre = d.createElement("genre");
		genre.setTextContent(m.getGenre().toString());
		
		movie.appendChild(title);
		movie.appendChild(date);
		movie.appendChild(duration);
		movie.appendChild(genre);
		
		return movie;
	}

	/**
	 * 
	 * @param item the element parsed from the file
	 * @return an object movie
	 */
	private Movie createMovieFromFile(Element item) {
		Movie e = new Movie();
		e.setID(Integer.parseInt(item.getAttribute("id")));
		e.setTitle(item.getElementsByTagName("title").item(0).getTextContent());
		e.setDate(item.getElementsByTagName("releaseDate").item(0).getTextContent());
		e.setDuration(Integer.parseInt(item.getElementsByTagName("duration").item(0).getTextContent()));
		e.setGenre(Genre.valueOf(item.getElementsByTagName("genre").item(0).getTextContent()));
		e.setPG(item.getAttribute("pg") != null);
		return e;
	}

}
