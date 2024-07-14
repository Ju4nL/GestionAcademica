
package View;
import javax.swing.table.DefaultTableModel;

public class SolicitudesTableModel extends DefaultTableModel{
    public SolicitudesTableModel() {
        super(new Object[]{"id", "Grado", "Seccion", "Estado", "Fecha solicitud"}, 0);
    }

    public void addSolicitud(String id, String grado, String seccion, String estado, String fechaSolicitud) {
        super.addRow(new Object[]{id, grado,  seccion, estado, fechaSolicitud});
    }
}
