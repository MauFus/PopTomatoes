package popt.model_sch;

import java.util.LinkedList;

import popt.data.Showtime;

public class DailyCardModel {

	private boolean isValidated;
	private int gap;
	private int opening;
	private int closing;
	private LinkedList<Showtime> showList;
	
	public DailyCardModel() {
		isValidated = false;
		gap = 45;
		opening = 14;
		closing = 02;
		showList = new LinkedList<Showtime>();
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public int getOpening() {
		return opening;
	}

	public void setOpening(int opening) {
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
