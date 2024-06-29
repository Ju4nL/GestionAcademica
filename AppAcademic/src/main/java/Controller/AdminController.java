
package Controller;

import View.AdminHomeFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class AdminController {
    private AdminHomeFrame adminHomeFrame;  
    private CursoController cursoController;  
    private VacanteController vacanteController;  

    public AdminController(AdminHomeFrame adminHomeFrame) {
        this.adminHomeFrame = adminHomeFrame; 
        initControllers();
    }
    
    private void initControllers() {
        vacanteController = new VacanteController(this);
        adminHomeFrame.getBtnVacantes().addActionListener(e -> vacanteController.loadVacantes());
        
        cursoController = new CursoController(this);
        adminHomeFrame.getBtnCursos().addActionListener(e -> cursoController.loadCursos());
        
        
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
         
    }
    
    public void showCursoPanel() { 
        showPanel(cursoController.getAdminPanelCursos());
        adminHomeFrame.getBtnVacantes().setBackground(new Color(255, 255, 255));
        adminHomeFrame.getBtnCursos().setBackground(new Color(240, 243, 253));
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
