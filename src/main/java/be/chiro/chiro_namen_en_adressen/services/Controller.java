
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import java.util.Date;

/**
 *
 * @author Arno
 */
public class Controller implements ControllerInterface {

    @Override
    public Person createPersonWithAddress(
            String firstName, 
            String lastName, 
            String eMailaddress, 
            String dob, 
            String city, 
            String street, 
            int number, 
            int zipCode
    ) throws BadAddressException, IncompletePersonException {
        return createPersonWithAddress(firstName, lastName, eMailaddress, dob, city, street, number, zipCode,"");
    }
    
    @Override
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
    ) throws BadAddressException, IncompletePersonException {
        PersonService ps = new PersonService();
        AddressService as = new AddressService();
        
        Address address = as.createAddress(city, street, number, zipCode, bus);
        return ps.createPerson(firstName, lastName, eMailaddress, convertStringToDate(dob), address);
    }
    
    @Override
    public boolean writeToFile(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfEntries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteLastEntryFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastEntry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Date convertStringToDate(String dob) {
        String pattern = "";
        
        if(dob.contains("-")){
            pattern = "-";
        } else if (dob.contains(" ")) {
            pattern = " ";
        } else if(dob.contains("/")) {
            pattern = "/";
        } else if(dob.contains(":")) {
            pattern = ":";
        } else if(dob.contains(";")) {
            pattern = ";";
        }
        
        String[] parts = dob.split(pattern);
        int[] convertedDateParts = new int[parts.length];
        
        for(int i=0;i<parts.length;i++) {
            try {
                convertedDateParts[i] = Integer.valueOf(parts[i].trim());
            } catch(NumberFormatException ex) {
                //TODO: write to logger;
            } catch (Exception ex){
                //TODO: write to logger;
            }
        }
        
        return new Date(convertedDateParts[0],convertedDateParts[1],convertedDateParts[2]);
    }
    
}
