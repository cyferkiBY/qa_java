package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sexLion;
    private final boolean expectedDoesHaveMane;

    public LionParameterizedTest(String sexLion, boolean expectedDoesHaveMane) {
        this.sexLion = sexLion;
        this.expectedDoesHaveMane = expectedDoesHaveMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeReturnCorrectValueTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sexLion, feline);
        boolean actualDoesHaveMane = lion.doesHaveMane();
        assertEquals(expectedDoesHaveMane, actualDoesHaveMane);
    }
}