package UserMap;


public class User {
    User(int id,String name,String city){
        this.id=id;
        this.city=city;
        this.name=name;
    }
    int id;
    String name;
    String city;
    Integer getId(){
        return id;
    }
}
