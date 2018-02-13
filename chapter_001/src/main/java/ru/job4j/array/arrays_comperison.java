package ru.job4j.array;

public class arrays_comperison {

    public int [] comp(int[] a,int[] b) {
        int i =0;   int j=0;  int index =0;
        int[] array2 = new int[a.length + b.length];
        while ((i<a.length) &&  (j<b.length)){
            array2[index] = a[i] < b[j]?a[i++]:b[j++];index++;
             }
        if (i<a.length){System.arraycopy (a,i, array2, index,a.length-i+1);}
        else {System.arraycopy (b,j,array2,index,b.length-i+1);}
        return array2;
       }
    }

