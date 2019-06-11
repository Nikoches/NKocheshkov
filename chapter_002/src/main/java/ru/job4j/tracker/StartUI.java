package ru.job4j.tracker;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author NKocheshkov
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    private final Input input;
    private final ITracker tracker;
    List<Integer> ranges = new ArrayList<>();
    private final Consumer<String> output;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
       MenuTracker menu = new MenuTracker(input, tracker, output);
       List<Integer> ranges =  menu.fillActions();
       do {
           menu.show();
           menu.select(input.ask("Select", ranges));
       } while (!"y".equals(this.input.ask("exit? y/n")));
    }

    /**
     * Запускт программы.
     * @param args as
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}