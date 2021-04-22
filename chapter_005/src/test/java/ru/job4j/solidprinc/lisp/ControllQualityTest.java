package ru.job4j.solidprinc.lisp;

import org.junit.Test;

import java.util.Date;

public class ControllQualityTest {

    @Test
    public void firstProductCheck() {
        ControllQuality ss = new ControllQuality();
        Date date = new Date(1564417969000L);
        System.out.println(new Food.Milk("s1",date,1,1564590769000L,90061000).getQuality());
        ss.productCheck(new Food.Milk("s1",date,1,1564590769000L,90061000));
    }
}