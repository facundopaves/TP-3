public class Jugador {
    private String tiempo;
    private String resultado;
    private String colorJugador;

    // Constructor inicializa jugador obteniendo los parametros tiempo, resultado, colojugador
    public Jugador(String tiempo, String resultado, String colorJugador) {
        this.tiempo = tiempo;
        this.resultado = resultado;
        this.colorJugador = colorJugador;
    }

    public String getTiempo() {
        return tiempo;
    }

    public String getResultado() {
        return resultado;
    }

    public String getColorJugador() {
        return colorJugador;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setColorJugador(String colorJugador) {
        this.colorJugador = colorJugador;
    }
}
