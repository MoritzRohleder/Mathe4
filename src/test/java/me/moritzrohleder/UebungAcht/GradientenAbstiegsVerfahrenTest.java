package me.moritzrohleder.UebungAcht;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GradientenAbstiegsVerfahrenTest {

    @BeforeEach
    public void setUp() {
        GradientenAbstiegsVerfahren.aufgabe = "b";
        GradientenAbstiegsVerfahren.isMaxVerfahren = true;
    }

    @AfterEach
    public void tearDown() {
        GradientenAbstiegsVerfahren.aufgabe = "b";
        GradientenAbstiegsVerfahren.isMaxVerfahren = true;
    }

    // --- f(double x) tests ---

    @Test
    public void testFAufgabeBAtZero() {
        // f(0) = 0
        GradientenAbstiegsVerfahren.aufgabe = "b";
        assertEquals(0.0, GradientenAbstiegsVerfahren.f(0.0), 1e-10);
    }

    @Test
    public void testFAufgabeBAtOne() {
        // f(1) = 0.0005 - 0.01 + 0.12 - 0.5 + 0.75 - 0.4 = -0.0395
        GradientenAbstiegsVerfahren.aufgabe = "b";
        assertEquals(-0.0395, GradientenAbstiegsVerfahren.f(1.0), 1e-10);
    }

    @Test
    public void testFAufgabeCAtZero() {
        // c) f(x) = x^2 * e^(-x), f(0) = 0
        GradientenAbstiegsVerfahren.aufgabe = "c";
        assertEquals(0.0, GradientenAbstiegsVerfahren.f(0.0), 1e-10);
    }

    @Test
    public void testFAufgabeCAtOne() {
        // f(1) = 1 * e^(-1) = e^(-1)
        GradientenAbstiegsVerfahren.aufgabe = "c";
        assertEquals(Math.exp(-1), GradientenAbstiegsVerfahren.f(1.0), 1e-10);
    }

    @Test
    public void testFDefaultReturnsZero() {
        GradientenAbstiegsVerfahren.aufgabe = "unknown";
        assertEquals(0.0, GradientenAbstiegsVerfahren.f(5.0), 1e-10);
    }

    // --- f(double x, double y) tests ---

    @Test
    public void testF2DAufgabeBAtOrigin() {
        // f(0,0) = 0 * e^0 = 0
        GradientenAbstiegsVerfahren.aufgabe = "b";
        assertEquals(0.0, GradientenAbstiegsVerfahren.f(0.0, 0.0), 1e-10);
    }

    @Test
    public void testF2DAufgabeBAtOneZero() {
        // f(1,0) = (1+0)*e^(-1) = e^(-1)
        GradientenAbstiegsVerfahren.aufgabe = "b";
        assertEquals(Math.exp(-1), GradientenAbstiegsVerfahren.f(1.0, 0.0), 1e-10);
    }

    @Test
    public void testF2DAufgabeCAtOrigin() {
        // c) f(x,y) = -e^(-(x^2+y^2)), f(0,0) = -1
        GradientenAbstiegsVerfahren.aufgabe = "c";
        assertEquals(-1.0, GradientenAbstiegsVerfahren.f(0.0, 0.0), 1e-10);
    }

    @Test
    public void testF2DArrayWrapperMatchesXY() {
        GradientenAbstiegsVerfahren.aufgabe = "b";
        double[] xy = {1.0, 2.0};
        assertEquals(GradientenAbstiegsVerfahren.f(1.0, 2.0), GradientenAbstiegsVerfahren.f(xy), 1e-15);
    }

    // --- gradient tests ---

    @Test
    public void testGradientSingleVarAtZero() {
        // f'(0) for aufgabe "b" = -0.4
        GradientenAbstiegsVerfahren.aufgabe = "b";
        assertEquals(-0.4, GradientenAbstiegsVerfahren.gradient(0.0, 0.001), 1e-4);
    }

    @Test
    public void testGradient2DAtOrigin() {
        // df/dx at (0,0) = 0, df/dy at (0,0) = 0
        GradientenAbstiegsVerfahren.aufgabe = "b";
        double[] grad = GradientenAbstiegsVerfahren.gradient(0.0, 0.0, 0.001);
        assertEquals(2, grad.length);
        assertEquals(0.0, grad[0], 1e-4);
        assertEquals(0.0, grad[1], 1e-4);
    }

    @Test
    public void testGradient2DArrayWrapperMatchesXY() {
        GradientenAbstiegsVerfahren.aufgabe = "b";
        double[] xy = {1.0, 1.0};
        double[] direct = GradientenAbstiegsVerfahren.gradient(1.0, 1.0, 0.001);
        double[] viaArray = GradientenAbstiegsVerfahren.gradient(xy, 0.001);
        assertArrayEquals(direct, viaArray, 1e-15);
    }

    @Test
    public void testGradientenNorm() {
        double[] grad = {3.0, 4.0};
        assertEquals(5.0, GradientenAbstiegsVerfahren.gradientenNorm(grad), 1e-10);
    }

    @Test
    public void testGradientenNormZero() {
        double[] grad = {0.0, 0.0};
        assertEquals(0.0, GradientenAbstiegsVerfahren.gradientenNorm(grad), 1e-10);
    }
}
