package popt.dbaccess;

import static org.junit.Assert.*;

import org.junit.Test;

import popt.data.CinemaHall;
import popt.data.Genre;
import popt.data.Movie;

public class MySQLAccessTest {
	
	MySQLAccess dba = new MySQLAccess();

	@Test
	public final void testSearchHall() throws Exception {
		dba.readDB();
		assertTrue(dba.insertCinemaHall('z', "Sala di test", 1, 4, 2));
		assertNotNull(dba.searchHall('z'));
		dba.closeDB();
	}

	@Test
	public final void testSearchHallNontEquals() throws Exception {
		dba.readDB();
		assertNotEquals(dba.searchHall('z'), new CinemaHall('p', "Sala di test", 1, 4, 2));
		dba.closeDB();
	}

	@Test
	public final void testSearchHalls() throws Exception {
		dba.readDB();
		assertNotNull(dba.searchHalls());
		dba.closeDB();
	}

	@Test
	public final void testSearchHallSeats() throws Exception {
		dba.readDB();
		assertTrue(dba.insertRow('z', 1, 4));
		assertNotNull(dba.searchHallSeats('z'));
		dba.closeDB();
	}
	
	@Test
	public final void testSearchMovie() throws Exception {
		dba.readDB();
		assertTrue(dba.insertMovie("Movie di prova", 10, "12-12-2012", Genre.ACTION.toString(), false));
		assertNotNull(dba.searchMovie(0, "Movie di prova", 10, "12-12-2012", Genre.ACTION, false));
		dba.closeDB();
	}

	@Test
	public final void testSearchShowtimes() throws Exception {
		dba.readDB();
		Movie m = dba.searchMovie(0, "Movie di prova", 10, "", (Genre)null, false).getFirst();
		CinemaHall h = dba.searchHall('z');
		assertTrue(dba.insertShowtime(m, h, "13-12-2013", "20:00"));
		assertNotNull(dba.searchShowtimes(0, m, h, "13-12-2013", "20:00"));
		long id = dba.searchShowtimes(0, null, h, "", "").getFirst().getId();
		assertTrue(dba.updateShowtimeAuditors(id, 5));
		dba.closeDB();
	}

	@Test
	public final void testDeleteShowtimes() throws Exception {
		dba.readDB();
		assertTrue(dba.deleteShowtimes("13-12-2013"));
		dba.closeDB();
	}

}
