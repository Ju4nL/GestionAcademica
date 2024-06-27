 
package Base;
//Controller
import Controller.LoginController;
import Model.LoginModel;
import View.AdminHomeFrame;
import View.LoginFrame;
import View.ParentsHomeFrame;
import View.RegisterFrame;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;
  
public class App implements AppInterface {
        
        private static App instancia = new App();
        
        public static App getInstancia() {
            return instancia;
        }
        
        public static void main(String[] args) {
        FlatMacLightLaf.setup();
        UIManager.put( "Button.arc", 25 );
        
        java.awt.EventQueue.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            LoginModel loginModel = new LoginModel();
            new LoginController (loginFrame, loginModel, new App());
            loginFrame.setVisible(true);
        });
                
    }
        
    @Override
    public void onLoginSuccess(int usuarioID, String role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onLoginFailed(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onLogout(int usuarioID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onRegisterSuccess(int usuarioID, String role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onRegisterFailed(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
    
}
