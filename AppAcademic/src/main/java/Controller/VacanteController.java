package Controller;

import Dao.VacanteDAOImpl;
import Model.Grado;
import Model.Seccion;
import Model.Vacante;
import View.AdminPanelVacantes;
import View.AdminPanelVacantesForm;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class VacanteController {

    private AdminController principalController;
    private VacanteDAOImpl vacanteDao;
    private AdminPanelVacantes adminPanelVacantes;

    public VacanteController(AdminController principalController) {
        this.principalController = principalController;
        this.vacanteDao = new VacanteDAOImpl();
        this.adminPanelVacantes = new AdminPanelVacantes(this);
        initController();
    }

    public AdminPanelVacantes getAdminPanelVacantes() {
        return adminPanelVacantes;
    }

    private void initController() {

        adminPanelVacantes.getBtnAdd().addActionListener(e -> displayformVacanteCreate());
        adminPanelVacantes.getBtnUpdate().addActionListener(e -> displayformVacanteUpdate());
        /*
        adminPanelVacantes.getBtnSearch().addActionListener(e -> searchVacante()); */
        adminPanelVacantes.getBtnDelete().addActionListener(e -> deleteVacante());
        loadVacantes();
    }

    public void loadVacantes() {
        try {
            List<Vacante> vacantes = vacanteDao.getAllVacantes();

            DefaultTableModel model = (DefaultTableModel) adminPanelVacantes.getTblVacantes().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Grado", "Seccion", "cupoDisponible"});
            TableColumnModel columnModel = adminPanelVacantes.getTblVacantes().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (Vacante vacante : vacantes) {
                model.addRow(new Object[]{vacante.getID(), vacante.getGrado().getNombre(), vacante.getSeccion().getNombre(), vacante.getCupoDisponible()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar vacantes: " + e.getMessage());
        }
    }

    private void displayformVacanteCreate() {
        AdminPanelVacantesForm formCreate = new AdminPanelVacantesForm(false);
        fillComboBoxes(formCreate);
        this.principalController.showPanel(formCreate);
        formCreate.getBtnSave().addActionListener(e -> addVacante(formCreate));
    }

    private void displayformVacanteUpdate() {
        int rowIndex = this.adminPanelVacantes.getTblVacantes().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }

        try {
            int vacanteId = Integer.parseInt(adminPanelVacantes.getTblVacantes().getValueAt(rowIndex, 0).toString());
            Vacante vacante = vacanteDao.getVacanteById(vacanteId);

            if (vacante == null) {
                principalController.displayErrorMessage("No se pudo encontrar la vacante seleccionada.");
                return;
            }

            AdminPanelVacantesForm formUpdate = new AdminPanelVacantesForm(true);
            fillComboBoxes(formUpdate);

            formUpdate.getCbxGrado().setSelectedItem(vacante.getGrado());
            formUpdate.getCbxSeccion().setSelectedItem(vacante.getSeccion());
            formUpdate.getSpCupoDisponible().setValue(vacante.getCupoDisponible());

            this.principalController.showPanel(formUpdate);
            formUpdate.getBtnSave().addActionListener(e -> updateVacante(formUpdate, vacante.getID()));

        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar vacante: " + e.getMessage());
        }
    }

    private void fillComboBoxes(AdminPanelVacantesForm form) {
        List<Grado> grados = vacanteDao.getAllGrados();
        List<Seccion> secciones = vacanteDao.getAllSecciones();

        form.getCbxGrado().removeAllItems();
        form.getCbxSeccion().removeAllItems();

        for (Grado grado : grados) {
            form.getCbxGrado().addItem(grado);
        }

        for (Seccion seccion : secciones) {
            form.getCbxSeccion().addItem(seccion);
        }
    }

    private void addVacante(AdminPanelVacantesForm form) {
        try {
            Grado grado = (Grado) form.getCbxGrado().getSelectedItem();
            Seccion seccion = (Seccion) form.getCbxSeccion().getSelectedItem();
            int cupoDisponible = (int) form.getSpCupoDisponible().getValue();

            Vacante vacante = new Vacante(0, grado, seccion, cupoDisponible);
            vacanteDao.insertVacante(vacante);

            principalController.displaySucessMessage("Vacante añadida con éxito");
            principalController.showVacantePanel();
            loadVacantes();
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al añadir vacante: " + e.getMessage());
        }
    }

    private void updateVacante(AdminPanelVacantesForm form, int vacanteId) {
        try {
            Grado grado = (Grado) form.getCbxGrado().getSelectedItem();
            Seccion seccion = (Seccion) form.getCbxSeccion().getSelectedItem();
            int cupoDisponible = (int) form.getSpCupoDisponible().getValue();

            Vacante vacante = new Vacante(vacanteId, grado, seccion, cupoDisponible);
            vacanteDao.updateVacante(vacante);
            principalController.displaySucessMessage("Vacante actualizada con éxito");
            principalController.showVacantePanel();
            loadVacantes();        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar vacante: " + e.getMessage());
        }
    }

    private void deleteVacante() {
        System.out.println("Delete");
        try {
            for (int row : this.adminPanelVacantes.getTblVacantes().getSelectedRows()) {
                int id = (int) this.adminPanelVacantes.getTblVacantes().getValueAt(row, 0);
                if (vacanteDao.deleteVacante(id)) {
                    this.principalController.displaySucessMessage("Se elimino el id " + id);
                } else {
                    this.principalController.displayErrorMessage("Falló al eliminar el id " + id);
                }
            }
        } catch (Exception e) {
            this.principalController.displayErrorMessage("Ocurrio un error");
        } finally {
            loadVacantes();
        }
    }

    /*
    private void searchVacante() {
        String searchTerm = this.adminPanelVacantes.getTxtSearch().getText(); 
        try {
            List<Vacante> vacantes = vacanteDao.getVacantesByName(searchTerm);

            DefaultTableModel model = (DefaultTableModel) adminPanelVacantes.getTblVacantes().getModel();
            model.setRowCount(0);
            for (Vacante vacante : vacantes) {
                model.addRow(new Object[]{vacante.getID(), vacante.getNombre(), vacante.getDescripcion()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar vacantes: " + e.getMessage());
        }
    }*/
}
