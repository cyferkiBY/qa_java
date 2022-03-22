package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class LionAlexTest {

    private LionAlex lionAlex;

    @Mock
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        lionAlex = new LionAlex(felineMock);
    }

    @Test
    public void getKittensReturnCorrectValueTest() {
        int expectedKittensCount = 0;
        int actualKittensCount = lionAlex.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getPlaceOfLivingReturnCorrectValueTest() {
        String expectedPlaceOfLiving = "Нью-Йоркский зоопарк";
        String actualPlaceOfLiving = lionAlex.getPlaceOfLiving();
        assertEquals(expectedPlaceOfLiving, actualPlaceOfLiving);
    }

    @Test
    public void getFriendsReturnCorrectValueTest() {
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        List<String> actualFriends = lionAlex.getFriends();
        assertThat(expectedFriends, containsInAnyOrder(actualFriends.toArray()));
    }
}