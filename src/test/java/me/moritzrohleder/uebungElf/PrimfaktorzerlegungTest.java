package me.moritzrohleder.uebungElf;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class PrimfaktorzerlegungTest {

    @Test
    public void testPrimfaktorzerlegung12() {
        LinkedList<Integer> result = Primfaktorzerlegung.primfaktorzerlegung(12);
        // 12 = 2 * 2 * 3
        assertEquals(3, result.size());
        assertEquals(2, (int) result.get(0));
        assertEquals(2, (int) result.get(1));
        assertEquals(3, (int) result.get(2));
    }

    @Test
    public void testPrimfaktorzerlegungPrime() {
        LinkedList<Integer> result = Primfaktorzerlegung.primfaktorzerlegung(7);
        // 7 is prime
        assertEquals(1, result.size());
        assertEquals(7, (int) result.get(0));
    }

    @Test
    public void testPrimfaktorzerlegung1() {
        // 1 has no prime factors
        LinkedList<Integer> result = Primfaktorzerlegung.primfaktorzerlegung(1);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testPrimfaktorzerlegungProduct() {
        // Product of factors must equal original number
        int n = 60;
        LinkedList<Integer> result = Primfaktorzerlegung.primfaktorzerlegung(n);
        int product = 1;
        for (int factor : result) {
            product *= factor;
        }
        assertEquals(n, product);
    }

    @Test
    public void testPrimfaktorzerlegungPowerOfTwo() {
        LinkedList<Integer> result = Primfaktorzerlegung.primfaktorzerlegung(8);
        // 8 = 2 * 2 * 2
        assertEquals(3, result.size());
        for (int factor : result) {
            assertEquals(2, factor);
        }
    }
}
