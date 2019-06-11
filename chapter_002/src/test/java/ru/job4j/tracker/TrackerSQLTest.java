package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }
    @Test
    public void creatingfirstline(){
        try(TrackerSQL sql = new TrackerSQL()){
            sql.init();
            sql.add(new Item("ziga","i dont expect you to belive",14888));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void replaceitem(){
        try(TrackerSQL sql = new TrackerSQL()){
            sql.init();
            sql.replace("1",new Item("0000","000000000",010203));
            sql.deleteItem("1");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void finditems(){
        try(TrackerSQL sql = new TrackerSQL()){
            sql.init();
            sql.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}