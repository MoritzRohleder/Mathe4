package me.moritzrohleder.UebungNeun;

public class RungeKuttaVerfahren {

	public static void rungeKuttaVerfahren(double x0, double xN, double h, double y0) {
		System.out.printf("Runge-Kutta-Verfahren mit x0: %.6f, xN: %.6f, h: %.6f, y0: %.6f\n", x0, xN, h, y0);
		double[] result = new double[]{0, 1};
		for(double x = x0; x < xN; x += h) {
			double k1 = h * f(result[0], result[1]);
			double k2 = h * f(result[0] + h/2, result[1] + k1/2);
			double k3 = h * f(result[0] + h/2, result[1] + k2/2);
			double k4 = h * f(result[0] + h, result[1] + k3);
			result[1] = result[1] + (k1 + 2*k2 + 2*k3 + k4)/6;
			result[0] = x + h;
			System.out.printf("x: %.6f, y: %.6f\n", result[0], result[1]);
		}
	}

	public static double f(double x, double y) {
		return y + Math.exp(x);
	}
}
