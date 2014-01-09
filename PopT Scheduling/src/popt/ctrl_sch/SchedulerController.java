package popt.ctrl_sch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import popt.data.Genre;
import popt.data.Movie;
import popt.gui_sch.SchedulerView;
import popt.model_sch.SchedulerModel;

public class SchedulerController {
	
	private SchedulerModel model;
	private SchedulerView view;

	public static final String MOVIE_LIST = "movielist.xml";

	public SchedulerController(SchedulerView v, SchedulerModel m) {
		view = v;
		model = m;
		
		uploadMovieList();
		uploadCinemaHallList();
		uploadScheduledShowtimes();
		
		// Instantiate all DailyCardController
		new DailyCardController(view.getSchContainerTh(), model.getThursdaySchedule());
		new DailyCardController(view.getSchContainerFr(), model.getFridaySchedule());
		new DailyCardController(view.getSchContainerSa(), model.getSaturdaySchedule());
		new DailyCardController(view.getSchContainerSu(), model.getSundaySchedule());
		new DailyCardController(view.getSchContainerMo(), model.getMondaySchedule());
		new DailyCardController(view.getSchContainerTu(), model.getTuesdaySchedule());
		new DailyCardController(view.getSchContainerWe(), model.getWednesdaySchedule());
		
		view.getBtnAccept().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Gestire il pulsante accept
				
			}
		});
	}

	private void uploadCinemaHallList() {
		// TODO Auto-generated method stub
		
	}

	private void uploadScheduledShowtimes() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Reads movieList.xml file
	 */
	private void uploadMovieList() {
		LinkedList<Movie> movies = new LinkedList<>();
		try {
			Document fileList;
			fileList = loadDocument(MOVIE_LIST);
			NodeList moviesFromFile = fileList.getElementsByTagName("Movie");
			for (int i = 0; i < moviesFromFile.getLength(); i++) {
				Movie mTemp = createMovieFromFile((Element) moviesFromFile
						.item(i));
				movies.add(mTemp);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return;
		}

		model.getThursdaySchedule().setMovieList(movies);
		model.getFridaySchedule().setMovieList(movies);
		model.getSaturdaySchedule().setMovieList(movies);
		model.getSundaySchedule().setMovieList(movies);
		model.getMondaySchedule().setMovieList(movies);
		model.getTuesdaySchedule().setMovieList(movies);
		model.getWednesdaySchedule().setMovieList(movies);
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

}
