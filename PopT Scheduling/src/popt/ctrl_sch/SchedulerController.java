package popt.ctrl_sch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.BorderFactory;
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
	
	private static SchedulerModel model;
	private static SchedulerView view;

	public static final String MOVIE_LIST = "movielist.xml";

	public SchedulerController(SchedulerView v, SchedulerModel m) {
		view = v;
		model = m;
		
		uploadMovieList();
		uploadCinemaHallList();
		uploadScheduledShowtimes();
		
		// Instantiate all DailyCardController
		final DailyCardController ctrlTh = new DailyCardController(view.getSchContainerTh(), model.getThursdaySchedule());
		final DailyCardController ctrlFr = new DailyCardController(view.getSchContainerFr(), model.getFridaySchedule());
		final DailyCardController ctrlSa = new DailyCardController(view.getSchContainerSa(), model.getSaturdaySchedule());
		final DailyCardController ctrlSu = new DailyCardController(view.getSchContainerSu(), model.getSundaySchedule());
		final DailyCardController ctrlMo = new DailyCardController(view.getSchContainerMo(), model.getMondaySchedule());
		final DailyCardController ctrlTu = new DailyCardController(view.getSchContainerTu(), model.getTuesdaySchedule());
		final DailyCardController ctrlWe = new DailyCardController(view.getSchContainerWe(), model.getWednesdaySchedule());
		
		view.getBtnAccept().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean allCardsValidated = ctrlTh.validateCard();
				allCardsValidated &= ctrlFr.validateCard();
				allCardsValidated &= ctrlSa.validateCard();
				allCardsValidated &= ctrlSu.validateCard();
				allCardsValidated &= ctrlMo.validateCard();
				allCardsValidated &= ctrlTu.validateCard();
				allCardsValidated &= ctrlWe.validateCard();
				
				if (allCardsValidated) {
					Main.deleteShowtimes(model.getThursdaySchedule().getDate());
					for (Showtime showtime : model.getThursdaySchedule().getShowList()) {
						Main.insertShowtime(showtime);
					}

					Main.deleteShowtimes(model.getFridaySchedule().getDate());
					for (Showtime showtime : model.getFridaySchedule().getShowList()) {
						Main.insertShowtime(showtime);
					}

					Main.deleteShowtimes(model.getSaturdaySchedule().getDate());
					for (Showtime showtime : model.getSaturdaySchedule().getShowList()) {
						Main.insertShowtime(showtime);
					}

					Main.deleteShowtimes(model.getSundaySchedule().getDate());
					for (Showtime showtime : model.getSundaySchedule().getShowList()) {
						Main.insertShowtime(showtime);
					}

					Main.deleteShowtimes(model.getMondaySchedule().getDate());
					for (Showtime showtime : model.getMondaySchedule().getShowList()) {
						Main.insertShowtime(showtime);
					}

					Main.deleteShowtimes(model.getTuesdaySchedule().getDate());
					for (Showtime showtime : model.getTuesdaySchedule().getShowList()) {
						Main.insertShowtime(showtime);
					}

					Main.deleteShowtimes(model.getWednesdaySchedule().getDate());
					for (Showtime showtime : model.getWednesdaySchedule().getShowList()) {
						Main.insertShowtime(showtime);
					}
				}
			}
		});
	}
	
	/**
	 * Resetta i colori di feedback sui bottoni dei giorni
	 */
	private static void resetButtonColors() {
		view.getButtonTh().setBorder(BorderFactory.createEmptyBorder());
		view.getButtonFr().setBorder(BorderFactory.createEmptyBorder());
		view.getButtonSa().setBorder(BorderFactory.createEmptyBorder());
		view.getButtonSu().setBorder(BorderFactory.createEmptyBorder());
		view.getButtonMo().setBorder(BorderFactory.createEmptyBorder());
		view.getButtonTu().setBorder(BorderFactory.createEmptyBorder());
		view.getButtonWe().setBorder(BorderFactory.createEmptyBorder());
	}
	
	/**
	 * Colora i bordi dei pulsanti dei giorni in base allo stato di validazione
	 */
	public static void markupValuatedStatus() {
		resetButtonColors();
		view.getButtonTh().setBorder(model.getThursdaySchedule().getValidated() > 0 ? 
				(BorderFactory.createLineBorder((model.getThursdaySchedule().getValidated() > 1 ? 
						Color.GREEN : Color.RED),2)) : BorderFactory.createEmptyBorder());

		view.getButtonFr().setBorder(model.getFridaySchedule().getValidated() > 0 ? 
				(BorderFactory.createLineBorder((model.getFridaySchedule().getValidated() > 1 ? 
						Color.GREEN : Color.RED),2)) : BorderFactory.createEmptyBorder());

		view.getButtonSa().setBorder(model.getSaturdaySchedule().getValidated() > 0 ? 
				(BorderFactory.createLineBorder((model.getSaturdaySchedule().getValidated() > 1 ? 
						Color.GREEN : Color.RED),2)) : BorderFactory.createEmptyBorder());

		view.getButtonSu().setBorder(model.getSundaySchedule().getValidated() > 0 ? 
				(BorderFactory.createLineBorder((model.getSundaySchedule().getValidated() > 1 ? 
						Color.GREEN : Color.RED),2)) : BorderFactory.createEmptyBorder());

		view.getButtonMo().setBorder(model.getMondaySchedule().getValidated() > 0 ? 
				(BorderFactory.createLineBorder((model.getMondaySchedule().getValidated() > 1 ? 
						Color.GREEN : Color.RED),2)) : BorderFactory.createEmptyBorder());

		view.getButtonTu().setBorder(model.getTuesdaySchedule().getValidated() > 0 ? 
				(BorderFactory.createLineBorder((model.getTuesdaySchedule().getValidated() > 1 ? 
						Color.GREEN : Color.RED),2)) : BorderFactory.createEmptyBorder());

		view.getButtonWe().setBorder(model.getWednesdaySchedule().getValidated() > 0 ? 
				(BorderFactory.createLineBorder((model.getWednesdaySchedule().getValidated() > 1 ? 
						Color.GREEN : Color.RED),2)) : BorderFactory.createEmptyBorder());
		
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
        int delay = (11 - Integer.parseInt(weekDay.format(today)));
        Date thu = new Date(today.getTime() + 86400000*delay);
        Date fri = new Date(thu.getTime() + 86400000);
        Date sat = new Date(fri.getTime() + 86400000);
        Date sun = new Date(sat.getTime() + 86400000);
        Date mon = new Date(sun.getTime() + 86400000);
        Date tue = new Date(mon.getTime() + 86400000);
        Date wed = new Date(tue.getTime() + 86400000);
        
        model.getThursdaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(thu), "")));
        model.getFridaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(fri), "")));
        model.getSaturdaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(sat), "")));
        model.getSundaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(sun), "")));
        model.getMondaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(mon), "")));
        model.getTuesdaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(tue), "")));
        model.getWednesdaySchedule().setShowList(Main.searchShowtimes(new Showtime(0l, null, null, onlyDate.format(wed), "")));

		model.getThursdaySchedule().setDate(onlyDate.format(thu));
		model.getFridaySchedule().setDate(onlyDate.format(fri));
		model.getSaturdaySchedule().setDate(onlyDate.format(sat));
		model.getSundaySchedule().setDate(onlyDate.format(sun));
		model.getMondaySchedule().setDate(onlyDate.format(mon));
		model.getTuesdaySchedule().setDate(onlyDate.format(tue));
		model.getWednesdaySchedule().setDate(onlyDate.format(wed));
	}

	/**
	 * Reads movieList.xml file
	 */
	public static void uploadMovieList() {
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
		
		view.revalidate();
		view.repaint();
	}

	/**
	 * 
	 * @param item the element parsed from the file
	 * @return an object movie
	 */
	private static Movie createMovieFromFile(Element item) {
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
