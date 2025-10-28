package tests;

import utils.Calculator;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Calculator Test")
public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator("Constructor Name");
        calculator.injectName("Injected Name");
    }

    @ParameterizedTest
    @MethodSource("sumTestData")
    @DisplayName("AddTests")
    public void addTest(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.add(a,b));
    }

    static Stream<Arguments> sumTestData() {
        return Stream.of(
                Arguments.of(2,5,7),
                Arguments.of(0,4,4),
                Arguments.of(-4,-3,-7)
        );
    }

    @ParameterizedTest
    @MethodSource("subTestData")
    @DisplayName("SubTests")
    public void subTest(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.sub(a,b));
    }

    static Stream<Arguments> subTestData() {
        return Stream.of(
                Arguments.of(5,2,3),
                Arguments.of(0,4,-4),
                Arguments.of(-4,-3,-1)
        );
    }

    @ParameterizedTest
    @MethodSource("mulTestData")
    @DisplayName("MulTests")
    public void mulTest(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.mul(a,b));
    }

    static Stream<Arguments> mulTestData() {
        return Stream.of(
                Arguments.of(5,2,10),
                Arguments.of(2,2,4),
                Arguments.of(0,-2,0)
        );
    }

    @ParameterizedTest
    @MethodSource("divTestData")
    @DisplayName("DivTests")
    public <T> void divTest(int a, int b, T expected) {
        if (expected instanceof ArithmeticException) {
            Assert.assertThrows(ArithmeticException.class, () -> calculator.div(a,b));
        }
        else{Assertions.assertEquals(expected, calculator.div(a,b));}

    }

    static Stream<Arguments> divTestData() {
        return Stream.of(
                Arguments.of(10,2,5),
                Arguments.of(3,0,new ArithmeticException("Division by zero"))
        );
    }

}
