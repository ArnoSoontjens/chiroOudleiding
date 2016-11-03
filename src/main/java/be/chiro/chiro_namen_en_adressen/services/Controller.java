
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import java.io.IOException;

/**
 *
 * @author Arno
 */
public class Controller implements ControllerInterface {

    private String fileLocation;
    private CSVManager writer;

    public Controller() throws IOException {
        initiateWriter("personen_bestand.csv");
    }
    
    public Controller(String fileLocation) throws IOException {
        initiateWriter(fileLocation);
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
        return ps.createPerson(firstName, lastName, eMailaddress, dob, address);
    }
    
    @Override
    public void writeToFile(Person person) throws IOException{
        String fullName = person.getLastName() + " " + person.getFirstName();
        String fullAddress = person.getAddress().getStreet() + " " +
                person.getAddress().getNumber() + " " +
                person.getAddress().getBus();
        String[] data = {
            fullName, 
            person.getDob(), 
            fullAddress, 
            person.getAddress().getCity(), 
            person.geteMailAddress()
        };
        writer.writeDataToCSVFile(data);
    }
    
    @Override
    public void closeWriter() throws IOException {
        writer.closeWriter();
    }
    
    @Override
    public boolean deleteFile() throws IOException {
        return writer.deleteFile();
    }
    
    private void initiateWriter(String fileLocation) throws IOException {
        writer = new CSVManager(fileLocation);
    }
    
}
