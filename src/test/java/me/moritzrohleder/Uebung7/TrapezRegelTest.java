package me.moritzrohleder.Uebung7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrapezRegelTest {

    private static final double DELTA = 0.1;

    @Test
    public void testCalculateTrapezRegelFunktionA() {
        // Integral von 2 bis 6 über x^2+2x
        // Exact: [x^3/3 + x^2] from 2 to 6 = (72+36) - (8/3+4) = 108 - 6.6667 = 101.3333
        double result = TrapezRegel.calculateTrapezRegel(2, 6, 1000, "a");
        assertEquals(101.3333, result, DELTA);
    }

    @Test
    public void testCalculateTrapezRegelFunktionB() {
        // Integral von 1 bis 2 über (1-x^(-x))/x ≈ 0.2658
        double result = TrapezRegel.calculateTrapezRegel(1, 2, 1000, "b");
        assertEquals(0.2658, result, 0.01);
    }

    @Test
    public void testCalculateTrapezRegelN1FunktionA() {
        // n=1: einfache Trapezregel: h=4, sum = (f(2)+f(6))/2 * 4 = (8+48)/2 * 4 = 28*4 = 112
        double result = TrapezRegel.calculateTrapezRegel(2, 6, 1, "a");
        assertEquals(112.0, result, 1e-9);
    }

    @Test
    public void testCalculateTrapezRegelApproximationImproves() {
        double coarseResult = TrapezRegel.calculateTrapezRegel(2, 6, 10, "a");
        double fineResult = TrapezRegel.calculateTrapezRegel(2, 6, 1000, "a");
        double exact = 101.3333;
        assertTrue(Math.abs(fineResult - exact) < Math.abs(coarseResult - exact),
                "Feinere Approximation sollte genauer sein");
    }
}
