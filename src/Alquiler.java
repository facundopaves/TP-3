import java.util.Date;

public class Alquiler {
    private int Cantidad_Dias;
    private Date fecha_Creacion;
    private int Precio_Base;
    private int Precio_Extra_Vehiculo_Carga;
    private int Precio_Extra_Camion;
    private int Precio_Extra_Vehiculo_Pasajero;
    private int Precio_Extra_Plaza_Auto;
    private int Precio_Extra_Plaza_Minivan;
    private double precioAlquiler;
    private int idCotizacion;

    // Inicializamos con los valores del TP6
    public Alquiler() {
        this.Cantidad_Dias = 0;
        this.Precio_Base = 2000;
        this.Precio_Extra_Vehiculo_Carga = 800;
        this.Precio_Extra_Camion = 1600;
        this.Precio_Extra_Vehiculo_Pasajero = 100;
        this.Precio_Extra_Plaza_Auto = 100;
        this.Precio_Extra_Plaza_Minivan = 120;
        this.precioAlquiler = 0.0;
    }

    //---------------- Getters ----------------//
    public int getCantidad_Dias() {
        return Cantidad_Dias;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public int getPrecio_Base() {
        return Precio_Base;
    }

    public int getPrecio_Extra_Vehiculo_Carga() {
        return Precio_Extra_Vehiculo_Carga;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public int getPrecio_Extra_Camion() {
        return Precio_Extra_Camion;
    }

    public int getPrecio_Extra_Vehiculo_Pasajero() {
        return Precio_Extra_Vehiculo_Pasajero;
    }

    public int getPrecio_Extra_Plaza_Auto() {
        return Precio_Extra_Plaza_Auto;
    }

    public int getPrecio_Extra_Plaza_Minivan() {
        return Precio_Extra_Plaza_Minivan;
    }

    public int getidCotizacion() {
        return idCotizacion;
    }

   

    //---------------- Setters ----------------//
    public void setCantidad_Dias(int cantidad_Dias) {
        this.Cantidad_Dias = cantidad_Dias;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public void setPrecio_Extra_Vehiculo_Carga(int precio_Extra_Vehiculo_Carga) {
        this.Precio_Extra_Vehiculo_Carga = precio_Extra_Vehiculo_Carga;
    }

    public void setPrecio_Extra_Camion(int precio_Extra_Camion) {
        this.Precio_Extra_Camion = precio_Extra_Camion;
    }

    public void setPrecio_Base(int precio_Base) {
        this.Precio_Base = precio_Base;
    }

    public void setPrecio_Extra_Vehiculo_Pasajero(int precio_Extra_Vehiculo_Pasajero) {
        this.Precio_Extra_Vehiculo_Pasajero = precio_Extra_Vehiculo_Pasajero;
    }

    public void setPrecio_Extra_Plaza_Auto(int precio_Extra_Plaza_Auto) {
        this.Precio_Extra_Plaza_Auto = precio_Extra_Plaza_Auto;
    }

    public void setPrecio_Extra_Plaza_Minivan(int precio_Extra_Plaza_Minivan) {
        this.Precio_Extra_Plaza_Minivan = precio_Extra_Plaza_Minivan;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public void setidCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

}
