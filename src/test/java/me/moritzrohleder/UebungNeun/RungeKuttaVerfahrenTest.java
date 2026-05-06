package me.moritzrohleder.UebungNeun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RungeKuttaVerfahrenTest {

    @Test
    public void testFAtZeroOne() {
        // f(x, y) = y + e^x
        // f(0, 1) = 1 + 1 = 2
        assertEquals(2.0, RungeKuttaVerfahren.f(0.0, 1.0), 1e-10);
    }

    @Test
    public void testFAtOneZero() {
        // f(1, 0) = 0 + e = e
        assertEquals(Math.E, RungeKuttaVerfahren.f(1.0, 0.0), 1e-10);
    }

    @Test
    public void testFAtZeroZero() {
        // f(0, 0) = 0 + 1 = 1
        assertEquals(1.0, RungeKuttaVerfahren.f(0.0, 0.0), 1e-10);
    }

    @Test
    public void testFMatchesEulerF() {
        // Both classes implement the same ODE f(x,y) = y + e^x
        double x = 2.5;
        double y = 3.7;
        assertEquals(EulerschesStreckenzugverfahren.f(x, y), RungeKuttaVerfahren.f(x, y), 1e-15);
    }

    @Test
    public void testRungeKuttaVerfahrenRunsWithoutException() {
        assertDoesNotThrow(() -> RungeKuttaVerfahren.rungeKuttaVerfahren(0.0, 1.0, 0.1, 0.0));
    }
}
