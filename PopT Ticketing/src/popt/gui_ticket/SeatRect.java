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
    
    boolean clicked = false;
    boolean suggest = false;
    boolean free = false;
    RectStatus status = RectStatus.FREE;
	
	public SeatRect() {
		super();
		setPreferredSize(new Dimension(20, 20));
        setOpaque(false);
        
        switch (status) {
		case FREE:
			setBackground(new Color(200,200,200));
			break;
		case BUSY:
			setBackground(new Color(100,100,100));
			break;
		case CHECKED:
			setBackground(new Color(0,200,0));
			break;
		case SUGGESTED:
			setBackground(new Color(200,240,0));
			break;
		default:
			break;
		}
        
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
				switch (status) {
				case FREE:
					setBackground(new Color(200,200,200));
					break;
				case BUSY:
					
					break;
				case CHECKED:
					
					break;
				case SUGGESTED:
					
					break;
				default:
					break;
				}
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				switch (status) {
				case FREE:
					setBackground(new Color(240,240,240));
					break;
				case BUSY:
					
					break;
				case CHECKED:
					
					break;
				case SUGGESTED:
					
					break;
				default:
					break;
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clicked = !clicked;
				if(free == false && clicked == true && status==RectStatus.FREE){
				    status = RectStatus.CHECKED;
					free = !free;
					}
				else if(free == true && clicked == false && status==RectStatus.CHECKED){
					status = RectStatus.FREE;
					free = !free;
				}
				else if(status==RectStatus.BUSY)
					status = RectStatus.BUSY;
				else if(suggest == false && clicked == true && status==RectStatus.SUGGESTED){
					status = RectStatus.CHECKED;
					suggest = !suggest;
					}
				else if(suggest == true && clicked == false && status==RectStatus.CHECKED){
					status = RectStatus.SUGGESTED;
					suggest = !suggest;
					}
				switch (status) {
				case FREE:
					setBackground(new Color(200,200,200));
					break;
				case BUSY:
					break;
				case CHECKED:
					setBackground(new Color(0,200,0));
					break;
				case SUGGESTED:
					setBackground(new Color(200,240,0));
					break;
				default:
					break;
				}
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
