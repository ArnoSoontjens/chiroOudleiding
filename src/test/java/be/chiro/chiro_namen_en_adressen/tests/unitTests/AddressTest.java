
package be.chiro.chiro_namen_en_adressen.tests.unitTests;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Arno
 */
public class AddressTest {
    
    private final String city = "Noorderwijk";
    private final String street = "Ring";
    private final int zipCode = 2200;
    private final int number = 9;
    private final String bus = "A";
    
    @Test
    public void shouldCreateNewAddress() {
        Address newAddress = new Address(city, street, zipCode, number, bus);
        
        assertNotNull(newAddress);
        assertNotNull(newAddress.getCity());
        assertNotNull(newAddress.getStreet());
        assertNotNull(newAddress.getZipCode());
        assertNotNull(newAddress.getNumber());
        assertNotNull(newAddress.getBus());
        
        System.out.println(newAddress.toString());
        
    }
}
