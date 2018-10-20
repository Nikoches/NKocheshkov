package ru.job4j.Tracker;
import java.util.*;
import java.util.ArrayList;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
   // private UserAction[] actions = new UserAction[6];
    ArrayList<UserAction> actions = new ArrayList<UserAction>();
    private int position;
    ArrayList<Integer> ranges = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public ArrayList<Integer> fillActions() {
        this.actions.add(this.new AddItem(0, "AddItem"));
        this.actions.add(new MenuTracker.ShowAll(1, "ShowAll"));
        this.actions.add(new EditItem(2, "EditItem"));
        this.actions.add(new MenuTracker.DeleteItem(3, "DeleteItem"));
        this.actions.add(new FoundById(4, "FoundById"));
        this.actions.add(new MenuTracker.FoundByName(5, "FoundByName"));
        Collections.addAll(ranges,0,1,2,3,4,5);
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

    private static class ShowAll extends BaseAction {

        public ShowAll(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Заявки: --------------");
            for (Item index : tracker.findAll()) {
                System.out.println(String.format("id=%s имя=%s описание=%s", index.getId(), index.getName(), index.getDescription()));
            }
        }
    }

    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите id заявки :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc, 123L);
            tracker.replace(id, item);
            item.setId(id);
        }
    }

    private static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            tracker.deleteItem(id);
            System.out.println(String.format("------------ Заявка с id=%s удалена --------------", id));
        }
    }

    private class FoundById extends BaseAction {
        public FoundById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки :");

            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(String.format("id=%s имя=%s описание=%s", item.getId(), item.getName(), item.getDescription()));
            } else {
                System.out.println("Ничего не нашлось!");
            }
        }
    }

    private static class FoundByName extends BaseAction {
        public FoundByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            for (Item index : tracker.findByName(name)) {
                if (index != null) {
                    System.out.println(String.format("id=%s имя=%s описание=%s", index.getId(), index.getName(), index.getDescription()));
                }
            }
        }
    }
}

