package me.moritzrohleder.uebungElf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroessterGemeinsamerTeilerTest {

    // --- ggT ---

    @Test
    public void testGgTBasic() {
        assertEquals(4, GroessterGemeinsamerTeiler.ggT(12, 8));
    }

    @Test
    public void testGgTCoprimes() {
        assertEquals(1, GroessterGemeinsamerTeiler.ggT(7, 13));
    }

    @Test
    public void testGgTSameNumbers() {
        assertEquals(5, GroessterGemeinsamerTeiler.ggT(5, 5));
    }

    @Test
    public void testGgTOrderIndependent() {
        assertEquals(GroessterGemeinsamerTeiler.ggT(12, 8), GroessterGemeinsamerTeiler.ggT(8, 12));
    }

    @Test
    public void testGgTThrowsForZeroA() {
        assertThrows(IllegalArgumentException.class,
                () -> GroessterGemeinsamerTeiler.ggT(0, 5));
    }

    @Test
    public void testGgTThrowsForZeroB() {
        assertThrows(IllegalArgumentException.class,
                () -> GroessterGemeinsamerTeiler.ggT(5, 0));
    }

    // --- erweiterterEuklidischerAlgorithmus ---

    @Test
    public void testErweiterterEuklid() {
        int[] result = GroessterGemeinsamerTeiler.erweiterterEuklidischerAlgorithmus(12, 8);
        // result[0] = gcd, result[1] = x, result[2] = y, such that 12x + 8y = gcd
        assertEquals(4, result[0]);
        assertEquals(0, 12 * result[1] + 8 * result[2] - result[0],
                "Bezout-Identität 12*x + 8*y = gcd(12,8) muss gelten");
    }

    @Test
    public void testErweiterterEuklidCoprimes() {
        // Use a > b so max(a,b)=a and the identity a*x + b*y = gcd holds directly
        int[] result = GroessterGemeinsamerTeiler.erweiterterEuklidischerAlgorithmus(5, 3);
        assertEquals(1, result[0]);
        assertEquals(0, 5 * result[1] + 3 * result[2] - result[0],
                "Bezout-Identität 5*x + 3*y = 1 muss gelten");
    }

    @Test
    public void testErweiterterEuklidThrowsForZero() {
        assertThrows(IllegalArgumentException.class,
                () -> GroessterGemeinsamerTeiler.erweiterterEuklidischerAlgorithmus(0, 5));
    }

    // --- ggTmehrererZahlen ---

    @Test
    public void testGgTMehrererZahlen() {
        assertEquals(2, GroessterGemeinsamerTeiler.ggTmehrererZahlen(new int[]{12, 8, 6}));
    }

    @Test
    public void testGgTMehrererZahlenSingle() {
        assertEquals(7, GroessterGemeinsamerTeiler.ggTmehrererZahlen(new int[]{7}));
    }

    @Test
    public void testGgTMehrererZahlenCoprimes() {
        assertEquals(1, GroessterGemeinsamerTeiler.ggTmehrererZahlen(new int[]{3, 5, 7}));
    }
}
