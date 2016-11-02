
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;

/**
 *
 * @author Arno
 */
public class Controller implements ControllerInterface {

    @Override
    public Person createPersonWithAddress(String firstName, String lastName, String eMailaddress, String dob, String city, String street, int number, int zipCode) throws BadAddressException, IncompletePersonException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Person createPersonWithAddress(String firstName, String lastName, String eMailaddress, String dob, String city, String street, int number, int zipCode, String bus) throws BadAddressException, IncompletePersonException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean writeToFile(Person person) {
        
    }

    @Override
    public int getNumberOfEntries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteLastEntryFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
