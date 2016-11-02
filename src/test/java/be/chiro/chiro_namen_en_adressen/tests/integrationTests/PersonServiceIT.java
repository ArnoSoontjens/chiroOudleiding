/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.chiro.chiro_namen_en_adressen.tests.integrationTests;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import be.chiro.chiro_namen_en_adressen.services.PersonService;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Arno
 */
public class PersonServiceIT {
    
    private static PersonService personService;
    private static String firstName, lastName, eMailAddress;
    private static String dob;
    private static Address address;
    
    @BeforeClass
    public static void setUp() {
        personService = new PersonService();
        firstName = "Arno";
        lastName = "Soontjens";
        eMailAddress = "arno.soontjens@test.be";
        dob = "27/10/1922";
        address = new Address();
    }
    
    @Test 
    public void shouldCreateNewPerson_4args() throws IncompletePersonException {
        Person newPerson = personService.createPerson(firstName, lastName, eMailAddress, dob);
        assertNotNull(newPerson);
        assertEquals(firstName, newPerson.getFirstName());
        assertEquals(lastName, newPerson.getLastName());
        assertEquals(eMailAddress, newPerson.geteMailAddress());
        assertEquals(dob, newPerson.getDob());
        assertNotNull(newPerson.getAddress());
    }
    
    @Test
    public void shouldCreateNewPerson_5args() throws IncompletePersonException {
        Person newPerson = personService.createPerson(firstName, lastName, eMailAddress, dob, address);
        assertNotNull(newPerson);
        assertEquals(firstName, newPerson.getFirstName());
        assertEquals(lastName, newPerson.getLastName());
        assertEquals(eMailAddress, newPerson.geteMailAddress());
        assertEquals(dob, newPerson.getDob());
        assertEquals(address,newPerson.getAddress());
    }
}
