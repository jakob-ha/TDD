package utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * This class converts money
 */
public class MoneyCalculator {
    private static final BigDecimal USD_TO_EUR = new BigDecimal("0.92");
    private static final BigDecimal EUR_TO_USD = new BigDecimal("1.00").divide(USD_TO_EUR, MathContext.DECIMAL128);

    public BigDecimal dollarsToEuros(BigDecimal dollarAmount) {
        if (dollarAmount.signum() == -1) {throw new IllegalArgumentException("dollarAmount must not be negative");}
        return dollarAmount.multiply(USD_TO_EUR).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal eurosToDollars(BigDecimal euroAmount) {
        if (euroAmount.signum() == -1) {throw new IllegalArgumentException("euroAmount must not be negative");}
        return euroAmount.multiply(EUR_TO_USD).setScale(2, RoundingMode.HALF_UP);
    }
}
