package Base;
//Controller

import Controller.CursoController;
import Controller.LoginController;
import Controller.AdminController;
import Controller.ParentController;
import Controller.StudentController;
import Controller.TeacherController;
import Model.HorarioStudentModel;
import Model.HorarioTeacherModel;
import Model.LoginModel;
import Model.VacantModel;
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
                System.out.println("Lanzando interfaz para alumno");
                launchStudentInterface(usuarioID);
                break;
            case "docente":
                System.out.println("Lanzando interfaz para docente");
                launchTeacherInterface(usuarioID);
                break;
            default:
                throw new UnsupportedOperationException("Role no encontrado: " + role);
        }
    }
    
    private void launchParentsInterface(int usuarioID) {
        ParentsHomeFrame parentsHomeFrame = new ParentsHomeFrame();
        VacantModel vacantModel = new VacantModel();
        ParentController parentController = new ParentController(parentsHomeFrame, vacantModel, usuarioID);
        parentsHomeFrame.setController(parentController);
        parentController.showVacantePanel();
        parentsHomeFrame.setVisible(true);

    }

    private void launchAdminInterface(int usuarioID, String role) {
        AdminHomeFrame adminHomeFrame = new AdminHomeFrame();
        System.out.println("iniciar admin");
        AdminController principalController = new AdminController(adminHomeFrame);
        adminHomeFrame.setController(principalController); // Asignar el controlador principal a la ventana
        adminHomeFrame.setDefaultCloseOperation(AdminHomeFrame.EXIT_ON_CLOSE);
        adminHomeFrame.pack();
        adminHomeFrame.setVisible(true);
        principalController.showCursoPanel(); // Mostrar el panel de cursos al iniciar sesión
    }

    private void launchStudentInterface(int usuarioID) {
        HorarioStudentModel horarioModel = new HorarioStudentModel();
        StudentHomeFrame studentHomeFrame = new StudentHomeFrame();
        new StudentController(studentHomeFrame, horarioModel, usuarioID);
        
        studentHomeFrame.setVisible(true);
    }

    private void launchTeacherInterface(int usuarioID) {
        HorarioTeacherModel horarioModel = new HorarioTeacherModel();
        TeacherHomeFrame teacherHomeFrame = new TeacherHomeFrame();
        new TeacherController(teacherHomeFrame, horarioModel, usuarioID);
        teacherHomeFrame.setVisible(true);
    }

    @Override
    public void onLoginFailed(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onLogout(int usuarioID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
