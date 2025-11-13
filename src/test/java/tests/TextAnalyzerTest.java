package tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Complex TextAnalyzer TDD Demo")
public class TextAnalyzerTest {
    Calculator calculator;
    StringProcessor stringProcessor;
    TextAnalyzer textAnalyzer;

    @BeforeEach
    void setUp() {
        stringProcessor = new StringProcessor();
        calculator = new Calculator("Cal");
        textAnalyzer = new TextAnalyzer(calculator, stringProcessor);
    }

    @Test
    @DisplayName("Should analyze positive sentiment correctly")
    public void shouldAnalyzePositiveSentimentCorrectly(){
        String positiveSentence = "Happy and wonderful, sunshine and bliss in every corner of this joyous party.";
        assertThat(textAnalyzer.analyzeSentiment(positiveSentence)).usingRecursiveComparison().isEqualTo(new SentimentResult(1, SentimentCategory.POSITIVE, 5,0));
        }

    @Test
    @DisplayName("Should analyze negative sentiment correctly")
    public void shouldAnalyzeNegativeSentimentCorrectly(){
        String negativeSentence = "Agony! Agony! Agony! I've never been more distraught.";
        assertThat(textAnalyzer.analyzeSentiment(negativeSentence)).usingRecursiveComparison().isEqualTo(new SentimentResult(-1, SentimentCategory.NEGATIVE, 0,4));
    }

    @Test
    @DisplayName("Should analyze neutral sentiment correctly")
    public void shouldAnalyzeNeutralSentimentCorrectly(){
        String neutralSentence = "Agony or bliss, it won't last forever.";
        assertThat(textAnalyzer.analyzeSentiment(neutralSentence)).usingRecursiveComparison().isEqualTo(new SentimentResult(0, SentimentCategory.NEUTRAL, 1,1));
    }
}
