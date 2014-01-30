package popt.init;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RmiStarterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testStart() {
		assertTrue(RmiStarter.start());
	}

}
