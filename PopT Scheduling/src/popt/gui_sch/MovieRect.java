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
		// this.setToolTipText("Movie Title");
		this.setText("Il lato...Oscuro");
		this.setDragEnabled(true);

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				setText("Il lato...Oscuro");
				setBounds(getX(), getY(), getWidth(), getHeight());
				// setta l'orario di inizio nell'oggetto showtime
				movieRectModel
						.setTime((14 + getX() / 60) + ":" + (getX() % 60));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				xOld = e.getX();
				setText(((14 + getX() / 60) % 24) + ":"
						+ (getX() % 60 < 10 ? "0" : "") + (getX() % 60) + "   "
						+ ((14 + getFinishTime() / 60) % 24) + ":"
						+ (getFinishTime() % 60 < 10 ? "0" : "")
						+ (getFinishTime() % 60));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(color.getRed() + 100,
						color.getGreen() + 100, color.getBlue() + 100));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int xNew = e.getX();
				int xRectOld = getStartTime();

				if (xNew < xOld - xRectOld)
					xNew = xOld - xRectOld;
				else if (xNew > 720 - (xRectOld + size.width - xOld))
					xNew = 720 - (xRectOld + size.width - xOld);

				setLocation(getX() + xNew - xOld, getY());
				setText(((14 + getX() / 60) % 24) + ":"
						+ (getX() % 60 < 10 ? "0" : "") + (getX() % 60) + "   "
						+ ((14 + getFinishTime() / 60) % 24) + ":"
						+ (getFinishTime() % 60 < 10 ? "0" : "")
						+ (getFinishTime() % 60));
				repaint();
			}
		});
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

}
