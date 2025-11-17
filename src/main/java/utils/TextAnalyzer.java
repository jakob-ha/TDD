package utils;

import java.util.Set;

public class TextAnalyzer {
    Calculator calculator;
    StringProcessor stringProcessor;

    public TextAnalyzer(Calculator calculator, StringProcessor stringProcessor) {
        this.calculator = calculator;
        this.stringProcessor = stringProcessor;
    }

    private final Set<String> POSITIVE_WORDS = Set.of("happy", "wonderful", "sunshine", "joyous", "bliss");
    private final Set<String> NEGATIVE_WORDS = Set.of("sad", "distraught", "agony");

    public SentimentResult analyzeSentiment(String text) {
        text = text.toLowerCase();
        String[] words = text.replaceAll("[^\\p{L}\\p{N}']", " ").trim().split("\\s+");
        int positiveWords = 0;
        int negativeWords = 0;
        for (String word : words) {
            if (POSITIVE_WORDS.contains(word)) {
                positiveWords++;
            }
            if (NEGATIVE_WORDS.contains(word)) {
                negativeWords++;
            }
        }
        double sentimentScore = 0;
        if (positiveWords + negativeWords != 0) {
            sentimentScore = ((double) positiveWords - (double) negativeWords) / ((double) positiveWords + (double) negativeWords);
        } else {
            sentimentScore = 0;
        }
        SentimentCategory sentimentCategory;
        if (sentimentScore == 0) {
            sentimentCategory = SentimentCategory.NEUTRAL;
        } else if (sentimentScore > 0) {
            sentimentCategory = SentimentCategory.POSITIVE;
        } else {
            sentimentCategory = SentimentCategory.NEGATIVE;
        }
        return new SentimentResult(sentimentScore, sentimentCategory, positiveWords, negativeWords);
    }

    public ReadabilityResult assessReadability(String text) {
        int wordsCount = countWords(text);
        int syllablesCount = countTotalSyllables(text);
        int sentencesCount = countSentences(text);
        double averageSyllablesPerWord;
        double averageWordsPerSentence;
        if (sentencesCount != 0 && wordsCount != 0) {
            averageWordsPerSentence = wordsCount / (double) sentencesCount;
            averageSyllablesPerWord = syllablesCount / (double) wordsCount;
        } else {
            return new ReadabilityResult(0, ReadingLevel.VERY_EASY, 0, 0, 0, 0, 0);
        }
        double fleschScore = 206.835 - (1.015 * averageWordsPerSentence) - (84.6 * averageSyllablesPerWord);
        ReadingLevel readingLevel = determineReadingLevel(fleschScore);
        return new ReadabilityResult(fleschScore, readingLevel, sentencesCount, wordsCount, syllablesCount, averageWordsPerSentence, averageSyllablesPerWord);

    }


    // Count sentences based on ., !, ?
    private static int countSentences(String text) {
        if (text == null || text.isEmpty()) return 0;
        String[] sentences = text.split("[.!?]+");
        int count = 0;

        for (String s : sentences) {
            if (s.trim().length() > 0) count++;
        }
        return count;
    }

    // Count words using alphabetic sequences
    private static int countWords(String text) {
        if (text == null || text.isEmpty()) return 0;
        String[] words = text.split("[^a-zA-Z]+");
        int count = 0;

        for (String w : words) {
            if (w.trim().length() > 0) count++;
        }
        return count;
    }

    // Count syllables in a single word
    // Rules:
    //  - Count groups of vowels
    //  - 'y' counts as a vowel
    //  - Subtract silent 'e' at the end
    //  - Minimum 1 syllable per word
    private static int countSyllables(String word) {
        word = word.toLowerCase().trim();
        if (word.isEmpty()) return 0;

        int count = 0;
        boolean prevVowel = false;

        String vowels = "aeiouy";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isVowel = vowels.indexOf(c) >= 0;

            if (isVowel && !prevVowel) {
                count++;
            }

            prevVowel = isVowel;
        }

        // Remove silent 'e'
        if (word.endsWith("e") && count > 1 && !isVowel(word.charAt(word.length() - 2))) {
            count--;
        }

        return Math.max(count, 1);
    }

    // Count syllables in a full text
    private static int countTotalSyllables(String text) {
        if (text == null || text.isEmpty()) return 0;
        String[] words = text.split("[^a-zA-Z]+");
        int total = 0;

        for (String w : words) {
            if (!w.isEmpty()) total += countSyllables(w);
        }
        return total;
    }

    private static boolean isVowel(char c) {
        return "aeiouy".indexOf(Character.toLowerCase(c)) >= 0;
    }


    private ReadingLevel determineReadingLevel(double fleschScore) {
        if (fleschScore >= 90) return ReadingLevel.VERY_EASY;
        if (fleschScore >= 80) return ReadingLevel.EASY;
        if (fleschScore >= 70) return ReadingLevel.SOMEWHAT_EASY;
        if (fleschScore >= 60) return ReadingLevel.MEDIUM;
        if (fleschScore >= 50) return ReadingLevel.SOMEWHAT_HARD;
        if (fleschScore >= 30) return ReadingLevel.HARD;
        return ReadingLevel.VERY_HARD;
    }
}
