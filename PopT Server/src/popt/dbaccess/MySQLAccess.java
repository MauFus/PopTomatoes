/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe atta alla comunicazione con il DB.
 * 
 * @author Matteo Ronchi & Fustinoni Mauro
 * @date october 2013
 */

package popt.dbaccess;

import java.sql.*;
import java.util.LinkedList;

import popt.data.*;

public class MySQLAccess {
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	/**
	 * Permette di caricare i driver MySQL ed aprire la connessione con il DB
	 * 
	 * @throws Exception
	 */
	public void readDB() throws Exception {
		try {
			// load the MySQL Driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/poptomatoesdb?"
							+ "user=root");
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Permette l'inserimento in DB di una Cinema Hall
	 * 
	 * @param ch_id
	 *            Cinema Hall ID
	 * @param ch_name
	 *            Cinema Hall Name
	 * @param ch_rows
	 *            Cinema Hall Rows
	 * @param ch_seats
	 *            Cinema Hall Seats
	 * @param ch_specialseats
	 *            Cinema Hall Special Seats
	 * @throws Exception
	 */
	public void insertCinemaHall(char ch_id, String ch_name, int ch_rows,
			int ch_seats, int ch_specialseats) throws Exception {
		try {
			preparedStatement = connect
					.prepareStatement("insert into POPTOMATOESDB.CINEMAHALL values (?,?,?,?,?)");
			// "Name, Rows, Seats, SpecialSeats, from POPTOMATOESDB.CINEMAHALL");
			// Parameters start with 1
			preparedStatement.setInt(1, ch_id);
			preparedStatement.setString(2, ch_name);
			preparedStatement.setInt(3, ch_rows);
			preparedStatement.setInt(4, ch_seats);
			preparedStatement.setInt(5, ch_specialseats);
			preparedStatement.executeUpdate();

			// TEST
			resultSet = preparedStatement
					.executeQuery("select * from POPTOMATOESDB.CINEMAHALL");
			writeMetaData(resultSet);
			writeResultSetHall(resultSet);

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Permette l'inserimento in DB di una nuova Row
	 * 
	 * @param idCinemaHall
	 *            Cinema Hall ID
	 * @param r_number
	 *            Numero Row
	 * @param r_seats
	 *            Seats Row
	 * @throws Exception
	 */
	public void insertRow(char idCinemaHall, int r_number, int r_seats)
			throws Exception {
		try {
			preparedStatement = connect
					.prepareStatement("insert into POPTOMATOESDB.ROW values (?,?,?)");
			// "IdCinemaHall, Numbers, Seats from POPTOMATOESDB.ROW");
			// Parameters start with 1
			preparedStatement.setInt(1, idCinemaHall);
			preparedStatement.setInt(2, r_number);
			preparedStatement.setInt(3, r_seats);
			preparedStatement.executeUpdate();

			// TEST
			resultSet = preparedStatement
					.executeQuery("select * from POPTOMATOESDB.ROW");
			writeMetaData(resultSet);
			writeResultSetRow(resultSet);

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Permette di inserire in DB un nuovo Movie
	 * 
	 * @param mv_title
	 *            titolo del film
	 * @param mv_duration
	 *            durata in minuti
	 * @param mv_date
	 *            data di rilascio
	 * @param mv_genre
	 *            genere del film
	 * @param mv_pg
	 *            soggetto a rating pg
	 * @return
	 * @throws Exception
	 */
	public void insertMovie(String mv_title, int mv_duration, String mv_date,
			String mv_genre, boolean mv_pg) throws Exception {
		try {
			preparedStatement = connect
					.prepareStatement("insert into POPTOMATOESDB.MOVIE values (ID,?,?,?,?,?)");
			preparedStatement.setString(1, mv_title);
			preparedStatement.setInt(2, mv_duration);
			preparedStatement.setString(3, mv_date);
			preparedStatement.setString(4, mv_genre);
			preparedStatement.setBoolean(5, mv_pg);
			preparedStatement.executeUpdate();

			// Test
			resultSet = preparedStatement
					.executeQuery("select * from POPTOMATOESDB.MOVIE");
			writeMetaData(resultSet);
			writeResultSetMovie(resultSet);
			
		} catch (Exception e) {
			throw e;
		}
	}

	public LinkedList<Movie> searchMovie(int mv_id, String mv_title, int mv_duration,
			String mv_date, String mv_genre, boolean mv_pg) throws Exception {
		try {
			preparedStatement = connect
					.prepareStatement("select * from POPTOMATOESDB.MOVIE where (?) and (?) and (?) and (?) and (?) and (?)");
			preparedStatement.setString(1, mv_id == -1 ? "true" : "ID = " + mv_id);
			preparedStatement.setString(2, mv_title == null ? "true" : "lower(Title) like " + "lower('%" + mv_title + "%')");
			preparedStatement.setString(3, mv_duration == -1 ? "true" : "Duration = " + mv_duration);
			preparedStatement.setString(4, mv_date == null ? "true" : "lower(ReleaseDate) like " + "lower('%" + mv_date + "')");
			preparedStatement.setString(5, mv_genre == null ? "true" : "Genre = " + mv_genre);
			preparedStatement.setString(6, !mv_pg ? "true" : "PG = " + mv_pg);
			
			ResultSet result = preparedStatement.executeQuery();
			LinkedList<Movie> selectedMovies = new LinkedList<>();
			do {
				Movie m = new Movie(result.getInt("ID"), result.getString("Title"), result.getInt("Duration"), 
						result.getString("ReleaseDate"), Genre.valueOf(result.getString("Genre")), result.getBoolean("PG"));
				selectedMovies.push(m);
				result.next();
			} while (result != null);
			
			return selectedMovies;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * test *
	 * 
	 * @param resultSet
	 * @throws SQLException
	 */
	private void writeMetaData(ResultSet resultSet) throws SQLException {
		// Now get some metadata from the database
		// Result set get the result of the SQL query

		System.out.println("The columns in the table are: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " "
					+ resultSet.getMetaData().getColumnName(i));
		}

	}

	/**
	 * test * stampa a video i risultati riguardanti l'inserimento di sala
	 * cinematografica
	 * 
	 * @param resultSet
	 * @throws SQLException
	 */
	private void writeResultSetHall(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g.resultSet.getSTring(2);
			int ch_id = resultSet.getInt("ID");
			String name = resultSet.getString("Name");
			int rows = resultSet.getInt("Rows");
			int seats = resultSet.getInt("Seats");
			int specialseats = resultSet.getInt("SpecialSeats");
			System.out.println("ID: " + ch_id);
			System.out.println("Name: " + name);
			System.out.println("Rows: " + rows);
			System.out.println("Seats: " + seats);
			System.out.println("SpecialSeats: " + specialseats);
		}
	}

	/**
	 * test * stampa a video i risultati riguardanti l'inserimento di una Riga
	 * 
	 * @param resultSet
	 * @throws SQLException
	 */
	private void writeResultSetRow(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g.resultSet.getSTring(2);
			int cinemaHall = resultSet.getInt("CinemaHall");
			int number = resultSet.getInt("Number");
			int seats = resultSet.getInt("Seats");
			System.out.println("CinemaHall: " + cinemaHall);
			System.out.println("Number: " + number);
			System.out.println("Seats: " + seats);
		}
	}

	/**
	 * test * stampa a video i risultati riguardanti l'inserimento di un movie
	 * 
	 * @param resultSet
	 * @throws SQLException
	 */
	private void writeResultSetMovie(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g.resultSet.getSTring(2);
			String title = resultSet.getString("Title");
			int duration = resultSet.getInt("Duration");
			Date releaseDate = resultSet.getDate("ReleaseDate");
			String genre = resultSet.getString("Genre");
			boolean pg = resultSet.getBoolean("PG");
			System.out.println("Title:" + title);
			System.out.println("Duration:" + duration);
			System.out.println("Realease Date:" + releaseDate);
			System.out.println("Genre:" + genre);
			System.out.println("PG:" + pg);
		}
	}

	/**
	 * Chiude la connessione con il DB
	 */
	public void closeDB() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}
}
