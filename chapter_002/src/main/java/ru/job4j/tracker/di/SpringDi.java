package ru.job4j.tracker.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class);
        context.register(StartUI.class);
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Oleg Sokolov");
        ui.add("Ponasenkov");
        ui.print();
    }
}
