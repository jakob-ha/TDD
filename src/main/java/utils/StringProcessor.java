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
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder compressedString = new StringBuilder();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            count++;
            // If it's the last character or the next character is different
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressedString.append(input.charAt(i));
                compressedString.append(count);
                count = 0; // Reset count for the next character
            }
        }

        // Return the original string if the compressed version is not shorter
        return compressedString.length() < input.length() ? compressedString.toString() : input;
    }

}
