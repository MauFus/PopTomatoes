package popt.ctrl_ticket;

import popt.gui_ticket.TicketSellView;
import popt.model_ticket.TicketSellModel;

public class TicketSellController {
	
	private TicketSellModel model;
	private TicketSellView view;

	public TicketSellController(TicketSellModel model, TicketSellView view) {
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
	public TicketSellView getView() {
		return view;
	}
}
