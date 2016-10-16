
package be.chiro.chiro_namen_en_adressen.views;

import javafx.scene.control.DatePicker;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Arno
 */
public class MainView extends JFrame {
   
    private JTextField txtFirstName, txtLastName, txtEmail,txtDob;
    private JTextField txtCity,txtZipCode, txtStreet, txtNumber, txtBus;
    private JLabel lblFirstName, lblLastname, lblEmail,lblDob;
    private JLabel lblCity, lblZipCode, lblStreet, lblNumber,lblBus;
    private JButton btnNewPerson;
    private JPanel panel;
    private DatePicker dateOfBirth;
    
    public MainView() {
        initializeComponents();
        setUpPanel();
        setUpFrame();
    }
    
    private void setUpFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        setVisible(true);
    }
    
    private void setUpPanel() {
        panel.add(lblFirstName);
        panel.add(txtFirstName);
        panel.add(lblLastname);
        panel.add(txtLastName);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblDob);
        panel.add(dateOfBirth);
    }
    
    private void initializeComponents() {
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtEmail = new JTextField();
        txtCity = new JTextField();
        txtZipCode = new JTextField();
        txtStreet = new JTextField();
        txtNumber = new JTextField();
        txtBus = new JTextField();
        
        lblFirstName = new JLabel("Voornaam:");
        lblLastname = new JLabel("Naam:");
        lblEmail = new JLabel("E-mail adres:");
        lblCity = new JLabel("Stad:");
        lblZipCode = new JLabel("Postcode:");
        lblStreet = new JLabel("Straat:");
        lblNumber = new JLabel("Huisnummer:");
        lblBus = new JLabel("Bus:");
        
        dateOfBirth = new DatePicker();
        
        btnNewPerson = new JButton("Toevoegen!");
        
        panel = new JPanel();
    }
}
