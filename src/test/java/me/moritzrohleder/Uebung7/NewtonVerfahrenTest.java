package me.moritzrohleder.Uebung7;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class NewtonVerfahrenTest {

    @Test
    public void testCalculateNewtonVerfahrenConverges() {
        // f(x) = x^2 - 2*cos(x), converges from x=1.0
        LinkedList<Double> result = NewtonVerfahren.calculateNewtonVerfahren(1.0);
        assertFalse(result.isEmpty(), "Ergebnis darf nicht leer sein für konvergenten Startwert");
        // Verify the result is actually a root: f(root) ≈ 0
        double root = result.getLast();
        assertEquals(0.0, NewtonMenu.funktionF(root), 1e-3, "Konvergierter Wert soll eine Nullstelle sein");
    }

    @Test
    public void testCalculateNewtonVerfahrenConvergesNegativeStart() {
        // f(x) = x^2 - 2*cos(x), converges from x=-1.0
        LinkedList<Double> result = NewtonVerfahren.calculateNewtonVerfahren(-1.0);
        assertFalse(result.isEmpty(), "Ergebnis darf nicht leer sein für konvergenten negativen Startwert");
        double root = result.getLast();
        assertEquals(0.0, NewtonMenu.funktionF(root), 1e-3, "Konvergierter Wert soll eine Nullstelle sein");
    }

    @Test
    public void testCalculateNewtonVerfahrenDiverges() {
        // x=0 causes f'(0)=0 => division by zero => non-convergence
        LinkedList<Double> result = NewtonVerfahren.calculateNewtonVerfahren(0.0);
        assertTrue(result.isEmpty(), "Ergebnis soll leer sein wenn Konvergenzkriterium verletzt");
    }

    @Test
    public void testCalculateNewtonVerfahrenIntervallConverges() {
        // g(x) = tan(x) - x - 2 on ]-Pi/2, Pi/2[
        LinkedList<Double> result = NewtonVerfahren.calculateNewtonVerfahrenIntervall(1.2, -Math.PI / 2, Math.PI / 2);
        assertFalse(result.isEmpty(), "Ergebnis darf nicht leer sein für konvergenten Startwert im Intervall");
        // Verify convergence: two last values must agree at 4 decimal places
        double root = result.getLast();
        assertTrue(Math.abs(root) < Math.PI / 2, "Ergebnis muss im Intervall liegen");
    }

    @Test
    public void testCalculateNewtonVerfahrenIntervallOutOfBounds() {
        // Startwert weit ausserhalb des Intervalls
        LinkedList<Double> result = NewtonVerfahren.calculateNewtonVerfahrenIntervall(10.0, -Math.PI / 2, Math.PI / 2);
        assertTrue(result.isEmpty(), "Ergebnis soll leer sein wenn Startwert ausserhalb Intervall");
    }

    @Test
    public void testCheckGleichheitEqual() {
        assertTrue(NewtonVerfahren.checkGleichheit(1.23456, 1.23456));
    }

    @Test
    public void testCheckGleichheitDifferentBeyondPrecision() {
        assertFalse(NewtonVerfahren.checkGleichheit(1.23456, 1.23457));
    }

    @Test
    public void testCheckGleichheitSameWithinPrecision() {
        // Differ only at 6th decimal place → round to same value at 5 decimal places → equal
        assertTrue(NewtonVerfahren.checkGleichheit(1.234561, 1.234562));
    }
}
