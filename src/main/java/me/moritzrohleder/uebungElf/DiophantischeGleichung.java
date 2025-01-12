package me.moritzrohleder.uebungElf;

public class DiophantischeGleichung {

	/**
	 * Berechnet die Lösung der diophantischen Gleichung ax + by = c.
	 *
	 * @param a Der Koeffizient von x
	 * @param b Der Koeffizient von y
	 * @param c Der Wert der Gleichung
	 * @return int[] mit den Lösungen x und y an den folgenden Stellen [x, y]
	 */
	public static int[] diophantischeGleichung(int a, int b, int c) {
		int[] ggT = GroessterGemeinsamerTeiler.erweiterterEuklidischerAlgorithmus(a, b);
		int ggt = ggT[0];
		int x = ggT[1];
		int y = ggT[2];

		if(c % ggt != 0) {
			throw new IllegalArgumentException("Die diophantische Gleichung hat keine Lösung.");
		}

		x = x * (c / ggt);
		y = y * (c / ggt);

		return new int[]{x, y};
	}
}
