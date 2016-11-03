
package be.chiro.chiro_namen_en_adressen.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    private JLabel lblUitleg, lblPersonalInfo, lblAddress;
    private JLabel lblFirstName, lblLastName, lblEmail,lblDob;
    private JLabel lblCity, lblZipCode, lblStreet, lblNumber,lblBus;
    private JLabel dummy;
    private JButton btnNewPerson;
    private JPanel mainPanel, inputPanel, northPanel;
    private BorderLayout borderLayout;
    private GridLayout gridLayout;
    private JLabel imageContainer;
    private BufferedImage chiroBanner;
    
    public MainView() {
        initializeComponents();
        setUpPanel();
    }
    
    private void setUpPanel() {
        
        this.add(mainPanel);
        northPanel.add(imageContainer);
        northPanel.add(lblUitleg);
        
        inputPanel.add(dummy);
        inputPanel.add(lblPersonalInfo);
        inputPanel.add(dummy);
        inputPanel.add(lblFirstName);
        inputPanel.add(txtFirstName);
        inputPanel.add(lblLastName);
        inputPanel.add(txtLastName);
        inputPanel.add(lblEmail);
        inputPanel.add(txtEmail);
        inputPanel.add(lblDob);
        inputPanel.add(txtDob);
        inputPanel.add(lblAddress);
        inputPanel.add(dummy);
        inputPanel.add(lblCity);
        inputPanel.add(txtCity);
        inputPanel.add(lblZipCode);
        inputPanel.add(txtZipCode);
        inputPanel.add(lblStreet);
        inputPanel.add(txtStreet);
        inputPanel.add(lblNumber);
        inputPanel.add(txtNumber);
        inputPanel.add(lblBus);
        inputPanel.add(txtBus);
        
        inputPanel.add(btnNewPerson);
        
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel,BorderLayout.CENTER);
    }
    
    private void initializeComponents() {
        
        try {
            chiroBanner = ImageIO.read(new File("icon.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + " - chiroBanner Image not found");
        }
        imageContainer = new JLabel();    
        imageContainer.setIcon(new ImageIcon(chiroBanner));
        
        borderLayout = new BorderLayout(15, 15);
        gridLayout = new GridLayout(12, 2);
        
        txtFirstName = new JTextField(20);
        txtLastName = new JTextField(20);
        txtEmail = new JTextField(30);
        txtCity = new JTextField(15);
        txtZipCode = new JTextField(5);
        txtStreet = new JTextField(20);
        txtNumber = new JTextField(5);
        txtBus = new JTextField(5);
        txtDob = new JTextField(10);
        
        lblUitleg = new JLabel("Om ons leden en oud-leiding bestand up-to-date te houden \nvragen we jullie om hier snel even je gegevens in te vullen,"
                + " zodat we jullie voor volgende evenementen ook snel en efficiënt kunnen bereiken!\n"
                + "Hartelijk bedankt!\n"
                + "\n"
                + "Chiro Noorderwijk");
        lblPersonalInfo = new JLabel("Persoonlijke gegevens");
        lblAddress = new JLabel("Adres gegevens");
        
        lblFirstName = new JLabel("Voornaam:");
        lblLastName = new JLabel("Naam:");
        lblEmail = new JLabel("E-mail adres:");
        lblCity = new JLabel("Stad:");
        lblZipCode = new JLabel("Postcode:");
        lblStreet = new JLabel("Straat:");
        lblNumber = new JLabel("Huisnummer:");
        lblBus = new JLabel("Bus:");
        lblDob = new JLabel("Geboortedatum:");
        dummy = new JLabel("");
        
        btnNewPerson = new JButton("Toevoegen!");
        
        mainPanel = new JPanel(borderLayout);
        northPanel = new JPanel();
        inputPanel = new JPanel(gridLayout);
        
    }
}
