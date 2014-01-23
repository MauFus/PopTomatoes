package popt.gui_ticket;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import popt.model_ticket.RectStatus;

public class SeatRect extends JPanel {

	private static final long serialVersionUID = -8502100078749938385L;
	
	/** Stroke size: 1 for better view */
    protected int strokeSize = 1;
    /** Shadow color */
    protected Color shadowColor = Color.black;
    /** Sets if it drops shadow */
    protected boolean shady = false;
    /** Sets if it has an High Quality view */
    protected boolean highQuality = true;
    /** Double values for Horizontal and Vertical radius of corner arcs */
    protected Dimension arcs = new Dimension(9, 9);
    /** Distance between shadow border and opaque panel border */
    protected int shadowGap = 5;
    /** The offset of shadow.  */
    protected int shadowOffset = 4;
    /** The transparency value of shadow. ( 0 - 255) */
    protected int shadowAlpha = 150;
    
    boolean clicked=false;
    RectStatus status;
	
	
	public SeatRect() {
		super();
		setPreferredSize(new Dimension(20, 20));
        setOpaque(false);
        setBackground(new Color(150,150,150));
        addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (clicked == true){
					setBackground(new Color(0,200,0));
					clicked = false;
				}
				else
				setBackground(new Color(150,150,150));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(new Color(200,200,200));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setBackground(new Color(0,200,0));
				clicked = true;
				
			}
		});
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int shadowGap = this.shadowGap;
        Color shadowColorA = new Color(shadowColor.getRed(), 
	shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
        Graphics2D graphics = (Graphics2D) g;

        //Sets antialiasing if HQ.
        if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Draws shadow borders if any.
        if (shady) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    shadowOffset,// X position
                    shadowOffset,// Y position
                    width - strokeSize - shadowOffset, // width
                    height - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
        } else {
            shadowGap = 1;
        }

        //Draws the rounded opaque panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - shadowGap, 
		height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(getForeground());       
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap, 
		height - shadowGap, arcs.width, arcs.height);

        //Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }

	public RectStatus getStatus() {
		return status;
	}

	public void setStatus(RectStatus status) {
		this.status = status;
	}

}
