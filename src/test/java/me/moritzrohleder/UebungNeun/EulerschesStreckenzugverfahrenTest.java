package me.moritzrohleder.UebungNeun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EulerschesStreckenzugverfahrenTest {

    @Test
    public void testFAtZeroOne() {
        // f(x, y) = y + e^x
        // f(0, 1) = 1 + e^0 = 2
        assertEquals(2.0, EulerschesStreckenzugverfahren.f(0.0, 1.0), 1e-10);
    }

    @Test
    public void testFAtOneZero() {
        // f(1, 0) = 0 + e^1 = e
        assertEquals(Math.E, EulerschesStreckenzugverfahren.f(1.0, 0.0), 1e-10);
    }

    @Test
    public void testFAtZeroZero() {
        // f(0, 0) = 0 + e^0 = 1
        assertEquals(1.0, EulerschesStreckenzugverfahren.f(0.0, 0.0), 1e-10);
    }

    @Test
    public void testFSymmetryInY() {
        // f(x, y) = y + e^x, linear in y
        double x = 0.5;
        double y1 = 2.0;
        double y2 = 5.0;
        assertEquals(y2 - y1, EulerschesStreckenzugverfahren.f(x, y2) - EulerschesStreckenzugverfahren.f(x, y1), 1e-10);
    }

    @Test
    public void testEulerschesStreckenzugverfahrenRunsWithoutException() {
        // Verifies that the method executes without throwing an exception
        assertDoesNotThrow(() -> EulerschesStreckenzugverfahren.eulerschesStreckenzugverfahren(0.0, 1.0, 0.1, 0.0));
    }
}
