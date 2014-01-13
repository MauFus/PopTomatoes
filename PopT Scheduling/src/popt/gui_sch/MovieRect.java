package popt.gui_sch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTextPane;

public class MovieRect extends JTextPane {

	private static final long serialVersionUID = -1214497401382184679L;
	private int xOld;
	private Dimension size;
	private Color color;
	
	public MovieRect(int w, int h, Color c) {

		size = new Dimension(w,h);
		setPreferredSize(size);
		this.setEditable(false);
		color = c;
		this.setBackground(color);
		this.setFocusable(false);
		this.setToolTipText("Movie Title");
		this.setText("Moviaamoawbdj");
		this.setDragEnabled(true);
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				setBounds(getX(), getY(), getWidth(), getHeight());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				xOld = e.getX();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(color.getRed()+100,color.getGreen()+100,color.getBlue()+100));
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
				setLocation(getX() + xNew - xOld, getY());
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
	
}
