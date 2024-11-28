import javax.swing.table.DefaultTableModel;

public interface iCotizador_VehiculoDAO {
  void MostrarInformacionVehiculos();

  void cargarDatosTabla(DefaultTableModel modelo);

  void cargarDatosTablaCotizacion(DefaultTableModel modelo2);

  void Insertar_Cotizacion(int idVehiculo, int idtipo_Vehiculo, Alquiler alquiler, Vehiculo vehiculo);
}
