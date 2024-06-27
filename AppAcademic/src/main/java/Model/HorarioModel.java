package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorarioModel {

    public List<String[]> getHorarios() {
        List<String[]> horarios = new ArrayList<>();
        String query = "SELECT h.horarioInicio, h.horarioFin, c.Nombre, p.nombre AS docente, p.telefono, p.email, a.nombre AS aula, h.dia "
                     + "FROM HorarioCurso h "
                     + "JOIN Curso c ON h.curso_id = c.id "
                     + "JOIN Persona p ON h.docente_id = p.id "
                     + "JOIN Aula a ON h.aula_id = a.id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String horario = rs.getString("horarioInicio") + " - " + rs.getString("horarioFin");
                String detalle = rs.getString("Nombre") + "<br>"
                               + rs.getString("docente") + "<br>"
                               + rs.getString("telefono") + "<br>"
                               + rs.getString("email") + "<br>"
                               + rs.getString("aula");

                String[] row = new String[6];
                row[0] = horario;

                switch (rs.getString("dia")) {
                    case "Lunes":
                        row[1] = detalle;
                        break;
                    case "Martes":
                        row[2] = detalle;
                        break;
                    case "Miercoles":
                        row[3] = detalle;
                        break;
                    case "Jueves":
                        row[4] = detalle;
                        break;
                    case "Viernes":
                        row[5] = detalle;
                        break;
                }

                horarios.add(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return horarios;
    }
}


