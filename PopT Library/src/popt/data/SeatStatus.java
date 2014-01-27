/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Tipo enumerativo per assegnare uno stato ad un posto
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.data;

import java.io.Serializable;

public enum SeatStatus implements Serializable{
	LIBERO, OCCUPATO, PRENOTATO
}
