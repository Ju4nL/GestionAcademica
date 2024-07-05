
package Model;

import Security.PasswordUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public String[] authenticate(String username, String password) {
        String query = "SELECT id, password, role_id FROM Usuario WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) { // evitar una inyección SQL
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                int roleID = rs.getInt("role_id");
                int id = rs.getInt("id");

                if (PasswordUtils.verifyPassword(password, storedPassword)) {
                    String role;
                    switch (roleID) {
                        case 1:
                            role = "padre";
                            break;
                        case 2:
                            role = "admin";
                            break;
                        case 3:
                            role = "alumno";
                            break;
                        case 4:
                            role = "docente";
                            break;
                        default:
                            role = "unknown";
                            break;
                    }
                    return new String[]{String.valueOf(id), role};
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

