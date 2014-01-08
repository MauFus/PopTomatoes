package popt.gui_sch;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
		JScrollPane scrb = new JScrollPane(hallPCont);
		scrb.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrb.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrb.setSize(new Dimension(1000, 510));
		this.add(optPanel);
		this.add(timeBar);
		this.add(scrb);
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
