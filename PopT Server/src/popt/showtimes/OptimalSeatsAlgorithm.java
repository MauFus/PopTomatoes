/**
 * PopTomatoes - Progetto Informatica III B
 * 
 * Algoritmo per la ricerca dei migliori posti da assegnare
 * tra quelli rimasti liberi
 * 
 * @author Fustinoni Mauro & Matteo Ronchi
 * @date December 2013
 */

package popt.showtimes;

import java.util.LinkedList;
import java.util.Vector;

import popt.data.Seat;

public class OptimalSeatsAlgorithm {

	public OptimalSeatsAlgorithm() {
		
	}
	
	public LinkedList<Seat> execute(int[][] valueMatrix, int target) {
		
		/* 
		 * Inizializzazione delle variabili di supporto all'algoritmo
		 */
		int[][] seatMatrix = valueMatrix.clone();
		float[] rowValue = calcAvgValue(seatMatrix);
		int counter = target;
		int requestedSolutions = 2;
		LinkedList<Seat> solution = new LinkedList<>();
		
		/* 
		 * Main Loop 
		 * rowIteration is the maximum number of iteration (one for each row).
		 * The algorithm could stop before the end, if found the optimal solution
		 * or if it's sure that there is no solution.
		 */
		for (int rowIteration = 0; rowIteration < seatMatrix.length; rowIteration++) {
			
			// Si valutano le file in ordine decrescente di valore
			int bestRow = indexOfMaxValue(rowValue);
			if (bestRow > -1) {
				
				// Ogni fila può essere valutata solo una volta
				rowValue[bestRow] = 0;
				
				// Soluzione temporanea
				Vector<Integer> tempSolution = new Vector<>();
				
				while (sumValues(seatMatrix[bestRow]) > 0) {

					// Inner Loop
					while (counter > 0) {
						int candidate = -1;
						if (counter == target) {
							// Primo posto scelto è quello di valore maggiore
							candidate = indexOfMaxValue(seatMatrix[bestRow]);
						} else {
							// Caso in cui si siano già scelti dei posti
							int left = minimunInSolution(tempSolution) - 1;
							int right = maximumInSolution(tempSolution) + 1;
							
							if (left > -1 && right < seatMatrix[bestRow].length)
								candidate = seatMatrix[bestRow][left] > seatMatrix[bestRow][right]? left : right;
							else if (left <= -1)
								candidate = right;
							else if (right >= seatMatrix[bestRow].length)
								candidate = left;
							else 
								candidate = -1;
						}
						
						// Controllo che il candidato sia accettabile
						if (candidate > -1 && seatMatrix[bestRow][candidate] > 0) {
							tempSolution.add(new Integer(candidate));
							seatMatrix[bestRow][candidate] = 0;
							counter--;
						} else
							// Non ci sono candidati utili nella fila
							break;
					}
					
					if (counter == 0) {
						requestedSolutions--;
						for (Integer seat : tempSolution)
							solution.add(new Seat(bestRow +1, seat + 1));
						counter = target;
						break;
					} else {
						tempSolution.clear();
						counter = target;
					}
				}
				
				if (requestedSolutions == 0)
					// Se sono già state trovate 2 soluzioni, finisce
					break;
				
			} else
				// se non esiste una file con posti disponibili si esce dal Main Loop
				break;
		} 
		
		return solution;
	}

	/**
	 * Calcola
	 * @param valueMatrix
	 * @return
	 */
	private float[] calcAvgValue(int[][] valueMatrix) {
		float[] sum = new float[valueMatrix.length];
		for (int row = 0; row < valueMatrix.length; row++) {
			for (int i = 0; i < valueMatrix[row].length; i++)
				sum[row] += valueMatrix[row][i];
			sum[row] /= valueMatrix[row].length;
		}
		return sum;
	}
	
	private int sumValues(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++)
			sum += array[i];
		return sum;
	}
	
	private int indexOfMaxValue(float[] vector) {
		int index = -1;
		float max = 0;
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] > max) {
				max = vector[i];
				index = i;
			}
		}
		return index;
	}
	
	private int indexOfMaxValue(int[] vector) {
		int index = -1;
		int max = 0;
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] > max) {
				max = vector[i];
				index = i;
			}
		}
		return index;
	}
	
	private int maximumInSolution(Vector<Integer> tempSolution) {
		Integer max = 0;
		for (Integer i : tempSolution) {
			if (i > max)
				max = i;
		}
		return max;
	}

	private int minimunInSolution(Vector<Integer> tempSolution) {
		Integer min = null;
		for (Integer i : tempSolution) {
			if (min == null || (min != null && i < min))
				min = i;
		}
		return min;
	}
}
