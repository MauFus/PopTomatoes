package popt.ctrl_sch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import popt.data.*;
import popt.gui_sch.SchedulerView;
import popt.main_sch.Main;
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

	/**
	 * Update CinemaHall list for each DailyCard
	 */
	private void uploadCinemaHallList() {
		LinkedList<CinemaHall> hallList = Main.searchCinemaHalls();

		model.getThursdaySchedule().setHallList(hallList);
		model.getFridaySchedule().setHallList(hallList);
		model.getSaturdaySchedule().setHallList(hallList);
		model.getSundaySchedule().setHallList(hallList);
		model.getMondaySchedule().setHallList(hallList);
		model.getTuesdaySchedule().setHallList(hallList);
		model.getWednesdaySchedule().setHallList(hallList);
	}

	/**
	 * Load Showtimes already scheduled
	 */
	private void uploadScheduledShowtimes() {
		DateFormat onlyDate = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat weekDay = new SimpleDateFormat("u");
        Date today = new Date();
        int delay = (11 - Integer.parseInt(weekDay.format(today))) % 7;
        if (delay == 0)
        	delay = 7;
        Date thu = new Date(today.getTime() + 8640000*delay);
        Date fri = new Date(thu.getTime() + 8640000);
        Date sat = new Date(fri.getTime() + 8640000);
        Date sun = new Date(sat.getTime() + 8640000);
        Date mon = new Date(sun.getTime() + 8640000);
        Date tue = new Date(mon.getTime() + 8640000);
        Date wed = new Date(tue.getTime() + 8640000);
        
        model.getThursdaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(thu), "")));
        model.getFridaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(fri), "")));
        model.getSaturdaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(sat), "")));
        model.getSundaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(sun), "")));
        model.getMondaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(mon), "")));
        model.getTuesdaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(tue), "")));
        model.getWednesdaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(wed), "")));
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
