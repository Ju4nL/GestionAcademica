
package Controller;

import View.AdminHomeFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class AdminController {
    private AdminHomeFrame adminHomeFrame;  
    private CursoController cursoController;  

    public AdminController(AdminHomeFrame adminHomeFrame) {
        this.adminHomeFrame = adminHomeFrame;
        this.cursoController = cursoController;  
        initControllers();
    }
    
    private void initControllers() {  
        cursoController = new CursoController(this);
        adminHomeFrame.getBtnCursos().addActionListener(e -> cursoController.loadCursos());
        
        
        //Cerrar sesion
        adminHomeFrame.getBtnCerrarSesion().addActionListener(e -> cerrarSesion());
        
    }
     
    
 
    
    public void showCursoPanel() {
        
        showPanel(cursoController.getAdminPanelCursos());
        adminHomeFrame.getBtnCursos().setBackground(new Color(240, 243, 253));
    }
    
    
    public void showPanel(JPanel panel) { 
        adminHomeFrame.getContentPanel().removeAll();
        adminHomeFrame.getContentPanel().add(panel, BorderLayout.CENTER);
        adminHomeFrame.getContentPanel().revalidate();
        adminHomeFrame.getContentPanel().repaint();
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
