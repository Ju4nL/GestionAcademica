 
package Controller;

import Dao.CursoDAOImpl;
import Dao.SolicitudVacanteDAOImpl;
import Model.Curso;
import View.AdminPanelCursos;
import View.PanelSolicitudes;
import View.ParentsPanelVacants;
import View.SolicitudesTableModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

 
public class SolicitudesController {
        private AdminController principalController;
        private ParentController parentController;
        private SolicitudVacanteDAOImpl solicitudDao;
        private PanelSolicitudes panelsolicitudes; 
        private int padre_id;
        
        
        public SolicitudesController(AdminController principalController) {
            this.principalController = principalController;
            this.solicitudDao = new SolicitudVacanteDAOImpl();
            this.panelsolicitudes = new PanelSolicitudes(true,this); 
            initController(true);
        }
        
         public SolicitudesController(ParentController parentController,int padre_id) {
            this.padre_id=padre_id;
            this.parentController = parentController;
            this.solicitudDao = new SolicitudVacanteDAOImpl();
            this.panelsolicitudes = new PanelSolicitudes(false,this); 
            initController(false);
        }
        
        private void initController(boolean is_admin) {
            if(is_admin){
                panelsolicitudes.getBtnAprobar().addActionListener(e -> temp()); 
                panelsolicitudes.getBtnRechazar().addActionListener(e -> temp()); 
                panelsolicitudes.getBtnVer().addActionListener(e -> temp()); 

            }else {
                panelsolicitudes.getBtnCancelar().addActionListener(e -> temp()); 
            }
 
            loadSolicitudes(is_admin);
        }
        
        
        public void loadSolicitudes(boolean is_admin) {
        try {
            List<String[]> solicitudes;
            if(is_admin){
                solicitudes = solicitudDao.getAllSolicitudes();
            }else{
                solicitudes = solicitudDao.getSolicitudesByPadreId(padre_id);
            } 
            SolicitudesTableModel solicitudesTableModel = new SolicitudesTableModel();
            solicitudesTableModel.setRowCount(0); 
            for (String[] solicitud : solicitudes) {
               solicitudesTableModel.addSolicitud(solicitud[0], solicitud[1], solicitud[2],solicitud[3], solicitud[4]);
            } 
            panelsolicitudes.getTblSolicitudes().setModel(solicitudesTableModel);
        } catch (Exception e) {
            panelsolicitudes.displayErrorMessage("Error al cargar cursos: " + e.getMessage());
        }
    }
        private void temp(){
            
        }
     
        
}
