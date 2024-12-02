package me.moritzrohleder;

import java.util.LinkedList;

public class SimpsonRegel {

	public static double calculateSimpsonRegel(double a, double b, int n, String funktion) {
		double schrittweite = calculateSchrittweite(a, b, n);
		LinkedList<Double> values = calculateValues(schrittweite, a, n, funktion);
		double sumBorderValues = calculateSumBorderValues(values);
		double sumEvenValues = calculateSumEvenValues(values);
		double sumOddValues = calculateSumOddValues(values);
		return (sumBorderValues + 4*sumOddValues + 2*sumEvenValues)*schrittweite/3;
	}

	private static LinkedList<Double> calculateValues(double schrittweite, double a, int n, String funktion) {
		LinkedList<Double> values = new LinkedList<>();
		for(int i = 0; i <= 2*n; i++) {
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

	private static double calculateSchrittweite(double a, double b, int n) {
		return (b-a)/(2*n);
	}

	private static double calculateSumBorderValues(LinkedList<Double> values) {
		return values.peekFirst() + values.peekLast();
	}

	private static double calculateSumEvenValues(LinkedList<Double> values) {
		double sum = 0;
		for(int i = 2; i < values.size()-1; i+=2) {
			sum += values.get(i);
		}
		return sum;
	}

	private static double calculateSumOddValues(LinkedList<Double> values) {
		double sum = 0;
		for(int i = 1; i < values.size()-1; i+=2) {
			sum += values.get(i);
		}
		return sum;
	}
}
