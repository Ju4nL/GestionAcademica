
package View;
import javax.swing.table.DefaultTableModel;

public class SolicitudesTableModel extends DefaultTableModel{
    public SolicitudesTableModel() {
        super(new Object[]{"id", "Solicitud", "Grado", "Estado", "Fecha solicitud"}, 0);
    }

    public void addSolicitud(String id, String solicitud, String grado, String estado, String fechaSolicitud) {
        super.addRow(new Object[]{id, grado, solicitud, grado, estado, fechaSolicitud});
    }
}
