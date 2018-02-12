package ru.job4j.array;

public class arrays_comperison {

    public int [] comp(int[] a,int[] b) {
        int i =0;   int j=0;  int index =0;
        int[] array2 = new int[a.length + b.length];
        while ((i<a.length) &&  (j<b.length)){
            System.out.println("index="+index+" i="+i+" j="+j);
           if ( a[i]<b[j]){
               array2[index] = a[i]; i++; }
               else {array2[index]=b[j];j++;}
                    index++;}
        while (i < a.length) {array2[index++] = a[i++];}
        while (j < b.length) {array2[index++] = b[j++];}
        return array2;
       }
    }

