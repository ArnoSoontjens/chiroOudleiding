
package be.chiro.chiro_namen_en_adressen.classes;

/**
 *
 * @author Arno
 */
public class Address {
    
    private String city;
    private String street;
    private int zipCode;
    private int number;
    private String bus;

    public Address() {
    }
    
    public Address(String city, String street, int zipCode, int number, String bus) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
        this.bus = bus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Address{" + "city=" + city + ", street=" + street + ", zipCode=" + zipCode + ", number=" + number + ", bus=" + bus + '}';
    }
    
}
