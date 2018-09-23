package List;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] x:array) {
            for (int x1 : x) {
                list.add(x1);
            }
        }
        for (int i : list) {
            System.out.println(i);
        }
        return list;
    }
    public List<Integer> convert (List<int[]> list){
        List<Integer> list_all = new ArrayList<>();
        for(int[] X:list){
            for (int X1:X){
                list_all.add(X1);
            }
        }
        return list_all;
    }

}
