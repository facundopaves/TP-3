public class Minivan extends Vehiculo_de_pasajeros {
    private int cantidad; // Cantidad de pasajeros

    // Constructor
    public Minivan(String patente, int diasDeAlquiler, int cantidad) {
        super(patente, diasDeAlquiler, cantidad); // Pasar la cantidad al constructor de la clase base
        this.cantidad = cantidad; // Inicializar el atributo cantidad
    }

    @Override
    public double calcularPrecio() {
        double precioBase = super.calcularPrecio(); // Obtener el precio base de la clase base
        double precioAdicional = 120 * cantidad; // Cargo adicional por cada pasajero
        return precioBase + precioAdicional; // Sumar el precio base y el cargo adicional
    }

    // Getter para la cantidad
    public int getCantidad() {
        return cantidad; // Método para obtener la cantidad de pasajeros
    }
}
