
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import sun.awt.image.BadDepthException;

/**
 *
 * @author Arno
 */
public interface ControllerInterface {
    public Person createPersonWithAddress(
            String firstName,
            String lastName,
            String eMailaddress,
            String dob,
            String city,
            String street,
            int number,
            int zipCode
    ) throws BadAddressException, IncompletePersonException;
    
    public Person createPersonWithAddress(
            String firstName,
            String lastName,
            String eMailaddress,
            String dob,
            String city,
            String street,
            int number,
            int zipCode,
            String bus
    ) throws BadAddressException, IncompletePersonException;
    
    public boolean writeToFile(Person person);
    public int getNumberOfEntries();
    public String getLastEntry();
    public boolean deleteLastEntryFromFile();
}
