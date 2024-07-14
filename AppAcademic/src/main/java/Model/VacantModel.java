package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacantModel {

    public List<String[]> getVacantes() {
        List<String[]> vacantes = new ArrayList<>();
        String query = "SELECT v.id, g.nombre AS grado,sc.nombre  as seccion, v.cupoDisponible, COUNT(s.id) AS solicitudes  \n" +
                        " FROM Vacante v  \n" +
                        " JOIN Grado g ON v.grado_id = g.id \n" +
                        " JOIN Seccion sc ON v.seccion_id = sc.id \n" +
                        " LEFT JOIN SolicitudVacante s ON v.grado_id = s.grado_id AND v.seccion_id = s.seccion_id  \n" +
                        " GROUP BY v.id, g.nombre, v.cupoDisponible ";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String[] row = new String[5];
                row[0] = String.valueOf(rs.getInt("id"));
                row[1] = rs.getString("grado"); // Mostrar nombre del grado
                row[2] = rs.getString("seccion");
                row[3] = String.valueOf(rs.getInt("cupoDisponible"));
                row[4] = String.valueOf(rs.getInt("solicitudes"));

                vacantes.add(row);
                // Mensaje de depuración
                System.out.println("ID: " + row[0] + ", Grado: "
                        + row[1] + ", Cupo Disponible: " + row[2] + ", Solicitudes: " + row[3]);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vacantes;
    }
}
