package ru.job4j.departments;


public class Depart  {
    public Depart(String path) {
       String[] names = path.split("\\\\");
       this.path = path;
       this.number = "" + (names[0].charAt(names[0].length() - 1));
       if (names.length > 1) {
       for (int i = 1; i < names.length; i++) {
           this.number += names[i].charAt(names[i].length() - 1);
            }
       } else {
           this.number = "" + names[0].charAt(names.length);
       }
    }
    protected String path;
    protected String number;

}
