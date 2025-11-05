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
    @DisplayName("Validation Negatives")
    void shouldThrowExceptionForNegativeSeconds() {
        Assertions.assertThatThrownBy(() -> converter.secondsToMinutes(-10)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("negative");
        Assertions.assertThatThrownBy(() -> converter.minutesToSeconds(-10)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("negative");
    }

    @Test
    @DisplayName("Should convert 60 seconds to 1 minute")
    void shouldConvert60SecondsTo1Minute() {
        assertThat(converter.secondsToMinutes(60)).isEqualTo(1.0);
    }

    @ParameterizedTest
    @CsvSource({
            "120, 2.0",
            "90, 1.5"
    })
    @DisplayName("Should Convert Seconds to Minutes")
    void shouldConvertSecondsToMinutes(long seconds, double minutesExpected) {
        assertThat(converter.secondsToMinutes(seconds)).isEqualTo(minutesExpected);
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 60",
            "2.0, 120",
            "2.5, 150"
    })
    @DisplayName("Should Convert Minutes to Seconds")
    void shouldConvertMinutesToSeconds(double minutes, long secondsExpected) {
        assertThat(converter.minutesToSeconds(minutes)).isEqualTo(secondsExpected);
    }

    @Test
    @DisplayName("Round Trip")
    void shouldRoundTrip() {
        assertThat(200).isEqualTo(converter.minutesToSeconds(converter.secondsToMinutes(200)));
        assertThat(2.0).isEqualTo(converter.secondsToMinutes(converter.minutesToSeconds(2.0)));
    }

    @ParameterizedTest
    @CsvSource({
            "60, 1",
            "120, 2"
    })
    @DisplayName("Should Convert Minutes to Hours")
    void shouldConvertMinutesToHours(long minutes, double hoursExpected) {
        assertThat(converter.minutesToHours(minutes)).isEqualTo(hoursExpected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 60",
            "2, 120"
    })
    @DisplayName("Should Convert Hours to Minutes")
    void shouldConvertHoursToMinutes(double hours, long minutesExpected) {
        assertThat(converter.hoursToMinutes(hours)).isEqualTo(minutesExpected);
    }

    @ParameterizedTest
    @CsvSource({
            "24, 1"
    })
    @DisplayName("Should Convert Hours to Days")
    void shouldConvertHoursToDays(long hours, double daysExpected) {
        assertThat(converter.hoursToDays(hours)).isEqualTo(daysExpected);
    }
}
