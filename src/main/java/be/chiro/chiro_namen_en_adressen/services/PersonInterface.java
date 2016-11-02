
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import java.util.Date;

/**
 *
 * @author Arno
 */
public interface PersonInterface {

    Person createPerson(String firstName, String lastName, String eMailAdress, Date dob) 
            throws IncompletePersonException;
    Person createPerson(String firstName, String lastName, String eMailAdress, Date dob, Address address) 
            throws IncompletePersonException;
}
