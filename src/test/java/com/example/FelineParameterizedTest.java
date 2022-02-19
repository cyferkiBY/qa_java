package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineParameterizedTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {-1, -1},
                {0, 0},
                {1, 1},
                {2147483647, 2147483647},
        };
    }

    @Test
    public void getKittensWithKittensCountAnyIntReturnCorrectValueTest() {
        Feline feline = new Feline();
        int actualKittensCount = feline.getKittens(kittensCount);
        assertEquals(expectedKittensCount, actualKittensCount);
    }

}