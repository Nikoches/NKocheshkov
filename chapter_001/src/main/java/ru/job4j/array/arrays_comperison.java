package ru.job4j.array;

public class arrays_comperison {

    public int [] comp(int[] a,int[] b) {
        int index_a =0;   int index_b=0;  int index =0;
        int[] array2 = new int[a.length + b.length];
        while ((index_a<a.length) &&  (index_b<b.length)){
            array2[index] = a[index_a] < b[index_b]?a[index_a++]:b[index_b++];index++;}
        if (index_a<a.length){System.arraycopy (a,index_a, array2, index,a.length-index_a+1);}
        else {System.arraycopy (b,index_b,array2,index,b.length-index_a+1);}
        return array2;
       }
    }

