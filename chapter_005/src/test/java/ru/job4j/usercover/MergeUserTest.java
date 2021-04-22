package ru.job4j.usercover;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MergeUserTest {
    @Test
    public void MergeTest(){
        LinkedList ss = new LinkedList();
        HashSet<String> listE = new HashSet<>();
        listE.add("OT");
        listE.add("OA");
        ss.add(new User("user1", listE));
        HashSet<String> listE1 = new HashSet<>();
        listE1.add("OQ");
        ss.add(new User("user2", listE1));
        HashSet<String> listE4 = new HashSet<>();
        listE4.add("OZ");
        ss.add(new User("user4", listE4));
        HashSet<String> listE2 = new HashSet<>();
        listE2.add("OB");
        listE2.add("OA");
        ss.add(new User("user3", listE2));
        HashSet result = new HashSet<User>();
        listE.add("OB");
        result.add(new User("user1",listE));
        result.add(new User("user2", listE1));
        result.add(new User("user4", listE4));
        assertThat(MergerUser.SetUtils.equals(result, new MergerUser().mergerUsers(ss)), is(false));
    }
}
