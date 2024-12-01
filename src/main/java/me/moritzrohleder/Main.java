package me.moritzrohleder;

import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Newton-Verfahren für f(x) = x^2 - 2*cos(x)\n"
		                  + "Erste Ableitung: f'(x) = 2*x + 2*sin(x)\n"
		                  + "Zweite Ableitung: f''(x) = 2 + 2*cos(x)\n"
		                  + "\n"
		                  + "Bitte geben Sie den Startwert für das Newton-Verfahren ein:");
		double startwert = scanner.nextDouble();
		System.out.printf("Startwert: %s\n", startwert);

		NewtonVerfahren.calculateNewtonVerfahren(startwert).forEach(System.out::println);
	}

	public static double funktionF(double x) {
		return x*x-2*Math.cos(x);
	}

	public static double funktionFStrich(double x) {
		return 2*x+2*Math.sin(x);
	}

	public static double funktionFStrichStrich(double x) {
		return 2+2*Math.cos(x);
	}
}