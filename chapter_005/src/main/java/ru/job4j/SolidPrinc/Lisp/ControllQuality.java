package ru.job4j.SolidPrinc.Lisp;

import java.util.ArrayList;

public class ControllQuality extends ExtendedControl {
    private ArrayList<Storage> storageArrayList = new ArrayList<>();

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

    @Override
    public void extendedCheck(Food prd) {
        for (Storage x : storageArrayList) {
            if (!x.getSpace()) {
                this.storageArrayList.add(x.getExpansion());
            }
            if (x.accept(prd) & x.getSpace() & prd.getMark().equals(x.getMark())) {
                x.add(prd);
                break;
            }
        }
    }
}
