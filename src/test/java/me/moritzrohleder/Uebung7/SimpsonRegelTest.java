package me.moritzrohleder.Uebung7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpsonRegelTest {

    private static final double DELTA = 0.01;

    @Test
    public void testCalculateSimpsonRegelFunktionA() {
        // Integral von 2 bis 6 über x^2+2x
        // Exact: 101.3333
        double result = SimpsonRegel.calculateSimpsonRegel(2, 6, 100, "a");
        assertEquals(101.3333, result, DELTA);
    }

    @Test
    public void testCalculateSimpsonRegelFunktionB() {
        // Integral von 1 bis 2 über (1-x^(-x))/x ≈ 0.2658
        double result = SimpsonRegel.calculateSimpsonRegel(1, 2, 100, "b");
        assertEquals(0.2658, result, 0.01);
    }

    @Test
    public void testCalculateSimpsonRegelN1FunktionA() {
        // n=1: Simpson with 3 points (x0=2, x1=4, x2=6)
        // h = (6-2)/(2*1) = 2
        // f(2)=8, f(4)=24, f(6)=48
        // Result = (f(2) + 4*f(4) + f(6)) * h/3 = (8 + 96 + 48) * 2/3 = 152 * 2/3 ≈ 101.333
        double result = SimpsonRegel.calculateSimpsonRegel(2, 6, 1, "a");
        assertEquals(101.333, result, DELTA);
    }

    @Test
    public void testSimpsonMoreAccurateThanTrapezForA() {
        // Simpson rule is of higher order than Trapez, so for same n it should be more accurate
        double simpsonResult = SimpsonRegel.calculateSimpsonRegel(2, 6, 10, "a");
        double trapezResult = TrapezRegel.calculateTrapezRegel(2, 6, 10, "a");
        double exact = 101.3333;
        assertTrue(Math.abs(simpsonResult - exact) <= Math.abs(trapezResult - exact),
                "Simpson-Regel sollte mindestens so genau sein wie Trapez-Regel");
    }
}
