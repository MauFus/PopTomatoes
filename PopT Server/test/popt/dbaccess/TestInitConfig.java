/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Classe atta alla lettura ed al salvataggio della configurazione iniziale.
 * 
 * @author Matteo Ronchi & Fustinoni Mauro
 * @date october 2013
 */

package popt.dbaccess;

import org.junit.Test;

public class TestInitConfig {

	@Test
	public void testReadInitialConfig() throws Exception {
		XMLInitialConfig.readInitialConfig();
	}

}
