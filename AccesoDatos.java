import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDatos {

    private static final String URL = "jdbc:mysql://localhost:3306/Ajedrez"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "root"; 

    public static Connection obtenerConexion() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
