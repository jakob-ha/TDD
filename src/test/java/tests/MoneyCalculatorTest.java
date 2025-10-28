package tests;

import utils.MoneyCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class MoneyCalculatorTest {

    MoneyCalculator moneyCalculator;

    @BeforeEach
    public void setup() {
        moneyCalculator = new MoneyCalculator();
    }

    @ParameterizedTest
    @CsvSource({
            "100.00, 92.00",
            "200.00, 184.00"})
    @DisplayName("Dollar to Euro Converter")
    void dollarToEuroConversionTest(BigDecimal dollarAmount, BigDecimal euroAmountExpected) {
        BigDecimal euroValueCalculated = moneyCalculator.dollarsToEuros(dollarAmount);
        assertThat(euroValueCalculated).isEqualByComparingTo(euroAmountExpected);
    }
}
