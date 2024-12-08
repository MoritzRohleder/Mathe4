package me.moritzrohleder.UebungAcht;

import static me.moritzrohleder.UebungAcht.GradientenAbstiegsVerfahren.f;

public class Differenzenformel {

	public static double ersteAbleitung(double x, double h) {
		assert h > 0;
		return (f(x + h) - f(x -h))/(2*h);
	}

	public static double ersteAbleitungX(double x, double y, double h) {
		assert h > 0;
		return (f(x + h, y) - f(x -h, y))/(2*h);
	}

	public static double ersteAbleitungY(double x, double y, double h) {
		assert h > 0;
		return (f(x, y + h) - f(x, y -h))/(2*h);
	}
}
