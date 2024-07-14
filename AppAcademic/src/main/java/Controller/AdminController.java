
package Controller;

import View.AdminHomeFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class AdminController {
    private AdminHomeFrame adminHomeFrame;  
    private CursoController cursoController;  
    private DocenteController docenteController;
    private VacanteController vacanteController;  
    private SolicitudesController solicitudController; 
    private AlumnoController  alumnoController; 

    public AdminController(AdminHomeFrame adminHomeFrame) {
        this.adminHomeFrame = adminHomeFrame; 
        initControllers();
    }
    
    private void initControllers() {
        vacanteController = new VacanteController(this);
        adminHomeFrame.getBtnVacantes().addActionListener(e -> vacanteController.loadVacantes());
        
        solicitudController = new SolicitudesController(this);
        adminHomeFrame.getBtnSolicitudes().addActionListener(e -> solicitudController.loadSolicitudes());
        
        alumnoController = new AlumnoController(this);
        adminHomeFrame.getBtnAlumnos().addActionListener(e -> alumnoController.loadAlumnos());
        
        cursoController = new CursoController(this);
        adminHomeFrame.getBtnCursos().addActionListener(e -> cursoController.loadCursos());
        
        
        docenteController = new DocenteController(this);
        adminHomeFrame.getBtnDocentes().addActionListener(e -> docenteController.loadDocentes());
        
        //Cerrar sesion
        adminHomeFrame.getBtnCerrarSesion().addActionListener(e -> cerrarSesion());
        
    }
     
    
 
    public void showPanel(JPanel panel) { 
        adminHomeFrame.getContentPanel().removeAll();
        adminHomeFrame.getContentPanel().add(panel, BorderLayout.CENTER);
        adminHomeFrame.getContentPanel().revalidate();
        adminHomeFrame.getContentPanel().repaint();
    
    }
    public void showVacantePanel() { 
        showPanel(vacanteController.getAdminPanelVacantes());
        adminHomeFrame.getBtnVacantes().setBackground(new Color(240, 243, 253));
        adminHomeFrame.getBtnCursos().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnSolicitudes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnDocentes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnAlumnos().setBackground(new Color(255, 255, 255));
         
    }
    
     public void showSolicitudesPanel() { 
        showPanel(solicitudController.getPanelSolicitudes());
        adminHomeFrame.getBtnVacantes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnCursos().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnSolicitudes().setBackground(new Color(240, 243, 253));
        adminHomeFrame.getBtnDocentes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnAlumnos().setBackground(new Color(255, 255, 255));
         
    }
      public void showDocentesPanel() { 
        showPanel(docenteController.getAdminPanelDocentes());
        adminHomeFrame.getBtnVacantes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnCursos().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnSolicitudes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnDocentes().setBackground(new Color(240, 243, 253));
        adminHomeFrame.getBtnAlumnos().setBackground(new Color(255, 255, 255));
         
    }
     public void showAlumnosPanel() { 
        showPanel(alumnoController.getAdminPanelCursos());
        adminHomeFrame.getBtnVacantes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnCursos().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnSolicitudes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnDocentes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnAlumnos().setBackground(new Color(240, 243, 253));
         
    }
    
    public void showCursoPanel() { 
        showPanel(cursoController.getAdminPanelCursos());
        adminHomeFrame.getBtnVacantes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnCursos().setBackground(new Color(240, 243, 253));
        adminHomeFrame.getBtnSolicitudes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnDocentes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnAlumnos().setBackground(new Color(255, 255, 255));
    }
     
   public void displayErrorMessage(String message){
        adminHomeFrame.displayErrorMessage(message);
    }
    
    public void displaySucessMessage(String message){
        adminHomeFrame.displaySucessMessage(message);
    }
    
    public void cerrarSesion() {
        adminHomeFrame.dispose();
        
    }
    
}
