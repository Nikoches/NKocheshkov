package ru.job4j.Cache;

import org.junit.Test;
import ru.job4j.AbstractCache.Cache;

public class CacheTest {

    @Test
    public void CacheFirstTest() {
        Cache ch1 = new Cache();
        System.out.println(ch1.getElement("pp.txt"));
    }
}
