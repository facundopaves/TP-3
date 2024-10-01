//Defino una clase llamada Reina que extiende otra clase llamada pieza
public class Reina extends Pieza {

    public Reina(){} //Constructor vacio

    public Reina(String colorPieza, String movimiento, String caracter) {
        super(colorPieza, movimiento, caracter,"Lenta");
    }


    @Override
    
    public String mover(){
        return "Se mueve en diagonal como en horizontal y en vertical";
    }
}
