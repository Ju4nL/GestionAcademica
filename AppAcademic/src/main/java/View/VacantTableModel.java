
package View;

import javax.swing.table.DefaultTableModel;

public class VacantTableModel extends DefaultTableModel {
    public VacantTableModel() {
        super(new Object[]{"id", "Grado","Seccion", "Vacantes Disponibles", "Solicitudes"}, 0);
    }

    public void addVacant(int id, String grado,String Seccion, int vacantesDisponibles, int solicitudes) {
        super.addRow(new Object[]{id, grado,Seccion, vacantesDisponibles, solicitudes});
    }
}
