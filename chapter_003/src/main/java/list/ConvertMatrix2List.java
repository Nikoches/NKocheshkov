package list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] x : array) {
            for (int x1 : x) {
                list.add(x1);
            }
        }
        for (int i : list) {
            System.out.println(i);
        }
        return list;
    }
    public List<Integer> convert(List<int[]> list) {
        List<Integer> listall = new ArrayList<>();
        for (int[] z : list) {
            for (int z1 : z) {
                listall.add(z1);
            }
        }
        return listall;
    }
}
