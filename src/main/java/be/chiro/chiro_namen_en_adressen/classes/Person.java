
package be.chiro.chiro_namen_en_adressen.classes;

import java.util.Date;

/**
 *
 * @author Arno
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private String eMailAddress;
    private Date dob;
    private Address address;

    public Person() {
    }
    
    public Person(String firstName, String lastName, String eMailAddress, Date dob, Address address) {
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    
    
}
