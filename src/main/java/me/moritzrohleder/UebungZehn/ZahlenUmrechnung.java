package me.moritzrohleder.UebungZehn;

public class ZahlenUmrechnung {

	/**
	 * Umrechnung einer Dezimalzahl in eine b-adische Zahl
	 * @param n die Dezimalzahl
	 * @param b die Basis, in die umgerechnet werden soll
	 * @return die b-adische Zahl
	 */
	public static int umrechnungDezimalBAdisch(int n, int b) throws IllegalArgumentException {
		if(n < 0) {
			throw new IllegalArgumentException("Die Zahl muss größer oder gleich 0 sein.");
		}
		if(b < 2 || b > 10) {
			throw new IllegalArgumentException("Die Basis muss zwischen 2 und 10 liegen.");
		}
		int result = 0;
		int multiplier = 1;
		while (n > 0) {
			result += n % b * multiplier;
			multiplier *= 10;
			n /= b;
		}
		return result;
	}

	/**
	 * Umrechnung einer b-adischen Zahl in eine Dezimalzahl
	 * @param x die b-adische Zahl
	 * @param b die Basis, in der die Zahl ist
	 * @return die Dezimalzahl
	 */
	public static int umrechnungBAdischDezimal(int x, int b) throws IllegalArgumentException {
		if(x < 0) {
			throw new IllegalArgumentException("Die Zahl muss größer oder gleich 0 sein.");
		}
		if(b < 2 || b > 10) {
			throw new IllegalArgumentException("Die Basis muss zwischen 2 und 10 liegen.");
		}
		int result = 0;
		int multiplier = 1;
		while (x > 0) {
			result += x % 10 * multiplier;
			multiplier *= b;
			x /= 10;
		}
		return result;
	}

	/**
	 * Umrechnung einer Zahl x aus der Basis b1 in die Basis b2
	 * @param x die Zahl
	 * @param b1 die Basis, in der die Zahl ist
	 * @param b2 die Basis, in die umgerechnet werden soll
	 * @return die Zahl in der Basis b2
	 */
	public static int umrechnung (int x, int b1, int b2) {
		int result = umrechnungBAdischDezimal(x, b1);
		return umrechnungDezimalBAdisch(result, b2);
	}

}
