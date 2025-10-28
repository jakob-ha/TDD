package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TimeConverter;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeConverterTest {
    private final TimeConverter converter = new TimeConverter();

    @Test
    @DisplayName("Should convert 60 seconds to 1 minute")
    void shouldConvert60SecondsTo1Minute() {
        assertThat(converter.secondsToMinutes(60)).isEqualTo(1.0);
    }
}
