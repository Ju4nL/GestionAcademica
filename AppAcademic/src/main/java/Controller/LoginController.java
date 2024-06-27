
package Controller;
//Base
import Base.AppInterface;

//Model
import Model.LoginModel;

//View
import View.LoginFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginFrame loginView;
    private LoginModel loginmodel;
    private AppInterface appInterface;

    public LoginController(LoginFrame loginView, LoginModel loginmodel, AppInterface appInterface) {
        this.loginView = loginView;
        this.loginmodel = loginmodel;
        this.appInterface = appInterface;
    }

    private boolean validarUsuario(String username) {
        return username != null && !username.trim().isEmpty();
    }
    
    private boolean validarPassword(String password) {
        return password != null && password.length() >=6;
    }
    
    class LoginListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getTxtUsername().getText();
            char[] passwordArray = loginView.getPswPassword().getPassword();
            
            try {
                String password = new String(passwordArray);
                
                if (!validarUsuario(username)) {
                    loginView.displayErrorMessage("\"El nombre de usuario no puede estar vacio");
                    return;
                }
                
                if (!validarPassword(password)) {
                    loginView.displayErrorMessage("\"La contraseña debe contener al menos 6 caracteres");
                    return;
                }
                String[] loginResult = loginmodel.authenticate(username, password);
                if (loginResult != null) {
                    loginView.setVisible(false);
                    appInterface.onLoginSuccess(Integer.parseInt(loginResult[0]), loginResult[1]);
                } else {
                    loginView.displayErrorMessage("Usuario o Contraseña incorrecta o error de conexion");
                    appInterface.onLoginFailed(username);
                }
                
            } finally {
                java.util.Arrays.fill(passwordArray, '0');
            }
        }
        
        
    }
}
