package me.moritzrohleder;

import me.moritzrohleder.Uebung7.NewtonMenu;
import me.moritzrohleder.Uebung7.NumerischeIntegrationMenu;
import me.moritzrohleder.UebungAcht.GradientenAbstiegsVerfahren;
import me.moritzrohleder.UebungNeun.EulerschesStreckenzugverfahren;
import me.moritzrohleder.UebungNeun.RungeKuttaVerfahren;
import me.moritzrohleder.UebungZehn.ZahlenUmrechnung;
import me.moritzrohleder.uebungElf.DiophantischeGleichung;
import me.moritzrohleder.uebungElf.GroessterGemeinsamerTeiler;
import me.moritzrohleder.uebungElf.Primfaktorzerlegung;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * Main Methode um die Programmier-Aufgaben des Moduls Mathe 4 zu starten.
	 *
	 * @param args Die Argumente die beim Starten des Programms übergeben werden.
	 */
	public static void main(String[] args) {
		System.out.print("Willkommen zu den Programmier-Aufgaben des Moduls Mathe 4.\n"
		                 + "Bitte wählen Sie aus, ob sie die Aufgabe 7, 8, 9, 10 oder 11 sehen wollen.\n");
		String aufgabenAuswahl = scanner.nextLine();
		if(aufgabenAuswahl.equalsIgnoreCase("7")) {
			uebungSieben();
		} else if(aufgabenAuswahl.equalsIgnoreCase("8")) {
			uebungAcht();
		} else if(aufgabenAuswahl.equalsIgnoreCase("9")) {
			uebungNeun();
		} else if(aufgabenAuswahl.equalsIgnoreCase("10")) {
			uebungZehn();
		} else if(aufgabenAuswahl.equalsIgnoreCase("11")) {
			uebungElf();
		}else {
			System.out.println("Bitte geben Sie 7, 8 oder 9 ein.");
		}
	}

	/**
	 * Methode um die Aufgaben der Übung 7 zu starten.
	 */
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

	/**
	 * Methode um die Aufgaben der Übung 8 zu starten.
	 */
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

	/**
	 * Methode um die Aufgaben der Übung 9 zu starten.
	 */
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

	/**
	 * Methode um die Aufgaben der Übung 10 zu starten.
	 */
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

	/**
	 * Methode um die Aufgaben der Übung 11 zu starten.
	 */
	public static void uebungElf() {
		System.out.print("Willkommen zu den Programmier-Aufgaben der Übung 11 des Moduls Mathe 4.\n"
				+ "Bitte wählen Sie aus, ob sie Aufgabe 1, 2 oder 3 sehen wollen.\n");
		String aufgabenAuswahl = scanner.nextLine();
		if(aufgabenAuswahl.equalsIgnoreCase("1")) {
			System.out.print("Bitte geben Sie die erste Zahl ein von welcher der ggt berechnet werden soll.\n");
			int a = scanner.nextInt();
			System.out.print("Bitte geben Sie die zweite Zahl ein von welcher der ggt berechnet werden soll.\n");
			int b = scanner.nextInt();
			int[] ergebnis = GroessterGemeinsamerTeiler.erweiterterEuklidischerAlgorithmus(a, b);
			System.out.println("Der ggT von " + a + " und " + b + " ist " + ergebnis[0] + " und die Koeffizienten x und y sind " + ergebnis[1] + " und " + ergebnis[2] + ".");
		} else if(aufgabenAuswahl.equalsIgnoreCase("2")) {
			System.out.print("Bitte geben Sie die Zahl ein von welcher die Primfaktorzerlegung berechnet werden soll.\n");
			int n = scanner.nextInt();
			LinkedList<Integer> primfaktoren = Primfaktorzerlegung.primfaktorzerlegung(n);
			StringBuilder sb = new StringBuilder("Die Primfaktorzerlegung von " + n + " ist: ");
			for(int i = 0; i < primfaktoren.size(); i++) {
				sb.append(primfaktoren.get(i));
				if(i != primfaktoren.size() - 1) {
					sb.append(" * ");
				}
			}
			System.out.println(sb.toString());
		} else if(aufgabenAuswahl.equalsIgnoreCase("3")) {
			System.out.print("Bitte geben Sie den Koeffizienten von x ein.\n");
			int a = scanner.nextInt();
			System.out.print("Bitte geben Sie den Koeffizienten von y ein.\n");
			int b = scanner.nextInt();
			System.out.print("Bitte geben Sie den Wert der Gleichung ein.\n");
			int c = scanner.nextInt();
			int[] loesung = DiophantischeGleichung.diophantischeGleichung(a, b, c);
			System.out.println("Die Lösung der diophantischen Gleichung " + a + "x + " + b + "y = " + c + " ist x = " + loesung[0] + " und y = " + loesung[1] + ".");
		} else {
			System.out.print("Bitte geben Sie 1, 2 oder 3 an.");
		}
	}
}