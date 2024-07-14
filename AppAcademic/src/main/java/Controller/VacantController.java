package Controller;
// Model

import Model.VacantModel;

// View
import View.ParentsPanelVacants;
import View.ParentsPanelVacantsForm;
import View.VacantTableModel;

// Utils
import java.util.List;

public class VacantController {

    private ParentController principalController;
    private VacantModel vacantModel;
    private ParentsPanelVacants parentsPanelVacants;

    public VacantController(ParentController principalController) {
        this.principalController = principalController;
        this.vacantModel = new VacantModel();
        this.parentsPanelVacants = new ParentsPanelVacants();
        initController();
    }
    
    public ParentsPanelVacants getParentsPanelVacants(){
        return parentsPanelVacants;
    }

    public void initController() {
        parentsPanelVacants.getBtnActualizar().addActionListener(e -> actualizarVacantes());
        parentsPanelVacants.getBtnBuscar().addActionListener(e -> buscarPorGrado());
        parentsPanelVacants.getBtnSolicitar().addActionListener(e -> displayformCursoCreate());
        loadVacantes();
    }

    public void loadVacantes() {
        List<String[]> data = vacantModel.getVacantes();
        parentsPanelVacants.cargarVacantes(data); // Llama a cargarVacantes en ParentsPanelVacants
        

    // Mensaje de depuración
        System.out.println("Datos cargados en la tabla: " + data.size() + " registros.");
    }

    private void actualizarVacantes() {

    }

    private void buscarPorGrado() {

    }
    
    private void displayformCursoCreate() {
        int selectedRow = parentsPanelVacants.getTblVacantes().getSelectedRow();
        if (selectedRow == -1) {
            parentsPanelVacants.displayErrorMessage("Por favor, selecciona una vacante");
            return;
        }

        int vacanteId = Integer.parseInt(parentsPanelVacants.getTblVacantes().getValueAt(selectedRow, 0).toString());
        String grado = parentsPanelVacants.getTblVacantes().getValueAt(selectedRow, 1).toString();
        String seccion   = parentsPanelVacants.getTblVacantes().getValueAt(selectedRow, 2).toString();
        
        principalController.showRegistrarAlumnoForm(vacanteId, grado,seccion);
    }

    public ParentsPanelVacants getVacanteSelectionPanel() {
        return parentsPanelVacants;
    }

}
