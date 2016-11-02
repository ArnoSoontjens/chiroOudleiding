
package be.chiro.chiro_namen_en_adressen.tests.unitTests;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.classes.Person;
import java.util.Date;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Arno
 */
public class PersonTest {
    
    private final String firstName = "Arno";
    private final String lastName = "Soontjens";
    private final String eMailAddress = "arno.soontjens@test.com";
    private final Date dob = new Date(1992, 10, 27);
    private final Address address = new Address("Noorderwijk", "Ring",2200, 9,"A");
    
    @Test
    public void shouldCreateNewPersonWithoutAddress() {
        Person newPerson = new Person(firstName,lastName,eMailAddress,dob);
        
        assertNotNull(newPerson);
        assertNotNull(newPerson.getFirstName());
        assertNotNull(newPerson.getLastName());
        assertNotNull(newPerson.geteMailAddress());
        assertNotNull(newPerson.getDob());
        assertNotNull(newPerson.getAddress());
    }
    
    @Test
    public void shouldCreateNewPersonWithAddress() {
        Person newPerson = new Person(firstName,lastName,eMailAddress,dob, address);
        
        assertNotNull(newPerson);
        assertNotNull(newPerson.getFirstName());
        assertNotNull(newPerson.getLastName());
        assertNotNull(newPerson.geteMailAddress());
        assertNotNull(newPerson.getDob());
        assertNotNull(newPerson.getAddress());
        
        assertNotNull(newPerson.getAddress().getCity());
        assertNotNull(newPerson.getAddress().getStreet());
        assertNotNull(newPerson.getAddress().getZipCode());
        assertNotNull(newPerson.getAddress().getNumber());
        assertNotNull(newPerson.getAddress().getBus());
        
    }
    
}
