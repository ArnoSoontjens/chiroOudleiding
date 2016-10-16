
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import java.util.Date;

/**
 *
 * @author Arno
 */
public class PersonService {

    public PersonService() {
    }
    
    private Person createPerson(
            String firstName, 
            String lastName, 
            String eMailAdress,
            Date dob
    ) throws IncompletePersonException {
        checkPerson(firstName, lastName);
        return new Person(firstName, lastName, eMailAdress, dob, null);
    } 
    
    private void checkPerson(String firstName,String lastName) throws IncompletePersonException {
        boolean error = false;
        String message="";
        if(firstName == null) {
            error = true;
            message += "Geen geldige voornaam.\n";
        }
        if(lastName == null) {
            error = true;
            message += "Geen geldige achternaam.\n";
        }
        if(error) throw new IncompletePersonException(message);
    }
}
