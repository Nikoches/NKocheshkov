package ru.job4j.departments;

public class Departments {
    String[][] depat1 = new String[2][2];
    String[][] depat2 = new String[1][2];

    public String[][] pulldep() {
        depat1[0][0] = "K1";
        depat1[1][0] = depat1[0][0] + "/SK1";
        depat1[1][1] = depat1[1][0] + "/SSK1";
        depat1[1][2] = depat1[1][0] + "/SSK2";
        depat1[2][0] = depat1[0][0] + "/SK2";
        depat2[0][0] = "K2";
        depat2[1][0] = depat2[0][0] +  "/SK1";
        depat2[1][1] = depat2[1][0] + "/SSK1";
        depat2[1][2] = depat2[1][0] + "/SSK2";
        return depat1;
    }
}
