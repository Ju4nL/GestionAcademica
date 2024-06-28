
package Base;
 
import Controller.PrincipalController;
import View.AdminHomeFrame;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        FlatMacLightLaf.setup();
        UIManager.put( "Button.arc", 25 );
        // Crear la vista principal sin el controlador inicialmente
        AdminHomeFrame mainFrame = new AdminHomeFrame();
        
        // Crear el controlador principal, pasando la vista
        PrincipalController principalController = new PrincipalController(mainFrame);
        
        // Establecer el controlador en la vista
        mainFrame.setController(principalController);

        mainFrame.setDefaultCloseOperation(AdminHomeFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

        // Mostrar el panel inicial deseado
        principalController.showCursoPanel();
    }
}
