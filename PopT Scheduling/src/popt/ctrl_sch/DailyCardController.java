package popt.ctrl_sch;

import popt.gui_sch.DailyCard;
import popt.model_sch.DailyCardModel;

public class DailyCardController {
	
	private DailyCard card;
	private DailyCardModel model;

	public DailyCardController(DailyCard view, DailyCardModel dailyModel) {
		card = view;
		model = dailyModel;
	}
}
