package Controller;

import Dao.DocenteDAOImpl;
import Model.Grado;
import Model.Seccion;
import Model.Docente;
import View.AdminPanelDocentes;
import View.AdminPanelDocentesForm;
import java.time.LocalDate;
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

        adminPanelDocentes.getBtnAdd().addActionListener(e -> displayformDocenteCreate());
        adminPanelDocentes.getBtnUpdate().addActionListener(e -> displayformDocenteUpdate());
        adminPanelDocentes.getBtnSearch().addActionListener(e -> searchDocente());
        adminPanelDocentes.getBtnActivar().addActionListener(e -> setDocenteActive(true));
        adminPanelDocentes.getBtnDesactivate().addActionListener(e -> setDocenteActive(false));
        loadDocentes();
    }

    public void loadDocentes() {
        try {
            List<Docente> docentes = docenteDao.getAllDocentes();

            DefaultTableModel model = (DefaultTableModel) adminPanelDocentes.getTblDocentes().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Activo?", "Email", "Telefono", "Tutor Aula"});
            TableColumnModel columnModel = adminPanelDocentes.getTblDocentes().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (Docente docente : docentes) {
                model.addRow(new Object[]{docente.getId(), docente.getNombre(), docente.isActive(), docente.getEmail(), docente.getTelefono(), docente.getTutorAulaNombre()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar docentes: " + e.getMessage());
        }
    }

    private void setDocenteActive(boolean is_Active) {
        int rowIndex = this.adminPanelDocentes.getTblDocentes().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }

        try {
            int docenteId = Integer.parseInt(adminPanelDocentes.getTblDocentes().getValueAt(rowIndex, 0).toString());
            docenteDao.setDocenteActive(docenteId, is_Active);
            principalController.displaySucessMessage("Se actualizo el estado del docente: ");
            loadDocentes();

        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar docente: " + e.getMessage());
        }
    }

    private void displayformDocenteCreate() {
        AdminPanelDocentesForm formCreate = new AdminPanelDocentesForm(true);
        this.principalController.showPanel(formCreate);
        formCreate.getBtnGuardar().addActionListener(e -> addDocente(formCreate));
    }

    private void addDocente(AdminPanelDocentesForm form) {
        Docente docente = new Docente(0,  
                                        form.getTxtName().getText(), 
                                        form.getTxtLastName().getText(),  
                                        form.getTxtDni().getText(), 
                                        form.getCbxSexo().getSelectedItem(), 
                                        LocalDate.MIN, 
                                        form.getTxtPhone().getText(), 
                                        form.getTxtAddress().getText(), 
                                        form.getTxtEmail().getText(), 
                                        form.getTxtEmail().getText(), 
                                        form.getPswPassword().getPassword(), 
                                        'Docente', 
                                        true, tutorAulaNombre);
        try {
            form.getTxtDni().getText();
            form.getTxtName().setText(docente.getNombre());
            form.getTxtLastName().setText(docente.getApellidos());
            form.getJdcFechaNac().setDate(java.sql.Date.valueOf(docente.getFechaNacimiento()));
            form.getCbxSexo().setSelectedItem(docente.getSexo());
            form.getTxtAddress().setText(docente.getDireccion());
            form.getTxtPhone().setText(docente.getTelefono());
            form.getTxtEmail().setText(docente.getEmail());
            form.getPswPassword().setText(docente.getPassword());
            loadDocentes();
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al añadir docente: " + e.getMessage());
        }
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

            formUpdate.getTxtDni().setText(docente.getDni());
            formUpdate.getTxtName().setText(docente.getNombre());
            formUpdate.getTxtLastName().setText(docente.getApellidos());
            formUpdate.getJdcFechaNac().setDate(java.sql.Date.valueOf(docente.getFechaNacimiento()));
            formUpdate.getCbxSexo().setSelectedItem(docente.getSexo());
            formUpdate.getTxtAddress().setText(docente.getDireccion());
            formUpdate.getTxtPhone().setText(docente.getTelefono());
            formUpdate.getTxtEmail().setText(docente.getEmail());
            formUpdate.getPswPassword().setText(docente.getPassword());

            this.principalController.showPanel(formUpdate);
            formUpdate.getBtnGuardar().addActionListener(e -> updateDocente(formUpdate, docente.getId()));

        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar docente: " + e.getMessage());
        }
    }

    private void updateDocente(AdminPanelDocentesForm form, int docenteId) {
    }

    private void searchDocente() {
        String searchTerm = this.adminPanelDocentes.getTxtSearch().getText();
        try {
            List<Docente> docentes = docenteDao.getDocentesByName(searchTerm);

            DefaultTableModel model = (DefaultTableModel) adminPanelDocentes.getTblDocentes().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Activo?", "Email", "Telefono", "Tutor Aula"});
            TableColumnModel columnModel = adminPanelDocentes.getTblDocentes().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (Docente docente : docentes) {
                model.addRow(new Object[]{docente.getId(), docente.getNombre(), docente.isActive(), docente.getEmail(), docente.getTelefono(), docente.getTutorAulaNombre()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar docentes: " + e.getMessage());
        }
    }

    /*
    

 
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

    

    /*
     */
}
