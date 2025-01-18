package me.moritzrohleder.UebungZwoelf;

import me.moritzrohleder.uebungElf.GroessterGemeinsamerTeiler;

public class EulerschePhiFunktion {

	/**
	 * Berechnet die Eulersche Phi-Funktion von n.
	 *
	 * @param n Die Zahl für die die Eulersche Phi-Funktion berechnet werden soll
	 * @return Die Eulersche Phi-Funktion von n
	 */
	public static int eulerschePhiFunktion(int n) {
		int phi = 1;
		for(int i = 2; i < n; i++) {
			if(GroessterGemeinsamerTeiler.ggT(n, i) == 1) {
				phi++;
			}
		}
		return phi;
	}

}
