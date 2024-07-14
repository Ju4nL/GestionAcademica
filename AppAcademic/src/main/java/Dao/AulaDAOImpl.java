package Dao;

import Interface.AulaDAO;
import Model.Aula;
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
        String sql = "SELECT a.*, g.nombre AS gradoNombre, s.nombre AS seccionNombre, CONCAT(p.nombre, ' ', p.apellidos) AS tutorNombre "
                + "FROM Aula a "
                + "JOIN Grado g ON a.grado_id = g.id "
                + "JOIN Seccion s ON a.seccion_id = s.id "
                + "JOIN Persona p ON a.tutor_id = p.id "
                + "WHERE a.id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    Grado grado = new Grado(rs.getInt("grado_id"), rs.getString("gradoNombre"));
                    Seccion seccion = new Seccion(rs.getInt("seccion_id"), rs.getString("seccionNombre"));
                    String tutorNombre = rs.getString("tutorNombre");
                    aula = new Aula(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("anio"),
                            grado,
                            seccion,
                            tutorNombre
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
        String sql = "SELECT a.*, g.nombre AS gradoNombre, s.nombre AS seccionNombre, CONCAT(p.nombre, ' ', p.apellidos) AS tutorNombre "
                + "FROM Aula a "
                + "JOIN Grado g ON a.grado_id = g.id "
                + "JOIN Seccion s ON a.seccion_id = s.id "
                + "JOIN Persona p ON a.tutor_id = p.id";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Grado grado = new Grado(rs.getInt("grado_id"), rs.getString("gradoNombre"));
                Seccion seccion = new Seccion(rs.getInt("seccion_id"), rs.getString("seccionNombre"));
                String tutorNombre = rs.getString("tutorNombre");
                Aula aula = new Aula(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("anio"),
                        grado,
                        seccion,
                        tutorNombre
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
            preparedStatement.setInt(5, obtenerTutorId(aula.getTutor())); // Obtener el ID del tutor por su nombre completo
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
            preparedStatement.setInt(5, obtenerTutorId(aula.getTutor())); // Obtener el ID del tutor por su nombre completo
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

    @Override
    public List<Grado> getAllGrados() {
        List<Grado> grados = new ArrayList<>();
        String sql = "SELECT id, nombre FROM Grado";

        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                grados.add(new Grado(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grados;
    }

    @Override
    public List<Seccion> getAllSecciones() {
        List<Seccion> secciones = new ArrayList<>();
        String sql = "SELECT id, nombre FROM Seccion";

        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                secciones.add(new Seccion(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return secciones;
    }

    @Override
    public List<String> getAllTutores() {
        List<String> tutores = new ArrayList<>();
        String sql = "SELECT CONCAT(p.nombre, ' ', p.apellidos) AS nombreCompleto \n"
                + "FROM Persona p\n"
                + "JOIN Usuario u ON p.id = u.id	\n"
                + "WHERE role_id = 4"; // Asume que rol_id = 2 es para 'docente'

        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                tutores.add(rs.getString("nombreCompleto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tutores;
    }

    @Override
    public int obtenerTutorId(String tutorNombre) {
        String sql = "SELECT id FROM Persona WHERE CONCAT(nombre, ' ', apellidos) = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tutorNombre);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    System.out.println("id:" + rs.getInt("id"));
                    return rs.getInt("id");
                } else {
                    System.err.println("Tutor no encontrado: " + tutorNombre);
                    return -1; // Indicador de tutor no encontrado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Indicador de error
        }
    }

    public List<String> getAllCursos() {
        List<String> cursos = new ArrayList<>();
        String sql = "SELECT nombre FROM Curso";

        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                cursos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public int obtenerCursoId(String cursoNombre) {
        String sql = "SELECT id FROM Curso WHERE nombre = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cursoNombre);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    System.err.println("Curso no encontrado: " + cursoNombre);
                    return -1; // Indicador de curso no encontrado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Indicador de error
        }
    }

    public List<String[]> obtenerHorariosPorAula(int aulaId) {
        List<String[]> horarios = new ArrayList<>();
        String sql = "SELECT hc.id, c.Nombre as Curso, a.nombre as Aula, CONCAT(d.nombre, ' ', d.apellidos) as Docente, dia, horarioInicio, horarioFin "
                + "FROM HorarioCurso hc "
                + "LEFT JOIN Curso c ON hc.curso_id = c.id "
                + "LEFT JOIN Aula a ON hc.aula_id = a.id "
                + "LEFT JOIN Persona d ON hc.docente_id = d.id "
                + "WHERE a.id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, aulaId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    String[] horario = new String[7];
                    horario[0] = String.valueOf(rs.getInt("id"));
                    horario[1] = rs.getString("Curso");
                    horario[2] = rs.getString("Aula");
                    horario[3] = rs.getString("Docente");
                    horario[4] = rs.getString("dia");
                    horario[5] = rs.getTime("horarioInicio").toString();
                    horario[6] = rs.getTime("horarioFin").toString();
                    horarios.add(horario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horarios;
    }
    
    public boolean insertHorarioCurso(int aulaId, String cursoNombre, String docenteNombre, String dia, Time horarioInicio, Time horarioFin) {
    String sql = "INSERT INTO HorarioCurso (aula_id, curso_id, docente_id, dia, horarioInicio, horarioFin) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setInt(1, aulaId);
        preparedStatement.setInt(2, obtenerCursoId(cursoNombre));
        preparedStatement.setInt(3, obtenerTutorId(docenteNombre));
        preparedStatement.setString(4, dia);
        preparedStatement.setTime(5, horarioInicio);
        preparedStatement.setTime(6, horarioFin);
        int affectedRows = preparedStatement.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


}
