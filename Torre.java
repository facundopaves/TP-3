public class Torre extends Pieza {
    public Torre(String colorPieza, String movimiento, String caracter) {
        super(colorPieza, movimiento, caracter,"Lenta");
    }


    @Override
    
    public String mover(){
        return "Se mueve en linea recta, hacia delante y hacia atras";
    }
}
