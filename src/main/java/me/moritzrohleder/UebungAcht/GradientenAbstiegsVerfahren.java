package me.moritzrohleder.UebungAcht;

public class GradientenAbstiegsVerfahren {

	//Used to determine which function to use, either b) or c). Changed manually as the code will only be run from
	// the IDEA and not from the command line.
	public static String aufgabe = "b";

	//Used to determine if the maximum or minimum of the function should be found. Changed manually as the code will only
	// be run from the IDEA and not from the command line.
	public static boolean isMaxVerfahren = true;

	public static void gradientenVerfahren(double x, double lambda, double epsilon) {
		double h = 0.01; //ToDo: Fragen: Wie wähle ich den Wert h für die Differenzenformel?
		double oldX;
		double newX = x;
		do {
			oldX = newX;
			if(isMaxVerfahren) {
				newX = oldX + lambda * gradient(oldX, h);
				if(f(newX) <= f(oldX)) {
					lambda = lambda/2;
				} else {
					lambda = f(newX + (lambda*2) * gradient(newX, h)) > f(newX) ? (lambda * 2) : lambda;
				}
			} else { //Minimum Berechnung
				newX = oldX - lambda * gradient(oldX, h);
				if(f(newX) >= f(oldX)) {
					lambda = lambda/2;
				} else {
					lambda = f(newX - (lambda*2) * gradient(newX, h)) < f(newX) ? (lambda * 2) : lambda;
				}
			}
		} while (Math.abs(gradient(newX, h)) > epsilon);
		System.out.printf("Das %s der Funktion f(x) = %s wurde bei x = %s gefunden.\n", isMaxVerfahren ? "Maximum"
				                  : "Minimum", f(newX), newX);
	}

	public static void gradientenVerfahren(double x, double y, double lambda, double epsilon, String aufgabe, boolean isMaxVerfahren) {
		double h = 0.01; //ToDo: Fragen: Wie wähle ich den Wert h für die Differenzenformel?
		isMaxVerfahren = isMaxVerfahren;
		aufgabe = aufgabe;
		double[] oldXY;
		double[] newXY = {x, y};
		do {
			oldXY = newXY;
			if(isMaxVerfahren) {
				newXY[0] = oldXY[0] + lambda * gradient(oldXY, h)[0];
				newXY[1] = oldXY[1] + lambda * gradient(oldXY, h)[1];
				if(f(newXY[0], newXY[1]) <= f(oldXY[0], oldXY[1])) {
					lambda = lambda/2;
				} else {
					lambda = f(newXY[0] + (lambda*2) * gradient(newXY, h)[0],
							newXY[1] + (lambda*2) * gradient(newXY, h)[1]) > f(newXY[0], newXY[1]) ? (lambda * 2) : lambda;
				}
			} else { //Minimum Berechnung
				newXY[0] = oldXY[0] - lambda * gradient(oldXY, h)[0];
				newXY[1] = oldXY[1] - lambda * gradient(oldXY, h)[1];
				if(f(newXY[0], newXY[1]) >= f(oldXY[0], oldXY[1])) {
					lambda = lambda/2;
				} else {
					lambda = f(newXY[0] - (lambda*2) * gradient(newXY, h)[0],
							newXY[1] - (lambda*2) * gradient(newXY, h)[1]) < f(newXY[0], newXY[1]) ? (lambda * 2) : lambda;
				}
			}
		} while (Math.abs(gradientenNorm(gradient(newXY, h))) > epsilon);
		System.out.printf("Das %s der Funktion f(x, y) = %s wurde bei x = %s und y = %s gefunden.\n",
				isMaxVerfahren ? "Maximum" : "Minimum", f(newXY[0], newXY[1]), newXY[0], newXY[1]);
	}

