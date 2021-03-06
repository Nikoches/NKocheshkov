package ru.job4j.dummybot;

import org.junit.Test;
import ru.job4j.condition.Dummybot;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class Dummybottest {
    @Test
    public void whenGreetBot() {
        Dummybot bot = new Dummybot();
        assertThat(
                bot.answer("Привет, Бот"),
                is("Привет, умник")
        );
    }
    @Test
    public void whenByuBot() {
        Dummybot bot = new Dummybot();
        assertThat(
                bot.answer("Пока"),
                is("До скорой встречи.")
        );
    }
    @Test
    public void whenUnknownBot() {
        Dummybot bot = new Dummybot();
        assertThat(
                bot.answer("Сколько будет 2 + 2?"),
                is("Это ставит меня в тупик. Спросите другой вопрос.")
        );
    }
}

