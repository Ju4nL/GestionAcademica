 
package Base;
 
import View.AdminHomeFrame;
import View.LoginFrame;
import View.ParentsHomeFrame;
import View.RegisterFrame;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;
  
public class App {
 
    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        UIManager.put( "Button.arc", 25 );
        
        AdminHomeFrame login= new AdminHomeFrame();
        
     
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
}
