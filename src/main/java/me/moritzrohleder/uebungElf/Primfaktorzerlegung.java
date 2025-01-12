package me.moritzrohleder.uebungElf;

import java.util.LinkedList;

public class Primfaktorzerlegung {

	/**
	 * Berechnet die Primfaktorzerlegung einer Zahl n.
	 *
	 * @param n Die Zahl für die die Primfaktorzerlegung berechnet werden soll
	 * @return LinkedList mit den Primfaktoren von n
	 */
	public static LinkedList<Integer> primfaktorzerlegung(int n) {
		LinkedList<Integer> primfaktoren = new LinkedList<>();
		int i = 2;
		while(n > 1) {
			if(n % i == 0) {
				primfaktoren.add(i);
				n /= i;
			} else {
				i++;
			}
		}
		return primfaktoren;
	}
}
