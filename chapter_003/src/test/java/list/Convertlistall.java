package list;

import java.util.*;
import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Convertlistall {
    @Test
    public void comparisonList() {
        ConvertMatrix2List list = new ConvertMatrix2List();
         ArrayList<int[]> fun = new ArrayList<int[]>();
         fun.add(new int[]{1, 2});
         fun.add(new int[]{66, 77, 99, 55});
        List<Integer> listall = list.convert(fun);
        List<Integer> expect = Arrays.asList(
                1, 2, 66, 77, 99, 55
        );
        assertThat(listall, is(expect));
    }
}
