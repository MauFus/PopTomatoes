package popt.ctrl_sch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import popt.gui_sch.SchedulerView;
import popt.model_sch.SchedulerModel;

public class SchedulerController {
	
	private SchedulerModel model;
	private SchedulerView view;

	public SchedulerController(SchedulerView v, SchedulerModel m) {
		view = v;
		model = m;
		
		// Instantiate all DailyCardController
		new DailyCardController(view.getSchContainerTh(), model.getThursdaySchedule());
		new DailyCardController(view.getSchContainerFr(), model.getFridaySchedule());
		new DailyCardController(view.getSchContainerSa(), model.getSaturdaySchedule());
		new DailyCardController(view.getSchContainerSu(), model.getSundaySchedule());
		new DailyCardController(view.getSchContainerMo(), model.getMondaySchedule());
		new DailyCardController(view.getSchContainerTu(), model.getTuesdaySchedule());
		new DailyCardController(view.getSchContainerWe(), model.getWednesdaySchedule());
		
		view.getBtnAccept().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Gestire il pulsante accept
				
			}
		});
	}

}
