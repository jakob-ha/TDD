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

    @Test
    @DisplayName("Add positive")
    public void addTest() {
        int result = does.add(2,3);
        Assertions.assertEquals(5, result);
    }

    @Test
    @DisplayName("Add zero")
    public void addZeroTest() {
        int result = does.add(5,0);
        Assertions.assertEquals(5, result);
    }

    @Test
    @DisplayName("Add negative")
    public void addNegativeTest() {
        int result = does.add(-2,-3);
        Assertions.assertEquals(-5, result);
    }

    @ParameterizedTest
    @MethodSource("sumTestData")
    @DisplayName("Addstests")
    public void addTest(int a, int b, int expected) {
        int result = does.add(a,b);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> sumTestData() {
        return Stream.of(
                Arguments.of(2,5,7),
                Arguments.of(0,4,4),
                Arguments.of(-4,-3,-7)
        );
    }


    @Test
    public void subTest() {
        int result = does.sub(5,3);
        Assertions.assertEquals(2, result);
    }

/*
    @Test
    public void mulTest() {
        int result = does.mul(3,2);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void divTest() {
        int result = does.div(6,3);
        Assertions.assertEquals(2, result);
    }
    */


}
