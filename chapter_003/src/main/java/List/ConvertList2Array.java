package List;
import java.util.*;


public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int noe = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int i = 0, i1 = 0;
        int[][] array = new int[rows][noe];
            for (Integer x : list) {
                array[i][i1] = x;
                if (i1 >= noe-1) {
                    i++; i1 = 0;
                } else {
                    i1++;
                }

        }
        return array;  }
    }
