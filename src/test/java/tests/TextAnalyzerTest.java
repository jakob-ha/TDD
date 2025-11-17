package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("Sentiment Analysis Tests")
    class SentimentAnalysisTests {

        @Test
        @DisplayName("Should analyze positive sentiment correctly")
        public void shouldAnalyzePositiveSentimentCorrectly() {
            String positiveSentence = "Happy and wonderful, sunshine and bliss in every corner of this joyous party.";
            assertThat(textAnalyzer.analyzeSentiment(positiveSentence)).usingRecursiveComparison().isEqualTo(new SentimentResult(1, SentimentCategory.POSITIVE, 5, 0));
        }

        @Test
        @DisplayName("Should analyze negative sentiment correctly")
        public void shouldAnalyzeNegativeSentimentCorrectly() {
            String negativeSentence = "Agony! Agony! Agony! I've never been more distraught.";
            assertThat(textAnalyzer.analyzeSentiment(negativeSentence)).usingRecursiveComparison().isEqualTo(new SentimentResult(-1, SentimentCategory.NEGATIVE, 0, 4));
        }

        @Test
        @DisplayName("Should analyze neutral sentiment correctly")
        public void shouldAnalyzeNeutralSentimentCorrectly() {
            String neutralSentence = "Agony or bliss, it won't last forever.";
            assertThat(textAnalyzer.analyzeSentiment(neutralSentence)).usingRecursiveComparison().isEqualTo(new SentimentResult(0, SentimentCategory.NEUTRAL, 1, 1));
        }

        @Test
        @DisplayName("Should handle empty text in sentiment analysis")
        public void shouldHandleEmptyTextInSentimentAnalysis() {
            String emptySentence = "";
            assertThat(textAnalyzer.analyzeSentiment(emptySentence)).usingRecursiveComparison().isEqualTo(new SentimentResult(0, SentimentCategory.NEUTRAL, 0, 0));
        }
    }

    @Nested
    @DisplayName("Readability Analysis Tests")
    class ReadabilityAnalysisTests {

        @Test
        @DisplayName("Should calculate Flesch Reading Ease correctly")
        public void shouldCalculateFleschReadingEaseCorrectly() {
            String text = "";
            assertThat(textAnalyzer.assessReadability(text)).usingRecursiveComparison().isEqualTo(new ReadabilityResult(0, ReadingLevel.VERY_EASY, 0, 0, 0, 0, 0));
        }

        @Test
        @DisplayName("Should classify reading levels correctly")
        public void shouldClassifyReadingLevelsCorrectly() {
            String text = "This is an easy text. Not many words.";
            assertThat(textAnalyzer.assessReadability(text)).usingRecursiveComparison().isEqualTo(new ReadabilityResult(97.025, ReadingLevel.VERY_EASY, 2, 8, 10, 4, 1.25));

        }

        @Test
        @DisplayName("Should handle complex sentences correctly")
        public void shouldHandleComplexSentencesCorrectly() {
            String text = "Confounding complexities mystifying esoteric connoisseurs abound. Demanding understanding. ";
            assertThat(textAnalyzer.assessReadability(text)).usingRecursiveComparison().isEqualTo(new ReadabilityResult(-72.175, ReadingLevel.VERY_HARD, 2, 8, 26, 4, 3.25));

        }
    }
}
