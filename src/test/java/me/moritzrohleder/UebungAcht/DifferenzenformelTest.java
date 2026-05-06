package me.moritzrohleder.UebungAcht;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DifferenzenformelTest {

    @BeforeEach
    public void setUp() {
        GradientenAbstiegsVerfahren.aufgabe = "b";
    }

    @AfterEach
    public void tearDown() {
        GradientenAbstiegsVerfahren.aufgabe = "b";
    }

    @Test
    public void testErsteAbleitungAtZero() {
        // aufgabe "b": f(x) = 0.0005x^6 - 0.01x^5 + 0.12x^4 - 0.5x^3 + 0.75x^2 - 0.4x
        // f'(0) = -0.4 (analytisch)
        double result = Differenzenformel.ersteAbleitung(0.0, 0.001);
        assertEquals(-0.4, result, 1e-5);
    }

    @Test
    public void testErsteAbleitungAtOne() {
        // f'(1) = 0.003 - 0.05 + 0.48 - 1.5 + 1.5 - 0.4 = 0.033
        double result = Differenzenformel.ersteAbleitung(1.0, 0.001);
        assertEquals(0.033, result, 1e-4);
    }

    @Test
    public void testErsteAbleitungXAtOrigin() {
        // aufgabe "b": f(x,y) = (x^2+y^2)*e^(-x)
        // df/dx at (0,0) = (2x - x^2 - y^2)*e^(-x) at (0,0) = 0
        double result = Differenzenformel.ersteAbleitungX(0.0, 0.0, 0.001);
        assertEquals(0.0, result, 1e-5);
    }

    @Test
    public void testErsteAbleitungYAtOrigin() {
        // df/dy at (0,0) = 2y*e^(-x) at (0,0) = 0
        double result = Differenzenformel.ersteAbleitungY(0.0, 0.0, 0.001);
        assertEquals(0.0, result, 1e-5);
    }

    @Test
    public void testErsteAbleitungXAtOneZero() {
        // df/dx at (1,0) = (2-1-0)*e^(-1) = e^(-1) ≈ 0.3679
        double result = Differenzenformel.ersteAbleitungX(1.0, 0.0, 0.001);
        assertEquals(Math.exp(-1), result, 1e-4);
    }

    @Test
    public void testErsteAbleitungYAtZeroOne() {
        // df/dy at (0,1) = 2*1*e^0 = 2
        double result = Differenzenformel.ersteAbleitungY(0.0, 1.0, 0.001);
        assertEquals(2.0, result, 1e-4);
    }

    @Test
    public void testErsteAbleitungFunktionC() {
        GradientenAbstiegsVerfahren.aufgabe = "c";
        // aufgabe "c": f(x) = x^2 * e^(-x)
        // f'(x) = (2x - x^2)*e^(-x)
        // f'(1) = (2-1)*e^(-1) = e^(-1) ≈ 0.3679
        double result = Differenzenformel.ersteAbleitung(1.0, 0.001);
        assertEquals(Math.exp(-1), result, 1e-4);
    }
}
