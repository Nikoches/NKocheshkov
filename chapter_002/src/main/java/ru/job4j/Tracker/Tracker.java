package ru.job4j.Tracker;
import java.util.ArrayList;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    ArrayList<Item> items = new ArrayList<Item>();
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
        this.items.add(item);
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
        for(Item reitem:items){
            if (reitem.getId().equals(id)){
                items.set(items.indexOf(reitem),item);
            }
        }


/*
        for (int i=0;i<this.position;i++){
            if (this.items[i].getId().equals(id)){
                this.items[i]=item;
                break;
            }
        }*/
    }

    public Item[] findAll() {
        Item[] founditems = new Item[position];
        founditems=items.toArray(founditems);
        return founditems;
    }

    public Item[] findByName(String key) {
        Item[] foundItems = new Item[position+1];
        if (key != null){
         for (Item fitem:items){
             if (fitem.getName().equals(key)){
               foundItems[position++] =fitem;
             }else return null;
            }
        }
        return foundItems;
    }
    public Item findById(String id) {
        Item fbritem = null;
        for(Item fbitem:items){
            if(fbitem.getId().equals(id)){
                fbritem = fbitem;
            }
        }
        return fbritem;
    }
    public void deleteItem(String id){
        int unicId=0;
       /* for (int index=0;index<this.position;index++){
            if (items[index].getId().equals(id)){
                unicId=index;break;
            }}
        items[unicId]=items[this.position-1];
        items[this.position-1]=null;
        this.position--;
        */
        for(Item ditem:items) {
            if (ditem.getId().equals(id)) {
              items.remove(ditem.getId());
            }
        }


    }
}