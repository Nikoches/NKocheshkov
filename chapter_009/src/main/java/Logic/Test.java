package Logic;

import Persistence.Item;
import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       Logic logic = Logic.getInstance();
       Item item =  new Item();
       item.setDescription("something");
       item.setDone(true);
       item.setName("else");
        logic.save(item);
    }

    public String createGson() {
        Gson gson = new Gson();
        Pojo pojo = new Pojo("desc",0);
        Pojo pojo1 = new Pojo("desc1",1);
        Pojo pojo2 = new Pojo("desc2",2);
        Pojo pojo3 = new Pojo("desc3",3);
        List<Pojo> list = new LinkedList<>();
        list.add(pojo);
        list.add(pojo1);
        list.add(pojo2);
        list.add(pojo3);
        return gson.toJson(list);
    }

    public class Pojo{
        private String desc;
        private Integer id;

        public Pojo(String desc, Integer id){
            this.desc = desc;
            this.id = id;
        }
        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
