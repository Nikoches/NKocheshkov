package List;
import java.util.Iterator;
import java.util.List;


public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int zeros = list.size()%3;
        int row = zeros!=0 ?list.size()/3+1:list.size()/3;
        int i = 0,i1=0;
        int[][] array = new int[3][row];
        for (Integer x:list) {
            array[i][i1]=x;
            if (i1>=2){
                i++;i1=0;
            }else {i1++;
            }
        }
        return array;
    }
}
