
package be.chiro.chiro_namen_en_adressen.Main;

import be.chiro.chiro_namen_en_adressen.views.MainView;
import javax.swing.JFrame;

/**
 *
 * @author Arno
 */
public class Main{
    
    public static void main(String[] args) {
        MainView mainView = new MainView();
        JFrame frame = new JFrame();
        
        frame.setContentPane(mainView);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
