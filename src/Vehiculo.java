
public class Vehiculo {
    
    private int idVehiculo;
    private int idtipo_vehiculo;
    private String Marca;
    private String Modelo;
    private int Anio_Fabricacion;
    private String Patente;
    private String Color;
    private String Tipo_Transmision;
    private int Cantidad_Plazas;
    private int Capacidad_Baul;
    private float PMA;
   

    //---------------- Getters ----------------//
    
    public int getidVehiculo() {
        return idVehiculo;
    }

    public int getidtipo_vehiculo() {
        return idtipo_vehiculo;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getAnio_Fabricacion() {
        return Anio_Fabricacion;
    }

    public String getPatente() {
        return Patente;
    }

    public String getColor() {
        return Color;
    }

    public String getTipo_Transmision() {
        return Tipo_Transmision;
    }

    public int getCantidad_Plazas() {
        return Cantidad_Plazas;
    }

    public int getCapacidad_Baul() {
        return Capacidad_Baul;
    }

    public float getPMA() {
        return PMA;
    }



    //---------------- Setters ----------------//

    public void setidVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setidtipo_vehiculo(int idtipo_vehiculo) {
        this.idtipo_vehiculo = idtipo_vehiculo;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setAnio_Fabricacion(int Anio_Fabricacion) {
        this.Anio_Fabricacion = Anio_Fabricacion;
    }

    public void setPatente(String Patente) {
        this.Patente = Patente;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setTipo_Transmision(String Tipo_Transmision) {
        this.Tipo_Transmision = Tipo_Transmision;
    }

    public void setCantidad_Plazas(int Cantidad_Plazas) {
        this.Cantidad_Plazas = Cantidad_Plazas;
    }

    public void setCapacidad_Baul(int CapacidadBaul) {
        this.Capacidad_Baul = CapacidadBaul;
    }

    public void setPMA(float PMA) {
        this.PMA = PMA;
    }

}
