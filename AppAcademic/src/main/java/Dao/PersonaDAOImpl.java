package Dao;

import Interface.PersonaDAO;
import Model.Persona;
import Model.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {

    @Override
    public Persona getPersonaById(int id) {
        Persona persona = null;
        String sql = "SELECT id, nombre, apellidos, dni, sexo, fechaNacimiento, telefono, direccion, email FROM Persona WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    persona = new Persona(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("sexo"),
                        rs.getDate("fechaNacimiento"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persona;
    }

    @Override
    public List<Persona> getAllPersonas() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT id, nombre, apellidos, dni, sexo, fechaNacimiento, telefono, direccion, email FROM Persona";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Persona persona = new Persona(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("dni"),
                    rs.getString("sexo"),
                    rs.getDate("fechaNacimiento"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("email")
                );
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    @Override
    public boolean insertPersona(Persona persona) {
        String sql = "INSERT INTO Persona (nombre, apellidos, dni, sexo, fechaNacimiento, telefono, direccion, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellidos());
            preparedStatement.setString(3, persona.getDni());
            preparedStatement.setString(4, persona.getSexo());
            preparedStatement.setDate(5, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            preparedStatement.setString(6, persona.getTelefono());
            preparedStatement.setString(7, persona.getDireccion());
            preparedStatement.setString(8, persona.getEmail());
            int affectedRows = preparedStatement.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        persona.setId(generatedKeys.getInt(1));
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
    public boolean updatePersona(Persona persona) {
        String sql = "UPDATE Persona SET nombre = ?, apellidos = ?, dni = ?, sexo = ?, fechaNacimiento = ?, telefono = ?, direccion = ?, email = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellidos());
            preparedStatement.setString(3, persona.getDni());
            preparedStatement.setString(4, persona.getSexo());
            preparedStatement.setDate(5, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            preparedStatement.setString(6, persona.getTelefono());
            preparedStatement.setString(7, persona.getDireccion());
            preparedStatement.setString(8, persona.getEmail());
            preparedStatement.setInt(9, persona.getId());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePersona(int id) {
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
