package popt.ctrl_ticket;

import popt.gui_ticket.MainView;
import popt.model_ticket.TicketSellModel;

public class TicketSellController {
	
	private TicketSellModel model;
	private MainView view;

	public TicketSellController(TicketSellModel model, MainView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * @return the model
	 */
	public TicketSellModel getModel() {
		return model;
	}

	/**
	 * @return the view
	 */
	public MainView getView() {
		return view;
	}
}
