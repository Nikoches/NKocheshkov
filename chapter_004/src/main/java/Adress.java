public class Adress {
    private String city;
    private String street;
    private int home;
    private int apartment;
    public Adress(String city, String street, int home, int apartment){
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "city= " + city + " str=" + street + home + " apr=" + apartment;
    }
}
