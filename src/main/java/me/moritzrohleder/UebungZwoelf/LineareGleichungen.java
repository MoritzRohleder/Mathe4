package me.moritzrohleder.UebungZwoelf;

import me.moritzrohleder.uebungElf.GroessterGemeinsamerTeiler;

public class LineareGleichungen {

	/**
	 * Methode um die Lösung einer linearen Gleichung in Z zu berechnen.
	 *
	 * @param a Der Koeffizient von x.
	 * @param b Die Lösung der Gleichung.
	 * @param n Der Modulo-Wert.
	 * @return Die Lösungs-Menge der Gleichung.
	 */
	public static int[] lineareGleichungInZ(int a, int b, int n) {
		int g = GroessterGemeinsamerTeiler.ggT(a, n);
		if(b % g != 0) {
			System.out.println("Es gibt keine Lösung für die Gleichung " + a + "x = " + b + " mod " + n + ", da " + g
					+ " kein Teiler von " + b + " ist.");
		} else {
			int aStrich = a / g;
			int bStrich = b / g;
			int nStrich = n / g;
			int x0 = 0;
			for(int i = 0; i < nStrich; i++) {
				if((aStrich * x0) % nStrich == bStrich) {
					break;
				}
				x0++;
			}

			int[] ergebnisse = new int[g + 1];
			ergebnisse[0] = x0;

			for(int i = 0; i < g; i++) {
				ergebnisse[i + 1] = (x0 + i * nStrich) % n;
			}

			return ergebnisse;
		}
		return new int[0];
	}
}
