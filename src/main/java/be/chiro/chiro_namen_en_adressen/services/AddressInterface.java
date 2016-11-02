
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;

/**
 *
 * @author Arno
 */
public interface AddressInterface {

    public Address createAddress(String city, String street, int number, int postCode) 
            throws BadAddressException;
    public Address createAddress(
            String city, 
            String street, 
            int number, 
            int zipCode, 
            String bus
    ) throws BadAddressException;
    
}
