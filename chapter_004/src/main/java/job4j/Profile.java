package job4j;


public class Profile {

    private Adress adress;

    public Profile(Adress adress){
        this.adress = adress;
    }

    public Adress getAdress() {
        return this.adress;
    }

    @Override
    public String toString() {
        return adress.toString();
    }
}
