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
        String query = "SELECT v.id, g.nombre AS grado, v.cupoDisponible, COUNT(s.id) AS solicitudes "
                + "FROM Vacante v "
                + "JOIN Grado g ON v.grado_id = g.id "
                + "LEFT JOIN SolicitudVacante s ON v.grado_id = s.grado_id AND v.seccion_id = s.seccion_id "
                + "GROUP BY v.id, g.nombre, v.cupoDisponible";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String[] row = new String[4];
                row[0] = String.valueOf(rs.getInt("id"));
                row[1] = rs.getString("grado"); // Mostrar nombre del grado
                row[2] = String.valueOf(rs.getInt("cupoDisponible"));
                row[3] = String.valueOf(rs.getInt("solicitudes"));

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
