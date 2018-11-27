package ru.job4j.array;

public class Arrayscomperison {

    public int[] comp(int[] arrayA, int[] arrayB) {
        int indexFirst = 0;   int indexSecond = 0;  int indexThird = 0;
        int[] arrayFinished = new int[arrayA.length + arrayB.length];
        while ((indexFirst < arrayA.length) &&  (indexSecond < arrayB.length)) {
            arrayFinished[indexThird] = arrayA[indexFirst] < arrayB[indexSecond] ? arrayA[indexFirst++] : arrayB[indexSecond++]; indexThird++; }
        if (indexFirst < arrayA.length) {
            System.arraycopy(arrayA, indexFirst, arrayFinished, indexThird, arrayA.length - indexFirst + 1);
        } else {
            System.arraycopy(arrayB, indexSecond, arrayFinished, indexThird, arrayB.length - indexFirst + 1);
            }
        return arrayFinished;
       }
    }

