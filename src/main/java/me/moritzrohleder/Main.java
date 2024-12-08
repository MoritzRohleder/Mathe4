package me.moritzrohleder;

import me.moritzrohleder.UebungAcht.GradientenAbstiegsVerfahren;

import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);

	/*public static void main(String[] args) {
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
	}*/

	public static void main(String[] args) {
		System.out.print("Willkommen zu den Programmier-Aufgaben der Übung 8 des Moduls Mathe 4.\n"
		                 + "Bitte wählen Sie aus, ob sie Aufgabe 8.2 oder 8.3 sehen wollen.\n");
		String aufgabenAuswahl = scanner.nextLine();
		if(aufgabenAuswahl.equalsIgnoreCase("8.2")) {
			System.out.print("Bitte geben Sie die Funktion ein, die Sie berechnen wollen (b, c).\n");
			String aufgabe = scanner.nextLine();
			GradientenAbstiegsVerfahren.aufgabe = aufgabe;
			System.out.print("Bitte geben Sie ein ob Maximum oder Minimum berechnet werden soll (max, min).\n");
			String maxMin = scanner.nextLine();
			GradientenAbstiegsVerfahren.isMaxVerfahren = maxMin.equalsIgnoreCase("max");
			GradientenAbstiegsVerfahren.gradientenVerfahren(0, 0.1, 0.0001);
		} else if(aufgabenAuswahl.equalsIgnoreCase("8.3")) {
			System.out.print("Bitte geben Sie die Funktion ein, die Sie berechnen wollen (b, c).\n");
			String aufgabe = scanner.nextLine();
			GradientenAbstiegsVerfahren.aufgabe = aufgabe;
			System.out.print("Bitte geben Sie ein ob Maximum oder Minimum berechnet werden soll (max, min).\n");
			String maxMin = scanner.nextLine();
			GradientenAbstiegsVerfahren.isMaxVerfahren = maxMin.equalsIgnoreCase("max");
			GradientenAbstiegsVerfahren.gradientenVerfahren(0, 0.1, 0.0001);
		} else {
			System.out.println("Bitte geben Sie 8.2 oder 8.3 ein.");
		}
	}
}