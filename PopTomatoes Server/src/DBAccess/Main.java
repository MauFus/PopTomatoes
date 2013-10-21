package DBAccess;

public class Main {

	public static void main(String[] args) throws Exception {
		MySQLAccess dao = new MySQLAccess();
		dao.readDB();
		dao.insertCinemaHall('A', "Sala MINO", 10, 100, 4);
		dao.insertRow('A', 2, 14);
		dao.insertRow('A', 3, 18);
		dao.insertRow('A', 4, 18);
		dao.closeDB();
	}

}
