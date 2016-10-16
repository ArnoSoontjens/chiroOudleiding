
package be.chiro.chiro_namen_en_adressen.Main;

import be.chiro.chiro_namen_en_adressen.views.MainView;
import javax.swing.JFrame;

/**
 *
 * @author Arno
 */
public class Main extends JFrame {
    
    public static void main(String[] args) {
        JFrame frame = new Main();

        frame.setContentPane(new MainView());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
