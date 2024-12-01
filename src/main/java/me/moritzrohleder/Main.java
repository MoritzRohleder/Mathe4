package me.moritzrohleder;

import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Willkommen zu den Programmier-Aufgaben der Übung 7 des Moduls Mathe 4.\n"
		                 + "Bitte wählen Sie aus, ob sie Aufgabe 1c) oder 2c) sehen wollen.\n");
		String aufgabenAuswahl = scanner.nextLine();
		if(aufgabenAuswahl.equalsIgnoreCase("1c")) {
			NewtonMenu.menu();
		} else if(aufgabenAuswahl.equalsIgnoreCase("2c")) {
			NumerischeIntegrationMenu.menu();
		} else {
			System.out.println("Bitte geben Sie 1c oder 2c ein.");
		}
	}
}