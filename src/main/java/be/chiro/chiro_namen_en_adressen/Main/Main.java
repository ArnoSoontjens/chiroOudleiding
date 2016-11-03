
package be.chiro.chiro_namen_en_adressen.Main;

import be.chiro.chiro_namen_en_adressen.services.Controller;
import be.chiro.chiro_namen_en_adressen.views.MainView;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Arno
 */
public class Main extends JFrame {
    
    public static void main(String[] args) throws IOException {
        JFrame frame = new Main();
        
        Controller controller = new Controller();
        
        frame.setContentPane(controller.getMainView());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
