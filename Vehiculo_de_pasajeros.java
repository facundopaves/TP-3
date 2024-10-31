public abstract class Vehiculo_de_pasajeros extends Vehiculo {
    private int cantidad; // Cantidad de pasajeros o plazas

    // Constructor
    public Vehiculo_de_pasajeros(String patente, int diasDeAlquiler, int cantidad) {
        super(patente, diasDeAlquiler);
        this.cantidad = cantidad;
    }

    @Override
    public double calcularPrecio() {

        // Precio base por dias de alquiler
        double precioBasePorDias = getPrecioBase() * getDiasDeAlquiler();

        // FORMULA: (precio base * días) + 100 * (días + plazas)
        double precioTotal = precioBasePorDias + 100 * getDiasDeAlquiler();

        return precioTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
