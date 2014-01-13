package popt.gui_sch;

import java.awt.Color;
import javax.swing.JPanel;

public class MovieLine extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5314001806476548519L;

	
	public MovieLine() {
		setLayout(null);
		
		// rettangoli di prova
		MovieRect r = new MovieRect(90, 50,(new Color(100,0,0)));
		r.setBounds(117, 25, 90, 50);
		MovieRect r1 = new MovieRect(120, 50,(new Color(0,100,0)));
		r1.setBounds(212, 25, 120, 50);
		add(r);
		add(r1);
	}
}
