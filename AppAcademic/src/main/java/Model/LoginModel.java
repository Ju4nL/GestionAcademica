
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public String [] authenticate(String email, String password ) {
        String query = "SELECT id, password, role_id from Usuario WHERE email = ?";
        
        return null;
    }
}
