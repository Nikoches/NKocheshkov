package ru.job4j;
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
    private int unicInt = 0;

    private String generateId() {
        Random random = new Random();
        return Integer.toString(random.nextInt(29 + 1) + unicInt++);
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
        Item[] founditems = new Item[position + 1];
        System.arraycopy(items, 0, founditems, 0, position + 1);
        return founditems;
    }

    public Item[] findByName(String key) {
        Item[] foundItems = new Item[position + 1];
        int j = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(key)) {
                foundItems[j] = items[i];
                j++;
            }
        }
        return foundItems;
    }

    public Item findById(String id) {
        int uq=0;
        for (int i=0;i<this.position;i++){
         if (items[i].getId().equals(id)){
             uq=i;break;
            }
            else uq=0;
          }
    return items[uq];
    }
    public void deleteItem(String id){
        int uq=0;
        for (int i=0;i<this.position;i++){
            if (items[i].getId().equals(id)){
                uq=i;break;
            }
        for (int k = uq; k < uq - 1; k++) //сдвиг последующих элементов
                this.items[k] = this.items[k + 1];
            uq--;
        }
}
}