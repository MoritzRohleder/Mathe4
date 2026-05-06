package me.moritzrohleder.UebungZehn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZahlenUmrechnungTest {

    // --- umrechnungDezimalBAdisch ---

    @Test
    public void testDezimalZuBinaer() {
        // 10 decimal → binary: 1010
        assertEquals(1010, ZahlenUmrechnung.umrechnungDezimalBAdisch(10, 2));
    }

    @Test
    public void testDezimalZuOktal() {
        // 8 decimal → octal: 10
        assertEquals(10, ZahlenUmrechnung.umrechnungDezimalBAdisch(8, 8));
    }

    @Test
    public void testDezimalZuBasis5() {
        // 25 decimal → base-5: 100
        assertEquals(100, ZahlenUmrechnung.umrechnungDezimalBAdisch(25, 5));
    }

    @Test
    public void testDezimalZeroReturnsZero() {
        assertEquals(0, ZahlenUmrechnung.umrechnungDezimalBAdisch(0, 2));
    }

    @Test
    public void testDezimalNegativeThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> ZahlenUmrechnung.umrechnungDezimalBAdisch(-1, 2));
    }

    @Test
    public void testDezimalBasisZuKleinThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> ZahlenUmrechnung.umrechnungDezimalBAdisch(10, 1));
    }

    @Test
    public void testDezimalBasisZuGrossThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> ZahlenUmrechnung.umrechnungDezimalBAdisch(10, 11));
    }

    // --- umrechnungBAdischDezimal ---

    @Test
    public void testBinaerZuDezimal() {
        // binary 1010 → decimal 10
        assertEquals(10, ZahlenUmrechnung.umrechnungBAdischDezimal(1010, 2));
    }

    @Test
    public void testOktalZuDezimal() {
        // octal 10 → decimal 8
        assertEquals(8, ZahlenUmrechnung.umrechnungBAdischDezimal(10, 8));
    }

    @Test
    public void testBasis5ZuDezimal() {
        // base-5 100 → decimal 25
        assertEquals(25, ZahlenUmrechnung.umrechnungBAdischDezimal(100, 5));
    }

    @Test
    public void testBAdischZeroReturnsZero() {
        assertEquals(0, ZahlenUmrechnung.umrechnungBAdischDezimal(0, 2));
    }

    @Test
    public void testBAdischNegativeThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> ZahlenUmrechnung.umrechnungBAdischDezimal(-1, 2));
    }

    @Test
    public void testBAdischBasisZuKleinThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> ZahlenUmrechnung.umrechnungBAdischDezimal(10, 1));
    }

    @Test
    public void testBAdischBasisZuGrossThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> ZahlenUmrechnung.umrechnungBAdischDezimal(10, 11));
    }

    // --- umrechnung ---

    @Test
    public void testUmrechnungBinaerZuOktal() {
        // binary 1000 (=8 decimal) → octal 10
        assertEquals(10, ZahlenUmrechnung.umrechnung(1000, 2, 8));
    }

    @Test
    public void testUmrechnungOktalZuBinaer() {
        // octal 10 (=8 decimal) → binary 1000
        assertEquals(1000, ZahlenUmrechnung.umrechnung(10, 8, 2));
    }

    @Test
    public void testUmrechnungIdentityBase10() {
        // decimal to decimal should be identity (for values storable in both bases)
        assertEquals(25, ZahlenUmrechnung.umrechnung(25, 10, 10));
    }
}
