package ru.job4j.Tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String Replace = "2";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    private static final String FindById = "4";
    private static final String FindByName = "5";
    private static final String ShowAll = "1";
    private static final String Delete = "3";
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (Delete.equals(answer)) {
                this.deleteItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else if (ShowAll.equals(answer)){
                this.showAllItem();
            }else if (Replace.equals(answer)){
                this.editItem();
            }else if (FindById.equals(answer)){
                this.findById();
            }else if (FindByName.equals(answer)){
                this.findByName();
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc,123L);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    private void deleteItem(){
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.deleteItem(id);
        System.out.println("------------ Заявка с id="+id+"удалена --------------");
    }
    private void showAllItem(){
        System.out.println("------------ Заявки: --------------");
       // System.out.println(this.tracker.findAll()[1].getName());
        for (Item i:this.tracker.findAll()) {
            System.out.println("id="+i.getId()+" имя="+i.getName()+" описание="+i.getDescription());
       }
    }
    private void showMenu() {
        System.out.println("Меню. \n 0. Add new Item \n 1. Show all items \n 2. Edit item  \n 3. Delete item \n 4. Find item by Id \n 5. Find items by name \n 6. Exit Program \n Select:");
        // добавить остальные пункты меню.
    }
    private void editItem(){
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc,123L);
        this.tracker.replace(id,item);
        item.setId(id);
    }
    private void findById(){
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки :");
        System.out.println("id="+this.tracker.findById(id).getId()+" имя="+this.tracker.findById(id).getName()+" описание="+this.tracker.findById(id).getDescription());
    }
    private void findByName(){
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        for (Item i:this.tracker.findByName(name)) {
            System.out.println("id="+i.getId()+" имя="+i.getName()+" описание="+i.getDescription());
        }}
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}