package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.StringProcessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * String processor tests
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
    "🎶😢,false",
    "'',true",
    ",true",
    "1,true"})
    @DisplayName("Tests if string is palindrome")
    public void shouldDetectPalindrome(String input, boolean expected) {
        assertEquals(expected, processor.detectPalindrome(input));
    }

    @ParameterizedTest
    @CsvSource({
            "aaa,a3",
            "bbb,b3",
            "aba,aba",
            ",",
            "AAAAAAAAAllllllllllllOOOOOOOoooo,A9l12O7o4",
            "'   ',' 3'"
    })
    @DisplayName("Test Strings Compressor")
    public void shouldCompressString(String input, String expected) {
        assertEquals(expected,processor.compress(input));
    }


    @ParameterizedTest
    @CsvSource({"Two words,2",
    "Three words now,3",
    " Still  three   words ,3",
    "One,1",
    "' ',0",
            "'  ',0",
    ",0"})
    @DisplayName("Test Word Counter")
    public void shouldCountWords(String input, int expected) {
        assertEquals(expected, processor.countWords(input));
    }

    @ParameterizedTest
    @CsvSource({
            "abra@kadabra.com,true"
    })
    @DisplayName("Tests Validating Email Format")
    public void shouldValidateEmailFormat(String input, boolean expected) {
        assertEquals(expected,processor.validateEmailFormat(input));
    }
}
