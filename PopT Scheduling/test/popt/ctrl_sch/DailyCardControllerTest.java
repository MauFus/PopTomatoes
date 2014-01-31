package popt.ctrl_sch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import popt.data.CinemaHall;
import popt.data.Genre;
import popt.data.Movie;
import popt.data.Showtime;
import popt.gui_sch.DailyCard;
import popt.model_sch.DailyCardModel;

public class DailyCardControllerTest {

	DailyCardController daily;
	DailyCardModel model;
	
	@Before
	public void setUp() throws Exception {
		model = new DailyCardModel();
		daily = new DailyCardController(new DailyCard(), model);
	}

	@Test
	public final void testValidateCard() {
		CinemaHall hall = new CinemaHall('z', "Sala di Prova", 5, 25, 2);
		model.getHallList().add(hall);
		model.getShowList().add(new Showtime(101, new Movie(1001, "Movie1", 20, "", Genre.ACTION, false), hall, "", "20:00"));
		model.getShowList().add(new Showtime(101, new Movie(1001, "Movie2", 20, "", Genre.ACTION, false), hall, "", "18:00"));
		assertTrue(daily.validateCard());
	}

	@Test
	public final void testValidateCardFailGap() {
		CinemaHall hall = new CinemaHall('z', "Sala di Prova", 5, 25, 2);
		model.getHallList().add(hall);
		model.getShowList().add(new Showtime(101, new Movie(1001, "Movie1", 20, "", Genre.ACTION, false), hall, "", "20:00"));
		model.getShowList().add(new Showtime(101, new Movie(1001, "Movie2", 20, "", Genre.ACTION, false), hall, "", "19:00"));
		assertFalse(daily.validateCard());
	}

}
