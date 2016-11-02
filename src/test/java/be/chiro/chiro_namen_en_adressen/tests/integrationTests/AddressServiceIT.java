
package be.chiro.chiro_namen_en_adressen.tests.integrationTests;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;
import be.chiro.chiro_namen_en_adressen.services.AddressService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Arno
 */
public class AddressServiceIT {
    
    private static String city = "Noorderwijk";
    private static String street = "Ring";
    private static int zipCode = 2200;
    private static int number = 9;
    private static String bus = "A";
    private static AddressService addressService;
            
    @BeforeClass
    public static void setUp() {
         addressService = new AddressService();
         city = "Noorderwijk";
         street = "Ring";
         zipCode = 2200;
         number = 9;
         bus = "A";
    }

    @Test
    public void shouldCreateNewAddress_4args() throws BadAddressException {
       Address newAddress = addressService.createAddress(city, street, number, zipCode);
        assertNotNull(newAddress);
        assertNotNull(newAddress.getCity());
        assertNotNull(newAddress.getStreet());
        assertNotNull(newAddress.getNumber());
        assertNotNull(newAddress.getZipCode());
        assertEquals("",newAddress.getBus()); 
    }
    @Test
    public void shouldCreateNewAddress_5args() throws BadAddressException {
        Address newAddress = addressService.createAddress(city, street, number, zipCode, bus);
        assertNotNull(newAddress);
        assertNotNull(newAddress.getCity());
        assertNotNull(newAddress.getStreet());
        assertNotNull(newAddress.getNumber());
        assertNotNull(newAddress.getZipCode());
        assertNotNull(newAddress.getBus());
    }
    
    @Test
    public void shouldNotCreateAddressBecauseEmptyStreetString() throws BadAddressException {
        try {
            Address newAddress = addressService.createAddress(city, "", number, zipCode, bus);
        } catch(BadAddressException ex) {
            assertEquals("Geen geldige straat\n", ex.getMessage());
        }
    }
    
    @Test
    public void shouldNotCreateAddressBecauseEmptyCityString() throws BadAddressException {
        try {
            Address newAddress = addressService.createAddress("", street, number, zipCode, bus);
        } catch(BadAddressException ex) {
            assertEquals("Geen geldige stad\n", ex.getMessage());
        }
    }
    
    @Test
    public void shouldNotCreateAddressBecauseNegativeNumber() throws BadAddressException {
        try {
            Address newAddress = addressService.createAddress(city, street, -1, zipCode, bus);
        } catch(BadAddressException ex) {
            assertEquals("Geen geldig nummer\n", ex.getMessage());
        }
    }
    
    @Test
    public void shouldNotCreateAddressBecauseInvalidZipCode() throws BadAddressException {
        try {
            Address newAddress = addressService.createAddress(city, street, number, 20, bus);
        } catch(BadAddressException ex) {
            assertEquals("Geen geldige postcode\n", ex.getMessage());
        }
    }
   
}
