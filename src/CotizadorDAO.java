import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CotizadorDAO implements iCotizador_VehiculoDAO {

    // Metodo para mostrar la información de los vehículos
    @Override
    public void MostrarInformacionVehiculos() {
        String query = "SELECT idVehiculo, idtipo_vehiculo, Marca, Modelo, Anio_Fabricacion, Color, Tipo_Transmision, Cantidad_Plazas, Capacidad_Baul, PMA FROM vehiculo";

        try (Connection con = new AccesoDatos().getConexion();
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int idVehiculo = rs.getInt("idVehiculo");
                int idtipo_vehiculo = rs.getInt("id_Tipo_Vehiculo");
                String Marca = rs.getString("Marca");
                String Modelo = rs.getString("Modelo");
                int Anio_Fabricacion = rs.getInt("Anio_Fabricacion");
                String Patente = rs.getString("Patente");
                String Color = rs.getString("Color");
                String Tipo_Transmision = rs.getString("Tipo_Transmision");
                int Cantidad_Plazas = rs.getInt("Cantidad_Plazas");
                int Capacidad_Baul = rs.getInt("Capacidad_Baul");
                float PMA = rs.getFloat("PMA");

                // Imprimir información
                System.out.println("Vehículo Nro: " + idVehiculo);
                System.out.println("Tipo Vehículo: " + idtipo_vehiculo);
                System.out.println("Marca: " + Marca);
                System.out.println("Modelo: " + Modelo);
                System.out.println("Año: " + Anio_Fabricacion);
                System.out.println("Patente: " + Patente);
                System.out.println("Color: " + Color);
                System.out.println("Transmisión: " + Tipo_Transmision);
                System.out.println("Plazas: " + Cantidad_Plazas);
                System.out.println("Capacidad Baúl: " + Capacidad_Baul + " litros");
                System.out.println("PMA: " + PMA + " kg");
                System.out.println("-----------------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
    }

    // Metodo para cargar datos en una tabla
    @Override
    public void cargarDatosTabla(DefaultTableModel modelo) {
        String query = "SELECT idVehiculo, idtipo_vehiculo, Marca, Modelo, Anio_Fabricacion, Patente, Color, Tipo_Transmision, Cantidad_Plazas, Capacidad_Baul, PMA FROM vehiculo";

        try (Connection con = new AccesoDatos().getConexion();
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                modelo.addRow(new Object[] {
                        rs.getInt("idVehiculo"),
                        rs.getInt("idtipo_vehiculo"),
                        rs.getString("Marca"),
                        rs.getString("Modelo"),
                        rs.getInt("Anio_Fabricacion"),
                        rs.getString("Patente"),
                        rs.getString("Color"),
                        rs.getString("Tipo_Transmision"),
                        rs.getInt("Cantidad_Plazas"),
                        rs.getInt("Capacidad_Baul"),
                        rs.getFloat("PMA")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
        }
    }

    //metodo para cargar los vehiculos en la tabla cotizacion
    @Override
    public void cargarDatosTablaCotizacion(DefaultTableModel modelo2) {
        String query = "SELECT idCotizacion, idVehiculo, Cantidad_Dias, precioCotizacion, fecha_Creacion FROM cotizacion";

        try (Connection con = new AccesoDatos().getConexion();
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs2 = pstmt.executeQuery()) {

            while (rs2.next()) {
                modelo2.addRow(new Object[] {
                        rs2.getInt("idCotizacion"),
                        rs2.getInt("idVehiculo"),
                        rs2.getInt("Cantidad_Dias"),
                        rs2.getDouble("precioCotizacion"),
                        rs2.getDate("fecha_Creacion")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
            e.printStackTrace(); // Agrega esto para obtener más detalles sobre el error
        }
    }

    // INSERTAMOS EL VEHICULO YA COTIZADO
    @Override
    public void Insertar_Cotizacion(int idVehiculo, int idtipo_Vehiculo, Alquiler alquiler, Vehiculo vehiculo) {

        double precioCotizacion = alquiler.getPrecioAlquiler(); // Asumimos que el precio es almacenado en Alquiler

        String query = "INSERT INTO cotizacion (idVehiculo, Cantidad_Dias, precioCotizacion, fecha_Creacion) VALUES (?, ?, ?, ?)";

        try (Connection con = new AccesoDatos().getConexion()) {

            // Validamos que el vehiculo existe en mi tabla vehiculo
            String validarVehiculo = "SELECT idVehiculo FROM vehiculo WHERE idVehiculo = ?";
            try (PreparedStatement pstmtVal = con.prepareStatement(validarVehiculo)) {
                pstmtVal.setInt(1, vehiculo.getidVehiculo());
                ResultSet rs = pstmtVal.executeQuery();
                if (!rs.next()) {
                    System.err.println("El vehículo con idVehiculo " + vehiculo.getidVehiculo()
                            + " no existe. No se puede crear la cotización.");
                    return;
                } else {
                    System.out.println("Vehículo encontrado: " + rs.getInt("idVehiculo"));
                }
            }

            // ejecutamos la insercion
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, vehiculo.getidVehiculo());
                pstmt.setInt(2, alquiler.getCantidad_Dias());
                pstmt.setDouble(3, precioCotizacion);
                pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar cotización: " + e.getMessage());
        }
    }

}
