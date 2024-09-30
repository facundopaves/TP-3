public abstract class Pieza {
    private String colorPieza;
    private String movimiento;
    private String caracter;
    private String velocidad="Lenta";  //Con esto seteo por defecto la velocidad a lenta
    

    // Constructor 
    public Pieza(String colorPieza, String movimiento, String caracter, String velocidad) {
        this.colorPieza = colorPieza;
        this.movimiento = movimiento;
        this.caracter = caracter;
        this.velocidad = velocidad;
        
    }


    //-------------------------------------------------------------------------//
    // Getters
    public String getColor() {
        return colorPieza;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public String getCaracter() {
        return caracter;
    }

    public String getVelocidad() {
        return velocidad;
    }

   

    //-------------------------------------------------------------------------//

    //-------------------------------------------------------------------------//
    //Setters

    public void setColorPieza(String colorPieza) {
        this.colorPieza = colorPieza;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

   
    //-------------------------------------------------------------------------//

    public abstract String mover();
}
