import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Defino los colores
        String rojo = "\033[31m";  // Rojo
        String verde = "\033[32m"; // Verde
        String amarillo = "\033[33m"; // Amarillo
        String reset = "\033[0m";  // Resetear color

        Scanner scanner = new Scanner(System.in);
        Connection connection = AccesoDatos.obtenerConexion(); // Obtengo la conexión a la BD
        IPiezaDAO iPiezaDAO = new PiezaDAO(connection);  // Pasa la conexión al constructor de PiezaDAO

        System.out.println(rojo + "================== Ajedrez con Base de Datos ==================\n\n" + reset);

        int opcion;

        try {
            do {
                System.out.println(rojo + "================== Menu ==================" + reset);
                System.out.println(verde + "1- Insertar las piezas" + reset);
                System.out.println(verde + "2- Mostrar las piezas" + reset);
                System.out.println(verde + "3- Eliminar una pieza" + reset);
                System.out.println(verde + "4- Salir" + reset);

                System.out.print(amarillo + "\nSeleccione una opción: " + reset);
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        insertarPiezas(iPiezaDAO);
                        break;
                    case 2:
                        iPiezaDAO.mostrarInformacionPiezas();
                        break;
                    case 3:
                        eliminarPieza(iPiezaDAO, scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }

            } while (opcion != 4);

        } catch (SQLException e) {
            System.err.println("Error al realizar la operación en la base de datos: " + e.getMessage());
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
            scanner.close();
        }
    }

    // Método para insertar varias piezas de ajedrez
    public static void insertarPiezas(IPiezaDAO iPiezaDAO) throws SQLException {
       
        
        // Crear e insertar las piezas blancas
        for (int i = 1; i <= 8; i++) {
            Peon peon = new Peon("Blanco", "Ladino", "Agresor");
            iPiezaDAO.insertarPieza(peon); //llamo al metodo InsertarPieza de la interfaz IpiezaDAO y le paso el objeto Rey Negro
        }
        for (int i = 1; i <= 2; i++) {
            Torre torre = new Torre("Blanco", "Hacia delante", "Homerica");
            iPiezaDAO.insertarPieza(torre);
        }
        for (int i = 1; i <= 2; i++) {
            Alfil alfil = new Alfil("Blanco", "Diagonal", "Sesgo");
            iPiezaDAO.insertarPieza(alfil);
        }
        for (int i = 1; i <= 2; i++) {
            Caballo caballo = new Caballo("Blanco", "L", "Ligero");
            iPiezaDAO.insertarPieza(caballo);
        }
        
        Reina reinaBlanca = new Reina("Blanco", "Diagonal", "Encarnizada");
        iPiezaDAO.insertarPieza(reinaBlanca);
        
        Rey reyBlanco = new Rey("Blanco", "Ladino", "Postrero");
        iPiezaDAO.insertarPieza(reyBlanco);

        // Crear e insertar las piezas negras
        for (int i = 1; i <= 8; i++) {
            Peon peon = new Peon("Negro", "Ladino", "Agresor");
            iPiezaDAO.insertarPieza(peon);
        }
        for (int i = 1; i <= 2; i++) {
            Torre torre = new Torre("Negro", "Hacia delante", "Homerica");
            iPiezaDAO.insertarPieza(torre);
        }
        for (int i = 1; i <= 2; i++) {
            Alfil alfil = new Alfil("Negro", "Diagonal", "Sesgo");
            iPiezaDAO.insertarPieza(alfil);
        }
        for (int i = 1; i <= 2; i++) {
            Caballo caballo = new Caballo("Negro", "L", "Ligero");
            iPiezaDAO.insertarPieza(caballo);
        }

        Reina reinaNegra = new Reina("Negro", "Diagonal", "Encarnizada");
        iPiezaDAO.insertarPieza(reinaNegra);

        Rey reyNegro = new Rey("Negro", "Ladino", "Postrero");
        iPiezaDAO.insertarPieza(reyNegro);
    }

    public static void eliminarPieza(IPiezaDAO iPiezaDAO, Scanner scanner) {
        System.out.print("Ingrese el ID de la pieza que desea eliminar: ");
        int idPieza = scanner.nextInt();
        iPiezaDAO.eliminarPieza(idPieza);
    }
}
