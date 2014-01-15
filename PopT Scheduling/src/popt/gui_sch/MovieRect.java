package popt.gui_sch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTextPane;

import popt.data.Showtime;

public class MovieRect extends JTextPane {

	private static final long serialVersionUID = -1214497401382184679L;
	private Showtime movieRectModel;
	private int xOld;
	private Dimension size;
	private Color color;

	public MovieRect(int w, int h, Color c) {

		size = new Dimension(w, h);
		setPreferredSize(size);
		this.setEditable(false);
		color = c;
		this.setBackground(color);
		this.setFocusable(false);
		this.setDragEnabled(true);
	}

	public int getStartTime() {
		return getX();
	}

	public int getFinishTime() {
		return getX() + size.width;
	}

	public Showtime getMovieRectModel() {
		return movieRectModel;
	}

	public void setMovieRectModel(Showtime movieRectModel) {
		this.movieRectModel = movieRectModel;
		this.setText(this.movieRectModel.getMovie().getTitle());
	}

	public int getxOld() {
		return xOld;
	}

	public Dimension getSize() {
		return size;
	}

	public Color getColor() {
		return color;
	}

	public void setxOld(int xOld) {
		this.xOld = xOld;
	}
	
	
}
