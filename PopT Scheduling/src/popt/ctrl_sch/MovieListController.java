package popt.ctrl_sch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.w3c.dom.ls.*;
import org.xml.sax.SAXException;

import popt.data.*;
import popt.gui_sch.*;
import popt.main_sch.Main;
import popt.model_sch.MovieListModel;

public class MovieListController {

	private MovieListModel model;
	private MovieListView view;
	private SearchMovieDialog searchDialog;

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
		view.getBtnInsert().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchDialog = new SearchMovieDialog(MainView.getGuiFrame());
				searchDialog.setVisible(true);
				initDialogListeners();
			}
		});
	}
	
	private void initDialogListeners() {
		searchDialog.getTextID().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Integer.parseInt(searchDialog.getTextID().getText());
				} catch (NumberFormatException nfe) {
					if (!searchDialog.getTextID().getText().equals(""))
						searchDialog.getTextID().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				searchDialog.getTextID().setBorder(BorderFactory.createEmptyBorder());
			}
		});
		
		searchDialog.getTextDuration().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Integer.parseInt(searchDialog.getTextDuration().getText());
				} catch (NumberFormatException nfe) {
					if (!searchDialog.getTextDuration().getText().equals(""))
						searchDialog.getTextDuration().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				searchDialog.getTextDuration().setBorder(BorderFactory.createEmptyBorder());
			}
		});
		
		searchDialog.getTextYear().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				try {
					int anno = Integer.parseInt(searchDialog.getTextYear().getText());
					if (anno < 1900)
						throw new NumberFormatException();
				} catch (NumberFormatException nfe) {
					if (!searchDialog.getTextYear().getText().equals(""))
						searchDialog.getTextYear().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				searchDialog.getTextYear().setBorder(BorderFactory.createEmptyBorder());
			}
		});
		
		searchDialog.getCancelButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchDialog.setVisible(false);
				searchDialog = null;				
			}
		});
		
		searchDialog.getSearchButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Movie toSearch = new Movie();
				try {
					if (!searchDialog.getTextID().getText().equals(""))
						toSearch.setID(Integer.parseInt(searchDialog.getTextID().getText()));
					else 
						toSearch.setID(-1);
					
					if (!searchDialog.getTextDuration().getText().equals(""))
						toSearch.setDuration(Integer.parseInt(searchDialog.getTextDuration().getText()));
					else
						toSearch.setDuration(-1);
					
					if (!searchDialog.getTextYear().getText().equals("")) {
						Integer a = Integer.parseInt(searchDialog.getTextYear().getText());
						toSearch.setDate(a.toString());
					} else
						toSearch.setDate("");
				} catch (NumberFormatException nfe) {
					return;
				}
				
				toSearch.setTitle(searchDialog.getTextTitle().getText());
				
				if (searchDialog.getComboGenre().getSelectedIndex() != 0)
					toSearch.setGenre(Genre.valueOf(searchDialog.getComboGenre().getSelectedItem().toString()));
				else
					toSearch.setGenre(null);
				
				toSearch.setPG(searchDialog.getCheckBoxPG().isSelected());
				
				// it start the search
				model.setSearchList(Main.searchMovie(toSearch));

				if (model.getSearchList() != null) {
					for (Movie m : model.getSearchList()) {
						searchDialog.getPnQueryResults().add(new JRadioButtonMenuItem("ID: " + m.getID()
									+ " : " + m.getTitle() + " (" + m.getDate().split("-")[2] + ")"));
					}
				}
			}
		});
		
		searchDialog.getInsertButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ID = null;
				for (int k = 0;	k < searchDialog.getPnQueryResults().getComponentCount(); k++) {
					if (((JRadioButtonMenuItem) searchDialog.getPnQueryResults().getComponent(k)).isSelected()) {
						ID = ((JRadioButtonMenuItem) searchDialog.getPnQueryResults().getComponent(k)).getText().split(":")[1].trim();
						break;
					}
				}

				if (ID != null && model.getSearchList() != null) {
					Movie selected = null;
					for (Movie m : model.getSearchList()) {
						if (m.getID() == Integer.parseInt(ID))
							selected = m;
					}
					if (selected != null)
						model.insertMovie(selected);
				}
			}
		});
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
