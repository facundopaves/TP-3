import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class PiezaDAO implements IPiezaDAO {

    private Connection connection; // Conexión de base de datos

    // Colores para la consola
    private static final String ROJO = "\033[31m";
    private static final String VERDE = "\033[32m";
    private static final String AMARILLO = "\033[33m";
    private static final String ROSA = "\033[35m";
    private static final String AZUL = "\033[34m";
    private static final String RESET = "\033[0m";

    // Constructor que recibe la conexión
    public PiezaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para obtener la conexión
    private Connection getConexion() {
        return connection;
    }

    // Método para insertar una pieza usando un objeto Pieza
    @Override
    public void insertarPieza(Pieza pieza) {
        String query = "INSERT INTO pieza (color, movimiento, velocidad, nombre, caracter, fecha_insercion) VALUES (?, ?, ?, ?, ?, ?)";
        
        if (connection == null) {
            System.err.println("Conexión no establecida. Verifique la configuración de la base de datos.");
            return;
        }

        try (PreparedStatement pstmt = getConexion().prepareStatement(query)) {
            pstmt.setString(1, pieza.getColor());
            pstmt.setString(2, pieza.getMovimiento());
            pstmt.setString(3, pieza.getVelocidad());
            pstmt.setString(4, pieza.getClass().getSimpleName()); // Nombre de la pieza (subclase)
            pstmt.setString(5, pieza.getCaracter());
            pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis())); // Fecha actual como fecha de inserción

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Pieza insertada correctamente con fecha.");
            } else {
                System.out.println("No se pudo insertar la pieza.");
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar pieza: " + e.getMessage());
        }
    }

    // Método para mostrar todas las piezas
    @Override
    public void mostrarInformacionPiezas() {
        String query = "SELECT idpieza, color, movimiento, velocidad, nombre, caracter, fecha_insercion FROM pieza";

        if (connection == null) {
            System.err.println("Conexión no establecida. Verifique la configuración de la base de datos.");
            return;
        }

        try (Statement stmt = getConexion().createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println(AMARILLO + "--------------------------------------------" + RESET);

            while (rs.next()) {
                int idPieza = rs.getInt("idpieza");
                String color = rs.getString("color");
                String movimiento = rs.getString("movimiento");
                String velocidad = rs.getString("velocidad");
                String nombre = rs.getString("nombre");
                String caracter = rs.getString("caracter");
                Timestamp fechaInsercion = rs.getTimestamp("fecha_insercion");

                System.out.println(ROJO + "Pieza Nro: " + RESET + idPieza);
                System.out.println(AMARILLO + "Nombre: " + RESET + nombre);
                System.out.println(AZUL + "Caracter: " + RESET + caracter);
                System.out.println(VERDE + "Color: " + RESET + color);
                System.out.println(ROSA + "Movimiento: " + RESET + movimiento);
                System.out.println(AZUL + "Velocidad: " + RESET + velocidad);
                System.out.println("Fecha: " + fechaInsercion);
                System.out.println(AMARILLO + "--------------------------------------------" + RESET);
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
    }

    // Método para eliminar una pieza por su ID
    @Override
    public void eliminarPieza(int idPieza) {
        String query = "DELETE FROM pieza WHERE idpieza = ?";

        if (connection == null) {
            System.err.println("Conexión no establecida. Verifique la configuración de la base de datos.");
            return;
        }

        try (PreparedStatement pstmt = getConexion().prepareStatement(query)) {
            pstmt.setInt(1, idPieza);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Pieza con ID " + idPieza + " eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna pieza con ID " + idPieza + ".");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la pieza: " + e.getMessage());
        }
    }
}
