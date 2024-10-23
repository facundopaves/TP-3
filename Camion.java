public class Camion extends Vehiculo_de_carga {

    public Camion(String patente, int diasDeAlquiler, float pesoMaximoAutorizado) {
        super(patente, diasDeAlquiler, pesoMaximoAutorizado);
    }


    @Override
    protected double calcularCargoAdicional() {
        // le Calculo del precio adicional para camiones
        return (800 * getPesoMaximoAutorizado()) + 1600; // PMA + costo fijo
    }
}
