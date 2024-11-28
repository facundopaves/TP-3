import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDatos {

    private String maquina = "localhost";
    private String usuario = "root";
    private String clave = "root";
    private int puerto = 3306;
    private String bd = "cotizador";
    private String servidor;
    private Connection conexion;

    public AccesoDatos() {
        this.servidor = "jdbc:mysql://" + this.maquina + ":" + this.puerto + "/" + this.bd;
        try {
            // Carga el driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece la conexión
            conexion = DriverManager.getConnection(this.servidor, this.usuario, this.clave);
            System.out.println("Conectado a la base de datos: " + bd);
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            e.printStackTrace();
        }
    }

    // Devuelve el objeto Connection
    public Connection getConexion() {
        return conexion;
    }

    // Cierra la conexión
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}
