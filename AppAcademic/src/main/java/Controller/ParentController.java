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
    private ParentsPanelVacants panelVacantes;
    private RegistrarAlumnoController registrarAlumnoController;
    private SolicitudesController solicitudController;
    private int id;

    public ParentController(ParentsHomeFrame parentsHomeFrame, VacantModel vacanteModel, int id) {
        this.principalFrame = parentsHomeFrame;
        this.principalFrame.setController(this);
        this.vacanteModel = vacanteModel;
        
        this.id = id;
        System.out.println(id);
        this.panelVacantes = new ParentsPanelVacants(); 
        initController();
    }

    public int getId() {
        return id;
    }

    public void initController() {
        vacantController = new VacantController(this);
        principalFrame.getBtnVacantes().addActionListener(e -> vacantController.loadVacantes());
        
        registrarAlumnoController = new RegistrarAlumnoController(this);
        
        solicitudController = new SolicitudesController(this, id);
        principalFrame.getBtnSolicitudes().addActionListener(e -> solicitudController.loadSolicitudes());
        
        principalFrame.getBtnCerrarSesion().addActionListener(e -> cerrarSesion());

    }
   

    public void showPanel(JPanel panel) {
        principalFrame.getContentPanel().removeAll();
        principalFrame.getContentPanel().add(panel, BorderLayout.CENTER);
        principalFrame.getContentPanel().revalidate();
        principalFrame.getContentPanel().repaint();

    }
    
    public void showVacantePanel() { 
        showPanel(vacantController.getParentsPanelVacants());
        principalFrame.getBtnVacantes().setBackground(new Color(240, 243, 253));
        principalFrame.getBtnSolicitudes().setBackground(new Color(255, 255, 255));     
    }
    
    public void showRegistrarAlumnoForm(int vacanteId, String grado,String seccion) {
        registrarAlumnoController.displayRegistrarAlumnoForm(vacanteId, grado,seccion);
    }
    
    public void showSolicitudesPanel() { 
        showPanel(solicitudController.getPanelSolicitudes());
        principalFrame.getBtnVacantes().setBackground(new Color(255, 255, 255));
        principalFrame.getBtnSolicitudes().setBackground(new Color(240, 243, 253));
         
    }

    public void cerrarSesion() {
        principalFrame.dispose();
    }

}
