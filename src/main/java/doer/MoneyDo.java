package doer;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MoneyDo {
    private static final BigDecimal USD_TO_EUR = new BigDecimal("92.00");

    public BigDecimal dollarsToEuros(BigDecimal dollarAmount) {
        return dollarAmount.multiply(USD_TO_EUR, new MathContext(2, RoundingMode.HALF_UP));
    }
}
