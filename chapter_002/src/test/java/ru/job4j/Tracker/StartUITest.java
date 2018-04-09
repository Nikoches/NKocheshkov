package ru.job4j.Tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.Tracker.Item;
import ru.job4j.Tracker.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    //ADD
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    //UPDATE
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name","desc",123L));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    //DELETE
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name","desc",123L));
        Item item1 = tracker.add(new Item("test name1","desc1",123L));
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item1.getId()), is(nullValue()));
    }
    //EDIT
    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name","desc",123L));
        Item item1 = tracker.add(new Item("test name1","desc1",123L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test","passed","6"});
        new StartUI(input, tracker).init();
        assertThat((tracker.findById(item.getId()).getName()+" "+tracker.findById(item.getId()).getDescription()), is("test passed"));
    }
    //SHOW ALL
    @Test
    public void whenPrintAll(){
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name","desc",123L));
        Item item1 = tracker.add(new Item("test name1","desc1",123L));
        Input input = new StubInput(new String[]{"1","6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(String.format("Меню. \n 0. Add new Item \n 1. Show all items \n 2. Edit item  \n 3. Delete item \n 4. Find item by Id \n 5. Find items by name \n 6. Exit Program \n Select:\r\n------------ Заявки: --------------\r\nid=%s имя=%s описание=%s\r\nid=%s имя=%s описание=%s\r\nМеню. \n 0. Add new Item \n 1. Show all items \n 2. Edit item  \n 3. Delete item \n 4. Find item by Id \n 5. Find items by name \n 6. Exit Program \n Select:\r\n",item.getId(),item.getName(),item.getDescription(),item1.getId(),item1.getName(),item1.getDescription())));

    }
    //FIND BY ID
    @Test
    public void whenFindById(){
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name","desc",123L));
        Item item1 = tracker.add(new Item("test name1","desc1",123L));
        Input input = new StubInput(new String[]{"4",item.getId(),"6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(String.format("Меню. \n 0. Add new Item \n 1. Show all items \n 2. Edit item  \n 3. Delete item \n 4. Find item by Id \n 5. Find items by name \n 6. Exit Program \n Select:\r\n------------ Поиск заявки по id --------------\r\nid=%s имя=%s описание=%s\r\nМеню. \n 0. Add new Item \n 1. Show all items \n 2. Edit item  \n 3. Delete item \n 4. Find item by Id \n 5. Find items by name \n 6. Exit Program \n Select:\r\n",item.getId(),item.getName(),item.getDescription())));

    }
    //FIND BY ID
    @Test
    public void whenFindByName(){
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test","desc",123L));
        Item item1 = tracker.add(new Item("test name1","desc1",123L));
        Input input = new StubInput(new String[]{"5","test","6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(String.format("Меню. \n 0. Add new Item \n 1. Show all items \n 2. Edit item  \n 3. Delete item \n 4. Find item by Id \n 5. Find items by name \n 6. Exit Program \n Select:\r\n------------ Поиск заявки по имени --------------\r\nid=%s имя=%s описание=%s\r\nМеню. \n 0. Add new Item \n 1. Show all items \n 2. Edit item  \n 3. Delete item \n 4. Find item by Id \n 5. Find items by name \n 6. Exit Program \n Select:\r\n",item.getId(),item.getName(),item.getDescription())));

    }
}