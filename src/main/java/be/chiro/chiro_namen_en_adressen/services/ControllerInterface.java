
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import java.io.IOException;

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
    
    public void writeToFile(Person person) throws IOException;
    public void closeWriter() throws IOException;
    public boolean deleteFile() throws IOException;
}
