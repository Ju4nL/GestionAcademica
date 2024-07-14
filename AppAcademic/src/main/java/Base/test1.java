package Base;

import View.PanelSolicitudes;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class test1 {

    public static void main(String[] args) {
        // Configurar el tema de la interfaz
        FlatMacLightLaf.setup();
        UIManager.put("Button.arc", 25);

        // Crear el JFrame para contener el panel
        JFrame mainFrame = new JFrame("Panel de Solicitudes");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);

        // Crear una instancia de PanelSolicitudes y añadirla al JFrame
        PanelSolicitudes panelSolicitudes = new PanelSolicitudes(false);
        mainFrame.add(panelSolicitudes);

        // Mostrar el JFrame
        mainFrame.setVisible(true);
    }
}
