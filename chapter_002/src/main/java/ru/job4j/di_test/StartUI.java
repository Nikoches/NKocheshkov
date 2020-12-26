package ru.job4j.di_test;

import org.springframework.stereotype.Component;

@Component
public class StartUI {
    private final Store store;
    private final ConsoleInput consoleInput;
    public StartUI(Store store,ConsoleInput consoleInput) {
        this.store = store;
        this.consoleInput = consoleInput;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
    public void ask(String question) {
        add(consoleInput.ask(question));
    }
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(StartUI.class);
        StartUI ui = context.get(StartUI.class);
        ui.ask("Add user. Input name?");
        ui.print();
    }
}
