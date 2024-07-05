package Dao;

import Interface.DocenteDAO;
import Model.Docente;
import Model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAOImpl  implements DocenteDAO {

    @Override
    public Docente getDocenteById(int id) {
        Docente docente = null;
        String sql = "SELECT p.*, u.username, u.password, u.rol, u.isActive, a.nombre AS tutorAulaNombre FROM Persona p " +
                     "JOIN Usuario u ON p.id = u.id " +
                     "LEFT JOIN Aula a ON u.id = a.tutor_id WHERE p.id = ? AND u.rol = 'Docente'";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    docente = new Docente(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellidos"),
                            rs.getString("dni"),
                            rs.getString("sexo"),
                            rs.getDate("fechaNacimiento").toLocalDate(),
                            rs.getString("telefono"),
                            rs.getString("direccion"),
                            rs.getString("email"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("rol"),
                            rs.getBoolean("isActive"),
                            rs.getString("tutorAulaNombre")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docente;
    }

    @Override
    public List<Docente> getAllDocentes() {
        List<Docente> docentes = new ArrayList<>();
        String sql = "SELECT p.*, u.username, u.password, u.rol, u.isActive, a.nombre AS tutorAulaNombre FROM Persona p " +
                     "JOIN Usuario u ON p.id = u.id " +
                     "LEFT JOIN Aula a ON u.id = a.tutor_id WHERE u.rol = 'Docente'";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Docente docente = new Docente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("sexo"),
                        rs.getDate("fechaNacimiento").toLocalDate(),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("rol"),
                        rs.getBoolean("isActive"),
                        rs.getString("tutorAulaNombre")
                );
                docentes.add(docente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docentes;
    }

    @Override
    public boolean insertDocente(Docente docente) {
        String sqlPersona = "INSERT INTO Persona (nombre, apellidos, dni, sexo, fechaNacimiento, telefono, direccion, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlUsuario = "INSERT INTO Usuario (id, username, password, rol, isActive) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatementPersona = connection.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement preparedStatementUsuario = connection.prepareStatement(sqlUsuario)) {
                // Insertar en Persona
                preparedStatementPersona.setString(1, docente.getNombre());
                preparedStatementPersona.setString(2, docente.getApellidos());
                preparedStatementPersona.setString(3, docente.getDni());
                preparedStatementPersona.setString(4, docente.getSexo());
                preparedStatementPersona.setDate(5, Date.valueOf(docente.getFechaNacimiento()));
                preparedStatementPersona.setString(6, docente.getTelefono());
                preparedStatementPersona.setString(7, docente.getDireccion());
                preparedStatementPersona.setString(8, docente.getEmail());
                int affectedRowsPersona = preparedStatementPersona.executeUpdate();

                if (affectedRowsPersona > 0) {
                    try (ResultSet generatedKeys = preparedStatementPersona.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int personaId = generatedKeys.getInt(1);
                            // Insertar en Usuario
                            preparedStatementUsuario.setInt(1, personaId);
                            preparedStatementUsuario.setString(2, docente.getUsername());
                            preparedStatementUsuario.setString(3, docente.getPassword());
                            preparedStatementUsuario.setString(4, docente.getRol());
                            preparedStatementUsuario.setBoolean(5, docente.isActive());
                            int affectedRowsUsuario = preparedStatementUsuario.executeUpdate();

                            if (affectedRowsUsuario > 0) {
                                connection.commit();
                                docente.setId(personaId);
                                return true;
                            }
                        }
                    }
                }
                connection.rollback();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDocente(Docente docente) {
        String sqlPersona = "UPDATE Persona SET nombre = ?, apellidos = ?, dni = ?, sexo = ?, fechaNacimiento = ?, telefono = ?, direccion = ?, email = ? WHERE id = ?";
        String sqlUsuario = "UPDATE Usuario SET username = ?, password = ?, rol = ?, isActive = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatementPersona = connection.prepareStatement(sqlPersona);
                 PreparedStatement preparedStatementUsuario = connection.prepareStatement(sqlUsuario)) {
                // Actualizar en Persona
                preparedStatementPersona.setString(1, docente.getNombre());
                preparedStatementPersona.setString(2, docente.getApellidos());
                preparedStatementPersona.setString(3, docente.getDni());
                preparedStatementPersona.setString(4, docente.getSexo());
                preparedStatementPersona.setDate(5, Date.valueOf(docente.getFechaNacimiento()));
                preparedStatementPersona.setString(6, docente.getTelefono());
                preparedStatementPersona.setString(7, docente.getDireccion());
                preparedStatementPersona.setString(8, docente.getEmail());
                preparedStatementPersona.setInt(9, docente.getId());
                int affectedRowsPersona = preparedStatementPersona.executeUpdate();

                if (affectedRowsPersona > 0) {
                    // Actualizar en Usuario
                    preparedStatementUsuario.setString(1, docente.getUsername());
                    preparedStatementUsuario.setString(2, docente.getPassword());
                    preparedStatementUsuario.setString(3, docente.getRol());
                    preparedStatementUsuario.setBoolean(4, docente.isActive());
                    preparedStatementUsuario.setInt(5, docente.getId());
                    int affectedRowsUsuario = preparedStatementUsuario.executeUpdate();

                    if (affectedRowsUsuario > 0) {
                        connection.commit();
                        return true;
                    }
                }
                connection.rollback();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDocente(int id) {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Persona WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
