package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.MoneyCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class MoneyCalculatorTest {

    MoneyCalculator moneyCalculator;

    @BeforeEach
    public void setup() {
        moneyCalculator = new MoneyCalculator();
    }

    @ParameterizedTest
    @CsvSource({
            "100.00, 92.00",
            "200.00, 184.00",
            "0.00,0.00"})
    @DisplayName("Dollar to Euro Converter")
    void dollarToEuroConversionTest(BigDecimal dollarAmount, BigDecimal euroAmountExpected) {
        BigDecimal euroValueCalculated = moneyCalculator.dollarsToEuros(dollarAmount);
        assertThat(euroValueCalculated).isEqualByComparingTo(euroAmountExpected);
    }

    @Test
    @DisplayName("Don't Allow Negative USD")
    void shouldThrowExceptionForNegativeUSDTest() {
        assertThatThrownBy(() -> moneyCalculator.dollarsToEuros(new BigDecimal("-10.00"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("negative");
    }

    @Test
    @DisplayName("Expect 2 Decimals")
    void shouldHaveTwoDecimalPlacesTest() {
        BigDecimal value1 = new BigDecimal("100");
        BigDecimal value2 = new BigDecimal("200.000");
        BigDecimal result1 = moneyCalculator.dollarsToEuros(value1);
        BigDecimal result2 = moneyCalculator.dollarsToEuros(value2);
        Assertions.assertNotEquals(2, value1.scale());
        Assertions.assertNotEquals(2, value2.scale());
        Assertions.assertEquals(2, result1.scale());
        Assertions.assertEquals(2, result2.scale());
    }

    @ParameterizedTest
    @CsvSource({"92.00, 100.00",
    "184.00, 200.00"})
    @DisplayName("Euro to Dollar Converter")
    void euroToDollarConversionTest(BigDecimal euroAmount, BigDecimal dollarAmountExpected){
        BigDecimal dollarValueCalculated = moneyCalculator.eurosToDollars(euroAmount);
        assertThat(dollarValueCalculated).isEqualByComparingTo(dollarAmountExpected);
    }
}
