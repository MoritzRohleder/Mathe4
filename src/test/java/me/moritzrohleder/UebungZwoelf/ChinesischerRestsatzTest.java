package me.moritzrohleder.UebungZwoelf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChinesischerRestsatzTest {

    @Test
    public void testBasicExample() {
        // x ≡ 2 (mod 3), x ≡ 3 (mod 5) → x = 8 (mod 15)
        int result = ChinesischerRestsatz.chinesischerRestsatz(new int[]{2, 3}, new int[]{3, 5});
        assertEquals(8, result);
    }

    @Test
    public void testAnotherExample() {
        // x ≡ 1 (mod 3), x ≡ 3 (mod 5) → x = 13 (mod 15)
        int result = ChinesischerRestsatz.chinesischerRestsatz(new int[]{1, 3}, new int[]{3, 5});
        assertEquals(13, result);
    }

    @Test
    public void testResultSatisfiesAllCongruences() {
        int[] a = {2, 3, 2};
        int[] n = {3, 5, 7};
        int result = ChinesischerRestsatz.chinesischerRestsatz(a, n);
        for (int i = 0; i < a.length; i++) {
            assertEquals(a[i], result % n[i],
                    "Ergebnis muss x ≡ " + a[i] + " (mod " + n[i] + ") erfüllen");
        }
    }

    @Test
    public void testSingleCongruence() {
        // x ≡ 3 (mod 7) → x = 3
        int result = ChinesischerRestsatz.chinesischerRestsatz(new int[]{3}, new int[]{7});
        assertEquals(3, result % 7);
    }
}
