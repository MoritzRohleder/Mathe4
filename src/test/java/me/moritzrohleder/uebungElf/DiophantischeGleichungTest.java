package me.moritzrohleder.uebungElf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiophantischeGleichungTest {

    @Test
    public void testBasicSolution() {
        // 5x + 3y = 1 (a > b, so max(a,b)=a and result satisfies a*x + b*y = c)
        int[] result = DiophantischeGleichung.diophantischeGleichung(5, 3, 1);
        assertEquals(1, 5 * result[0] + 3 * result[1],
                "5x + 3y = 1 muss erfüllt sein");
    }

    @Test
    public void testScaledSolution() {
        // 5x + 3y = 4 (a > b)
        int[] result = DiophantischeGleichung.diophantischeGleichung(5, 3, 4);
        assertEquals(4, 5 * result[0] + 3 * result[1],
                "5x + 3y = 4 muss erfüllt sein");
    }

    @Test
    public void testSolutionWhenGcdIsNotOne() {
        // gcd(6, 4) = 2, c = 8 → divisible → solution must satisfy 6x + 4y = 8
        int[] result = DiophantischeGleichung.diophantischeGleichung(6, 4, 8);
        assertEquals(8, 6 * result[0] + 4 * result[1],
                "6x + 4y = 8 muss erfüllt sein");
    }

    @Test
    public void testNoSolutionThrows() {
        // gcd(2, 4) = 2, c = 3 → not divisible → exception
        assertThrows(IllegalArgumentException.class,
                () -> DiophantischeGleichung.diophantischeGleichung(2, 4, 3));
    }

    @Test
    public void testNoSolutionThrowsForOddC() {
        // gcd(6, 4) = 2, c = 3 → not divisible → exception
        assertThrows(IllegalArgumentException.class,
                () -> DiophantischeGleichung.diophantischeGleichung(6, 4, 3));
    }
}
