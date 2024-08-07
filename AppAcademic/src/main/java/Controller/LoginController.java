package Controller;
//Base

import Base.AppInterface;
import Dao.ApoderadoDAOImpl;

//Model
import Model.LoginModel;

//View
import View.LoginFrame;
import View.RegisterFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class LoginController {

    private LoginFrame loginView;
    private LoginModel loginmodel;
    private AppInterface appInterface;
    private RegistrarApoderadoController registrarApoderadoController;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@jgp\\.edu\\.pe$");

    public LoginController(LoginFrame loginView, LoginModel loginmodel, AppInterface appInterface) {
        this.loginView = loginView;
        this.loginmodel = loginmodel;
        this.appInterface = appInterface;
        this.loginView.setLoginAction(new LoginAction());
        this.loginView.setRegisterAction(new RegisterAction());
    }

    private boolean validarUsuario(String username) {
        return username != null && !username.trim().isEmpty() && EMAIL_PATTERN.matcher(username).matches();
    }

    private boolean validarPassword(String password) {
        return password != null && password.length() >= 6;
    }

    class LoginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Validar ingreso");
            String username = loginView.getTxtUsername().getText();
            char[] passwordArray = loginView.getPswPassword().getPassword();

            try {
                String password = new String(passwordArray);

                if (username == null || username.trim().isEmpty()) {
                    loginView.displayErrorMessage("\"El nombre de usuario no puede estar vacio");
                    return;
                }
                if (!validarUsuario(username)) {
                    loginView.displayErrorMessage("El nombre de usuario debe ser un correo válido con la extensión @jgp.edu.pe");
                    return;
                }

                if (!validarPassword(password)) {
                    loginView.displayErrorMessage("\"La contraseña debe contener al menos 6 caracteres");
                    return;
                }

                System.out.println("Autenticando usuario: " + username);
                String[] loginResult = loginmodel.authenticate(username, password);

                if (loginResult != null) {
                    System.out.println("Autenticación exitosa. Usuario ID: " + loginResult[0] + ", Rol: " + loginResult[1]);
                    loginView.setVisible(false);

                    appInterface.onLoginSuccess(Integer.parseInt(loginResult[0]), loginResult[1]);

                } else {
                    System.out.println("Autenticación fallida para el usuario: " + username);
                    loginView.displayErrorMessage("Usuario o Contraseña incorrecta o error de conexion");

                    appInterface.onLoginFailed(username);
                }

            } finally {
                java.util.Arrays.fill(passwordArray, '0');
            }
        }

    }

    class RegisterAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            loginView.setVisible(false);


            RegisterFrame registerFrame = new RegisterFrame();
            RegistrarApoderadoController registrarApoderadoController = new RegistrarApoderadoController(registerFrame, new ApoderadoDAOImpl(), 0, loginView);
            registerFrame.setVisible(true);
        }
    }
}
