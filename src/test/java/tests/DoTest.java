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

}
