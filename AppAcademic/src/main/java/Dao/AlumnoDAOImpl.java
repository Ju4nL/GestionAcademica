package Dao;

import Interface.RegistrarAlumnoDAO;
import Model.RegistrarAlumno;
import Model.DatabaseConnection;
import java.sql.*;
import java.util.List;
import java.util.Random;

public class AlumnoDAOImpl implements RegistrarAlumnoDAO {

    @Override
    public boolean insertAlumno(RegistrarAlumno alumno) {
        boolean personaInserted = false;
        boolean usuarioInserted = false;
        boolean solicitudVacanteInserted = false;
        int personaId = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);

            System.out.println("Insertando en Persona...");
            // Insert into Persona table
            String insertPersonaSql = "INSERT INTO Persona (nombre, apellidos, dni, sexo, fechaNacimiento, telefono, direccion, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement personaStmt = connection.prepareStatement(insertPersonaSql, Statement.RETURN_GENERATED_KEYS)) {
                personaStmt.setString(1, alumno.getNombre());
                personaStmt.setString(2, alumno.getApellidos());
                personaStmt.setString(3, alumno.getDni());
                personaStmt.setString(4, alumno.getSexo());
                personaStmt.setDate(5, Date.valueOf(alumno.getFechaNacimiento()));
                personaStmt.setString(6, alumno.getTelefono());
                personaStmt.setString(7, alumno.getDireccion());
                personaStmt.setString(8, alumno.getCorreo());

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
                                usuarioStmt.setString(2, alumno.getCorreo());
                                usuarioStmt.setString(3, alumno.getContraseña());
                                usuarioStmt.setInt(4, 3);
                                usuarioStmt.setBoolean(5, true);

                                int userAffectedRows = usuarioStmt.executeUpdate();
                                System.out.println("Filas afectadas en Usuario: " + userAffectedRows);
                                usuarioInserted = userAffectedRows > 0;
                            }

                            System.out.println("Insertando en SolicitudVacante...");
                            // Insert into SolicitudVacante table
                            String insertSolicitudVacanteSql = "INSERT INTO SolicitudVacante (padre_id, alumno_id, grado_id, seccion_id, fechaSolicitud, estado) VALUES (?, ?, ?, ?, ?, ?)";
                            try (PreparedStatement solicitudVacanteStmt = connection.prepareStatement(insertSolicitudVacanteSql)) {
                                solicitudVacanteStmt.setInt(1, 1); // 1 = rol de padre
                                solicitudVacanteStmt.setInt(2, personaId);
                                solicitudVacanteStmt.setInt(3, getGradoId(alumno.getGrado())); // Actualizado para usar getGrado()
                                solicitudVacanteStmt.setInt(4, getSeccionId(alumno.getSeccion())); // Asumir cualquier seccion
                                solicitudVacanteStmt.setDate(5, new Date(System.currentTimeMillis()));
                                solicitudVacanteStmt.setString(6, "Pendiente");

                                int solicitudVacanteAffectedRows = solicitudVacanteStmt.executeUpdate();
                                System.out.println("Filas afectadas en SolicitudVacante: " + solicitudVacanteAffectedRows);
                                solicitudVacanteInserted = solicitudVacanteAffectedRows > 0;
                            }
                        }
                    }
                }
            }

            if (personaInserted && usuarioInserted && solicitudVacanteInserted) {
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
        return personaInserted && usuarioInserted && solicitudVacanteInserted;
    }

    private int getGradoId(String grado) throws SQLException {
        System.out.println("Obteniendo ID de Grado para: " + grado);
        int gradoId = 0;
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement("SELECT id FROM Grado WHERE nombre = ?")) {
            stmt.setString(1, grado);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    gradoId = rs.getInt("id");
                    System.out.println("ID de Grado obtenido: " + gradoId);
                }
            }
        }
        return gradoId;
    }
    
     private int getSeccionId(String seccion) throws SQLException { 
        int seccionid = 0;
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement("SELECT id FROM Seccion WHERE nombre = ?")) {
            stmt.setString(1, seccion);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    seccionid = rs.getInt("id");
                     
                }
            }
        }
        return seccionid;
    }
 
    @Override
    public List<RegistrarAlumno> getAllAlumnos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RegistrarAlumno getAlumnoByDni(String dni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateAlumno(RegistrarAlumno alumno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteAlumno(String dni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
