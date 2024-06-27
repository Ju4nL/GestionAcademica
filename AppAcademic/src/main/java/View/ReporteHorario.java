package View;

import javax.swing.table.DefaultTableModel;

public class ReporteHorario extends DefaultTableModel {
    public ReporteHorario() {
        super(new Object[]{"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"}, 0);
    }

    public void addHorario(String hora, String lunes, String martes, String miercoles, String jueves, String viernes) {
        super.addRow(new Object[]{hora, lunes, martes, miercoles, jueves, viernes});
    }
}
