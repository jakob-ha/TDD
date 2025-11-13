package tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import utils.Calculator;
import utils.SentimentCategory;
import utils.SentimentResult;
import utils.StringProcessor;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Complex TextAnalyzer TDD Demo")
public class TextAnalyzerTest {
    Calculator calculator;
    StringProcessor stringProcessor;

    @BeforeEach
    void setUp() {
        stringProcessor = new StringProcessor();
        calculator = new Calculator("Cal");
    }

    @DisplayName("Should analyze positive sentiment correctly")
    public SentimentResult shouldAnalyzePositiveSentimentCorrectly(){
        String positiveSentence = "Happy and wonderful, sunshine and bliss in every corner of this joyous party.";
        Assert.assertEquals(new SentimentResult(1, SentimentCategory.POSITIVE, 5,0),textAnalyzer.analyzeSentiment(positiveSentence));
        }
}
