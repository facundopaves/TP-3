//Defino una clase llamada caballo que extiende otra clase llamada pieza
public class Caballo extends Pieza {

    public Caballo(){} //Constructor vacio

    public Caballo(String colorPieza, String movimiento, String caracter) {
        super(colorPieza, movimiento, caracter, "Lenta"); //la clase super se utiliza para referirse a la clase padre,
        //en este caso el metodo super() llama al constructor de la clase Pieza
    }

    @Override
    public String mover(){
        return "Me muevo en L";
    }
}
