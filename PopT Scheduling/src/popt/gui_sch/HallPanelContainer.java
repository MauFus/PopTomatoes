package popt.gui_sch;

import javax.swing.JPanel;

public class HallPanelContainer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8296948967595551796L;

	private HallPanel hallPanel;
	
	/**
	 * Create the panel.
	 */
	public HallPanelContainer() {
		
		hallPanel = new HallPanel();
		this.add(hallPanel);
	}
}
