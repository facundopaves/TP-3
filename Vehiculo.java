public abstract class Vehiculo {
    private String patente;
    private int diasDeAlquiler;
    private final double precioBase; // Precio base por día es fijo

    // Constructor
    public Vehiculo(String patente, int diasDeAlquiler) {
        this.patente = patente;
        this.diasDeAlquiler = diasDeAlquiler;
        this.precioBase = 2000; // Establece precio base por día
    }

    // Metodo abstracto para calcular el precio
    public abstract double calcularPrecio();

    // Getters
    public String getPatente() {
        return patente;
    }

    public int getDiasDeAlquiler() {
        return diasDeAlquiler;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    // En la clase Vehiculo
    public void setDiasDeAlquiler(int diasDeAlquiler) {
        this.diasDeAlquiler = diasDeAlquiler;
    }

}
