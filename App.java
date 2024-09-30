import java.util.ArrayList; 
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Creo un objeto tablero que tiene 8 filas y 8 columnas
        Tablero tablero = new Tablero(8, 8);

        // Creo las piezas y las agrego a una lista
        List<Pieza> piezasBlancas = crearPiezas();

        // Imprimo las piezas y el tablero
        imprimirPiezas(piezasBlancas);
        System.out.println("===== Tablero =====");
        tablero.imprimirTablero(); // Imprimo el tablero
    }

    // Método para crear las piezas blancas
    private static List<Pieza> crearPiezas() {
        List<Pieza> piezasBlancas = new ArrayList<>();
        
        for (int i = 1; i <= 8; i++) { // Creo 8 peones
            piezasBlancas.add(new Peon("Blanco", "Hacia delante 1 casilla", "Agresor"));
        }
        for (int i = 1; i <= 2; i++) { // Creo 2 torres
            piezasBlancas.add(new Torre("Blanco", "Hacia delante", "Directa"));
        }
        for (int i = 1; i <= 2; i++) { // Creo 2 alfiles
            piezasBlancas.add(new Alfil("Blanco", "Diagonal", "Astuto"));
        }
        for (int i = 1; i <= 2; i++) { // Creo 2 caballos
            piezasBlancas.add(new Caballo("Blanco", "L", "Ligero"));
        }

        piezasBlancas.add(new Reina("Blanco", "Diagonal", "Encarnizada"));
        piezasBlancas.add(new Rey("Blanco", "Ladino", "Postrero"));

        return piezasBlancas; // Retorno la lista de piezas
    }

    // Método para imprimir las piezas
    private static void imprimirPiezas(List<Pieza> piezas) {
        System.out.println("==================== PIEZAS BLANCAS ====================\n");

        // Recorro la lista de piezas y las imprimo
        for (Pieza pieza : piezas) {
            System.out.println("------- " + pieza.getClass().getSimpleName() + " --------"); // con el get class obtengo lo que pertenece al objeto pieza
            // el simple name retorna el nombre simple de la clase
            System.out.println("Color: " + pieza.getColor());
            System.out.println("Caracter: " + pieza.getCaracter());
            System.out.println("Movimiento: " + pieza.getMovimiento());
            System.out.println("Velocidad: " + pieza.getVelocidad());
            System.err.println("Movimiento literal: " + pieza.mover());
            System.out.println(); // Salto de línea
        }
    }
}
