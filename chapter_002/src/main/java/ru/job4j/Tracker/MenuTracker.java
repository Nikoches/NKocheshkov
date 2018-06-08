package ru.job4j.Tracker;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];
    private int position;

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

    public void fillActions() {
        this.actions[position++] = this.new AddItem(0, "AddItem");
        this.actions[position++] = new MenuTracker.ShowAll(1, "ShowAll");
        this.actions[position++] = new EditItem(2, "EditItem");
        this.actions[position++] = new MenuTracker.DeleteItem(3, "DeleteItem");
        this.actions[position++] = new FoundById(4, "FoundById");
        this.actions[position++] = new MenuTracker.FoundByName(5, "FoundByName");
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
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
        //public String info();
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

    /*
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item (name, desc, 123L));
        }

        public String info() {
            return String.format("%s.%s", this.key(), "add the new item");
        }
    }

    private static class ShowAll implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Заявки: --------------");
            for (Item index : tracker.findAll()) {
                System.out.println(String.format("id=%s имя=%s описание=%s", index.getId(), index.getName(), index.getDescription()));
            }
        }

        public String info() {
            return String.format("%s.%s", this.key(), "Show all items");
        }
    }

    private class EditItem implements UserAction {
        public int key() {
            return 2;
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

        public String info() {
            return String.format("%s.%s", this.key(), "Edit Item");
        }
    }

    private static class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            tracker.deleteItem(id);
            System.out.println(String.format("------------ Заявка с id=%s удалена --------------", id));
        }

        public String info() {
            return String.format("%s.%s", this.key(), "Delete Item");
        }
    }

    private class FoundById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки :");

            Item item = tracker.findById(id);
            if (item!=null) {
                System.out.println(String.format("id=%s имя=%s описание=%s", item.getId(), item.getName(), item.getDescription()));
            } else {
                System.out.println("Ничего не нашлось!");
            }
        }

        public String info() {
            return String.format("%s.%s", this.key(), "Found by ID");
        }
    }
    private static class FoundByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            for (Item index:tracker.findByName(name)) {
                if(index!=null){
                System.out.println(String.format("id=%s имя=%s описание=%s",index.getId(),index.getName(),index.getDescription()));
                }
            }
        }

        public String info() {
            return String.format("%s.%s", this.key(), "Found by Name");
        }
    }
}
*/
