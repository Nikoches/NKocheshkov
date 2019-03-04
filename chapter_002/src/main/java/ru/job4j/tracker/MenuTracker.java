package ru.job4j.tracker;
import java.util.*;
import java.util.function.Consumer;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    List<UserAction> actions = new ArrayList<>();
    List<Integer> ranges = new ArrayList<>();
    private final Consumer<String> output;
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                this.output.accept(action.info());
            }
        }
    }

    public List<Integer> fillActions() {
        this.actions.add(this.new AddItem(0, "AddItem"));
        this.actions.add(new MenuTracker.ShowAll(1, "ShowAll"));
        this.actions.add(new EditItem(2, "EditItem"));
        this.actions.add(new MenuTracker.DeleteItem(3, "DeleteItem"));
        this.actions.add(new FoundById(4, "FoundById"));
        this.actions.add(new MenuTracker.FoundByName(5, "FoundByName"));
        for (UserAction act:actions) {
            ranges.add(act.key());
        }
        return ranges;
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name:");
            String desc = input.ask("Enter description:");
            tracker.add(new Item(name, desc, 1002001));
        }
    }

    private  class ShowAll extends BaseAction {
        public ShowAll(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Заявки: --------------");
            for (Item index : tracker.findAll()) {
                output.accept(String.format("id=%s имя=%s описание=%s", index.getId(), index.getName(), index.getDescription()));
            }
        }
    }

    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Редактирование заявки --------------");
            String id = input.ask("Введите id заявки :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc, 123L);
            tracker.replace(id, item);
            item.setId(id);
        }
    }

    private  class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            tracker.deleteItem(id);
            output.accept(String.format("------------ Заявка с id=%s удалена --------------", id));
        }
    }

    private class FoundById extends BaseAction {
        public FoundById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки :");

            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(String.format("id=%s имя=%s описание=%s", item.getId(), item.getName(), item.getDescription()));
            } else {
                output.accept("Ничего не нашлось!");
            }
        }
    }

    private  class FoundByName extends BaseAction {
        public FoundByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            for (Item index : tracker.findByName(name)) {
                if (index != null) {
                    output.accept(String.format("id=%s имя=%s описание=%s", index.getId(), index.getName(), index.getDescription()));
                }
            }
        }
    }
}

