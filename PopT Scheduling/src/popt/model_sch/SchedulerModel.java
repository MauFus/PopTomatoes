/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Modello per l'interfaccia dello Scheduler
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.model_sch;

import java.util.LinkedList;

import popt.data.Showtime;

public class SchedulerModel {
	
	private int[] gap;
	private int[] aperture;
	private int[] closure;
	private LinkedList<Showtime> thurdayShows;
	private LinkedList<Showtime> fridayShows;
	private LinkedList<Showtime> saturdayShows;
	private LinkedList<Showtime> sundayShows;
	private LinkedList<Showtime> mondayShows;
	private LinkedList<Showtime> tuesdayShows;
	private LinkedList<Showtime> wednesdayShows;
	
	public SchedulerModel() {
		for (int i = 0; i < 7; i++) {
			gap[i] = 45;
			aperture[i] = 14;
			closure[i] = 22;
			thurdayShows = new LinkedList<Showtime>();
			fridayShows = new LinkedList<Showtime>();
			saturdayShows = new LinkedList<Showtime>();
			sundayShows = new LinkedList<Showtime>();
			mondayShows = new LinkedList<Showtime>();
			tuesdayShows = new LinkedList<Showtime>();
			wednesdayShows = new LinkedList<Showtime>();
		}
	}

	public int getGap(int day) {
		return gap[day];
	}

	public void setGap(int day, int gap) {
		this.gap[day] = gap;
	}

	public int getAperture(int day) {
		return aperture[day];
	}

	public void setAperture(int day, int aperture) {
		this.aperture[day] = aperture;
	}

	public int getClosure(int day) {
		return closure[day];
	}

	public void setClosure(int day, int closure) {
		this.closure[day] = closure;
	}

	public LinkedList<Showtime> getThurdayShows() {
		return thurdayShows;
	}

	public LinkedList<Showtime> getFridayShows() {
		return fridayShows;
	}

	public LinkedList<Showtime> getSaturdayShows() {
		return saturdayShows;
	}

	public LinkedList<Showtime> getSundayShows() {
		return sundayShows;
	}

	public LinkedList<Showtime> getMondayShows() {
		return mondayShows;
	}

	public LinkedList<Showtime> getTuesdayShows() {
		return tuesdayShows;
	}

	public LinkedList<Showtime> getWednesdayShows() {
		return wednesdayShows;
	}
}
