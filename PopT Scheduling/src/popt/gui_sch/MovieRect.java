package popt.gui_sch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTextPane;

import sun.security.util.Length;

public class MovieRect extends JTextPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1214497401382184679L;
	private int xMin, yMin, xMax, yMax, xOld, yOld, xNew;
	private Dimension size;
	private int startTime, finishTime;
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
				//System.out.println("mouse released!");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//System.out.println("mouse pressed!");
				xOld = e.getX();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
				//setText("Movie Title");
				//System.out.println("mouse exited!");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(color.getRed()+100,color.getGreen()+100,color.getBlue()+100));
				//setText("s: "+getStartTime()+"f: "+getFinishTime() );
				//System.out.println("mouse entered!");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse clicked!");
				// TODO Auto-generated method stub

			}
		});

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				//System.out.println("mouse moved!");
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				//System.out.println("mouse dragged!");
		            xNew = e.getX();
		            setPosition(getxMin()+xNew-xOld,getyMin());
		            //startTime=getStartTime();
		            //finishTime=getFinishTime();
		            //setText("s: "+getStartTime()+"f: "+getFinishTime() );
		            //xNew = getxMin()+xNew-xOld;
		            repaint();
			}
		});
	}

	public void setPosition(int x, int y) {
		this.setLocation(x, y);
	}

	public int getxMin() {
		System.out.println("x min is:" + this.getX());
		return this.getX();
	}

	public int getyMin() {
		return this.getY();
	}

	public int getxMax() {
		return (this.getxMin() + this.size.width);
	}

	public int getyMax() {
		return (this.getyMin() - this.size.height);
	}

	public int getStartTime() {
		return getxMin()+xNew-xOld;
	}

	public int getFinishTime() {
		return (getxMin()+xNew-xOld)+this.size.width;
	}
	
}
