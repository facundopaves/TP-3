import java.util.ArrayList;
import java.util.List;

// Clase principal
public class App {

    // Método para crear las piezas blancas
    public static void crearPiezas(List<Pieza> piezasBlancas) {
        for (int i = 1; i <= 8; i++) { // Creo 8 peones
            piezasBlancas.add(new Peon("Blanco", "Ladino", "Agresor"));
        }
        for (int i = 1; i <= 2; i++) { // Creo 2 torres
            piezasBlancas.add(new Torre("Blanco", "Hacia delante", "Homerica"));
        }
        for (int i = 1; i <= 2; i++) { // Creo 2 alfiles
            piezasBlancas.add(new Alfil("Blanco", "Diagonal", "Sesgo"));
        }
        for (int i = 1; i <= 2; i++) { // Creo 2 caballos
            piezasBlancas.add(new Caballo("Blanco", "L", "Ligero"));
        }

        piezasBlancas.add(new Reina("Blanco", "Diagonal", "Encarnizada"));
        piezasBlancas.add(new Rey("Blanco", "Ladino", "Postrero"));
    }

    // Método para imprimir las piezas
    public static void imprimirPiezas(List<Pieza> piezas) {
        System.out.println("==================== PIEZAS BLANCAS ====================\n");

        // Recorro la lista de piezas y las imprimo
        for (Pieza pieza : piezas) {
            System.out.println("------- " + pieza.getClass().getSimpleName() + " --------");
            System.out.println("Color: " + pieza.getColor());
            System.out.println("Caracter: " + pieza.getCaracter());
            System.out.println("Movimiento: " + pieza.getMovimiento());
            System.out.println("Velocidad: " + pieza.getVelocidad());
            System.err.println("Movimiento literal: " + pieza.mover());
            System.out.println(); // Salto de línea
        }
    }

    //clase main
    public static void main(String[] args) {
        // Creo un objeto tablero que tiene 8 filas y 8 columnas
        Tablero tablero = new Tablero(8, 8);

        // Creo las piezas y las agrego a una lista
        List<Pieza> piezasBlancas = new ArrayList<>();

        // Creo las piezas blancas
        crearPiezas(piezasBlancas);

        // Imprimo las piezas y el tablero
        imprimirPiezas(piezasBlancas);
        System.out.println("===== Tablero =====");
        tablero.imprimirTablero(); // Imprimo el tablero
    }
}
