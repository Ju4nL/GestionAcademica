package Controller;

import Dao.AulaDAOImpl;
import Model.Grado;
import Model.Seccion;
import Model.Aula;
import View.AdminPanelAulas;
import View.AdminPanelAulasForm;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AulaController {

    private AdminController principalController;
    private AulaDAOImpl aulaDao;
    private AdminPanelAulas adminPanelAulas;

    public AulaController(AdminController principalController) {
        this.principalController = principalController;
        this.aulaDao = new AulaDAOImpl();
        this.adminPanelAulas = new AdminPanelAulas(this);
        initController();
    }

    public AdminPanelAulas getAdminPanelAulas() {
        return adminPanelAulas;
    }

    private void initController() {

        /*adminPanelAulas.getBtnAdd().addActionListener(e -> displayformAulaCreate());
        adminPanelAulas.getBtnUpdate().addActionListener(e -> displayformAulaUpdate());
        
        adminPanelAulas.getBtnSearch().addActionListener(e -> searchAula());  
        adminPanelAulas.getBtnDelete().addActionListener(e -> deleteAula());*/
        loadAulas();
    }

    public void loadAulas() {
        try {
            List<Aula> aulas = aulaDao.getAllAulas();

            DefaultTableModel model = (DefaultTableModel) adminPanelAulas.getTblAulas().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Año", "Grado","Sección","Tutor"});
            TableColumnModel columnModel = adminPanelAulas.getTblAulas().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (Aula aula : aulas) {
                model.addRow(new Object[]{aula.getID(), aula.getNombre(),aula.getAnio(),aula.getGrado().getNombre(), aula.getSeccion().getNombre(), aula.getTutor().getNombre()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar aulas: " + e.getMessage());
        }
    }
    /*
    private void displayformAulaCreate() {
        AdminPanelAulasForm formCreate = new AdminPanelAulasForm(false);
        fillComboBoxes(formCreate);
        this.principalController.showPanel(formCreate);
        formCreate.getBtnSave().addActionListener(e -> addAula(formCreate));
    }

    private void displayformAulaUpdate() {
        int rowIndex = this.adminPanelAulas.getTblAulas().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }

        try {
            int aulaId = Integer.parseInt(adminPanelAulas.getTblAulas().getValueAt(rowIndex, 0).toString());
            Aula aula = aulaDao.getAulaById(aulaId);

            if (aula == null) {
                principalController.displayErrorMessage("No se pudo encontrar la aula seleccionada.");
                return;
            }

            AdminPanelAulasForm formUpdate = new AdminPanelAulasForm(true);
            fillComboBoxes(formUpdate);

            formUpdate.getCbxGrado().setSelectedItem(aula.getGrado());
            formUpdate.getCbxSeccion().setSelectedItem(aula.getSeccion());
            formUpdate.getSpCupoDisponible().setValue(aula.getCupoDisponible());

            this.principalController.showPanel(formUpdate);
            formUpdate.getBtnSave().addActionListener(e -> updateAula(formUpdate, aula.getID()));

        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar aula: " + e.getMessage());
        }
    }

    private void fillComboBoxes(AdminPanelAulasForm form) {
        List<Grado> grados = aulaDao.getAllGrados();
        List<Seccion> secciones = aulaDao.getAllSecciones();

        form.getCbxGrado().removeAllItems();
        form.getCbxSeccion().removeAllItems();

        for (Grado grado : grados) {
            form.getCbxGrado().addItem(grado);
        }

        for (Seccion seccion : secciones) {
            form.getCbxSeccion().addItem(seccion);
        }
    }

    private void addAula(AdminPanelAulasForm form) {
        try {
            Grado grado = (Grado) form.getCbxGrado().getSelectedItem();
            Seccion seccion = (Seccion) form.getCbxSeccion().getSelectedItem();
            int cupoDisponible = (int) form.getSpCupoDisponible().getValue();

            Aula aula = new Aula(0, grado, seccion, cupoDisponible);
            aulaDao.insertAula(aula);

            principalController.displaySucessMessage("Aula añadida con éxito");
            principalController.showAulaPanel();
            loadAulas();
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al añadir aula: " + e.getMessage());
        }
    }

    private void updateAula(AdminPanelAulasForm form, int aulaId) {
        try {
            Grado grado = (Grado) form.getCbxGrado().getSelectedItem();
            Seccion seccion = (Seccion) form.getCbxSeccion().getSelectedItem();
            int cupoDisponible = (int) form.getSpCupoDisponible().getValue();

            Aula aula = new Aula(aulaId, grado, seccion, cupoDisponible);
            aulaDao.updateAula(aula);
            principalController.displaySucessMessage("Aula actualizada con éxito");
            principalController.showAulaPanel();
            loadAulas();        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar aula: " + e.getMessage());
        }
    }

    private void deleteAula() {
        System.out.println("Delete");
        try {
            for (int row : this.adminPanelAulas.getTblAulas().getSelectedRows()) {
                int id = (int) this.adminPanelAulas.getTblAulas().getValueAt(row, 0);
                if (aulaDao.deleteAula(id)) {
                    this.principalController.displaySucessMessage("Se elimino el id " + id);
                } else {
                    this.principalController.displayErrorMessage("Falló al eliminar el id " + id);
                }
            }
        } catch (Exception e) {
            this.principalController.displayErrorMessage("Ocurrio un error");
        } finally {
            loadAulas();
        }
    }
 
    private void searchAula() {
        String searchTerm = this.adminPanelAulas.getTxtSearch().getText(); 
        try {
            List<Aula> aulas = aulaDao.getAulasByName(searchTerm);

            DefaultTableModel model = (DefaultTableModel) adminPanelAulas.getTblAulas().getModel();
            model.setRowCount(0);
            for (Aula aula : aulas) {
                model.addRow(new Object[]{aula.getID(), aula.getNombre(), aula.getDescripcion()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar aulas: " + e.getMessage());
        }
    }*/
}
