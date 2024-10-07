package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class AnimalParamTest {

        private final String animalKind;
        private final List<String> expectedListOfFood;

        public AnimalParamTest(String animalKind, List<String> expectedListOfFood) {
            this.animalKind = animalKind;
            this.expectedListOfFood = expectedListOfFood;
        }

        @Parameterized.Parameters(name = "Класс Animal. Тип животного: {0}")
        public static Object[][] paramsForTest() {
            return new Object[][] {
                    {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                    {"Травоядное", List.of("Трава", "Различные растения")}
            };
        }

        @Test
        public void foodIsCorrect() throws Exception {
            MatcherAssert.assertThat("Неверный список еды",
                    new Animal().getFood(animalKind),
                    equalTo(this.expectedListOfFood)
            );
        }

    }
