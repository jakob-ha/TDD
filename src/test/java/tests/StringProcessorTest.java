package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.StringProcessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * String processor will be able to reverse strings and detect palindromes
 */
public class StringProcessorTest {
    private StringProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new StringProcessor();
    }

    @ParameterizedTest
    @CsvSource({"abra, arba",
    "kadabra, arbadak",
    "'',''",
    "this contains spaces,secaps sniatnoc siht",
    " abc , cba ",
    "' ',' '",
    "HEllo,ollEH"})
    @DisplayName("Tests whether simple strings can be reversed")
    public void shouldReverseSimpleString(String input, String expected) {
        assertEquals(expected, processor.reverse(input));
    }

    @ParameterizedTest
    @CsvSource({"abba,true",
    "abc,false",
    "Abba,true",
    "AB BA,true",
    "😊😒😊,true",
    "🎶😢,false"})
    @DisplayName("Tests whether simple strings can be reversed")
    public void shouldDetectPalindrome(String input, boolean expected) {
        assertEquals(expected, processor.detectPalindrome(input));
    }
}
