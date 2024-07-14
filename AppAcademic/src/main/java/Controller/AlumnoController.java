package Controller;

import Dao.AlumnoDAOImpl; 
import View.AdminPanelAlumnos;
import View.AdminPanelCursosForm;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

 
public class AlumnoController {
    private AdminController principalController;
    private AlumnoDAOImpl alumnoDao;
    private AdminPanelAlumnos adminPanelalumnos; 

    public AlumnoController(AdminController principalController) {
        this.principalController = principalController;
        this.alumnoDao = new AlumnoDAOImpl();
        this.adminPanelalumnos = new AdminPanelAlumnos(this); 
       
    }

    public AdminPanelAlumnos getAdminPanelCursos() {
        return adminPanelalumnos;
    }

    private void initController() { 
        adminPanelalumnos.getBtnSearch().addActionListener(e -> searchAlumno()); 
        loadAlumnos();
    }
    
    public void loadAlumnos() {
        try {
            List<String[]> alumnos = alumnoDao.getAlumnosInfo();

            DefaultTableModel model = (DefaultTableModel) adminPanelalumnos.getTblAlumnos().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Nombre","Apellidos","Dni","Sexo", "FechNacimiento", "Telefono","Direccion","Email","Aula"});
            TableColumnModel columnModel = adminPanelalumnos.getTblAlumnos().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (String[] alumno : alumnos) {
                model.addRow(new Object[]{alumno[0],alumno[1],alumno[2],alumno[3],alumno[4],alumno[5],alumno[6],alumno[7],alumno[8],alumno[9]});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar vacantes: " + e.getMessage());
        }
    }
    
    private void searchAlumno() {
        String searchTerm = this.adminPanelalumnos.getTxtSearch().getText(); 
        try {
            List<String[]> alumnos = alumnoDao.getAlumnosInfoByName(searchTerm);

            DefaultTableModel model = (DefaultTableModel) adminPanelalumnos.getTblAlumnos().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Nombre","Apellidos","Dni","Sexo", "FechNacimiento", "Telefono","Direccion","Email","Aula"});
            TableColumnModel columnModel = adminPanelalumnos.getTblAlumnos().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);
            model.setRowCount(0);
            for (String[] alumno : alumnos) {
                model.addRow(new Object[]{alumno[0],alumno[1],alumno[2],alumno[3],alumno[4],alumno[5],alumno[6],alumno[7],alumno[8],alumno[9]});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar cursos: " + e.getMessage());
        }
    }
}
