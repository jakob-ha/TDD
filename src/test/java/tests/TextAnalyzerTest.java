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
}
