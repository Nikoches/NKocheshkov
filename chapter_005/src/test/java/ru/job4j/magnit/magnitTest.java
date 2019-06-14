package ru.job4j.magnit;

import org.junit.Test;

import java.util.List;

public class magnitTest {
    @Test
    public void testsqljdbc() {
        StoreSQL storeSQL = new StoreSQL(new Config());
        storeSQL.createNewDatabase("ddd");
        storeSQL.generate(5);
        List<Entry> list = storeSQL.load();
        System.out.println(list);
    }

}
