
package be.chiro.chiro_namen_en_adressen.classes;

/**
 *
 * @author Arno
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private String eMailAddress;
    private String dob;
    private Address address;

    public Person() {
    }
    
    public Person(String firstName, String lastName, String eMailAddress, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.dob = dob;
        this.address = new Address();  
    }
    
    public Person(String firstName, String lastName, String eMailAddress, String dob, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.dob = dob;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", eMailAddress=" + eMailAddress + ", dob=" + dob + ", address=" + address + '}';
    }
    
}
