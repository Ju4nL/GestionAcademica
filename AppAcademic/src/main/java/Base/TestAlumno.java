package Base;

import Controller.StudentController;
import Model.HorarioModel;
import View.StudentHomeFrame;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TestAlumno {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        FlatMacLightLaf.setup();
        UIManager.put("Button.arc", 25);

        // Crear la vista principal
        StudentHomeFrame studentFrame = new StudentHomeFrame();
        
        // Crear el modelo del horario
        HorarioModel horarioModel = new HorarioModel();
        
        // Crear el controlador del estudiante, pasando la vista y el modelo
        StudentController studentController = new StudentController(studentFrame, horarioModel, 1); // Usando un ID de usuario ficticio
        
        studentFrame.setDefaultCloseOperation(StudentHomeFrame.EXIT_ON_CLOSE);
        studentFrame.pack();
        studentFrame.setVisible(true);

        // Puedes agregar cualquier inicialización adicional que necesites aquí
    }
}
