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
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;

    @Mock
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        String sex = "Самка";
        lion = new Lion(sex, felineMock);
    }

    @Test
    public void getKittensReturnCorrectValueTest() {
        int expectedKittensCount = 1;
        Mockito.when(felineMock.getKittens()).thenReturn(expectedKittensCount);
        int actualKittensCount = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getFoodReturnCorrectValueTest() throws Exception {
        List<String> expectedListFood =  List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood(anyString())).thenReturn(expectedListFood);
        List<String> actualListFood = lion.getFood();
        assertThat(expectedListFood, containsInAnyOrder(actualListFood.toArray()));
    }

    @Test
    public void checkThatLionReturnsExceptionTest() throws Exception {
        Exception actualException = null;
        String wrongSex = "львица";
        try {
            Lion lion = new Lion(wrongSex, felineMock);
        } catch (Exception ex) {
            actualException = ex;
        }
        assertNotNull(String.format("Конструктор Lion() не вернул исключение для ошибочного пола '%s'", wrongSex), actualException);
    }
}