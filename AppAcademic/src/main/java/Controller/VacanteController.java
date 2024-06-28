package Controller;

import Dao.VacanteDAOImpl;
import Model.Vacante;
import View.AdminPanelVacantes;  
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VacanteController {

    private AdminController principalController;
    private VacanteDAOImpl vacanteDao;
    private AdminPanelVacantes adminPanelVacantes; 

    public VacanteController(AdminController principalController) {
        this.principalController = principalController;
        this.vacanteDao = new VacanteDAOImpl();
        this.adminPanelVacantes = new AdminPanelVacantes(this); 
        /*initController();*/
    }

    public AdminPanelVacantes getAdminPanelVacantes() {
        return adminPanelVacantes;
    }
 /*
    private void initController() {
        adminPanelVacantes.getBtnAdd().addActionListener(e -> displayformVacanteCreate());
        adminPanelVacantes.getBtnUpdate().addActionListener(e -> displayformVacanteUpdate()); 
        adminPanelVacantes.getBtnDelete().addActionListener(e -> deleteVacante()); 
        adminPanelVacantes.getBtnSearch().addActionListener(e -> searchVacante()); 
        loadVacantes();
    }

    public void loadVacantes() {
        try {
            List<Vacante> vacantes = vacanteDao.getAllVacantes();

            DefaultTableModel model = (DefaultTableModel) adminPanelVacantes.getTblVacantes().getModel();
            model.setRowCount(0);
            for (Vacante vacante : vacantes) {
                model.addRow(new Object[]{vacante.getID(), vacante.getNombre(), vacante.getDescripcion()});
            }
        } catch (Exception e) {
            adminPanelVacantes.displayErrorMessage("Error al cargar vacantes: " + e.getMessage());
        }
    }

    private void displayformVacanteCreate() {
        AdminPanelVacantesForm formCreate = new AdminPanelVacantesForm(false);
        this.principalController.showPanel(formCreate);
        formCreate.getBtnSave().addActionListener(e -> addVacante(formCreate));
    }

    private void displayformVacanteUpdate() {
        System.out.println("Iniciando");
        int rowIndex = this.adminPanelVacantes.getTblVacantes().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }

        try {
            
            int idCourse = Integer.parseInt(adminPanelVacantes.getTblVacantes().getValueAt(rowIndex, 0).toString());
            Vacante vacante = vacanteDao.getVacanteById(idCourse);

            if (vacante != null) {
                AdminPanelVacantesForm formUpdate = new AdminPanelVacantesForm(true);
                System.out.println(idCourse);
                this.principalController.showPanel(formUpdate);
                System.out.println(idCourse);
                formUpdate.getTxtNombre().setText(vacante.getNombre());
                formUpdate.getTxtDescripcion().setText(vacante.getDescripcion());
                this.principalController.showPanel(formUpdate); 
                formUpdate.getBtnSave().addActionListener(e -> updateVacante(formUpdate,idCourse));
                
            } else {
                System.out.println("Vacante not found with ID: " + idCourse);
            }
        } catch (Exception e) {
            adminPanelVacantes.displayErrorMessage("Error al actualizar vacante: " + e.getMessage());
        } 
    }

    private void addVacante(AdminPanelVacantesForm form) { 
        Vacante vacante = new Vacante(0,
                                form.getTxtNombre().getText(),
                             form.getTxtDescripcion().getText());
        if (vacanteDao.insertVacante(vacante)) {
            this.principalController.displaySucessMessage("Se creo el vacante " + vacante.getNombre()); 
            this.principalController.showVacantePanel();
            loadVacantes();
        } else {
            this.principalController.displayErrorMessage("No se creo el vacante " + vacante.getNombre());
        }
    }

    private void updateVacante(AdminPanelVacantesForm form,int id) {
        form.getTxtNombre();
        form.getTxtDescripcion();
        Vacante vacante = new Vacante(0,
                            form.getTxtNombre().getText(),
                            form.getTxtDescripcion().getText());
        vacante.setID(id);
        if (vacanteDao.updateVacante(vacante)) {
            this.principalController.displaySucessMessage("Se actualizo el vacante " + vacante.getNombre());
            this.principalController.showVacantePanel();
            loadVacantes();
        } else {
            this.principalController.displayErrorMessage("No se actualizo el vacante " + vacante.getNombre());
        }
    }
    
    private void deleteVacante(){
        try {
            for (int row : this.adminPanelVacantes.getTblVacantes().getSelectedRows()) {
                int id = (int) this.adminPanelVacantes.getTblVacantes().getValueAt(row, 0);
                if (vacanteDao.deleteVacante(id)){ 
                    this.principalController.displaySucessMessage("Se elimino el id "+id);
                }else{
                    this.principalController.displayErrorMessage("Falló al eliminar el id "+ id);
                }
            }
        } catch (Exception e) {
            this.principalController.displayErrorMessage("Ocurrio un error");
        } finally{
            loadVacantes();
        }
    }
    
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
            adminPanelVacantes.displayErrorMessage("Error al cargar vacantes: " + e.getMessage());
        }
    }*/
}
