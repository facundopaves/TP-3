public interface iCotizador_CotizacionDao {
    void Calcular_Precio_Alquiler(int idtipo_Vehiculo, Alquiler alquiler, Vehiculo vehiculo);

    double Calcular_Alquiler_Auto(Alquiler alquiler, Vehiculo vehiculo);

    double Calcular_Alquiler_Minivan(Alquiler alquiler, Vehiculo vehiculo);

    double Calcular_Alquiler_Camion(Alquiler alquiler, Vehiculo vehiculo);

    double Calcular_Alquiler_Furgoneta(Alquiler alquiler, Vehiculo vehiculo);
}
