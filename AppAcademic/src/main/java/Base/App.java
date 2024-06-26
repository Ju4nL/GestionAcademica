 
package Base;
 
import View.HomeFrame;
import View.LoginFrame;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
  
public class App {
 
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        UIManager.put( "Button.arc", 25 );
        
        HomeFrame login= new HomeFrame();
        
     
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
}
