package ru.job4j.SolidPrinc.Lisp;

public class ControllQuality {
    private Storage storagtr;
    private Storage storagsh;
    private Storage storagwareh;
    public ControllQuality(){
        this.storagtr = new Trash();
        this.storagsh = new Shop();
        this.storagwareh = new Warehouse();
    }
    public void productCheck(Food prd) {
        if (prd.getQuality() < 25) {
            storagwareh.add(prd);
        } else if (25 < prd.getQuality() & prd.getQuality() < 75) {
            storagsh.add(prd);
        } else if (prd.getQuality() > 75 & prd.getQuality() < 100){
            prd.setDiscount();
            storagsh.add(prd);
        }else {
            storagtr.add(prd);
        }
    }
}
