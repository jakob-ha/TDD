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
            if (POSITIVE_WORDS.contains(word)) {positiveWords++;}
            if (NEGATIVE_WORDS.contains(word)) {negativeWords++;}
        }
        double sentimentScore = 0;
        if (positiveWords + negativeWords != 0) {
            sentimentScore = ((double) positiveWords - (double) negativeWords) / ((double) positiveWords + (double) negativeWords);
        } else {sentimentScore = 0;}
        SentimentCategory sentimentCategory;
        if (sentimentScore == 0){sentimentCategory = SentimentCategory.NEUTRAL;}
        else if (sentimentScore > 0) {sentimentCategory = SentimentCategory.POSITIVE;}
        else {sentimentCategory = SentimentCategory.NEGATIVE;}
        return new SentimentResult(sentimentScore, sentimentCategory, positiveWords, negativeWords);
    }
}
