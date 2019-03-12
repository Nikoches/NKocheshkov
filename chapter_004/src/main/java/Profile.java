public class Profile {

    private Adress adress;
    public Profile(Adress adress){
        this.adress = adress;
    }

    @Override
    public String toString() {
        return adress.toString();
    }
}
