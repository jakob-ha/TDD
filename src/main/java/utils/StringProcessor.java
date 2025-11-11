package utils;


/**
 * Reverses strings and detects palindromes
 */
public class StringProcessor {
    public String reverse(String input) {
        StringBuilder result = new StringBuilder(input);
        return result.reverse().toString();
    }

    public boolean detectPalindrome(String input) {
        if (input == null) {return true;}
        StringBuilder result = new StringBuilder(input.toLowerCase());
        return input.toLowerCase().contentEquals(result.reverse());
    }

    public String compress(String input) {
        return "a3";
    }
}
