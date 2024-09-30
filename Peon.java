//Defino una clase llamada Peon que extiende otra clase llamada pieza
public class Peon extends Pieza {
    public Peon(String colorPieza, String movimiento, String caracter) {
        super(colorPieza, movimiento, caracter, "Lenta");
    }

    @Override
    public String mover(){
        return "Se mueve para adelante";
    }
}
