package utils;

public class StringProcessor {
    public String reverse(String input) {
        StringBuilder result = new StringBuilder(input);
        return result.reverse().toString();
    }

    public boolean detectPalindrome(String input) {
        StringBuilder result = new StringBuilder(input);
        return input.contentEquals(result.reverse());
    }
}
