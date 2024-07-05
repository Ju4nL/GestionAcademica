package Controller;

import Dao.DocenteDAOImpl;
import Model.Grado;
import Model.Seccion;
import Model.Docente;
import View.AdminPanelDocentes;
/*import View.AdminPanelDocentesForm;*/
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class DocenteController {

    private AdminController principalController;
    private DocenteDAOImpl docenteDao;
    private AdminPanelDocentes adminPanelDocentes;

    public DocenteController(AdminController principalController) {
        this.principalController = principalController;
        this.docenteDao = new DocenteDAOImpl();
        this.adminPanelDocentes = new AdminPanelDocentes(this);
        initController();
    }

    public AdminPanelDocentes getAdminPanelDocentes() {
        return adminPanelDocentes;
    }

    private void initController() {
/*
        adminPanelDocentes.getBtnAdd().addActionListener(e -> displayformDocenteCreate());
        adminPanelDocentes.getBtnUpdate().addActionListener(e -> displayformDocenteUpdate());
        
        adminPanelDocentes.getBtnSearch().addActionListener(e -> searchDocente()); 
        adminPanelDocentes.getBtnDelete().addActionListener(e -> deleteDocente());*/
        loadDocentes();
    }

    public void loadDocentes() {
        try {
            List<Docente> docentes = docenteDao.getAllDocentes();

            DefaultTableModel model = (DefaultTableModel) adminPanelDocentes.getTblDocentes().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Grado", "Seccion", "cupoDisponible"});
            TableColumnModel columnModel = adminPanelDocentes.getTblDocentes().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (Docente docente : docentes) {
                model.addRow(new Object[]{docente.getId(), docente.get().getNombre(), docente.getSeccion().getNombre(), docente.getCupoDisponible()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar docentes: " + e.getMessage());
        }
    }
    
    /*
    private void displayformDocenteCreate() {
        AdminPanelDocentesForm formCreate = new AdminPanelDocentesForm(false);
        fillComboBoxes(formCreate);
        this.principalController.showPanel(formCreate);
        formCreate.getBtnSave().addActionListener(e -> addDocente(formCreate));
    }

    private void displayformDocenteUpdate() {
        int rowIndex = this.adminPanelDocentes.getTblDocentes().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }

        try {
            int docenteId = Integer.parseInt(adminPanelDocentes.getTblDocentes().getValueAt(rowIndex, 0).toString());
            Docente docente = docenteDao.getDocenteById(docenteId);

            if (docente == null) {
                principalController.displayErrorMessage("No se pudo encontrar la docente seleccionada.");
                return;
            }

            AdminPanelDocentesForm formUpdate = new AdminPanelDocentesForm(true);
            fillComboBoxes(formUpdate);

            formUpdate.getCbxGrado().setSelectedItem(docente.getGrado());
            formUpdate.getCbxSeccion().setSelectedItem(docente.getSeccion());
            formUpdate.getSpCupoDisponible().setValue(docente.getCupoDisponible());

            this.principalController.showPanel(formUpdate);
            formUpdate.getBtnSave().addActionListener(e -> updateDocente(formUpdate, docente.getID()));

        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar docente: " + e.getMessage());
        }
    }

    private void fillComboBoxes(AdminPanelDocentesForm form) {
        List<Grado> grados = docenteDao.getAllGrados();
        List<Seccion> secciones = docenteDao.getAllSecciones();

        form.getCbxGrado().removeAllItems();
        form.getCbxSeccion().removeAllItems();

        for (Grado grado : grados) {
            form.getCbxGrado().addItem(grado);
        }

        for (Seccion seccion : secciones) {
            form.getCbxSeccion().addItem(seccion);
        }
    }

    private void addDocente(AdminPanelDocentesForm form) {
        try {
            Grado grado = (Grado) form.getCbxGrado().getSelectedItem();
            Seccion seccion = (Seccion) form.getCbxSeccion().getSelectedItem();
            int cupoDisponible = (int) form.getSpCupoDisponible().getValue();

            Docente docente = new Docente(0, grado, seccion, cupoDisponible);
            docenteDao.insertDocente(docente);

            principalController.displaySucessMessage("Docente añadida con éxito");
            principalController.showDocentePanel();
            loadDocentes();
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al añadir docente: " + e.getMessage());
        }
    }

    private void updateDocente(AdminPanelDocentesForm form, int docenteId) {
        try {
            Grado grado = (Grado) form.getCbxGrado().getSelectedItem();
            Seccion seccion = (Seccion) form.getCbxSeccion().getSelectedItem();
            int cupoDisponible = (int) form.getSpCupoDisponible().getValue();

            Docente docente = new Docente(docenteId, grado, seccion, cupoDisponible);
            docenteDao.updateDocente(docente);
            principalController.displaySucessMessage("Docente actualizada con éxito");
            principalController.showDocentePanel();
            loadDocentes();        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar docente: " + e.getMessage());
        }
    }

    private void deleteDocente() {
        System.out.println("Delete");
        try {
            for (int row : this.adminPanelDocentes.getTblDocentes().getSelectedRows()) {
                int id = (int) this.adminPanelDocentes.getTblDocentes().getValueAt(row, 0);
                if (docenteDao.deleteDocente(id)) {
                    this.principalController.displaySucessMessage("Se elimino el id " + id);
                } else {
                    this.principalController.displayErrorMessage("Falló al eliminar el id " + id);
                }
            }
        } catch (Exception e) {
            this.principalController.displayErrorMessage("Ocurrio un error");
        } finally {
            loadDocentes();
        }
    }

    /*
    private void searchDocente() {
        String searchTerm = this.adminPanelDocentes.getTxtSearch().getText(); 
        try {
            List<Docente> docentes = docenteDao.getDocentesByName(searchTerm);

            DefaultTableModel model = (DefaultTableModel) adminPanelDocentes.getTblDocentes().getModel();
            model.setRowCount(0);
            for (Docente docente : docentes) {
                model.addRow(new Object[]{docente.getID(), docente.getNombre(), docente.getDescripcion()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar docentes: " + e.getMessage());
        }
    }*/
}
