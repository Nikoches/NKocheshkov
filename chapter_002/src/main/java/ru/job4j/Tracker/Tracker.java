package ru.job4j.Tracker;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     */
    private int unicInt =0;

    private String generateId() {
        Random random = new Random();
        return ((Integer.toString(random.nextInt(15)) + Integer.toString(unicInt++)));
    }

    public void replace(String id, Item item) {
        for (int i=0;i<this.position;i++){
            if (this.items[i].getId().equals(id)){
                this.items[i]=item;
                break;
            }
        }
    }

    public Item[] findAll() {
        Item[] founditems = new Item[position];
        System.arraycopy(items, 0, founditems, 0, position);
        return founditems;
    }

    public Item[] findByName(String key) {
        Item[] foundItems = new Item[position];
        int index1=0;
        for (int index=0;index<this.position;index++) {
            if (items[index].getName().equals(key)) {
                foundItems[index1] = items[index1];
                index1++;
            }
        }
        return foundItems;
    }
    public Item findById(String id) {
        int unicId=0;
        for (int index=0;index<this.position;index++){
            if (items[index].getId().equals(id)){
                unicId=index;
                break;
            }
            else return null;
        }
        return items[unicId];
    }
    public void deleteItem(String id){
        int unicId=0;
        for (int index=0;index<this.position;index++){
            if (items[index].getId().equals(id)){
                unicId=index;break;
            }}
        items[unicId]=items[this.position-1];
        items[this.position-1]=null;
        this.position--;
    }
}