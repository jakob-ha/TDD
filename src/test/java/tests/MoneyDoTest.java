package tests;

import doer.MoneyDo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;


public class MoneyDoTest {

    MoneyDo moneyDo;

    @BeforeEach
    public void setup() {
        moneyDo = new MoneyDo();
    }

    @ParameterizedTest
    @CsvSource({"100, 92"})
    @DisplayName("Dollar to Euro Converter")
    void dollarToEuroConversionTest(BigDecimal dollarAmount, BigDecimal euroAmountExpected) {
        BigDecimal euroValueCalculated = moneyDo.dollarsToEuros(dollarAmount);
        assertThat(euroValueCalculated).isEqualByComparingTo(euroAmountExpected);
    }
}
