package me.moritzrohleder.Uebung7;

import java.util.Scanner;

public class NumerischeIntegrationMenu {

	private static final Scanner scanner = new Scanner(System.in);

	public static void menu() {
		System.out.print("Willkommen zur numerischen Integration!\n" + "Bitte wählen Sie eine der folgenden Aufgaben:\n"
		                 + "a) Das Integral von 2 bis 6 über x^2+2x\n"
		                 + "b) Das Integral von 1 bis 2 über (1-x^-x)/x\n");
		String aufgabenAuswahl = scanner.nextLine();
		System.out.print("Bitte geben Sie an, ob Trapez oder Simpson Regel verwendet werden soll:\n");
		String regelAuswahl = scanner.nextLine();
		switch(regelAuswahl) {
			case "Trapez":
				System.out.print("Bitte geben Sie die Anzahl der Teilintervalle an:\n");
				int n = scanner.nextInt();
				System.out.println("Das Ergebnis der Trapezregel beträgt: " + TrapezRegel.calculateTrapezRegel(2, 6, n,
				                                                                                               aufgabenAuswahl));
				break;
			case "Simpson":
				System.out.print("Bitte geben Sie die Anzahl der Teilintervalle an:\n");
				int nSimpson = scanner.nextInt();
				System.out.println(
						"Das Ergebnis der Simpsonregel beträgt: " + SimpsonRegel.calculateSimpsonRegel(2, 6, nSimpson,
						                                                                               aufgabenAuswahl));
				break;
			default:
				System.out.println("Bitte geben Sie Trapez oder Simpson ein.");
		}
	}

	public static double funktionH(double x) {
		return Math.pow(x, 2) +2*x;
	}

	public static double funktionG(double x) {
		return (1-Math.pow(x, -x))/x;
	}
}
