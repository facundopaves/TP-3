public class CotizacionDAO implements iCotizador_CotizacionDao {

    @Override
    public void Calcular_Precio_Alquiler(int idtipo_Vehiculo, Alquiler alquiler, Vehiculo vehiculo) {
        double precioCotizacion;

        // Dependiendo del idtipo_Vehiculo realizara una de las acciones
        switch (idtipo_Vehiculo) {
            case 1 -> {
                // Auto
                precioCotizacion = Calcular_Alquiler_Auto(alquiler, vehiculo);
            }
            case 2 -> {
                // Minivan
                precioCotizacion = Calcular_Alquiler_Minivan(alquiler, vehiculo);
            }
            case 3 -> {
                // Camión
                precioCotizacion = Calcular_Alquiler_Camion(alquiler, vehiculo);
            }
            case 4 -> {
                // Furgoneta
                precioCotizacion = Calcular_Alquiler_Furgoneta(alquiler, vehiculo);
            }
            default -> {
                System.out.println("Tipo de vehículo no reconocido.");
                return;
            }
        }

        // Guardamos el precio total
        alquiler.setPrecioAlquiler(precioCotizacion);
    }

    @Override
    public double Calcular_Alquiler_Auto(Alquiler alquiler, Vehiculo vehiculo) {
        double precioCotizacion = (alquiler.getCantidad_Dias() *
                (alquiler.getPrecio_Base() + alquiler.getPrecio_Extra_Vehiculo_Pasajero())) +
                (alquiler.getPrecio_Extra_Plaza_Auto() * vehiculo.getCantidad_Plazas());
        return precioCotizacion;
    }

    @Override
    public double Calcular_Alquiler_Minivan(Alquiler alquiler, Vehiculo vehiculo) {
        double precioCotizacion = (alquiler.getCantidad_Dias() *
                (alquiler.getPrecio_Base() + alquiler.getPrecio_Extra_Vehiculo_Pasajero())) +
                (alquiler.getPrecio_Extra_Plaza_Minivan() * vehiculo.getCantidad_Plazas());
        return precioCotizacion;
    }

    @Override
    public double Calcular_Alquiler_Camion(Alquiler alquiler, Vehiculo vehiculo) {
        double precioCotizacion = (alquiler.getPrecio_Base() * alquiler.getCantidad_Dias()) +
                alquiler.getPrecio_Extra_Camion() +
                (alquiler.getPrecio_Extra_Vehiculo_Carga() * vehiculo.getPMA());
        return precioCotizacion;
    }

    @Override
    public double Calcular_Alquiler_Furgoneta(Alquiler alquiler, Vehiculo vehiculo) {
        double precioCotizacion = (alquiler.getPrecio_Base() * alquiler.getCantidad_Dias()) +
                (alquiler.getPrecio_Extra_Vehiculo_Carga() * vehiculo.getPMA());
        return precioCotizacion;
    }

}
