package ru.job4j.SolidPrinc.Lisp;

import java.util.ArrayList;

public class ControllQuality {
    private Storage storagtr;
    private Storage storagsh;
    private Storage storagwareh;
    private ArrayList<Storage> storageArrayList = new ArrayList<>();
    public ControllQuality(){
        this.storageArrayList.add(new Warehouse());
        this.storageArrayList.add(new Shop());
        this.storageArrayList.add(new Trash());
    }
    public void productCheck(Food prd) {
        if (prd.getQuality() < 25) {
            storageArrayList.get(0).add(prd);
        } else if (25 < prd.getQuality() & prd.getQuality() < 75) {
            storageArrayList.get(1).add(prd);
        } else if (prd.getQuality() > 75 & prd.getQuality() < 100){
            prd.setDiscount();
            storageArrayList.get(1).add(prd);
        }else {
            storageArrayList.get(2).add(prd);
        }
    }
}
