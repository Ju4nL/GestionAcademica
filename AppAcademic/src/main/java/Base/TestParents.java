package Base;

import Controller.ParentController;
import Model.VacantModel;
import View.ParentsHomeFrame;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

public class TestParents {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FlatMacLightLaf.setup();
                UIManager.put("Button.arc", 25);
                // Crear el frame
                ParentsHomeFrame frame = new ParentsHomeFrame();
                // Crear el modelo
                VacantModel model = new VacantModel();
                // Crear el controlador
                ParentController controller = new ParentController( frame, model, 0);
                // Hacer el frame visible
                frame.setVisible(true);
            }
        });

    }

}
