public class Auto {
    //declaro las variables
    private String patente;
    private int diasDeAlquiler;
    private int cantidadPasajeros;

    public Auto(String patente, int diasDeAlquiler, int cantidadPasajeros) {
        this.patente = patente;
        this.diasDeAlquiler = diasDeAlquiler;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    // Método para obtener los días de alquiler
    public int getDiasDeAlquiler() {
        return diasDeAlquiler;
    }

    // Método para calcular el precio basado en la fórmula proporcionada
    public double calcularPrecio() {
        double precioBase = 2000; // Precio base por día
        return (precioBase * diasDeAlquiler) + 100 * (diasDeAlquiler + cantidadPasajeros);
    }
}
