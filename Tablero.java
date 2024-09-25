public class Tablero {
    //atributos de la clase tablero
    private Casillero[][] casilleros; // Matriz de objetos Casillero
    private int filas;
    private int columnas;

    //el constructor inicializa el tablero recibiendo los parametros filas y columnas
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casilleros = new Casillero[filas][columnas];
        generarCasilleros();
    }
    //Metodo para generar el casillero 
    private void generarCasilleros() {
        for (int i = 0; i < filas; i++) { //recorro la matriz con un for inicializando con un objeto casillero
            for (int j = 0; j < columnas; j++) {
                // Alterno colores entre blanco y negro
                String color = (i + j) % 2 == 0 ? "B" : "N"; // // Si la suma de i + j es par, el casillero será blanco, si es impar, va a ser negro
                casilleros[i][j] = new Casillero(color);
            }
        }
    }

    public void imprimirTablero() { 
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                if (casilleros[i][j] != null) {
                    // Imprime el color del casillero (Blanco o Negro) con el get.color()
                    System.out.print(casilleros[i][j].getColor() + " ");
                } else {
                    // Si por alguna razón no hay casillero, muestra un punto
                    System.out.print(". ");
                }
            }
            System.out.println();  // Salto de línea después de cada fila
        }
    }
    
    
    //Metodo casillero 
    public Casillero getCasillero(int fila, int columna) {
        return casilleros[fila][columna]; //obtengo la casilla especifica
    }

    public void setCasillero(int fila, int columna, Casillero casillero) {
        casilleros[fila][columna] = casillero; //me permite establecer una casilla especifica
    }

    //Estos dos metodos son getters que devuelven el numero de las columnas y las filas
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    
}
