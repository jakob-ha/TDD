package utils;


public class SentimentResult {
    private double sentimentScore;
    private SentimentCategory sentimentCategory;
    private int positiveWordCount;
    private int negativeWordCount;

    public SentimentResult(double sentimentScore, SentimentCategory sentimentCategory, int positiveWordCount, int negativeWordCount) {
        this.sentimentScore = sentimentScore;
        this.sentimentCategory = sentimentCategory;
        this.positiveWordCount = positiveWordCount;
        this.negativeWordCount = negativeWordCount;
    }

    public double getSentimentScore() {
        return sentimentScore;
    }

    public void setSentimentScore(double sentimentScore) {
        this.sentimentScore = sentimentScore;
    }

    public SentimentCategory getSentimentCategory() {
        return sentimentCategory;
    }

    public void setSentimentCategory(SentimentCategory sentimentCategory) {
        this.sentimentCategory = sentimentCategory;
    }

    public int getPositiveWordCount() {
        return positiveWordCount;
    }

    public void setPositiveWordCount(int positiveWordCount) {
        this.positiveWordCount = positiveWordCount;
    }

    public int getNegativeWordCount() {
        return negativeWordCount;
    }

    public void setNegativeWordCount(int negativeWordCount) {
        this.negativeWordCount = negativeWordCount;
    }
}
