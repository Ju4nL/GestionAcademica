package Controller;
// Model

import Model.VacantModel;

// View
import View.ParentsPanelVacants;
import View.VacantTableModel;

// Utils
import java.util.List;

public class VacantController {

    private ParentController principalController;
    private VacantModel vacantModel;
    private ParentsPanelVacants parentsVacants;

    public VacantController(ParentController principalController, VacantModel vacanteModel, ParentsPanelVacants parentsVacants) {
        this.principalController = principalController;
        this.vacantModel = vacanteModel;
        this.parentsVacants = parentsVacants;
        initController();
    }

    public void initController() {
        parentsVacants.getBtnActualizar().addActionListener(e -> actualizarVacantes());
        parentsVacants.getBtnBuscar().addActionListener(e -> buscarPorGrado());
        parentsVacants.getBtnSolicitar().addActionListener(e -> solicitarVacante());
        loadVacantes();
    }

    public void loadVacantes() {
        List<String[]> data = vacantModel.getVacantes();
        parentsVacants.cargarVacantes(data); // Llama a cargarVacantes en ParentsPanelVacants
        // Mensaje de depuración
        System.out.println("Datos cargados en la tabla: " + data.size() + " registros.");
    }

    private void actualizarVacantes() {

    }

    private void buscarPorGrado() {

    }

    private void solicitarVacante() {
        int selectedRow = parentsVacants.getTblVacantes().getSelectedRow();
        if (selectedRow == -1) {
            parentsVacants.displayErrorMessage("Por favor, selecciona una vacante");
            return;
        }

        int vacanteId = Integer.parseInt(parentsVacants.getTblVacantes().getValueAt(selectedRow, 0).toString());
        String grado = parentsVacants.getTblVacantes().getValueAt(selectedRow, 1).toString();
        String seccion   = parentsVacants.getTblVacantes().getValueAt(selectedRow, 2).toString();

        principalController.showRegistrarAlumnoForm(vacanteId, grado,seccion);
    }

    public ParentsPanelVacants getVacanteSelectionPanel() {
        return parentsVacants;
    }

}
