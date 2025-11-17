package utils;

public class ReadabilityResult {
    private double fleschScore;
    private ReadingLevel readingLevel;
    private int sentenceCount;
    private int wordCount;
    private int syllableCount;
    private double averageWordsPerSentence;
    private double averageSyllablesPerWord;

    public ReadabilityResult(double fleschScore, ReadingLevel readingLevel, int sentenceCount, int wordCount, int syllableCount, double averageWordsPerSentence, double averageSyllablesPerWord) {
        this.fleschScore = fleschScore;
        this.readingLevel = readingLevel;
        this.sentenceCount = sentenceCount;
        this.wordCount = wordCount;
        this.syllableCount = syllableCount;
        this.averageWordsPerSentence = averageWordsPerSentence;
        this.averageSyllablesPerWord = averageSyllablesPerWord;
    }

    public double getFleschScore() {
        return fleschScore;
    }

    public void setFleschScore(double fleschScore) {
        this.fleschScore = fleschScore;
    }

    public ReadingLevel getReadingLevel() {
        return readingLevel;
    }

    public void setReadingLevel(ReadingLevel readingLevel) {
        this.readingLevel = readingLevel;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(int sentenceCount) {
        this.sentenceCount = sentenceCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getSyllableCount() {
        return syllableCount;
    }

    public void setSyllableCount(int syllableCount) {
        this.syllableCount = syllableCount;
    }

    public double getAverageWordsPerSentence() {
        return averageWordsPerSentence;
    }

    public void setAverageWordsPerSentence(double averageWordsPerSentence) {
        this.averageWordsPerSentence = averageWordsPerSentence;
    }

    public double getAverageSyllablesPerWord() {
        return averageSyllablesPerWord;
    }

    public void setAverageSyllablesPerWord(double averageSyllablesPerWord) {
        this.averageSyllablesPerWord = averageSyllablesPerWord;
    }
}
