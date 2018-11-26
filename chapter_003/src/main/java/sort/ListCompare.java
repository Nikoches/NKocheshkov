package sort;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int kol = left.length() > right.length() ? right.length() : left.length();
        int rst = 0;
            for (int i=0;i<kol;i++){
                if (Character.compare(left.charAt(i),right.charAt(i))>0){
                  rst = 1;
                }
             }
        if ((rst == 0)&& (left.length() < right.length())) {
            rst = -1;
        }
        if ((rst == 0)&& (left.length() > right.length())){
            rst = -1;
        }
     return rst;
    }
}
