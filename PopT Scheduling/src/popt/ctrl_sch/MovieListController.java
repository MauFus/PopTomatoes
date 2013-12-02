package popt.ctrl_sch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.w3c.dom.ls.*;
import org.xml.sax.SAXException;

import popt.data.*;
import popt.gui_sch.MovieListView;
import popt.gui_sch.MoviePanel;
import popt.model_sch.MovieListModel;

public class MovieListController {

	private MovieListModel model;
	private MovieListView view;

	public static final String MOVIE_LIST = "movielist.xml";

	public MovieListController(MovieListView v, MovieListModel m) {
		model = m;
		view = v;
		
		initListeners();
		
		try {
			uploadListInModel();
		} catch (Exception e) {
			//TODO segnalare errore alla view
			e.printStackTrace();
		}
		
		updateMovieListView();
	}
	
	/**
	 * it initializes all the listeners on the view
	 */
	private void initListeners() {
		
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
			d.appendChild(radice);

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
	 * Aggiorna la view con la lista di film contanuta nel model
	 */
	private void updateMovieListView() {
		view.getMovieListContainer().removeAll();
		
		for (Movie m : model.getMovieList()) {
			final MoviePanel mp = new MoviePanel();
			mp.getTxtpnMovieTitle().setText(m.getTitle() + " (" + m.getDate().split("-")[2] + ")");
			mp.getTxtpnGenre().setText("Genre: " + m.getGenre().toString());
			mp.getTxtpnId().setText("ID: " + m.getID());
			mp.getTxtpnDuration().setText("Duration: " + m.getDuration() + " min.");
			mp.getTxtpnPg().setText(m.isPG() ? "PG-18" : "");
			view.getMovieListContainer().add(mp);
			
			mp.getBtnCloseMovie().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Movie m = new Movie();
					m.setID(Integer.parseInt(mp.getTxtpnId().getText().split(":")[1].trim()));
					model.removeMovie(m);
					((JPanel)view.getMovieListContainer()).remove(mp);
					((JPanel)view.getMovieListContainer()).repaint();
					updateMovieListView();
					writeMovieList();
				}
			});;
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
	
	/**
	 * 
	 * @param d the document to be saved
	 * @param w the writer to save the document
	 */
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
		else
			movie.setAttribute("pg", "false");
			
		
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
		e.setPG(Boolean.valueOf(item.getAttribute("pg")));
		return e;
	}

}
