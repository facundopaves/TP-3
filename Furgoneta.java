public class Furgoneta extends Vehiculo_de_carga {

    public Furgoneta(String patente, int diasDeAlquiler, float pesoMaximoAutorizado) {
        super(patente, diasDeAlquiler, pesoMaximoAutorizado);
    }


    //sobreescribo el metodo calcularcargoadicional
    @Override
    protected double calcularCargoAdicional() {

        // Cálculo del precio adicional para furgonetas

        return 800 * getPesoMaximoAutorizado(); 
    }
}
