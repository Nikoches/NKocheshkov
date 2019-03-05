package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class StartUITest {
    String n1 = System.getProperty("line.separator");
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };


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
        Tracker tracker = new Tracker();     // создаём tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker,System.out::println).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    //UPDATE
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        tracker.add(new Item("test name", "desc", 123L));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker,System.out::println).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }
    //DELETE
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Item item1 = tracker.add(new Item("test name1", "desc1", 123L));
        Input input = new StubInput(new String[]{"3", item1.getId(), "y"});
        new StartUI(input, tracker,System.out::println).init();
        assertThat(tracker.findById(item1.getId()), is(nullValue()));
    }
    //EDIT
    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Item item1 = tracker.add(new Item("test name1", "desc1", 123L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test", "passed", "y"});
        new StartUI(input, tracker,System.out::println).init();
        assertThat((tracker.findById(item.getId()).getName() + " " + tracker.findById(item.getId()).getDescription()), is("test passed"));
    }
    //SHOW ALL
    @Test
    public void whenPrintAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Item item1 = tracker.add(new Item("test name1", "desc1", 123L));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker,System.out::println).init();
        assertThat(new String(this.out.toByteArray()), is(String.format("0 : AddItem" + n1 + "1 : ShowAll" + n1 + "2 : EditItem" + n1 + "3 : DeleteItem" + n1 + "4 : FoundById" + n1 + "5 : FoundByName" + n1 +  "------------ Заявки: --------------" + n1 + "id=%s имя=%s описание=%s" + n1 + "id=%s имя=%s описание=%s" + n1, item.getId(), item.getName(), item.getDescription(), item1.getId(), item1.getName(), item1.getDescription())));

    }
    //FIND BY ID
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Item item1 = tracker.add(new Item("test name1", "desc1", 123L));
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker,System.out::println).init();
        assertThat(new String(this.out.toByteArray()), is(String.format("0 : AddItem" + n1 + "1 : ShowAll" + n1 + "2 : EditItem" + n1 + "3 : DeleteItem" + n1 + "4 : FoundById" + n1 + "5 : FoundByName" + n1 + "------------ Поиск заявки по id --------------" + n1 + "id=%s имя=%s описание=%s" + n1, item.getId(), item.getName(), item.getDescription())));

    }
    //FIND BY ID
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test", "desc", 123L));
        Item item1 = tracker.add(new Item("test name1", "desc1", 123L));
        Input input = new StubInput(new String[]{"5", "test", "y"});
        new StartUI(input, tracker,System.out::println).init();
        assertThat(new String(this.out.toByteArray()), is(String.format("0 : AddItem" + n1 + "1 : ShowAll" + n1 + "2 : EditItem" + n1 + "3 : DeleteItem" + n1 + "4 : FoundById" + n1 + "5 : FoundByName" + n1 + "------------ Поиск заявки по имени --------------" + n1 + "id=%s имя=%s описание=%s" + n1, item.getId(), item.getName(), item.getDescription())));
    }
}
