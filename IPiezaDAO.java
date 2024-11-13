public interface IPiezaDAO {

    
    // Método para insertar una pieza, con los parámetros necesarios
    public abstract void insertarPieza(Pieza pieza);

    // Método para mostrar la información de todas las piezas
    public abstract void mostrarInformacionPiezas();

    // Método para eliminar una pieza por su ID
    public abstract void eliminarPieza(int idPieza);
}
