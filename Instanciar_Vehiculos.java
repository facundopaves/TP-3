public class Instanciar_Vehiculos {

    public double calcularPrecioAuto(int cantidadPasajeros, int diasDeAlquiler) {
        Auto auto = new Auto("ABC123", diasDeAlquiler, cantidadPasajeros); // instancio un objeto creando una patente de ejemplo

        return auto.calcularPrecio(); // Llamo al metodo de calculo de precio de la clase Auto
    }

    public double calcularPrecioCamion(float pesoMaximoAutorizado, int diasDeAlquiler) {
        Camion camion = new Camion("DEF456", diasDeAlquiler, pesoMaximoAutorizado);
        return camion.calcularPrecio(); // '' clase Camion
    }

    public double calcularPrecioFurgoneta(float pesoMaximoAutorizado, int diasDeAlquiler) {
        Furgoneta furgoneta = new Furgoneta("GHI789", diasDeAlquiler, pesoMaximoAutorizado);
        return furgoneta.calcularPrecio(); // '' clase Furgoneta
    }

    public double calcularPrecioMinivan(int cantidadPasajeros, int diasDeAlquiler) {
        Minivan minivan = new Minivan("JKL012", diasDeAlquiler, cantidadPasajeros); // Ejemplo de patente
        return minivan.calcularPrecio(); // Llama al método de cálculo de precio de la clase Minivan
    }

}
