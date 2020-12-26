package ru.job4j.di_test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringDi {
    private static final Logger logger = LogManager.getLogger(SpringDi.class);
    private final Store store;
    private final ConsoleInput consoleInput;

    public SpringDi(Store store, ConsoleInput consoleInput) {
        this.store = store;
        this.consoleInput = consoleInput;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru/job4j/di_test");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.ask("Input name to add");
        ui.print();

    }
}
