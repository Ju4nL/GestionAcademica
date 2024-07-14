package Controller;

// Model
import Model.VacantModel;

// View
import View.ParentsHomeFrame;
import View.ParentsPanelVacants;
import View.VacantTableModel;

// Utils
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class ParentController {

    private ParentsHomeFrame principalFrame;
    private VacantModel vacanteModel;
    private VacantController vacantController;
    private ParentsPanelVacants parentsVacants;
    private RegistrarAlumnoController registrarAlumnoController;
    private int id;

    public ParentController(ParentsHomeFrame parentsHomeFrame, VacantModel vacanteModel, int id) {
        this.principalFrame = parentsHomeFrame;
        this.vacanteModel = vacanteModel;
        this.id = id;
        this.parentsVacants = new ParentsPanelVacants(); // Inicializar ParentsPanelVacants
        initController();
    }

    public void initController() {
        vacantController = new VacantController(this, vacanteModel, parentsVacants);
        registrarAlumnoController = new RegistrarAlumnoController(this);
        principalFrame.getBtnVacantes().addActionListener(e -> {
            principalFrame.ShowJPanel(parentsVacants);  // Muestra el panel
            vacantController.loadVacantes();  // Carga las vacantes
        });
        principalFrame.getBtnCerrarSesion().addActionListener(e -> cerrarSesion());
        principalFrame.getBtnSolicitudes().addActionListener(e -> verSolicitudes());
    }
   

    public void showPanel(JPanel panel) {
        principalFrame.setContentPane(panel);
        principalFrame.revalidate();
    }
    
    public void showRegistrarAlumnoForm(int vacanteId, String grado,String seccion) {
        registrarAlumnoController.displayRegistrarAlumnoForm(vacanteId, grado,seccion);
    }

    public void cerrarSesion() {
        principalFrame.dispose();
    }

    public void verSolicitudes() {

    }

}
