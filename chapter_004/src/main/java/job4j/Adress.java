package job4j;

public class Adress implements Comparable<Adress>{
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

    public String getCity(){
        return this.city;
    }

    public boolean  equals(Object obj){
        boolean equality = false;
        if (obj == this) {
            equality = true;
        }
        Adress adres = (Adress) obj;
        equality = city != null && street != null && city.equals(adres.city) && street.equals(adres.street) && home == adres.home && apartment == adres.apartment;

        if (obj == null || obj.getClass() != this.getClass()) {
            equality = false;
        }
        return equality;
    }

    public int hashCode() {
        int res = 17;
        res = 31 * res + city.hashCode();
        res = 31 * res + street.hashCode();
        return res;
    }

    public int compareTo(Adress adres){
        return this.city.compareTo(adres.city);
    }
}
