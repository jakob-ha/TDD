package utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MoneyCalculator {
    private static final BigDecimal USD_TO_EUR = new BigDecimal("0.92");

    public BigDecimal dollarsToEuros(BigDecimal dollarAmount) {
        if (dollarAmount.signum() == -1) {throw new IllegalArgumentException("dollarAmount must not be negative");}
        return dollarAmount.multiply(USD_TO_EUR, new MathContext(3, RoundingMode.HALF_UP));
    }
}
