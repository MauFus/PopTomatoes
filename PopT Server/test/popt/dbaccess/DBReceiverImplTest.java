package popt.dbaccess;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import popt.data.Genre;
import popt.data.Movie;
import popt.data.Showtime;

public class DBReceiverImplTest {
	
	DBReceiverImpl dbr;
	
	public DBReceiverImplTest() throws RemoteException {
		dbr = new DBReceiverImpl();
	}
	
	@Test
	public final void testInsertMovie() throws RemoteException {
		assertTrue(dbr.insertMovie(new Movie("Movie di prova2", 10, "12-12-2012", Genre.ACTION, false)));
		assertEquals(new String("Inserimento in DB eseguito con successo!\n"), dbr.getStatus());
	}

	@Test
	public final void testSearchMovie() throws RemoteException {
		assertNotNull(dbr.searchMovie(new Movie("Movie di prova", 0, "", Genre.ACTION, false)));
	}

	@Test
	public final void testSearchShowtime() throws RemoteException {
		dbr.insertShowtime(new Showtime(0, null, null, "13-12-2013", "21:00"));
		assertNotNull(dbr.searchShowtime(new Showtime(0, null, null, "13-12-2013", "")));
	}

	@Test
	public final void testDeleteShowtime() throws RemoteException {
		//Movie m = dbr.searchMovie(new Movie("Movie di prova2", 10, "", (Genre)null, false)).getFirst();
		//assertTrue(dbr.insertShowtime(new Showtime(0, m, null, "12-12-2013", "21:00")));
		assertTrue(dbr.deleteShowtimes("1-12-2013"));
	}

	@Test
	public final void testSearchCinemaHalls() throws RemoteException {
		assertNotNull(dbr.searchCinemaHalls());
	}

	@Test
	public final void testIsAvailable() throws RemoteException {
		assertTrue(dbr.isAvailable());
	}

}
