package List;

import java.util.*;
import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Convert_list_all {
    @Test
    public void ComparisonList(){
        ConvertMatrix2List list = new ConvertMatrix2List();
         ArrayList <int[]> fun = new ArrayList<int[]>();
         fun.add(new int[]{1,2});
         fun.add(new int[]{66,77,99,55});
        List<Integer> list_all = list.convert(fun);
        List<Integer> expect = Arrays.asList(
                1, 2, 66,77,99,55
        );
        assertThat(list_all, is(expect));
    }
}
