package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    @Mock
    Feline feline;

    @Test
    public void kittensIsAlwaysZero() throws Exception{
        MatcherAssert.assertThat("У льва Алекса нет котят",
                new AlexLion(feline).getKittens(),
                equalTo(0)
        );
    }

    @Test
    public void placeOfLivingIsCorrect() throws Exception {
        MatcherAssert.assertThat("Лев Алекс живет в другом месте",
                new AlexLion(feline).getPlaceOfLiving(),
                equalTo("Нью-Йоркский зоопарк")
        );
    }

    @Test
    public void friendsListIsCorrect() throws Exception {
        List<String> expectedList = List.of(
                "зебра Марти",
                "бегемотиха Глория",
                "жираф Мелман"
        );
        MatcherAssert.assertThat("Неверный список друзей",
                new AlexLion(feline).getFriends(),
                equalTo(expectedList)
        );
    }
}