package me.moritzrohleder.UebungZwoelf;

public class ChinesischerRestsatz {

	public static int chinesischerRestsatz(int[] a, int[] n) {
		int grossN = produkt(n);
		System.out.println("N: " + grossN);

		int[] nStrich = new int[n.length];
		for(int i = 0; i < n.length; i++) {
			nStrich[i] = grossN / n[i];
			System.out.println("n" + i + ": " + nStrich[i]);
		}

		int x = 0;
		for(int i = 0; i < n.length; i++) {
			int temp = LineareGleichungen.lineareGleichungInZ(nStrich[i] % n[i], a[i], n[i])[0];
			System.out.println("x" + i + ": " + temp);
			x += temp * nStrich[i];
		}
		System.out.println("x: " + x);

		return x % grossN;
	}

	/**
	 * Berechnet das Produkt aller Elemente in n.
	 *
	 * @param n Array mit den Elementen
	 * @return Produkt aller Elemente in n
	 */
	private static int produkt(int[] n) {
		int produkt = n[0];
		for(int i = 1; i < n.length; i++) {
			produkt *= n[i];
		}
		return produkt;
	}
}
