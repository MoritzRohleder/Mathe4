package me.moritzrohleder.uebungElf;

public class GroessterGemeinsamerTeiler {

	/**
	 * Berechnet den größten gemeinsamen Teiler von a und b.
	 *
	 * @param a Die erste Zahl für die der GroessterGemeinsamerTeiler berechnet werden soll
	 * @param b Die zweite Zahl für die der GroessterGemeinsamerTeiler berechnet werden soll
	 * @return int[] mit dem GroessterGemeinsamerTeiler an erster Stelle und den Koeffizienten x und y an den folgenden Stellen [ggt(a, b), x, y]
	 */
	public static int[] erweiterterEuklidischerAlgorithmus(int a, int b) {
		if(a == 0 || b == 0) {
			throw new IllegalArgumentException("a und b dürfen nicht 0 sein.");
		}

		int r0 = a > b ? a : b;
		int r1 = a > b ? b : a;
		int x0 = 1;
		int x1 = 0;
		int y0 = 0;
		int y1 = 1;

		while(r1 != 0) {
			int q = r0 / r1;
			int r2 = r0 % r1;
			int x2 = x0 - q * x1;
			int y2 = y0 - q * y1;

			r0 = r1;
			r1 = r2;
			x0 = x1;
			x1 = x2;
			y0 = y1;
			y1 = y2;
		}

		return new int[]{r0, x0, y0};
	}

	/**
	 * Berechnet den größten gemeinsamen Teiler von a und b.
	 *
	 * @param a Die erste Zahl für die der GroessterGemeinsamerTeiler berechnet werden soll
	 * @param b Die zweite Zahl für die der GroessterGemeinsamerTeiler berechnet werden soll
	 * @return int mit dem GroessterGemeinsamerTeiler
	 */
	public static int ggT(int a, int b) {
		if(a == 0 || b == 0) {
			throw new IllegalArgumentException("a und b dürfen nicht 0 sein.");
		}
		int r0 = a > b ? a : b;
		int r1 = a > b ? b : a;

		while(r1 != 0) {
			int r2 = r0 % r1;
			r0 = r1;
			r1 = r2;
		}

		return r0;
	}

	/**
	 * Berechnet den größten gemeinsamen Teiler von mehreren Zahlen.
	 *
	 * @param zahlen Die Zahlen für die der GroessterGemeinsamerTeiler berechnet werden soll
	 * @return int mit dem GroessterGemeinsamerTeiler
	 */
	public static int ggTmehrererZahlen (int[] zahlen) {
		int ggT = zahlen[0];
		for (int i = 1; i < zahlen.length; i++) {
			ggT = ggT(ggT, zahlen[i]);
		}
		return ggT;
	}
}
