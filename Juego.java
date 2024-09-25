public class Juego {
    private String tiempoJuego;

    // Constructor inicializa el juego obteniendo como parametro tiempo de juego
    public Juego(String tiempoJuego) {
        this.tiempoJuego = tiempoJuego;
    }

    public String getTiempoJuego() {
        return tiempoJuego;
    }

    public void setTiempoJuego(String tiempoJuego) {
        this.tiempoJuego = tiempoJuego;
    }
}
