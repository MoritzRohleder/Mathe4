package me.moritzrohleder;

import me.moritzrohleder.Uebung7.NewtonMenu;
import me.moritzrohleder.Uebung7.NumerischeIntegrationMenu;
import me.moritzrohleder.UebungAcht.GradientenAbstiegsVerfahren;
import me.moritzrohleder.UebungNeun.EulerschesStreckenzugverfahren;
import me.moritzrohleder.UebungNeun.RungeKuttaVerfahren;
import me.moritzrohleder.UebungZehn.ZahlenUmrechnung;

import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Willkommen zu den Programmier-Aufgaben des Moduls Mathe 4.\n"
		                 + "Bitte wählen Sie aus, ob sie die Aufgabe 7, 8, 9 oder 10 sehen wollen.\n");
		String aufgabenAuswahl = scanner.nextLine();
		if(aufgabenAuswahl.equalsIgnoreCase("7")) {
			uebungSieben();
		} else if(aufgabenAuswahl.equalsIgnoreCase("8")) {
			uebungAcht();
		} else if(aufgabenAuswahl.equalsIgnoreCase("9")) {
			uebungNeun();
		} else if(aufgabenAuswahl.equalsIgnoreCase("10")) {
			uebungZehn();
		} else {
			System.out.println("Bitte geben Sie 7, 8 oder 9 ein.");
		}
	}

	public static void uebungSieben() {
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

	public static void uebungAcht() {
		System.out.print("Willkommen zu den Programmier-Aufgaben der Übung 8 des Moduls Mathe 4.\n"
		                 + "Bitte wählen Sie aus, ob sie Aufgabe 8.2 oder 8.3 sehen wollen.\n");
		String aufgabenAuswahl = scanner.nextLine();
		System.out.print("Bitte geben Sie die Funktion ein, die Sie berechnen wollen (b, c).\n");
		String aufgabe = scanner.nextLine();
		if(aufgabenAuswahl.equalsIgnoreCase("8.2")) {
			GradientenAbstiegsVerfahren.aufgabe = aufgabe;
			System.out.print("Bitte geben Sie ein ob Maximum oder Minimum berechnet werden soll (max, min).\n");
			String maxMin = scanner.nextLine();
			GradientenAbstiegsVerfahren.isMaxVerfahren = maxMin.equalsIgnoreCase("max");
			GradientenAbstiegsVerfahren.gradientenVerfahren(0, 1, 0.01);
		} else if(aufgabenAuswahl.equalsIgnoreCase("8.3")) {
			GradientenAbstiegsVerfahren.aufgabe = aufgabe;
			System.out.print("Bitte geben Sie ein ob Maximum oder Minimum berechnet werden soll (max, min).\n");
			String maxMin = scanner.nextLine();
			GradientenAbstiegsVerfahren.isMaxVerfahren = maxMin.equalsIgnoreCase("max");
			GradientenAbstiegsVerfahren.gradientenVerfahren(0, 0, 0.1, 0.01);
		} else {
			System.out.println("Bitte geben Sie 8.2 oder 8.3 ein.");
		}
	}

	public static void uebungNeun() {
		System.out.print("Willkommen zu den Programmier-Aufgaben der Übung 9 des Moduls Mathe 4.\n"
		                 + "Bitte wählen Sie aus, ob sie Aufgabe a) oder b) sehen wollen.\n");
		String aufgabenAuswahl = scanner.nextLine();
		if(aufgabenAuswahl.equalsIgnoreCase("a)")) {
			double x0 = 0;
			double xN = 0.2;
			EulerschesStreckenzugverfahren.eulerschesStreckenzugverfahren(x0, xN, 0.05, 1);
		} else if(aufgabenAuswahl.equalsIgnoreCase("b)")) {
			double x0 = 0;
			double xN = 0.2;
			RungeKuttaVerfahren.rungeKuttaVerfahren(x0, xN, 0.05, 1);
		} else {
			System.out.print("Bitte geben Sie a) oder b) an.");
		}
	}

	public static void uebungZehn() {
		System.out.print("Willkommen zu den Programmier-Aufgabe der Übung 10 des Moduls Mathe 4.\n"
		                 + "Bitte wählen Sie aus, ob sie Aufgabe a), b) oder c) sehen wollen.\n");
		String aufgabenAuswahl = scanner.nextLine();
		if(aufgabenAuswahl.equalsIgnoreCase("a)")) {
			System.out.print("Bitte geben Sie die Zahl (n) ein, die Sie umrechnen wollen.\n");
			int n = scanner.nextInt();
			System.out.print("Bitte geben Sie die Basis (b) ein, in die Sie umrechnen wollen.\n");
			int b = scanner.nextInt();
			System.out.println("Das Ergebnis ist: " + ZahlenUmrechnung.umrechnungDezimalBAdisch(n, b));
		} else if(aufgabenAuswahl.equalsIgnoreCase("b)")) {
			System.out.print("Bitte geben Sie die Zahl (x) ein, die Sie umrechnen wollen.\n");
			int x = scanner.nextInt();
			System.out.print("Bitte geben Sie die Basis (b) ein, welche die Zahl hat.\n");
			int b = scanner.nextInt();
			System.out.println("Das Ergebnis ist: " + ZahlenUmrechnung.umrechnungBAdischDezimal(x, b));
		} else if(aufgabenAuswahl.equalsIgnoreCase("c)")) {
			System.out.print("Bitte geben Sie die Zahl (x) ein, die Sie umrechnen wollen.\n");
			int x = scanner.nextInt();
			System.out.print("Bitte geben Sie die Basis (b1) ein, welche die Zahl hat.\n");
			int b1 = scanner.nextInt();
			System.out.print("Bitte geben Sie die Basis (b2) ein, in die Sie umrechnen wollen.\n");
			int b2 = scanner.nextInt();
			System.out.println("Das Ergebnis ist: " + ZahlenUmrechnung.umrechnung(x, b1, b2));
		} else {
			System.out.print("Bitte geben Sie a), b) oder c) an.");
		}
	}
}