package Dao;

import Interface.VacanteDAO;
import Model.Vacante;
import Model.DatabaseConnection;
import Model.Grado;
import Model.Seccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacanteDAOImpl implements VacanteDAO {

    @Override
    public Vacante getVacanteById(int id) {
        Vacante vacante = null;
        String sql = "SELECT v.id, g.id as gradoID, g.nombre as gradoNombre, s.id as seccionID, s.nombre as seccionNombre, v.cupoDisponible " +
                     "FROM Vacante v " +
                     "JOIN Grado g ON v.grado_id = g.id " +
                     "JOIN Seccion s ON v.seccion_id = s.id " +
                     "WHERE v.id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    Grado grado = new Grado(rs.getInt("gradoID"), rs.getString("gradoNombre"));
                    Seccion seccion = new Seccion(rs.getInt("seccionID"), rs.getString("seccionNombre"));
                    vacante = new Vacante(rs.getInt("id"), grado, seccion, rs.getInt("cupoDisponible"));
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
        String sql = "SELECT v.id, g.id as gradoID, g.nombre as gradoNombre, s.id as seccionID, s.nombre as seccionNombre, v.cupoDisponible " +
                     "FROM Vacante v " +
                     "JOIN Grado g ON v.grado_id = g.id " +
                     "JOIN Seccion s ON v.seccion_id = s.id";
        try (Connection connection = DatabaseConnection.getConnection(); 
             Statement statement = connection.createStatement(); 
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Grado grado = new Grado(rs.getInt("gradoID"), rs.getString("gradoNombre"));
                Seccion seccion = new Seccion(rs.getInt("seccionID"), rs.getString("seccionNombre"));
                Vacante vacante = new Vacante(rs.getInt("id"), grado, seccion, rs.getInt("cupoDisponible"));
                vacantes.add(vacante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacantes;
    }
    
    @Override
    public List<Grado> getAllGrados() {
        List<Grado> grados = new ArrayList<>();
        String sql = "SELECT id, nombre FROM Grado";
        
        try (Connection connection = DatabaseConnection.getConnection(); 
             Statement statement = connection.createStatement(); 
             ResultSet rs = statement.executeQuery(sql)) {
            
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
        
        try (Connection connection = DatabaseConnection.getConnection(); 
             Statement statement = connection.createStatement(); 
             ResultSet rs = statement.executeQuery(sql)) {
            
            while (rs.next()) {
                secciones.add(new Seccion(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return secciones;
    }

    @Override
    public boolean deleteVacante(int id) {
        try (Connection connection = DatabaseConnection.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Vacante WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean insertVacante(Vacante vacante) {
        String sql = "INSERT INTO Vacante (grado_id, seccion_id, cupoDisponible) VALUES (?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, vacante.getGrado().getId());
            preparedStatement.setInt(2, vacante.getSeccion().getId());
            preparedStatement.setInt(3, vacante.getCupoDisponible());
            int affectedRows = preparedStatement.executeUpdate();
            
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean updateVacante(Vacante vacante) {
        String sql = "UPDATE Vacante SET grado_id = ?, seccion_id = ?, cupoDisponible = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnection.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, vacante.getGrado().getId());
            preparedStatement.setInt(2, vacante.getSeccion().getId());
            preparedStatement.setInt(3, vacante.getCupoDisponible());
            preparedStatement.setInt(4, vacante.getID());
            
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
