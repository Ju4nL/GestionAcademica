package Dao;

import Model.RegistrarApoderado;
import Model.DatabaseConnection;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import Interface.ApoderadoDAO;

public class ApoderadoDAOImpl implements ApoderadoDAO {

    @Override
    public boolean insertApoderado(RegistrarApoderado apoderado) {
        boolean personaInserted = false;
        boolean usuarioInserted = false;
        int personaId = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);

            System.out.println("Insertando en Persona...");
            
            // Insert into Persona table
            String insertPersonaSql = "INSERT INTO Persona (nombre, apellidos, dni, sexo, fechaNacimiento, telefono, direccion, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement personaStmt = connection.prepareStatement(insertPersonaSql, Statement.RETURN_GENERATED_KEYS)) {
                personaStmt.setString(1, apoderado.getNombre());
                personaStmt.setString(2, apoderado.getApellidos());
                personaStmt.setString(3, apoderado.getDni());
                personaStmt.setString(4, apoderado.getGenero());
                personaStmt.setDate(5, Date.valueOf(apoderado.getFechaNac()));
                personaStmt.setString(6, apoderado.getTelefono());
                personaStmt.setString(7, apoderado.getDireccion());
                personaStmt.setString(8, apoderado.getEmail());

                int affectedRows = personaStmt.executeUpdate();
                System.out.println("Filas afectadas en Persona: " + affectedRows);
                personaInserted = affectedRows > 0;

                if (personaInserted) {
                    try (ResultSet generatedKeys = personaStmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            personaId = generatedKeys.getInt(1);
                            System.out.println("ID de Persona generado: " + personaId);

                            System.out.println("Insertando en Usuario...");
                            // Insert into Usuario table
                            String insertUsuarioSql = "INSERT INTO Usuario (id, email, password, role_id, is_active) VALUES (?, ?, ?, ?, ?)";
                            try (PreparedStatement usuarioStmt = connection.prepareStatement(insertUsuarioSql)) {
                                usuarioStmt.setInt(1, personaId); // Usar el ID de Persona
                                usuarioStmt.setString(2, apoderado.getEmail());
                                usuarioStmt.setString(3, apoderado.getContrasena());
                                usuarioStmt.setInt(4, 1); // El rol de apoderado es 1
                                usuarioStmt.setBoolean(5, true);

                                int userAffectedRows = usuarioStmt.executeUpdate();
                                System.out.println("Filas afectadas en Usuario: " + userAffectedRows);
                                usuarioInserted = userAffectedRows > 0;
                            }
                        }
                    }
                }
            }

            if (personaInserted && usuarioInserted) {
                connection.commit();
                System.out.println("Transacción completada exitosamente.");
            } else {
                connection.rollback();
                System.out.println("Transacción revertida.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la transacción: " + e.getMessage());
        }
        return personaInserted && usuarioInserted;
    }

    @Override
    public List<RegistrarApoderado> getAllApoderados() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RegistrarApoderado getApoderadoByDni(String dni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateApoderado(RegistrarApoderado apoderado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteApoderado(String dni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<String[]> getApoderadosInfo() {
        List<String[]> apoderadosInfo = new ArrayList<>();
        String query = "SELECT p.*, r.nombre AS Rol "
                + "FROM Persona p "
                + "JOIN Usuario u ON p.id = u.id "
                + "JOIN Rol r ON u.role_id = r.id "
                + "WHERE r.nombre = 'padre'";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String[] apoderadoInfo = new String[10];
                apoderadoInfo[0] = String.valueOf(rs.getInt("id"));
                apoderadoInfo[1] = rs.getString("nombre");
                apoderadoInfo[2] = rs.getString("apellidos");
                apoderadoInfo[3] = rs.getString("dni");
                apoderadoInfo[4] = rs.getString("sexo");
                apoderadoInfo[5] = String.valueOf(rs.getDate("fechaNacimiento"));
                apoderadoInfo[6] = rs.getString("telefono");
                apoderadoInfo[7] = rs.getString("direccion");
                apoderadoInfo[8] = rs.getString("email");
                apoderadoInfo[9] = rs.getString("Rol");

                apoderadosInfo.add(apoderadoInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apoderadosInfo;
    }

    @Override
    public List<String[]> getApoderadosInfoByName(String nombre) {
        List<String[]> apoderadosInfo = new ArrayList<>();
        String query = "SELECT p.*, r.nombre AS Rol "
                + "FROM Persona p "
                + "JOIN Usuario u ON p.id = u.id "
                + "JOIN Rol r ON u.role_id = r.id "
                + "WHERE r.nombre = 'padre' AND p.nombre LIKE ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + nombre + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String[] apoderadoInfo = new String[10];
                    apoderadoInfo[0] = String.valueOf(rs.getInt("id"));
                    apoderadoInfo[1] = rs.getString("nombre");
                    apoderadoInfo[2] = rs.getString("apellidos");
                    apoderadoInfo[3] = rs.getString("dni");
                    apoderadoInfo[4] = rs.getString("sexo");
                    apoderadoInfo[5] = String.valueOf(rs.getDate("fechaNacimiento"));
                    apoderadoInfo[6] = rs.getString("telefono");
                    apoderadoInfo[7] = rs.getString("direccion");
                    apoderadoInfo[8] = rs.getString("email");
                    apoderadoInfo[9] = rs.getString("Rol");

                    apoderadosInfo.add(apoderadoInfo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apoderadosInfo;
    }
}