	/**
	 * Implementiert die Funktionen f(x) der Übung
	 * Aufgabe 8.2 b) f(x) = 0.0005*x^6−0.01*x^5+0.12*x^4 − 0.5*x^3 +0.75*x^2 −0.4x
	 * Aufgabe 8.2 c) f(x, y) = (x^2 + y^2) * e^-x
	 *
	 * @param x der x-Wert der Funktion
	 * @return der Funktionswert (y-Wert) der Funktion
	 */
	public static double f(double x) {
		switch(aufgabe) {
			case "b":
				//b) f(x) = 0.0005*x^6−0.01*x^5+0.12*x^4 − 0.5*x^3 +0.75*x^2 −0.4x
				return 0.0005*Math.pow(x, 6) - 0.01*Math.pow(x, 5) + 0.12*Math.pow(x, 4) - 0.5*Math.pow(x, 3) + 0.75*Math.pow(x, 2) - 0.4*x;
			case "c":
				//c) f(x) = (x-1)^3 + (x-2)^2
				return Math.pow(x, 2) * Math.exp(-x);
			default:
				return 0;
		}
	}

	/**
	 * Implementiert die Funktionen f(x, y) der Übung
	 * Aufgabe 8.3 b) f(x, y) = (x^2 + y^2) * e^-x
	 * Aufgabe 8.3 c) f(x, y) = -e^(-(x^2 + y^2))
	 *
	 * @param x der x-Wert der Funktion
	 * @param y der y-Wert der Funktion
	 * @return der Funktionswert (z-Wert) der Funktion
	 */
	public static double f(double x, double y) {
		switch(aufgabe) {
			case "b":
				//b) f(x, y) = (x^2 + y^2) * e^-x
				return (Math.pow(x, 2) + Math.pow(y, 2)) * Math.exp(-x);
			case "c":
				//c) f(x, y) = -e^(-(x^2 + y^2))
				return -Math.exp(-(Math.pow(x, 2) + Math.pow(y, 2)));
			default:
				return 0;
		}
	}

	/**
	 * Calculates the function value f(x, y) for the given array of coordinates.
	 *
	 * @param xy an array containing the x and y coordinates
	 * @return the function value f(x, y) at the given coordinates
	 */
	public static double f(double[] xy) {
	    return f(xy[0], xy[1]);
	}

	/**
	 * Berechnet den Gradienten der Funktion f(x) an der Stelle x mit der Laufvariable h
	 * Zum Berechnen der ersten Ableitung wird die Zentrale Differenzenformel verwendet
	 *
	 * @param x der x-Wert der Funktion
	 * @param h die Laufvariable h
	 * @return der Gradient der Funktion f(x) an der Stelle x
	 */
	public static double gradient(double x, double h) {
		return Differenzenformel.ersteAbleitung(x, h);
	}

	/**
	 * Berechnet den Gradienten der Funktion f(x, y) an der Stelle (x, y) mit der Laufvariable h
	 * Zum Berechnen der ersten Ableitung wird die Zentrale Differenzenformel verwendet
	 *
	 * @param x der x-Wert der Funktion
	 * @param y der y-Wert der Funktion
	 * @param h die Laufvariable h
	 * @return der Gradient der Funktion f(x, y) an der Stelle (x, y) in der Form [x, y]
	 */
	public static double[] gradient(double x, double y, double h) {
		double[] gradient = new double[2];
		gradient[0] = Differenzenformel.ersteAbleitungX(x, y, h);
		gradient[1] = Differenzenformel.ersteAbleitungY(x, y, h);
		return gradient;
	}

	/**
	 * Calculates the gradient of the function f(x, y) at the point (x, y) with the step size h.
	 * This method is a convenience wrapper for the gradient(double x, double y, double h) method.
	 *
	 * @param xy an array containing the x and y coordinates of the point
	 * @param h the step size for the central difference formula
	 * @return an array containing the gradient of the function f(x, y) at the point (x, y)
	 */
	public static double[] gradient(double[] xy, double h) {
	    return gradient(xy[0], xy[1], h);
	}

	public static double gradientenNorm(double[] gradient) {
		return Math.sqrt(Math.pow(gradient[0], 2) + Math.pow(gradient[1], 2));
	}
}
