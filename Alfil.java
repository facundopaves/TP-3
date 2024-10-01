public class Alfil extends Pieza {


    public Alfil(){} //Constructor vacio

    
    // Constructor de la clase Alfil
    public Alfil(String colorPieza, String movimiento, String caracter) {
        super(colorPieza, movimiento, caracter,"lenta");
    }

    @Override //sobreescribo un metodo de la clase padre
    
    public String mover(){
        return "se mueve en diagonal";
    }
}
