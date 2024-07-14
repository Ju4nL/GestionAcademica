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
        String query = "SELECT s.id,g.nombre as grado, s2.nombre as seccion, s.estado, s.fechaSolicitud " +
                       "FROM SolicitudVacante s " +
                       "LEFT JOIN Grado g ON s.grado_id = g.id " +
                       "LEFT JOIN Seccion s2 ON s.seccion_id = s2.id";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                String[] solicitud = new String[6];
                solicitud[0] = String.valueOf(rs.getInt("id"));
                solicitud[1] = rs.getString("grado");
                solicitud[2] = rs.getString("seccion");
                solicitud[3] = rs.getString("estado");
                solicitud[4] = rs.getString("fechaSolicitud").toString();
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
        String query = "SELECT s.id, g.nombre as grado, s2.nombre as seccion, s.estado, s.fechaSolicitud " +
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
                solicitud[1] = rs.getString("grado");
                solicitud[2] = rs.getString("seccion");
                solicitud[3] = rs.getString("estado");
                solicitud[4] = rs.getString("fechaSolicitud").toString();
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
    
     @Override
    public List<String[]> getDetailsSolicitud(int solicitudId) {
        List<String[]> detalles = new ArrayList<>();
        String query = "SELECT p.dni, p.nombre, p.apellidos, p.direccion, p.telefono, p.fechaNacimiento, p.sexo, p.email, '-' as contraseña " +
                       "FROM SolicitudVacante sv " +
                       "LEFT JOIN Persona p ON sv.alumno_id = p.id " +
                       "WHERE sv.id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, solicitudId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String[] detalle = new String[9];
                detalle[0] = rs.getString("dni");
                detalle[1] = rs.getString("nombre");
                detalle[2] = rs.getString("apellidos");
                detalle[3] = rs.getString("direccion");
                detalle[4] = rs.getString("telefono");
                detalle[5] = rs.getString("fechaNacimiento").toString();
                detalle[6] = rs.getString("sexo");
                detalle[7] = rs.getString("email");
                detalle[8] = rs.getString("contraseña");
                detalles.add(detalle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;
    }
    
     @Override
    public int insertarYBuscarAula(int solicitudId) {
        String insertQuery = "INSERT INTO Aula (nombre, anio, grado_id, seccion_id) " +
                             "SELECT B.nombre, B.anio, B.grado_id, B.seccion_id " +
                             "FROM (SELECT CONCAT(g.nombre, ' ', s.nombre) AS nombre, YEAR(CURDATE()) AS anio, sv.grado_id, sv.seccion_id " +
                             "FROM SolicitudVacante sv " +
                             "JOIN Grado g ON sv.grado_id = g.id " +
                             "JOIN Seccion s ON sv.seccion_id = s.id " +
                             "WHERE sv.id = ?) B " +
                             "LEFT JOIN Aula a ON B.nombre = a.nombre " +
                             "WHERE a.id IS NULL";

        String selectQuery = "SELECT id FROM Aula WHERE nombre = (SELECT CONCAT(g.nombre, ' ', s.nombre) " +
                             "FROM SolicitudVacante sv " +
                             "JOIN Grado g ON sv.grado_id = g.id " +
                             "JOIN Seccion s ON sv.seccion_id = s.id " +
                             "WHERE sv.id = ?)";

        int aulaId = -1;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {

            // Insertar el aula
            insertStatement.setInt(1, solicitudId);
            insertStatement.executeUpdate();

            // Buscar el aula_id
            selectStatement.setInt(1, solicitudId);
            ResultSet rs = selectStatement.executeQuery();
            if (rs.next()) {
                aulaId = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aulaId;
    }
    
    @Override
    public boolean insertarPersonaAula(int personaId, int aulaId) {
        String query = "INSERT INTO PersonaAula (persona_id, aula_id) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, personaId);
            preparedStatement.setInt(2, aulaId);
            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
public boolean procesarAprobacionSolicitud(int solicitudId) {
    Connection connection = null;
    PreparedStatement updateStatement = null;
    PreparedStatement getAlumnoStatement = null;
    boolean result = false;

    try {
        connection = DatabaseConnection.getConnection();
        connection.setAutoCommit(false);

        // Actualizar el estado de la solicitud
        String updateQuery = "UPDATE SolicitudVacante SET estado = 'Aprobada' WHERE id = ?";
        updateStatement = connection.prepareStatement(updateQuery);
        updateStatement.setInt(1, solicitudId);
        int rowsUpdated = updateStatement.executeUpdate();

        if (rowsUpdated > 0) {
            // Obtener el alumno_id (persona_id) de la solicitud
            String getAlumnoQuery = "SELECT alumno_id FROM SolicitudVacante WHERE id = ?";
            getAlumnoStatement = connection.prepareStatement(getAlumnoQuery);
            getAlumnoStatement.setInt(1, solicitudId);
            ResultSet rs = getAlumnoStatement.executeQuery();
            int personaId = -1;
            if (rs.next()) {
                personaId = rs.getInt("alumno_id");
            }

            if (personaId != -1) {
                // Insertar y buscar el aula
                int aulaId = insertarYBuscarAula(solicitudId);

                if (aulaId != -1) {
                    // Insertar en PersonaAula
                    if (insertarPersonaAula(personaId, aulaId)) {
                        connection.commit();
                        result = true;
                    } else {
                        connection.rollback();
                    }
                } else {
                    connection.rollback();
                }
            } else {
                connection.rollback();
            }
        } else {
            connection.rollback();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } finally {
        try {
            if (updateStatement != null) {
                updateStatement.close();
            }
            if (getAlumnoStatement != null) {
                getAlumnoStatement.close();
            }
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return result;
}
}
