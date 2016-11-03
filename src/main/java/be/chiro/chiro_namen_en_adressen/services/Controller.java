
package be.chiro.chiro_namen_en_adressen.services;

import be.chiro.chiro_namen_en_adressen.classes.Address;
import be.chiro.chiro_namen_en_adressen.classes.Person;
import be.chiro.chiro_namen_en_adressen.exceptions.BadAddressException;
import be.chiro.chiro_namen_en_adressen.exceptions.IncompletePersonException;
import be.chiro.chiro_namen_en_adressen.views.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author Arno
 */
public class Controller implements ControllerInterface {

    private String fileLocation;
    private CSVManager writer;
    private MainView mainView;
    
    public Controller() throws IOException {
        this.fileLocation = "personen_bestand.csv";
        initializeWriter();
        mainView = new MainView();
        addListener();
    }
    
    public Controller(String fileLocation) throws IOException {
        this.fileLocation = fileLocation;
        initializeWriter();
        mainView = new MainView();
        addListener();
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
    public boolean deleteFile() throws IOException {
        return writer.deleteFile();
    }
    
    private void initializeWriter() throws IOException {
        writer = new CSVManager(fileLocation);
    }

    public MainView getMainView() {
        return mainView;
    }
    
     public void addListener() {
        mainView.btnNewPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fn, ln, dob, email, city, street, bus;
                int number, zc;
                number = -1;
                zc = -1;
                bus ="";
                
                fn = mainView.txtFirstName.getText();
                ln = mainView.txtLastName.getText();
                dob = mainView.txtDob.getText();
                email = mainView.txtEmail.getText();
                
                city = mainView.txtCity.getText();
                street = mainView.txtStreet.getText();
                try {
                    number = Integer.valueOf(mainView.txtNumber.getText());
                } catch (NumberFormatException ex){
                    mainView.txtNumber.setText("");
                    mainView.showMessageBox("Gelieve een geldig nummer in te geven", "Geen geldig nummer!",true);
                }
                
                try {
                    zc = Integer.valueOf(mainView.txtZipCode.getText());
                } catch (NumberFormatException ex){
                    mainView.txtZipCode.setText("");
                    mainView.showMessageBox("Gelieve een geldige postcode in te geven", "Geen geldige postcode!",true);
                }
                
                Person personToAdd = null;
                        
                try {
                    personToAdd = createPersonWithAddress(fn, ln, email, dob, city, street, number, zc, bus);
                    try {
                        writeToFile(personToAdd);
                        clearTextBoxes();
                        mainView.showMessageBox("Uw gegevens zijn toegevoegd!\nBedankt!\n\nEn nu pinten gaan drinken, komaan!" , "Okidoki!", false);
                    } catch (IOException ex) {
                        mainView.showMessageBox("Oeps, er ging iets mis." + ex.getMessage(), "Onverwachte fout", true);
                    }
                } catch (BadAddressException | IncompletePersonException ex) {
                    if(ex.getClass() == BadAddressException.class) {
                        mainView.showMessageBox(ex.getMessage(), "Fout in adres!",true);
                    } else if(ex.getClass() == IncompletePersonException.class) {
                        mainView.showMessageBox(ex.getMessage(), "Fout in persoonlijke info!",true);
                    }
                }  
            }
        });
    }
     
    public void clearTextBoxes() {
        mainView.txtFirstName.setText("");
        mainView.txtLastName.setText("");
        mainView.txtDob.setText("");
        mainView.txtEmail.setText("");
        mainView.txtCity.setText("");
        mainView.txtStreet.setText("");
        mainView.txtNumber.setText("");
        mainView.txtZipCode.setText("");
        mainView.txtBus.setText("");   
    }
    
}
