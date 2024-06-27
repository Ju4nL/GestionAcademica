
package Controller;

import View.AdminHomeFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PrincipalController {
    private AdminHomeFrame view; // La ventana principal
    private CursoController cursoController; // Controlador para el panel de cursos

    public PrincipalController(AdminHomeFrame view) {
        this.view = view;
        initControllers();
    }
    
    private void initControllers() { 
        cursoController = new CursoController(this);
    }

    // Método para mostrar paneles específicos
    public void showPanel(JPanel panel) {
        view.getContentPanel().removeAll();
        view.getContentPanel().add(panel, BorderLayout.CENTER);
        view.getContentPanel().revalidate();
        view.getContentPanel().repaint();
    }

    /*
        private void ShowJPanel(JPanel panel) {
        panel.setSize(815, 580);
        panel.setLocation(0, 0);

        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
        private void btnCursosMousePressed(java.awt.event.MouseEvent evt) {                                       
        principalController.showVacantesPanel(); 
    }        
    */
    // Ejemplo de método para mostrar el panel de cursos
    public void showCursoPanel() {
        showPanel(cursoController.getAdminPanelCursos());
    }
}
