package me.moritzrohleder.UebungZwoelf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineareGleichungenTest {

    @Test
    public void testUniqueSolution() {
        // 3x ≡ 1 (mod 5): gcd(3,5)=1, solution x=2 (3*2=6≡1 mod 5)
        int[] result = LineareGleichungen.lineareGleichungInZ(3, 1, 5);
        assertEquals(2, result.length);
        // result[0] = x0 (raw), result[1] = x0 % n = solution
        assertEquals(1, (3 * result[1]) % 5);
    }

    @Test
    public void testMultipleSolutions() {
        // 2x ≡ 4 (mod 6): gcd(2,6)=2, 4%2=0 → 2 solutions
        int[] result = LineareGleichungen.lineareGleichungInZ(2, 4, 6);
        // Should return g+1 = 3 elements: [x0, sol1, sol2]
        assertEquals(3, result.length);
        for (int i = 1; i < result.length; i++) {
            assertEquals(0, (2 * result[i] - 4) % 6,
                    "result[" + i + "] = " + result[i] + " must satisfy 2x ≡ 4 (mod 6)");
        }
    }

    @Test
    public void testNoSolutionReturnsEmptyArray() {
        // 2x ≡ 3 (mod 6): gcd(2,6)=2, 3%2≠0 → no solution
        int[] result = LineareGleichungen.lineareGleichungInZ(2, 3, 6);
        assertEquals(0, result.length);
    }

    @Test
    public void testSolutionModulo7() {
        // 5x ≡ 3 (mod 7): gcd(5,7)=1, x=2 (5*2=10≡3 mod 7)
        int[] result = LineareGleichungen.lineareGleichungInZ(5, 3, 7);
        assertEquals(2, result.length);
        assertEquals(3, (5 * result[1]) % 7);
    }
}
