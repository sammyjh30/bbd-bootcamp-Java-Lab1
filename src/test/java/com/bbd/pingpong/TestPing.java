package com.bbd.pingpong;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPing {
    @Test
    public void throwIllegalArgumentExceptionWhenInputNotInIVXLCDM() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    RomanConverter.convert("W");
                });
    }

    @Test
    public void throwIllegalArgumentExceptionWhenInputNotInOrderWithIL() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    RomanConverter.convert("IL");
                });
    }

    @Test
    public void throwIllegalArgumentExceptionWhenInputNotInOrderWithVX() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    RomanConverter.convert("VX");
                });
    }

    @Test
    public void throwIllegalArgumentExceptionWhenInputNotInOrderWithLM() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    RomanConverter.convert("LM");
                });
    }



    @Test
    public void throwIllegalArgumentExceptionWhenInputNotInOrderWithIIII() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    RomanConverter.convert("IIII");
                });
    }

    @Test
    public void outputEquals1IfInputEqualsI()
    {
        assertEquals(1, RomanConverter.convert("I"));
    }
    @Test
    public void outputEquals5IfInputEqualsV()
    {
        assertEquals(5, RomanConverter.convert("V"));
    }

    @Test
    public void outputEquals4IfInputEqualsIV()
    {
        assertEquals(4, RomanConverter.convert("IV"));
    }

    @Test
    public void outputEquals9IfInputEqualsIX()
    {
        assertEquals(9, RomanConverter.convert("IX"));
    }

    // 10 to 90

    @Test
    public void outputEquals10IfInputEqualsX()
    {
        assertEquals(10, RomanConverter.convert("X"));
    }

    @Test
    public void outputEquals40IfInputEqualsXL()
    {
        assertEquals(40, RomanConverter.convert("XL"));
    }

    @Test
    public void outputEquals50IfInputEqualsL()
    {
        assertEquals(50, RomanConverter.convert("L"));
    }

    @Test
    public void outputEquals90IfInputEqualsXC()
    {
        assertEquals(90, RomanConverter.convert("XC"));
    }

    // 100 to 900
    @Test
    public void outputEquals100IfInputEqualsC()
    {
        assertEquals(100, RomanConverter.convert("C"));
    }

    @Test
    public void outputEquals400IfInputEqualsCD()
    {
        assertEquals(400, RomanConverter.convert("CD"));
    }

    @Test
    public void outputEquals500IfInputEqualsD()
    {
        assertEquals(500, RomanConverter.convert("D"));
    }

    @Test
    public void outputEquals900IfInputEqualsCM()
    {
        assertEquals(900, RomanConverter.convert("CM"));
    }

    // 1000 to 2000
    @Test
    public void outputEquals1000IfInputEqualsM()
    {
        assertEquals(1000, RomanConverter.convert("M"));
    }

    @Test
    public void outputEquals2000IfInputEqualsMM()
    {
        assertEquals(2000, RomanConverter.convert("MM"));
    }

    // Other tests
    @Test
    public void outputEquals3000IfInputEqualsMMM()
    {
        assertEquals(3000, RomanConverter.convert("MMM"));
    }

    @Test
    public void outputEquals55IfInputEqualsLV()
    {
        assertEquals(55, RomanConverter.convert("LV"));
    }

    @Test
    public void outputEquals511IfInputEqualsDXI()
    {
        assertEquals(511, RomanConverter.convert("DXI"));
    }

    @Test
    public void outputEquals102IfInputEqualsCII()
    {
        assertEquals(102, RomanConverter.convert("CII"));
    }

    @Test
    public void outputEquals4000IfInputEqualsMMMM()
    {
        assertEquals(4000, RomanConverter.convert("MMMM"));
    }


    @ParameterizedTest
    @CsvSource({ "i, 1", "ii, 2", "v, 5" })
    void testWithCsvSource(String roman, int expected){
        assertEquals(expected, RomanConverter.convert(roman));
    }

}
