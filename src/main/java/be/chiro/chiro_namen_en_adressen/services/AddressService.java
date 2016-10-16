
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;

/**
 *
 * @author Arno
 */
public class AddressService {

    public AddressService() {
    }
    
    public Address createAddress(
            String city, 
            String street, 
            int number, 
            int zipCode,
            String bus
    ) throws BadAddressException {
        if(bus==null) bus = "";
        checkAddress(city, street, number, zipCode);
        return new Address(city, street, zipCode, number, bus);
    }
    
    private void checkAddress(
            String city, 
            String street, 
            int number, 
            int zipCode
    ) throws BadAddressException {
        boolean error = false;
        String message="";
        
        if(city==null || city.isEmpty()){ 
            error = true;
            message += "Geen geldige stad\n";
        } 
        if(street==null || street.isEmpty()){
            error = true;
            message += "Geen geldige straat\n";
        }
        if(number < 0) {
            error = true;
            message += "Geen geldig nummer\n";
        }
        if(zipCode < 1000){
            error = true;
            message += "Geen geldige postcoce\n";
        }
        if(error) throw new BadAddressException(message);  
    }
}
