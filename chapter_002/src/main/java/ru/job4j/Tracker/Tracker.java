package ru.job4j.Tracker;
import java.util.*;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    List<Item> items = new ArrayList<Item>();
    /**
     * Указатель ячейки для новой заявки.
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
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
        return ((Integer.toString(random.nextInt(15)) + Integer.toString(unicInt++)));
    }

    public void replace(String id, Item item) {
       items.set(items.indexOf(findById(id)), item);
    }

    public List<Item>  findAll() {
        List<Item> itemsall = new ArrayList<Item>();
        itemsall.addAll(items);
        return itemsall;
    }

    public List<Item> findByName(String key) {
        List<Item> foundItems = new ArrayList<Item>();
        if (key != null) {
         for (Item fitem : items) {
             if (fitem.getName().equals(key)) {
               foundItems.add(fitem);
             }
            }
        } else {
            return null;
        }
        return foundItems;
    }
    public Item findById(String id) {
        Item fbritem = null;
        for (Item fbitem : items) {
            if (fbitem.getId().equals(id)) {
                fbritem = fbitem;
            }
        }
        return fbritem;
    }
    public void deleteItem(String id) {
        Item deleteid = null;
        for (Item ditem : items) {
            if (ditem.getId().equals(id)) {
              deleteid = ditem;
            }
        }
        items.remove(deleteid);

    }
}