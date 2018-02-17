package ru.job4j.array;

public class arrays_comperison {

    public int [] comp(int[] a,int[] b) {
        int indexFirst =0;   int indexSecond=0;  int indexThird =0;
        int[] array2 = new int[a.length + b.length];
        while ((indexFirst<a.length) &&  (indexSecond<b.length)){
            array2[indexThird] = a[indexFirst] < b[indexSecond]?a[indexFirst++]:b[indexSecond++];indexThird++;}
        if (indexFirst<a.length){System.arraycopy (a,indexFirst, array2, indexThird,a.length-indexFirst+1);}
        else {System.arraycopy (b,indexSecond,array2,indexThird,b.length-indexFirst+1);}
        return array2;
       }
    }

