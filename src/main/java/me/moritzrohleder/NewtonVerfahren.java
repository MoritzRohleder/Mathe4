package me.moritzrohleder;

import java.util.LinkedList;

public class NewtonVerfahren {

	private static final int genauigkeit = 4;

	/**
	 * Berechnet die Iterationen des Newton-Verfahrens für einen gegebenen Startwert.
	 *
	 * @param x der Startwert für das Newton-Verfahren
	 * @return eine LinkedList mit den berechneten Werten der Iterationen
	 */
	public static LinkedList<Double> calculateNewtonVerfahren(double x) {
		LinkedList<Double> result = new LinkedList<>();
		result.add(x);
		while(checkKonvergenzKriteriumF(x)) {
			x = calculateIterationsSchrittF(x);
			if(checkGleichheit(x, result.getLast())) {
				System.out.printf("%s ist gleich %s mit einer Genauigkeit von %s Nachkommastellen\n", x,
				                  result.getLast(), genauigkeit);
				result.add(x);
				return result;
			}
			result.add(x);
		}
		System.out.printf("Konvergenzkriterium wurde nicht erfüllt bei x = %s\n", x);
		result.clear();
		return result;
	}

	/**
	 * Berechnet die Iterationen des Newton-Verfahrens für einen gegebenen Startwert innerhalb eines Intervalls.
	 *
	 * @param x der Startwert für das Newton-Verfahren
	 * @param linkeGrenze die linke Grenze des Intervalls
	 * @param rechteGrenze die rechte Grenze des Intervalls
	 * @return eine LinkedList mit den berechneten Werten der Iterationen
	 */
	public static LinkedList<Double> calculateNewtonVerfahrenIntervall(double x, double linkeGrenze,
	                                                                   double rechteGrenze) {
		LinkedList<Double> result = new LinkedList<>();
		result.add(x);
		while(checkKonvergenzKriteriumG(x) && x >= linkeGrenze && x <= rechteGrenze) {
			x = calculateIterationsSchrittG(x);
			if(checkGleichheit(x, result.getLast())) {
				System.out.printf("%s ist gleich %s mit einer Genauigkeit von %s Nachkommastellen\n", x,
				                  result.getLast(), genauigkeit);
				result.add(x);
				return result;
			}
			result.add(x);
		}
		if(!checkKonvergenzKriteriumG(x)) {
			System.out.printf("Konvergenzkriterium wurde nicht erfüllt bei x = %s\n", x);
		} else if ( x < linkeGrenze && x > rechteGrenze) {
			System.out.printf("Der Wert %s liegt nicht im Intervall [%s, %s]\n", x, linkeGrenze, rechteGrenze);
		}
		result.clear();
		return result;
	}

	/**
	 * Berechnet den nächsten Iterationsschritt für das Newton-Verfahren.
	 * Als Grundlage dient Funktion f(x)
	 *
	 * @param x der aktuelle Wert der Iteration
	 * @return der nächste Wert der Iteration
	 */
	private static double calculateIterationsSchrittF(double x) {
		return x - NewtonMenu.funktionF(x)/NewtonMenu.funktionFStrich(x);
	}

	/**
	 * Überprüft das Konvergenzkriterium für den gegebenen Wert x.
	 * Als Grundlage dient Funktion f(x)
	 *
	 * @param x der Wert, für den das Konvergenzkriterium überprüft werden soll
	 * @return true, wenn das Konvergenzkriterium erfüllt ist, andernfalls false
	 */
	private static boolean checkKonvergenzKriteriumF(double x) {
		return Math.abs((NewtonMenu.funktionF(x) * NewtonMenu.funktionFStrichStrich(x))/Math.pow(2, NewtonMenu.funktionFStrich(x))) < 1;
	}

	private static double calculateIterationsSchrittG(double x) {
		return x - NewtonMenu.funktionG(x)/NewtonMenu.funktionGStrich(x);
	}

	private static boolean checkKonvergenzKriteriumG(double x) {
		return Math.abs((NewtonMenu.funktionG(x) * NewtonMenu.funktionGStrichStrich(x))/Math.pow(2, NewtonMenu.funktionGStrich(x))) < 1;
	}

	/**
	 * Checks if the given value x is equal to the last result in the list,
	 * based on the defined precision.
	 *
	 * @param x the value to be checked
	 * @param lastResult the last element in the result list
	 * @return true if the value x is equal to the last result in the list, otherwise false
	 */
	public static boolean checkGleichheit(double x, Double lastResult) {
	    double scale = Math.pow(10, genauigkeit+1);
	    return Math.round(x * scale) == Math.round(lastResult * scale);
	}
}
