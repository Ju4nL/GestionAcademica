package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://roundhouse.proxy.rlwy.net:58769/DbAcademic";
    private static final String USER = "root";
    private static final String PASSWORD = "bjNCKeZEamuJIGdNAmPrjgwvaYkTkriA";

    // Método para obtener la conexión a la base de datos MySQL
    public static Connection getConnection() throws SQLException {
        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer y retornar la conexión
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("No se encontró el driver JDBC", e);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar a la base de datos", e);
        }
    }

 
}
