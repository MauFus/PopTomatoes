package popt.gui_sch;

import java.awt.GridLayout;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;

public class HallPanelContainer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8296948967595551796L;
	
	/**
	 * Create the panel.
	 */
	public HallPanelContainer() {
		
		setBackground(new Color(102, 204, 0));
		setBorder(null);
		this.setLayout(new GridLayout(0,1,0,10));
		HallPanel hallPanel = new HallPanel();
		hallPanel.getMovieLine().setBackground(UIManager.getColor("Button.background"));
		hallPanel.setBorder(null);
		this.add(hallPanel);
	}
}
