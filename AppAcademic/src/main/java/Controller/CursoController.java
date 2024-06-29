package Controller;

import Dao.CursoDAOImpl;
import Model.Curso;
import View.AdminPanelCursos;
import View.AdminPanelCursosForm;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CursoController {

    private AdminController principalController;
    private CursoDAOImpl cursoDao;
    private AdminPanelCursos adminPanelCursos; 

    public CursoController(AdminController principalController) {
        this.principalController = principalController;
        this.cursoDao = new CursoDAOImpl();
        this.adminPanelCursos = new AdminPanelCursos(this); 
        initController();
    }

    public AdminPanelCursos getAdminPanelCursos() {
        return adminPanelCursos;
    }

    private void initController() {
        adminPanelCursos.getBtnAdd().addActionListener(e -> displayformCursoCreate());
        adminPanelCursos.getBtnUpdate().addActionListener(e -> displayformCursoUpdate()); 
        adminPanelCursos.getBtnDelete().addActionListener(e -> deleteCurso()); 
        adminPanelCursos.getBtnSearch().addActionListener(e -> searchCurso()); 
        loadCursos();
    }

    public void loadCursos() {
        try {
            List<Curso> cursos = cursoDao.getAllCursos();

            DefaultTableModel model = (DefaultTableModel) adminPanelCursos.getTblCursos().getModel();
            model.setRowCount(0);
            for (Curso curso : cursos) {
                model.addRow(new Object[]{curso.getID(), curso.getNombre(), curso.getDescripcion()});
            }
        } catch (Exception e) {
            adminPanelCursos.displayErrorMessage("Error al cargar cursos: " + e.getMessage());
        }
    }

    private void displayformCursoCreate() {
        AdminPanelCursosForm formCreate = new AdminPanelCursosForm(false);
        this.principalController.showPanel(formCreate);
        formCreate.getBtnSave().addActionListener(e -> addCurso(formCreate));
    }

    private void displayformCursoUpdate() {
        System.out.println("Iniciando");
        int rowIndex = this.adminPanelCursos.getTblCursos().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }

        try {
            
            int idCourse = Integer.parseInt(adminPanelCursos.getTblCursos().getValueAt(rowIndex, 0).toString());
            Curso curso = cursoDao.getCursoById(idCourse);

            if (curso != null) {
                AdminPanelCursosForm formUpdate = new AdminPanelCursosForm(true);
                System.out.println(idCourse);
                this.principalController.showPanel(formUpdate);
                System.out.println(idCourse);
                formUpdate.getTxtNombre().setText(curso.getNombre());
                formUpdate.getTxtDescripcion().setText(curso.getDescripcion());
                this.principalController.showPanel(formUpdate); 
                formUpdate.getBtnSave().addActionListener(e -> updateCurso(formUpdate,idCourse));
                
            } else {
                System.out.println("Curso not found with ID: " + idCourse);
            }
        } catch (Exception e) {
            adminPanelCursos.displayErrorMessage("Error al actualizar curso: " + e.getMessage());
        } 
    }

    private void addCurso(AdminPanelCursosForm form) { 
        Curso curso = new Curso(0,
                                form.getTxtNombre().getText(),
                             form.getTxtDescripcion().getText());
        if (cursoDao.insertCurso(curso)) {
            this.principalController.displaySucessMessage("Se creo el curso " + curso.getNombre()); 
            this.principalController.showCursoPanel();
            loadCursos();
        } else {
            this.principalController.displayErrorMessage("No se creo el curso " + curso.getNombre());
        }
    }

    private void updateCurso(AdminPanelCursosForm form,int id) {
        form.getTxtNombre();
        form.getTxtDescripcion();
        Curso curso = new Curso(0,
                            form.getTxtNombre().getText(),
                            form.getTxtDescripcion().getText());
        curso.setID(id);
        if (cursoDao.updateCurso(curso)) {
            this.principalController.displaySucessMessage("Se actualizo el curso " + curso.getNombre());
            this.principalController.showCursoPanel();
            loadCursos();
        } else {
            this.principalController.displayErrorMessage("No se actualizo el curso " + curso.getNombre());
        }
    }
    
    private void deleteCurso(){
        try {
            for (int row : this.adminPanelCursos.getTblCursos().getSelectedRows()) {
                int id = (int) this.adminPanelCursos.getTblCursos().getValueAt(row, 0);
                if (cursoDao.deleteCurso(id)){ 
                    this.principalController.displaySucessMessage("Se elimino el id "+id);
                }else{
                    this.principalController.displayErrorMessage("Falló al eliminar el id "+ id);
                }
            }
        } catch (Exception e) {
            this.principalController.displayErrorMessage("Ocurrio un error");
        } finally{
            loadCursos();
        }
    }
    
    private void searchCurso() {
        String searchTerm = this.adminPanelCursos.getTxtSearch().getText(); 
        try {
            List<Curso> cursos = cursoDao.getCursosByName(searchTerm);

            DefaultTableModel model = (DefaultTableModel) adminPanelCursos.getTblCursos().getModel();
            model.setRowCount(0);
            for (Curso curso : cursos) {
                model.addRow(new Object[]{curso.getID(), curso.getNombre(), curso.getDescripcion()});
            }
        } catch (Exception e) {
            adminPanelCursos.displayErrorMessage("Error al cargar cursos: " + e.getMessage());
        }
    }
}
