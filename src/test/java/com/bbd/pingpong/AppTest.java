package com.bbd.pingpong;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @DisplayName("Valid roman numeral")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({
            "I, 1",
            "II, 2",
            "V, 5",
            "VI, 6",
            "vi, 6",
            "X, 10",
            "l, 50",
            "c, 100",
            "d, 500",
            "M, 1000",
            "MMX, 2010",
            "IV, 4",
            "IX, 9",
            "XL, 40",
            "XC, 90",
            "CD, 400",
            "CM, 900",
            "CDVI, 406",
            "CDIV, 404",
            "VIII, 8",
            "XXXIX, 39",
            "MMMCMXLIX, 3949",
            "LXXXIX, 89",
            "CMXCIX, 999"
    })
    public void shouldHandleValidRomanNumerals(String roman, int arabic) {
        assertEquals(arabic, RomanConverter.Convert(roman));
    }

    @DisplayName("Invalid roman numeral")
    @ParameterizedTest(name = "\"should be throw and exception for {0}")
    @CsvSource({
            "P",
            "A",
            "ICXII",
            "XXXX",
            "IIII"

    })
    public void shouldThrowForInvalidRomanNumerals(String invalidRoman) {
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.Convert(invalidRoman));
    }

    @Test
    public void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.Convert(""));
    }

    @Test
    public void testNull() {
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.Convert(null));
    }
}