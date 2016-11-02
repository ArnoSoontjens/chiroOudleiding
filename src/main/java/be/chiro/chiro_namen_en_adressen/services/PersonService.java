
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import java.util.Date;

/**
 *
 * @author Arno
 */
public class PersonService implements PersonInterface {

    public PersonService() {
    }
    
    @Override
    public Person createPerson(
            String firstName, 
            String lastName, 
            String eMailAdress,
            Date dob
    ) throws IncompletePersonException {
        return createPerson(firstName, lastName, eMailAdress, dob, new Address());
    } 
    
    @Override
    public Person createPerson(
            String firstName, 
            String lastName, 
            String eMailAdress, 
            Date dob, 
            Address address
    ) throws IncompletePersonException {
        checkPerson(firstName, lastName);
        return new Person(firstName, lastName, eMailAdress, dob, address);
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
