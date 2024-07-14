package Dao;

import Interface.SolicitudVacanteDAO;
import Model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitudVacanteDAOImpl implements SolicitudVacanteDAO {

    @Override
    public List<String[]> getAllSolicitudes() {
        List<String[]> solicitudes = new ArrayList<>();
        String query = "SELECT s.id, CONCAT('Solicitud', s.id) as nombre, g.nombre as grado, s2.nombre as seccion, s.estado, s.fechaSolicitud " +
                       "FROM SolicitudVacante s " +
                       "LEFT JOIN Grado g ON s.grado_id = g.id " +
                       "LEFT JOIN Seccion s2 ON s.seccion_id = s2.id";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                String[] solicitud = new String[6];
                solicitud[0] = String.valueOf(rs.getInt("id"));
                solicitud[1] = rs.getString("nombre");
                solicitud[2] = rs.getString("grado");
                solicitud[3] = rs.getString("seccion");
                solicitud[4] = rs.getString("estado");
                solicitud[5] = rs.getString("fechaSolicitud").toString();
                solicitudes.add(solicitud);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }

    @Override
    public List<String[]> getSolicitudesByPadreId(int padreId) {
        List<String[]> solicitudes = new ArrayList<>();
        String query = "SELECT s.id, CONCAT('Solicitud', s.id) as nombre, g.nombre as grado, s2.nombre as seccion, s.estado, s.fechaSolicitud " +
                       "FROM SolicitudVacante s " +
                       "LEFT JOIN Grado g ON s.grado_id = g.id " +
                       "LEFT JOIN Seccion s2 ON s.seccion_id = s2.id " +
                       "WHERE s.padre_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, padreId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String[] solicitud = new String[6];
                solicitud[0] = String.valueOf(rs.getInt("id"));
                solicitud[1] = rs.getString("nombre");
                solicitud[2] = rs.getString("grado");
                solicitud[3] = rs.getString("seccion");
                solicitud[4] = rs.getString("estado");
                solicitud[5] = rs.getString("fechaSolicitud").toString();
                solicitudes.add(solicitud);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }

    @Override
    public boolean updateEstadoSolicitud(int id, String nuevoEstado) {
        String query = "UPDATE SolicitudVacante SET estado = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nuevoEstado);
            preparedStatement.setInt(2, id);
            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
