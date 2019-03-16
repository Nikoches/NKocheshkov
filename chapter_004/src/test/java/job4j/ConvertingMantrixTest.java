package job4j;

import org.junit.Test;

public class ConvertingMantrixTest {

    @Test
    public void convert(){
        ConvertingMantrix mantrix = new ConvertingMantrix();
        mantrix.convertMatrixToList();
        Integer [][] array = {{1,2}, {3,4}};
        System.out.println(mantrix.converting(array));
    }
}
