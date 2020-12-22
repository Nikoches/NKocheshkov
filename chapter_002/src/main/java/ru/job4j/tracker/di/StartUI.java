package ru.job4j.tracker.di;

public class StartUI {
    private final Store store;

    public StartUI(Store store) {
        this.store = store;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(StartUI.class);
        StartUI ui = context.get(StartUI.class);
        ui.add("Vova Vovkin");
        ui.add("Kapitan");
        ui.print();
    }
}
