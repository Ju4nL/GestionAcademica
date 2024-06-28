
package Controller;

import View.AdminHomeFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PrincipalController {
    private AdminHomeFrame adminHomeFrame; // La ventana principal
    private CursoController cursoController; // Controlador para el panel de cursos

    public PrincipalController(AdminHomeFrame adminHomeFrame) {
        this.adminHomeFrame = adminHomeFrame;
        this.cursoController = cursoController; // Asignar el cursoController recibido
        initControllers();
    }
    
    private void initControllers() { 
        initCourse();
    }
    
    private void initCourse(){
        cursoController = new CursoController(this);
        adminHomeFrame.getBtnCursos().addActionListener(e -> cursoController.loadCursos());
    }
    
    // Método para mostrar paneles específicos
   
    
    public void showCursoPanel() {
        showPanel(cursoController.getAdminPanelCursos());
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
    
}
