package popt.gui_sch;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MovieLine extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5314001806476548519L;

	
	public MovieLine() {
		MovieRect r = new MovieRect(90, 50,(new Color(100,0,0)));
		MovieRect r1 = new MovieRect(120, 50,(new Color(0,100,0)));
		add(r);
		add(r1);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, r, 25, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, r, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, r1, 25, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, r1, 155, SpringLayout.WEST, this);
		setLayout(springLayout);
	}
}
