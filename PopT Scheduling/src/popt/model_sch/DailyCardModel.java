package popt.model_sch;

import java.util.LinkedList;

import popt.data.Showtime;

public class DailyCardModel {

	private int gap;
	private int opening;
	private int closing;
	private LinkedList<Showtime> showList;
	
	public DailyCardModel() {
		gap = 45;
		opening = 14;
		closing = 22;
		showList = new LinkedList<Showtime>();
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		if (gap > 0)
			this.gap = gap;
	}

	public int getOpening() {
		return opening;
	}

	public void setOpening(int opening) {
		if (opening > 14 && opening < closing)
			this.opening = opening;
	}

	public int getClosing() {
		return closing;
	}

	public void setClosing(int closing) {
		if (closing < 22 && closing > opening)
			this.closing = closing;
	}

	public LinkedList<Showtime> getShowList() {
		return showList;
	}
}
