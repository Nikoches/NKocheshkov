package ru.job4j.Tracker;
import org.junit.Test;
import ru.job4j.Tracker.Item;
import ru.job4j.Tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class TestTracker {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll(), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void removingElemenbtsAfterAddingThree() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription", 123L);
        tracker.add(firstItem);
        Item SecondItem = new Item("test2", "testDescription", 123L);
        tracker.add(SecondItem);
        Item ThirdItem = new Item("test3", "testDescription", 123L);
        tracker.add(ThirdItem);
        tracker.deleteItem(SecondItem.getId());
       // assertThat(tracker.findAll().getName(), is("test3"));
    }
}