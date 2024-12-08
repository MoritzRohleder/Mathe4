package me.moritzrohleder.Uebung7;

import java.util.LinkedList;
import java.util.Scanner;

public class NewtonMenu {

	private static final Scanner scanner = new Scanner(System.in);

	public static void menu() {
		System.out.print("Willkommen zum Newton-Verfahren!\n"
		                 + "Bitte wählen Sie eine der folgenden Aufgaben:\n"
		                 + "a) f(x) = x^2 - 2*cos(x)\n"
		                 + "b) g(x) = tan(x)-x-2 mit dem Intervall ]-Pi/2;Pi/2[\n");
		String aufgabenAuswahl = scanner.nextLine();
		if(aufgabenAuswahl.equalsIgnoreCase("a")) {
			aufgabeA();
		} else if(aufgabenAuswahl.equalsIgnoreCase("b")) {
			aufgabeB();
		} else {
			System.out.println("Bitte geben Sie a oder b ein.");
		}
	}

	private static void aufgabeA () {
		System.out.println("Newton-Verfahren für f(x) = x^2 - 2*cos(x)\n"
		                   + "Erste Ableitung: f'(x) = 2*x + 2*sin(x)\n"
		                   + "Zweite Ableitung: f''(x) = 2 + 2*cos(x)\n"
		                   + "\n"
		                   + "Bitte geben Sie den Startwert für das Newton-Verfahren ein:");
		double startwert = scanner.nextDouble();
		scanner.nextLine(); //Verwerte den Zeilenumbruch, damit im folgenden keine Probleme auftreten
		System.out.printf("Startwert: %s\n", startwert);

		LinkedList<Double> results = NewtonVerfahren.calculateNewtonVerfahren(startwert);

		if(results.isEmpty()) {
			System.out.println("Bei der Anwendung des Newton-Verfahrens wurde das Konvergenzkriterium verletzt.");
		} else {
			System.out.printf("Das Ergebnis der Funktion f(x) = x^2 - 2*cos(x) durch Newton-Verfahren ist %s.\n"
			                  + "Das Ergebnis wurde nach %s Iterationen gefunden.\n"
			                  + "\n"
			                  + "Möchten Sie die Zwischenwerte sehen?\n", results.getLast(), results.size()-1);
			String zwischenWerteZeigen = scanner.nextLine();
			if(zwischenWerteZeigen.equalsIgnoreCase("ja")) {
				results.forEach(result -> System.out.printf("%s\n", result));
			}
		}
	}

	private static void aufgabeB () {
		System.out.println("Newton-Verfahren für g(x) = tan(x)-x-2\n"
		                   + "Erste Ableitung: g'(x) = (1/Math.cos(x)^2)-1\n"
		                   + "Zweite Ableitung: g''(x) = 2*sin(x)/cos(x)^3)\n"
		                   + "\n"
		                   + "Bitte geben Sie den Startwert für das Newton-Verfahren ein:");
		double startwert = scanner.nextDouble();
		scanner.nextLine(); //Verwerte den Zeilenumbruch, damit im folgenden keine Probleme auftreten
		System.out.printf("Startwert: %s\n", startwert);

		LinkedList<Double> results = NewtonVerfahren.calculateNewtonVerfahrenIntervall(startwert, -Math.PI/2, Math.PI/2);

		if(results.isEmpty()) {
			System.out.println("Bei der Anwendung des Newton-Verfahrens wurde das Konvergenzkriterium verletzt oder "
			                   + "die Intervallgrenze überschritten.");
		} else {
			System.out.printf("Das Ergebnis der Funktion g(x) = tan(x)-x-2 durch Newton-Verfahren ist %s.\n"
			                  + "Das Ergebnis wurde nach %s Iterationen gefunden.\n"
			                  + "\n"
			                  + "Möchten Sie die Zwischenwerte sehen?\n", results.getLast(), results.size()-1);
			String zwischenWerteZeigen = scanner.nextLine();
			if(zwischenWerteZeigen.equalsIgnoreCase("ja")) {
				results.forEach(result -> System.out.printf("%s\n", result));
			}
		}
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

	public static double funktionG(double x) {
		return Math.tan(x)-x-2;
	}

	public static double funktionGStrich(double x) {
		return Math.pow(1/Math.cos(x), 2)-1;
	}

	public static double funktionGStrichStrich(double x) {
		return 2*Math.sin(x)/Math.pow(Math.cos(x), 3);
	}
}
