package tests;

import doer.Do;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Calculator Test")
public class DoTest {
    Do does;

    @BeforeEach
    public void setUp() {
        does = new Do("Constructor Name");
        does.injectName("Injected Name");
    }

    @ParameterizedTest
    @MethodSource("sumTestData")
    @DisplayName("AddTests")
    public void addTest(int a, int b, int expected) {
        Assertions.assertEquals(expected, does.add(a,b));
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
        Assertions.assertEquals(expected, does.sub(a,b));
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
        Assertions.assertEquals(expected, does.mul(a,b));
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
    public void divTest(int a, int b, int expected) {
        Assertions.assertEquals(expected, does.div(a,b));
    }

    static Stream<Arguments> divTestData() {
        return Stream.of(
                Arguments.of(5,2,10)
        );
    }

}
