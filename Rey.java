//Defino una clase llamada Rey que extiende otra clase llamada pieza
public class Rey extends Pieza {

    public Rey(){}//Constructor vacio


    public Rey(String colorPieza, String movimiento, String caracter) {
        super(colorPieza, movimiento, caracter,"Lenta");
    }


    @Override
    
    public String mover(){
        return "Solo se puede mover una casilla horizontal, vertical o diagonal";
    }
}
