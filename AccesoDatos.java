import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDatos {

    private static final String URL = "jdbc:mysql://localhost:3306/Ajedrez"; // Cambia "tu_base_de_datos" por el nombre de tu BD
    private static final String USER = "root"; // Cambia "tu_usuario" por tu usuario de BD
    private static final String PASSWORD = "root"; // Cambia "tu_contraseña" por tu contraseña de BD

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
