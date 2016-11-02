
package be.chiro.chiro_namen_en_adressen.views;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Arno
 */
public class MainView extends JPanel {
   
    private JTextField txtFirstName, txtLastName, txtEmail, txtDob;
    private JTextField txtCity,txtZipCode, txtStreet, txtNumber, txtBus;
    private JLabel lblFirstName, lblLastname, lblEmail,lblDob;
    private JLabel lblCity, lblZipCode, lblStreet, lblNumber,lblBus;
    private JButton btnNewPerson;
    private JPanel panel;
    
    public MainView() {
        initializeComponents();
        setUpPanel();
    }
    
    private void setUpPanel() {
        panel.add(lblFirstName);
        panel.add(txtFirstName);
        panel.add(lblLastname);
        panel.add(txtLastName);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblDob);
        panel.add(txtDob);
        panel.add(lblCity);
        panel.add(txtCity);
        panel.add(lblZipCode);
        panel.add(txtZipCode);
        panel.add(lblStreet);
        panel.add(txtStreet);
        panel.add(lblNumber);
        panel.add(txtNumber);
        panel.add(lblBus);
        panel.add(txtBus);
        
        this.add(panel);
    }
    
    private void initializeComponents() {
        txtFirstName = new JTextField(20);
        txtLastName = new JTextField(20);
        txtEmail = new JTextField(30);
        txtCity = new JTextField(15);
        txtZipCode = new JTextField(5);
        txtStreet = new JTextField(20);
        txtNumber = new JTextField(5);
        txtBus = new JTextField(5);
        txtDob = new JTextField(10);
        
        lblFirstName = new JLabel("Voornaam:");
        lblLastname = new JLabel("Naam:");
        lblEmail = new JLabel("E-mail adres:");
        lblCity = new JLabel("Stad:");
        lblZipCode = new JLabel("Postcode:");
        lblStreet = new JLabel("Straat:");
        lblNumber = new JLabel("Huisnummer:");
        lblBus = new JLabel("Bus:");
        lblDob = new JLabel("Geboortedatum:");
        
        btnNewPerson = new JButton("Toevoegen!");
        
        panel = new JPanel();
    }
}
