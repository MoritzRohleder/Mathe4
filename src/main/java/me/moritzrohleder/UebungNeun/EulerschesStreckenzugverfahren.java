package me.moritzrohleder.UebungNeun;

public class EulerschesStreckenzugverfahren {

	public static void eulerschesStreckenzugverfahren(double x0, double xN, double h, double y0) {
		System.out.printf("Eulersches Streckenzugverfahren mit x0: %.6f, xN: %.6f, h: %.6f, y0: %.6f\n", x0, xN, h, y0);
		double[] result = new double[]{x0, y0};
		for(double x = x0; x < xN; x += h) {
			result[1] = result[1] + h * f(result[0], result[1]);
			result[0] = x + h;
			System.out.printf("x: %.6f, y: %.6f\n", result[0], result[1]);
		}
	}

	public static double f(double x, double y) {
		return y + Math.exp(x);
	}
}
