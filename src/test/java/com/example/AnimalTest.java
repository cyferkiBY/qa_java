package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {

    private Animal animal;

    @Before
    public void setUp() throws Exception {
        animal = new Animal();
    }

    @Test
    public void getFamilyReturnCorrectValueTest() {
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void checkThatAnimalGetFoodReturnsExceptionTest() throws Exception {
        Exception actualException = null;
        String wrongAnimalKind = "Всеядные";
        try {
            animal.getFood(wrongAnimalKind);
        } catch (Exception ex) {
            actualException = ex;
        }
        assertNotNull(String.format("GetFood() не вернул исключение для ошибочного вида животного '%s'", wrongAnimalKind), actualException);
    }
}