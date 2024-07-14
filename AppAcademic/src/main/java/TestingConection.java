import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestingConection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://db-projects.cn62022agaif.us-east-2.rds.amazonaws.com:3306/DbAcademic";
        String user = "root";
        String password = "bjNCKeZEamuJIGdNAmPrjgwvaYkTkriA";

        Connection conn = null;

        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexión establecida correctamente");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
