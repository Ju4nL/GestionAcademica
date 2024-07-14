
package View;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class VacantTableModel extends DefaultTableModel {
    public VacantTableModel() {
        super(new Object[]{"id", "Grado", "Vacantes Disponibles", "Solicitudes"}, 0);
    }

    public void addVacant(int id, String grado, int vacantesDisponibles, int solicitudes) {
        super.addRow(new Object[]{id, grado, vacantesDisponibles, solicitudes});
    }
}
