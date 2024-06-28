package dao;

import Interface.CursoDAO;
import Model.Curso;
import Model.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO {

    @Override
    public Curso getCursoById(int id) {
        Curso curso = null;
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Curso WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    curso = new Curso(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("Descripcion"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return curso;
    }

    @Override
    public List<Curso> getAllCursos() {
        List<Curso> cursos = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery("SELECT ID,Nombre,Descripcion FROM Curso")) {
            while (rs.next()) {
                Curso curso = new Curso(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("Descripcion"));
                cursos.add(curso);
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }
    
    @Override
    public List<Curso> getCursosByName(String name) {
        List<Curso> filteredCursos = new ArrayList<>(); 
        String sql = "SELECT * FROM Curso WHERE nombre LIKE ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"));
                filteredCursos.add(curso);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return filteredCursos;
    }

    @Override
    public boolean insertCurso(Curso curso) {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Curso (Nombre, Descripcion) VALUES (?, ?)")) {
            preparedStatement.setString(1, curso.getNombre());
            preparedStatement.setString(2, curso.getDescripcion());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCurso(Curso curso) {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Curso SET Nombre = ?, Descripcion = ? WHERE ID = ?")) {
            preparedStatement.setString(1, curso.getNombre());
            preparedStatement.setString(2, curso.getDescripcion());
            preparedStatement.setInt(3, curso.getID());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCurso(int id) {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Curso WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
