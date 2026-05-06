package me.moritzrohleder.UebungZwoelf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EulerschePhiFunktionTest {

    @Test
    public void testPhiOf1() {
        // φ(1) = 1
        assertEquals(1, EulerschePhiFunktion.eulerschePhiFunktion(1));
    }

    @Test
    public void testPhiOf2() {
        // φ(2) = 1
        assertEquals(1, EulerschePhiFunktion.eulerschePhiFunktion(2));
    }

    @Test
    public void testPhiOf6() {
        // φ(6) = 2 (1 and 5 are coprime to 6)
        assertEquals(2, EulerschePhiFunktion.eulerschePhiFunktion(6));
    }

    @Test
    public void testPhiOfPrime() {
        // For prime p: φ(p) = p-1
        assertEquals(6, EulerschePhiFunktion.eulerschePhiFunktion(7));
    }

    @Test
    public void testPhiOf12() {
        // φ(12) = 4 (1, 5, 7, 11 are coprime to 12)
        assertEquals(4, EulerschePhiFunktion.eulerschePhiFunktion(12));
    }
}
