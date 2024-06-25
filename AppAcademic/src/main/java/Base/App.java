/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Base;

import View.LoginFrame;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;

/**
 *
 * @author LOZADA
 */  
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        UIManager.put( "Button.arc", 25 );
        
        LoginFrame login= new LoginFrame();
        
     
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
}
