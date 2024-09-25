import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Creo un objeto tablero que tiene 8 filas y 8 columnas
        Tablero tablero = new Tablero(8, 8);

        // Creo las piezas y las agrego a una lista
        List<Pieza> piezasBlancas = new ArrayList<>();
        for(int i=1; i<=8;i++){ //con el for imprimo 8 peones
            piezasBlancas.add(new Peon("Blanco", "Hacia delante 1 casilla", "Agresor"));

        }
        for(int i=1; i<=2;i++){ //con el for imprimo 2 torres
        piezasBlancas.add(new Torre("Blanco", "Hacia delante", "Directa"));
        }
        for(int i=1; i<=2;i++) { //con el for imprimo 2 alfiles
        piezasBlancas.add(new Alfil("Blanco", "Diagonal", "Astuto"));
        }
        for(int i=1; i<=2;i++) { //con el for imprimo 2 caballos
            piezasBlancas.add(new Caballo("Blanco", "L", "Ligero"));
        }

        piezasBlancas.add(new Reina("Blanco", "Diagonal", "Encarnizada"));
        piezasBlancas.add(new Rey("Blanco", "Ladino", "Postrero"));

        System.out.println("==================== PIEZAS BLANCAS ===================="); 
        System.out.println();

        // Recorro la lista de piezas blancas y las imprimo
        for (Pieza pieza : piezasBlancas) {
            System.out.println("------- " + pieza.getClass().getSimpleName() + " --------");
            System.out.println("Color: " + pieza.getColor());
            System.out.println("Caracter: " + pieza.getCaracter());
            System.out.println("Movimiento: " + pieza.getMovimiento());
            System.out.println("Velocidad: " + pieza.getVelocidad());
            System.out.println(); // Salto de línea
        }
        

        System.out.println("===== Tablero =====");
        tablero.imprimirTablero();
    }
}
