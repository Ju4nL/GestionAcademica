package Dao;

import Interface.VacanteDAO;
import Model.Vacante;
import Model.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacanteDAOImpl implements VacanteDAO {

    @Override
    public Vacante getVacanteById(int id) {
        Vacante vacante = null;
        String sql ="SELECT v.id,g.nombre as \"Grado\",s.nombre as \"Seccion\",v.cupoDisponible \n" +
                    "    FROM Vacante v \n" +
                    "    JOIN Grado g ON v.grado_id=g.id\n" +
                    "    JOIN Seccion s ON v.seccion_id=s.id\n" +
                    "    WHERE v.id = ? ";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    vacante = new Vacante(rs.getInt("ID"), rs.getString("Grado"), rs.getString("Seccion"),rs.getInt("cupoDisponible"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacante;
    }

    @Override
    public List<Vacante> getAllVacantes() {
        List<Vacante> vacantes = new ArrayList<>();
        String sql ="SELECT v.id,g.nombre as \"Grado\",s.nombre as \"Seccion\",v.cupoDisponible \n" +
                    "    FROM Vacante v \n" +
                    "    JOIN Grado g ON v.grado_id=g.id\n" +
                    "    JOIN Seccion s ON v.seccion_id=s.id\n" ;
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Vacante vacante = new  Vacante(rs.getInt("ID"), 
                                               rs.getString("Grado"), 
                                               rs.getString("Seccion"),
                                               rs.getInt("cupoDisponible"));
                vacantes.add(vacante);
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacantes;
    }
    
    /*
    @Override
    public List<Vacante> getVacantesByName(String name) {
        MethodHandles.throwException(returnType, exType)
        List<Vacante> filteredVacantes = new ArrayList<>(); 
        String sql = "SELECT * FROM Vacante WHERE nombre LIKE ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Vacante vacante = new Vacante(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"));
                filteredVacantes.add(vacante);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return filteredVacantes;
    }

    @Override
    public boolean insertVacante(Vacante vacante) {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Vacante (Nombre, Descripcion) VALUES (?, ?)")) {
            preparedStatement.setString(1, vacante.getNombre());
            preparedStatement.setString(2, vacante.getDescripcion());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateVacante(Vacante vacante) {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Vacante SET Nombre = ?, Descripcion = ? WHERE ID = ?")) {
            preparedStatement.setString(1, vacante.getNombre());
            preparedStatement.setString(2, vacante.getDescripcion());
            preparedStatement.setInt(3, vacante.getID());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteVacante(int id) {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Vacante WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
