package ru.job4j.solidprinc.lisp;

import java.util.ArrayList;

public class ExtendedControlQuality {
    private final ControllQuality cs;
    private final ArrayList<Storage> storageArrayList = new ArrayList<>();

    public ExtendedControlQuality(ControllQuality cs) {
        this.cs = cs;
        this.storageArrayList.add(new Warehouse());
        this.storageArrayList.add(new Shop());
        this.storageArrayList.add(new Trash());
        this.storageArrayList.add(new LowtempStorage());
    }

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

    public void resort() {
        for (Storage x : storageArrayList) {
            for (Food y : x.getFood()) {
                this.extendedCheck(y);
            }
        }
    }
}
