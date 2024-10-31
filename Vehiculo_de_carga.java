public abstract class Vehiculo_de_carga extends Vehiculo {
    private float pesoMaximoAutorizado; // Peso Máximo Autorizado en toneladas

    // Constructor
    public Vehiculo_de_carga(String patente, int diasDeAlquiler, float pesoMaximoAutorizado) {
        super(patente, diasDeAlquiler);
        this.pesoMaximoAutorizado = pesoMaximoAutorizado;
    }

    // Getters
    public float getPesoMaximoAutorizado() {
        return pesoMaximoAutorizado;
    }

    @Override
    public double calcularPrecio() {
        
        // Precio base por días de alquiler
        double precioBasePorDias = 2000 * getDiasDeAlquiler(); // Precio base por días de alquiler
        
        // Este metodo debe ser implementado por las subclases
        return precioBasePorDias + calcularCargoAdicional();
    }

    // Metodo abstracto para el cargo adicional que tengo que hacerle a los camiones(1600)
    protected abstract double calcularCargoAdicional();
}
