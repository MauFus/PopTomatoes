package popt.gui_sch;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JTextPane;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;

import java.awt.Color;

public class HallPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5314001806476548519L;

	private MovieLine movieLine;
	private JTextPane txtpnHall;
	private JComboBox<String> comboBoxMovie;
	private char cinemaHallID;

	/**
	 * Create the panel.
	 */
	public HallPanel() {
		setBackground(new Color(132, 234, 0));
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 720, 154 };
		gridBagLayout.rowHeights = new int[] { 100, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		txtpnHall = new JTextPane();
		txtpnHall.setEditable(false);
		txtpnHall.setBackground(new Color(132,234,0));
		Insets m = new Insets(0, 5, 0, 5);
		txtpnHall.setMargin(m);
		txtpnHall.setPreferredSize(new Dimension(80, 30));
		GridBagConstraints gbc_txtpnHall = new GridBagConstraints();
		gbc_txtpnHall.insets = new Insets(0, 0, 0, 0);
		gbc_txtpnHall.gridx = 0;
		gbc_txtpnHall.gridy = 0;
		add(txtpnHall, gbc_txtpnHall);

		movieLine = new MovieLine();
		movieLine.setBackground(Color.GRAY);
		movieLine.setBorder(null);
		GridBagConstraints gbc_movieLine = new GridBagConstraints();
		gbc_movieLine.fill = GridBagConstraints.BOTH;
		gbc_movieLine.gridx = 1;
		gbc_movieLine.gridy = 0;
		add(movieLine, gbc_movieLine);

		comboBoxMovie = new JComboBox<String>();
		comboBoxMovie.setPreferredSize(new Dimension(132, 30));
		GridBagConstraints gbc_comboBoxMovie = new GridBagConstraints();
		gbc_comboBoxMovie.gridx = 2;
		gbc_comboBoxMovie.gridy = 0;
		add(comboBoxMovie, gbc_comboBoxMovie);

	}

	public MovieLine getMovieLine() {
		return movieLine;
	}

	public JTextPane getTxtpnHall() {
		return txtpnHall;
	}

	public JComboBox<String> getComboBoxMovie() {
		return comboBoxMovie;
	}

	public char getCinemaHallID() {
		return cinemaHallID;
	}

	public void setCinemaHallID(char cinemaHallID) {
		this.cinemaHallID = cinemaHallID;
	}

}
