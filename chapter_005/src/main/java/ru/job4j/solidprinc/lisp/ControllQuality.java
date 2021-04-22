package ru.job4j.solidprinc.lisp;

import java.util.ArrayList;

public class ControllQuality {
    private final ArrayList<Storage> storageArrayList = new ArrayList<>();

    public ControllQuality() {
        this.storageArrayList.add(new Warehouse());
        this.storageArrayList.add(new Shop());
        this.storageArrayList.add(new Trash());
    }

    public void productCheck(Food prd) {
        for (Storage x : storageArrayList) {
            if (x.accept(prd) & x.getSpace()) {
                x.add(prd);
                break;
            }
        }
    }
}
