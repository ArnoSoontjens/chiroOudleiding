
package be.chiro.chiro_namen_en_adressen.tests.integrationTests;

import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import be.chiro.chiro_namen_en_adressen.services.Controller;
import java.io.IOException;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Arno
 */
public class ControllerIT {
    
    private static String firstName,lastName, eMailAddress,dob;
    private static String city, street, bus;
    private static int number, zipCode;
    
    private static Controller controller;
    
    @BeforeClass
    public static void setUp() throws IOException {
        controller = new Controller();
        firstName = "Arno";
        lastName = "Soontjens";
        eMailAddress = "arno.soontjens@test.be";
        dob = "27-10-1992";
        city = "Olen";
        street = "Voortkapelseweg";
        bus = "A";
        number = 19;
        zipCode = 2250;
    }
    
    @AfterClass
    public static void cleanUp() throws IOException {
        controller.closeWriter();
    }
    
    @Test
    public void shouldCreateNewPersonWithAddress_8args() throws BadAddressException, IncompletePersonException {
        Person newPerson = controller.createPersonWithAddress(
                firstName, lastName, eMailAddress, dob,
                city, street, number, zipCode
        );
        assertNotNull(newPerson);
        assertNotNull(newPerson.getAddress());
    }
    
    @Test
    public void shouldCreateNewPersonWithAddress_9args() throws BadAddressException, IncompletePersonException {
        Person newPerson = controller.createPersonWithAddress(
                firstName, lastName, eMailAddress, dob,
                city, street, number, zipCode
        );
        assertNotNull(newPerson);
        assertNotNull(newPerson.getAddress());
    }
    
    @Test(expected = BadAddressException.class)
    public void shouldNotCreatePersonBecauseBadAddress() throws BadAddressException, IncompletePersonException {
        controller.createPersonWithAddress(firstName, lastName, eMailAddress, dob, city, null, number, zipCode);
    }
    
    @Test(expected = IncompletePersonException.class)
    public void shouldNotCreatePersonBecauseIncompletePerson() throws BadAddressException, IncompletePersonException {
        controller.createPersonWithAddress(null, lastName, eMailAddress, dob, city, street, number, zipCode);
    }
    
    @Test
    public void shouldWriteNewPersonToFile() 
            throws BadAddressException, IncompletePersonException, IOException {
        /*String expectedString = 
                firstName + "" + lastName + ", "+dob +"," + eMailAddress +
                " - " + street + " " + number + " " + bus+ ", " + zipCode + ", " + city; */
                
        for(int i=0;i<10;i++) {
            Person newPerson = controller.createPersonWithAddress(
                    firstName, lastName, eMailAddress, dob,
                    city, street, number, zipCode
            );
            controller.writeToFile(newPerson);
        }
        
        //assertEquals(expectedString, controller.getLastEntry());
    }
}
