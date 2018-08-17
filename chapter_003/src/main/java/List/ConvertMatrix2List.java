package List;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] X:array) {
            for (int X1:X){
                list.add(X1);
            }

        }
        for (int I:list) {
            System.out.println(I);
        }
        return list;
    }
}
