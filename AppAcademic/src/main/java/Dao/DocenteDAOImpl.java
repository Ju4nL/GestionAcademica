package Dao;

import Interface.DocenteDAO;
import Model.Docente;
import Model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAOImpl implements DocenteDAO {

    @Override
    public Docente getDocenteById(int id) {
        Docente docente = null;

        String sql = "SELECT p.*, u.email AS username, 'pass' AS password, r.nombre AS rol, u.is_active, a.nombre AS tutorAulaNombre "
                + "FROM Persona p "
                + "JOIN Usuario u ON p.id = u.id "
                + "LEFT JOIN Rol r ON u.role_id = r.id "
                + "LEFT JOIN Aula a ON u.id = a.tutor_id "
                + "WHERE r.nombre = 'Docente' AND p.id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    boolean isActive = rs.getInt("is_active") == 1;
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
                            isActive,
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
        String sql = "SELECT p.*,u.email as username, u.password, r.nombre as rol, u.is_active, a.nombre AS tutorAulaNombre FROM Persona p   \n"
                + "JOIN Usuario u ON p.id = u.id  \n"
                + "LEFT JOIN Rol r ON u.role_id = r.id  \n"
                + "LEFT JOIN Aula a ON u.id = a.tutor_id WHERE r.nombre = 'docente' ";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                boolean is_Active = rs.getInt("is_active") == 1;

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
                        is_Active,
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
        String sqlUsuario = "INSERT INTO Usuario (id, email, password, role_id, is_active) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatementPersona = connection.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS); PreparedStatement preparedStatementUsuario = connection.prepareStatement(sqlUsuario)) {
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
                            preparedStatementUsuario.setString(3, docente.getPassword()); // Ya está hasheada
                            preparedStatementUsuario.setInt(4, 4);
                            preparedStatementUsuario.setInt(5, 1);
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
        String sqlUsuario = "UPDATE Usuario SET email = ?, role_id = ?, is_active = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatementPersona = connection.prepareStatement(sqlPersona); PreparedStatement preparedStatementUsuario = connection.prepareStatement(sqlUsuario)) {
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
                    preparedStatementUsuario.setInt(2, 4); // Asumiendo que 4 es el role_id para 'docente'
                    preparedStatementUsuario.setInt(3, 1);
                    preparedStatementUsuario.setInt(4, docente.getId());
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
    public boolean setDocenteActive(int id, boolean isActive) {
        String sql = "UPDATE Usuario SET is_active = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, isActive ? 1 : 0);
            preparedStatement.setInt(2, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Docente> getDocentesByName(String nombre) {
        List<Docente> docentes = new ArrayList<>();
        String sql = "SELECT p.*, u.email AS username, 'pass' AS password, r.nombre AS rol, u.is_active, a.nombre AS tutorAulaNombre "
                + "FROM Persona p "
                + "JOIN Usuario u ON p.id = u.id "
                + "LEFT JOIN Rol r ON u.role_id = r.id "
                + "LEFT JOIN Aula a ON u.id = a.tutor_id "
                + "WHERE r.nombre = 'Docente' AND p.nombre LIKE ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, "%" + nombre + "%");

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    boolean isActive = rs.getInt("is_active") == 1;

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
                            isActive,
                            rs.getString("tutorAulaNombre")
                    );
                    docentes.add(docente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docentes;
    }

}
