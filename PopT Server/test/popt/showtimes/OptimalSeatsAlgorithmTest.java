package popt.showtimes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OptimalSeatsAlgorithmTest {
	
	int[][] matrix1 = {{1, 2, 3, 2, 1}, {2, 3, 4, 3, 2}, {3, 4, 5, 4, 3}, {4, 5, 6, 5, 4}, {5, 6, 7, 6, 5}};
	int[][] matrix2 = {{1, 0, 2, 0, 1}, {3, 0, 6, 0, 2}, {3, 4, 8, 0, 4}, {5, 0, 10, 0, 5}, {5, 0, 9, 0, 5}};
	int[][] matrix3 = {{1, 0, 2, 0, 1}, {3, 0, 6, 0, 2}, {4, 0, 8, 0, 4}, {5, 0, 10, 0, 5}, {5, 0, 9, 0, 5}};
	
	OptimalSeatsAlgorithm algo;

	@Before
	public void setUp() throws Exception {
		algo = new OptimalSeatsAlgorithm();
	}

	@Test
	public final void testExecute1() {
		assertEquals(6, (algo.execute(matrix1, 3)).size());
	}

	@Test
	public final void testExecute2() {
		assertEquals(3, (algo.execute(matrix2, 3)).size());
	}

	@Test
	public final void testExecute3() {
		assertEquals(0, (algo.execute(matrix3, 3)).size());
	}

}
