/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Modello per l'interfaccia dello Scheduler
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.model_sch;

public class SchedulerModel {
	
	private DailyCardModel thursdaySchedule;
	private DailyCardModel fridaySchedule;
	private DailyCardModel saturdaySchedule;
	private DailyCardModel sundaySchedule;
	private DailyCardModel mondaySchedule;
	private DailyCardModel tuesdaySchedule;
	private DailyCardModel wednesdaySchedule;
	
	public SchedulerModel() {
		thursdaySchedule = new DailyCardModel();
		fridaySchedule = new DailyCardModel();
		saturdaySchedule = new DailyCardModel();
		sundaySchedule = new DailyCardModel();
		mondaySchedule = new DailyCardModel();
		tuesdaySchedule = new DailyCardModel();
		wednesdaySchedule = new DailyCardModel();
	}

	public DailyCardModel getThursdaySchedule() {
		return thursdaySchedule;
	}

	public DailyCardModel getFridaySchedule() {
		return fridaySchedule;
	}

	public DailyCardModel getSaturdaySchedule() {
		return saturdaySchedule;
	}

	public DailyCardModel getSundaySchedule() {
		return sundaySchedule;
	}

	public DailyCardModel getMondaySchedule() {
		return mondaySchedule;
	}

	public DailyCardModel getTuesdaySchedule() {
		return tuesdaySchedule;
	}

	public DailyCardModel getWednesdaySchedule() {
		return wednesdaySchedule;
	}
}
