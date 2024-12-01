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
		while(checkKonvergenzKriterium(x)) {
			x = calculateIterationsSchritt(x);
			if(checkGleichheit(x, result.getLast())) {
				System.out.printf("%s ist gleich %s mit einer Genauigkeit von %s Nachkommastellen\n", x,
				                  result.getLast(), genauigkeit);
				result.add(x);
				return result;
			}
			result.add(x);
		}
		System.out.printf("Konvergenzkriterium wurde nicht erfüllt bei x = %s\n", x);
		return result;
	}

	/**
	 * Berechnet den nächsten Iterationsschritt für das Newton-Verfahren.
	 *
	 * @param x der aktuelle Wert der Iteration
	 * @return der nächste Wert der Iteration
	 */
	private static double calculateIterationsSchritt(double x) {
		return x - Main.funktionF(x)/Main.funktionFStrich(x);
	}

	/**
	 * Überprüft das Konvergenzkriterium für den gegebenen Wert x.
	 *
	 * @param x der Wert, für den das Konvergenzkriterium überprüft werden soll
	 * @return true, wenn das Konvergenzkriterium erfüllt ist, andernfalls false
	 */
	private static boolean checkKonvergenzKriterium(double x) {
		return Math.abs((Main.funktionF(x) * Main.funktionFStrichStrich(x))/Math.pow(2, Main.funktionFStrich(x))) < 1;
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
	    double scale = Math.pow(10, genauigkeit-1);
	    return Math.round(x * scale) == Math.round(lastResult * scale);
	}
}
