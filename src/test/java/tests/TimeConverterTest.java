package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.TimeConverter;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeConverterTest {
    private final TimeConverter converter = new TimeConverter();

    @Test
    @DisplayName("Should convert 60 seconds to 1 minute")
    void shouldConvert60SecondsTo1Minute() {
        assertThat(converter.secondsToMinutes(60)).isEqualTo(1.0);
    }

    @ParameterizedTest
    @CsvSource({
            "120, 2.0"
    })
    @DisplayName("Should Convert Seconds to Minutes")
    void shouldConvertSecondsToMinutes(long seconds, double minutesExpected) {
        assertThat(converter.secondsToMinutes(seconds)).isEqualTo(minutesExpected);
    }

    @Test
    @DisplayName("Validation Negatives")
    void shouldThrowExceptionForNegativeSeconds() {
        Assertions.assertThatThrownBy(() -> converter.secondsToMinutes(-10)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("negative");
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 60",
            "2.0, 120"
    })
    @DisplayName("Should Convert Minutes to Seconds")
    void shouldConvertMinutesToSeconds(double minutes, long secondsExpected) {
        assertThat(converter.minutesToSeconds(minutes)).isEqualTo(secondsExpected);
    }
}
