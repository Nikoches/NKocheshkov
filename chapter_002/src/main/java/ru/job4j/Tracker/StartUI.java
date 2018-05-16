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
    private static final String REPLACE = "2";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String SHOW_ALL = "1";
    private static final String DELETE = "3";
    /**
     * Хранилище заявок.
     */
    private final Input input;
    private final Tracker tracker;
    private int[] ranges  = new int[]{0,1,2,3,4,5};

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
       /* boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else if (SHOW_ALL.equals(answer)){
                this.showAllItem();
            }else if (REPLACE.equals(answer)){
                this.editItem();
            }else if (FIND_BY_ID.equals(answer)){
                this.findById();
            }else if (FIND_BY_NAME.equals(answer)){
                this.findByName();
            }
        }*/
       MenuTracker menu = new MenuTracker(this.input,tracker);
       menu.fillActions();
       do{
           menu.show();
           menu.select(input.ask("Select",ranges));
       }while (!"y".equals(this.input.ask("exit? y/n")));
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc,123L);
        this.tracker.add(item);
        System.out.println(String.format("------------ Новая заявка с getId : %s -----------",item.getId()));
    }
    private void deleteItem(){
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.deleteItem(id);
        System.out.println(String.format("------------ Заявка с id=%s удалена --------------",id));
    }
    private void showAllItem(){
        System.out.println("------------ Заявки: --------------");
       // System.out.println(this.tracker.findAll()[1].getName());
        for (Item index:this.tracker.findAll()) {
            System.out.println(String.format("id=%s имя=%s описание=%s",index.getId(),index.getName(),index.getDescription()));
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
        Item item = this.tracker.findById(id);
       if (item!=null) {
           System.out.println(String.format("id=%s имя=%s описание=%s", item.getId(), item.getName(), item.getDescription()));
       } else {
           System.out.println("Ничего не нашлось!");
       }
       // System.out.printf("id=%s",this.tracker.findById(id).getId()," имя=%s",this.tracker.findById(id).getName()," описание=%s",this.tracker.findById(id).getDescription());
    }
    private void findByName(){
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        for (Item index:this.tracker.findByName(name)) {
            System.out.println(String.format("id=%s имя=%s описание=%s",index.getId(),index.getName(),index.getDescription()));
        }}
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {

        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}