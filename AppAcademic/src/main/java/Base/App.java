package Base;
//Controller

import Controller.CursoController;
import Controller.LoginController;
import Controller.PrincipalController;
import Model.LoginModel;
import View.AdminHomeFrame;
import View.LoginFrame;
import View.ParentsHomeFrame;
import View.RegisterFrame;
import View.StudentHomeFrame;
import View.TeacherHomeFrame;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

public class App implements AppInterface {

    private static App instancia = new App();

    public static App getInstancia() {
        return instancia;
    }

    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        UIManager.put("Button.arc", 25);

        java.awt.EventQueue.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            LoginModel loginModel = new LoginModel();
            new LoginController(loginFrame, loginModel, new App());
            loginFrame.setVisible(true);
        });

    }

    @Override
    public void onLoginSuccess(int usuarioID, String role) {
        switch (role) {
            case "padre":
                launchParentsInterface(usuarioID);
                break;
            case "admin":
                launchAdminInterface(usuarioID, role);
                break;
            case "alumno":
                launchStudentInterface(usuarioID);
                break;
            case "tutor":
                launchTeacherInterface(usuarioID);
                break;
            default:
                throw new UnsupportedOperationException("Role no encontrado: " + role);
        }
    }
    
    private void launchParentsInterface(int usuarioID) {
        ParentsHomeFrame parentsHomeFrame = new ParentsHomeFrame();
        // Aquí puedes inicializar los controladores y modelos necesarios para la interfaz de los padres

        parentsHomeFrame.setVisible(true);

    }

    private void launchAdminInterface(int usuarioID, String role) {
        AdminHomeFrame adminHomeFrame = new AdminHomeFrame();
        System.out.println("iniciar admin");
        PrincipalController principalController = new PrincipalController(adminHomeFrame);
        adminHomeFrame.setController(principalController); // Asignar el controlador principal a la ventana
        adminHomeFrame.setVisible(true);
        principalController.showCursoPanel(); // Mostrar el panel de cursos al iniciar sesión
    }

    private void launchStudentInterface(int usuarioID) {
        StudentHomeFrame alumnoHomeFrame = new StudentHomeFrame();
        // Aquí puedes inicializar los controladores y modelos necesarios para la interfaz de los alumnos
        alumnoHomeFrame.setVisible(true);
    }

    private void launchTeacherInterface(int usuarioID) {
        TeacherHomeFrame profesorHomeFrame = new TeacherHomeFrame();
        // Aquí puedes inicializar los controladores y modelos necesarios para la interfaz de los profesores
        profesorHomeFrame.setVisible(true);
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
