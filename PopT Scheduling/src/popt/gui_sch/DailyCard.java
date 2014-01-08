package popt.gui_sch;

import javax.swing.JPanel;

public class DailyCard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8201243940293209245L;
	
	private OptionPanel optPanel;
	private TimeBar timeBar;
	private HallPanelContainer hallPCont;
	
	/**
	 * Create the panel.
	 */
	public DailyCard() {
		
		optPanel = new OptionPanel();
		timeBar = new TimeBar();
		hallPCont = new HallPanelContainer();
		this.add(optPanel);
		this.add(timeBar);
		this.add(hallPCont);
	}

	public OptionPanel getOptPanel() {
		return optPanel;
	}

	public TimeBar getTimeBar() {
		return timeBar;
	}

	public HallPanelContainer getHallPCont() {
		return hallPCont;
	}

}
