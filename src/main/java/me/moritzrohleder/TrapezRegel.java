package me.moritzrohleder;

import java.util.LinkedList;

public class TrapezRegel {

	public static double calculateTrapezRegel(double a, double b, int n, String funktion) {
		double schrittweite = calculateSchrittweite(a, b, n);
		LinkedList<Double> values = calculateValues(schrittweite, a, n, funktion);
		double sumBorderValues = calculateSumBorderValues(values);
		double sumInnerValues = calculateSumInnerValues(values);
		return ((sumBorderValues/2)+ sumInnerValues)*schrittweite;
	}

	private static double calculateSchrittweite(double a, double b, int n) {
		return (b-a)/n;
	}

	private static LinkedList<Double> calculateValues(double schrittweite, double a, int n, String funktion) {
		LinkedList<Double> values = new LinkedList<>();
		for(int i = 0; i <= n; i++) {
			switch(funktion) {
				case "a":
					values.add(NumerischeIntegrationMenu.funktionH(a+i*schrittweite));
					break;
				case "b":
					values.add(NumerischeIntegrationMenu.funktionG(a+i*schrittweite));
					break;
			}
		}
		return values;
	}

	private static double calculateSumBorderValues(LinkedList<Double> values) {
		return values.peekFirst() + values.peekLast();
	}

	private static double calculateSumInnerValues(LinkedList<Double> values) {
		double sum = 0;
		for(int i = 1; i < values.size()-1; i++) {
			sum += values.get(i);
		}
		return sum;
	}
}
