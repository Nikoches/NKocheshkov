package ru.job4j.tracker;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    private final Consumer<String> output;
    List<Integer> ranges = new ArrayList<>();

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Запускт программы.
     *
     * @param args as
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru/job4j/tracker");
        context.refresh();
        ru.job4j.ditest.StartUI ui = context.getBean(ru.job4j.ditest.StartUI.class);
        new StartUI(context.getBean(ValidateInput.class), context.getBean(Tracker.class), System.out::println).init();
        //new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }

    public void init() {
        MenuTracker menu = new MenuTracker(input, tracker, output);
        List<Integer> ranges = menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select", ranges));
        } while (!"y".equals(this.input.ask("exit? y/n")));
    }
}