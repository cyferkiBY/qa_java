package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    private Feline felineMock;

    @Before
    public void setUp() {
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundReturnCorrectValueTest() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void getFoodReturnCorrectValueTest() throws Exception {
        List<String> expectedListFood =  List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedListFood);
        List<String> actualListFood = cat.getFood();
        assertThat(expectedListFood, containsInAnyOrder(actualListFood.toArray()));
    }
}