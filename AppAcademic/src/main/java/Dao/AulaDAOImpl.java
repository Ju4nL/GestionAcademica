/*package Dao;

import Interface.AulaDAO;
import Model.Aula;
import Model.Docente;
import Model.Grado;
import Model.Seccion;
import Model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AulaDAOImpl implements AulaDAO {

    @Override
    public Aula getAulaById(int id) {
        Aula aula = null;
        String sql = "SELECT a.*, g.nombre AS gradoNombre, s.nombre AS seccionNombre, p.nombre AS tutorNombre, p.apellidos AS tutorApellidos, p.dni AS tutorDni, p.sexo AS tutorSexo, p.fechaNacimiento AS tutorFechaNacimiento, p.telefono AS tutorTelefono, p.direccion AS tutorDireccion, p.email AS tutorEmail " +
                     "FROM Aula a " +
                     "JOIN Grado g ON a.grado_id = g.id " +
                     "JOIN Seccion s ON a.seccion_id = s.id " +
                     "JOIN Persona p ON a.tutor_id = p.id " +
                     "WHERE a.id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    Grado grado = new Grado(rs.getInt("grado_id"), rs.getString("gradoNombre"));
                    Seccion seccion = new Seccion(rs.getInt("seccion_id"), rs.getString("seccionNombre"));
                    Docente tutor = new Docente(
                            rs.getInt("tutor_id"),
                            rs.getString("tutorNombre"),
                            rs.getString("tutorApellidos"),
                            rs.getString("tutorDni"),
                            rs.getString("tutorSexo"),
                            rs.getDate("tutorFechaNacimiento").toLocalDate(),
                            rs.getString("tutorTelefono"),
                            rs.getString("tutorDireccion"),
                            rs.getString("tutorEmail"),
                            null,
                            null
                    );
                    aula = new Aula(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("anio"),
                            grado,
                            seccion,
                            tutor
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aula;
    }

    @Override
    public List<Aula> getAllAulas() {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT a.*, g.nombre AS gradoNombre, s.nombre AS seccionNombre, p.nombre AS tutorNombre, p.apellidos AS tutorApellidos, p.dni AS tutorDni, p.sexo AS tutorSexo, p.fechaNacimiento AS tutorFechaNacimiento, p.telefono AS tutorTelefono, p.direccion AS tutorDireccion, p.email AS tutorEmail " +
                     "FROM Aula a " +
                     "JOIN Grado g ON a.grado_id = g.id " +
                     "JOIN Seccion s ON a.seccion_id = s.id " +
                     "JOIN Persona p ON a.tutor_id = p.id";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Grado grado = new Grado(rs.getInt("grado_id"), rs.getString("gradoNombre"));
                Seccion seccion = new Seccion(rs.getInt("seccion_id"), rs.getString("seccionNombre"));
                Docente tutor = new Docente(
                        rs.getInt("tutor_id"),
                        rs.getString("tutorNombre"),
                        rs.getString("tutorApellidos"),
                        rs.getString("tutorDni"),
                        rs.getString("tutorSexo"),
                        rs.getDate("tutorFechaNacimiento").toLocalDate(),
                        rs.getString("tutorTelefono"),
                        rs.getString("tutorDireccion"),
                        rs.getString("tutorEmail"),
                        null,
                        null
                );
                Aula aula = new Aula(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("anio"),
                        grado,
                        seccion,
                        tutor
                );
                aulas.add(aula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aulas;
    }

    @Override
    public boolean insertAula(Aula aula) {
        String sql = "INSERT INTO Aula (nombre, anio, grado_id, seccion_id, tutor_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, aula.getNombre());
            preparedStatement.setInt(2, aula.getAnio());
            preparedStatement.setInt(3, aula.getGrado().getId());
            preparedStatement.setInt(4, aula.getSeccion().getId());
            preparedStatement.setInt(5, aula.getTutor().getId());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        aula.setID(generatedKeys.getInt(1));
                    }
                }
            }
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAula(Aula aula) {
        String sql = "UPDATE Aula SET nombre = ?, anio = ?, grado_id = ?, seccion_id = ?, tutor_id = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, aula.getNombre());
            preparedStatement.setInt(2, aula.getAnio());
            preparedStatement.setInt(3, aula.getGrado().getId());
            preparedStatement.setInt(4, aula.getSeccion().getId());
            preparedStatement.setInt(5, aula.getTutor().getId());
            preparedStatement.setInt(6, aula.getID());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAula(int id) {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Aula WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
*/