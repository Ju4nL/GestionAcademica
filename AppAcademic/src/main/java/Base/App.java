/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Base;

import View.LoginFrame;
import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author LOZADA
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        LoginFrame login= new LoginFrame();
        
     
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
}
