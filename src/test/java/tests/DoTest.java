package tests;

import doer.Do;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
