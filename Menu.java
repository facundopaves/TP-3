import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Instanciar_Vehiculos calculadora;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.calculadora = new Instanciar_Vehiculos(); // Instanciar la clase CalculadoraDePrecios
    }

    public void iniciar() {
        boolean menu = true;

        while (menu) {
            mostrarMenuPrincipal(); // Mostrar el menú principal
            int opcion = leerOpcion(scanner);
            switch (opcion) {
                case 1:
                    Menu_Vehiculos_Pasajeros(); // Acceder al menú de vehículos de pasajeros
                    break;
                case 2:
                    Menu_Vehiculos_Carga(); // Acceder al menú de vehículos de carga
                    break;
                case 0:
                    menu = false; // Salir del programa

                    String mensajeSalida = "\n\n\u001B[31mSaliendo del programa...\u001B[0m";

                    for (char letra : mensajeSalida.toCharArray()) {
                        System.out.print(letra);
                        try {
                            Thread.sleep(50); // tardo 50 en cada letra
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese 1, 2 o 0.");
            }
            System.out.println(); // Espacio adicional para mejorar la legibilidad
        }
    }

    private void mostrarMenuPrincipal() {

        // Mensaje de bienvenida que aparece despacio
        String mensajeBienvenida = "\n                \u001B[32m==========================================\n" +
                "                \u001B[32mBienvenido al Menú de Alquiler de Vehículos\u001B[0m\n" +
                "                \u001B[32m==========================================\n\u001B[0m";

        // Muestro el mensaje de bienvenida letra por letra
        for (char letra : mensajeBienvenida.toCharArray()) {
            System.out.print(letra);
            try {
                Thread.sleep(15); // tardo 15 milisegundos en cada letra
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Manejo de la excepción
            }
        }

        System.out.println(
                "\n\n\u001B[34m====================\u001B[0m \u001B[33mMENÚ DE ALQUILER DE VEHÍCULOS\u001B[0m \u001B[34m====================\u001B[0m\n");
        System.out.println("\u001B[32m1- Vehículos de Pasajeros\u001B[0m");
        System.out.println("\u001B[32m2- Vehículos de Carga\u001B[0m");
        System.out.println("\u001B[32m0- Salir\u001B[0m\n");
        System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");
    }

    // --------------------------MENU DE VEHÍCULOS
    // PASAJEROS-------------------------
    private void Menu_Vehiculos_Pasajeros() {
        boolean subMenuPasajeros = true;

        while (subMenuPasajeros) {
            limpiarPantalla(); // Limpiar la pantalla
            System.out.println(
                    "\u001B[34m====================\u001B[0m \u001B[33mVehículos de Pasajeros\u001B[0m \u001B[34m====================\u001B[0m");
            System.out.println("\u001B[32m1- Auto\u001B[0m");
            System.out.println("\u001B[32m2- Minivan\u001B[0m");
            System.out.println("\u001B[32m0- Regresar al menú principal\u001B[0m");
            System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");

            int opcionPasajeros = leerOpcion(scanner);
            switch (opcionPasajeros) {
                case 1:
                    seleccionarPasajerosAuto(); // Seleccionar pasajeros para auto
                    break;
                case 2:
                    seleccionarPasajerosMinivan(); // Seleccionar pasajeros para minivan
                    break;
                case 0:
                    subMenuPasajeros = false; // Regresar al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese 1, 2 o 0.");
            }
        }
    }

    // --------------------------MENU DE VEHÍCULOS DE CARGA-------------------------
    private void Menu_Vehiculos_Carga() {
        boolean subMenuCarga = true; // Mantener el menú abierto mientras sea verdadero

        while (subMenuCarga) {
            limpiarPantalla(); // Limpiar la pantalla
            System.out.println(
                    "\u001B[34m====================\u001B[0m \u001B[33mVehículos de Carga\u001B[0m \u001B[34m====================\u001B[0m");
            System.out.println("\u001B[32m1- Camión\u001B[0m");
            System.out.println("\u001B[32m2- Furgoneta\u001B[0m");
            System.out.println("\u001B[32m0- Regresar al menú principal\u001B[0m");
            System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");

            int opcionCarga = leerOpcion(scanner);
            switch (opcionCarga) {
                case 1:
                    seleccionarCargaCamion(); // Seleccionar carga para camión
                    break;
                case 2:
                    menuCargaFurgoneta(); // Acceder al menú de furgoneta
                    break;
                case 0:
                    subMenuCarga = false; // Regresar al menú principal
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese 1, 2 o 0.");
            }
        }
    }

    private int leerOpcion(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    // -------------------------------SELECCIÓN CARGA CAMIÓN-------------------------------
    private void seleccionarCargaCamion() {
        boolean subMenuCamion = true;
        while (subMenuCamion) {
            limpiarPantalla(); // Limpiar la pantalla
            System.out.println(
                    "\u001B[34m====================\u001B[0m \u001B[33mSeleccione la carga máxima del camión (en toneladas)\u001B[0m \u001B[34m====================\u001B[0m");
            System.out.println("\u001B[32m5 - Carga máxima 5 toneladas\u001B[0m");
            System.out.println("\u001B[32m10 - Carga máxima 10 toneladas\u001B[0m");
            System.out.println("\u001B[32m15 - Carga máxima 15 toneladas\u001B[0m");
            System.out.println("\u001B[32m0 - Regresar al menú de vehículos de carga\u001B[0m");
            System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");

            int opcionCamion = leerOpcion(scanner);
            int pesoMaximoAutorizado = 0;

            switch (opcionCamion) {
                case 1:
                    pesoMaximoAutorizado = 5;
                    calcularPrecioCarga(pesoMaximoAutorizado); // Llamar al método que usa la calculadora
                    break;
                case 2:
                    pesoMaximoAutorizado = 10;
                    calcularPrecioCarga(pesoMaximoAutorizado);
                    break;
                case 3:
                    pesoMaximoAutorizado = 15;
                    calcularPrecioCarga(pesoMaximoAutorizado);
                    break;
                case 0:
                    subMenuCamion = false; // Regresar al menú de vehículos de carga
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese 1, 2, 3 o 0.");
            }
        }
    }

    private void menuCargaFurgoneta() {
        boolean subMenuFurgoneta = true;
        while (subMenuFurgoneta) {
            limpiarPantalla(); // Limpiar la pantalla
            System.out.println(
                    "\u001B[34m====================\u001B[0m \u001B[33mSeleccione el peso máximo autorizado de la furgoneta (en toneladas)\u001B[0m \u001B[34m====================\u001B[0m");
            System.out.println("\u001B[32m3 - Carga máxima 3 toneladas\u001B[0m");
            System.out.println("\u001B[32m4 - Carga máxima 4 toneladas\u001B[0m");
            System.out.println("\u001B[32m5 - Carga máxima 5 toneladas\u001B[0m");
            System.out.println("\u001B[32m0 - Regresar al menú de vehículos de carga\u001B[0m");
            System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");

            int opcionFurgoneta = leerOpcion(scanner);
            float pesoMaximoAutorizado = 0;

            switch (opcionFurgoneta) {
                case 3:
                    pesoMaximoAutorizado = 3; // Peso máximo para la furgoneta
                    calcularPrecioFurgoneta(pesoMaximoAutorizado); // Llama al método que usa la calculadora
                    break;
                case 4:
                    pesoMaximoAutorizado = 4; // Peso máximo para la furgoneta
                    calcularPrecioFurgoneta(pesoMaximoAutorizado);
                    break;
                case 5:
                    pesoMaximoAutorizado = 5; // Peso máximo para la furgoneta
                    calcularPrecioFurgoneta(pesoMaximoAutorizado);
                    break;
                case 0:
                    subMenuFurgoneta = false; // Regresar al menú de vehículos de carga
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese 1, 2, 3 o 0.");
            }
        }
    }

    // Método para calcular el precio de la furgoneta
    private void calcularPrecioFurgoneta(float pesoMaximoAutorizado) {
        System.out.print("\u001B[33m\nIngrese el número de días del alquiler:\u001B[0m ");
        int diasDeAlquiler = leerOpcion(scanner); // Lee la cantidad de días

        // Llama al método de la clase CalculadoraDePrecios para calcular el precio de
        // la furgoneta
        double precioTotal = calculadora.calcularPrecioFurgoneta(pesoMaximoAutorizado, diasDeAlquiler);

        // Imprime el precio total
        System.out.println(
                "\n\n \u001B[35m======================================================================\u001B[0m");
        System.out.println("\n\n\u001B[35m El precio total por " + diasDeAlquiler + " día/s para una furgoneta de "
                + pesoMaximoAutorizado + " toneladas es: " + precioTotal + "\u001B[0m");
        System.out.println(
                "\n\n \u001B[35m======================================================================\u001B[0m");
    }

    // ---------------------------SELECCIÓN PASAJEROS AUTO Y MINIVAN---------------------------
    private void seleccionarPasajerosAuto() {
        boolean subMenuAuto = true;
        while (subMenuAuto) {
            limpiarPantalla(); // Limpiar la pantalla
            System.out.println(
                    "\u001B[34m====================\u001B[0m \u001B[33mSeleccione la cantidad de pasajeros\u001B[0m \u001B[34m====================\u001B[0m");
            System.out.println("\u001B[32m2 - Pasajeros\u001B[0m");
            System.out.println("\u001B[32m5 - Pasajeros\u001B[0m");
            System.out.println("\u001B[32m7 - Pasajeros\u001B[0m");
            System.out.println("\u001B[32m0 - Regresar al menú de vehículos de pasajeros\u001B[0m");
            System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");

            int opcionAuto = leerOpcion(scanner);
            int cantidadPasajeros = 0;

            switch (opcionAuto) {
                case 2:
                    cantidadPasajeros = 2;
                    calcularPrecioAuto(cantidadPasajeros); // Llama al método que usa la calculadora
                    break;
                case 5:
                    cantidadPasajeros = 5;
                    calcularPrecioAuto(cantidadPasajeros);
                    break;
                case 7:
                    cantidadPasajeros = 7;
                    calcularPrecioAuto(cantidadPasajeros);
                    break;
                case 0:
                    subMenuAuto = false; // Regresar al menú de vehículos de pasajeros
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese 2, 5, 7 o 0.");
            }
        }
    }

    // -------------------------------CÁLCULO DEL PRECIO AUTO-------------------------------
    private void calcularPrecioAuto(int cantidadPasajeros) {
        System.out.print("\u001B[33m\nIngrese el número de días del alquiler:\u001B[0m ");
        int diasDeAlquiler = leerOpcion(scanner); // Lee la cantidad de días

        // Llama al método de la clase CalculadoraDePrecios
        double precioTotal = calculadora.calcularPrecioAuto(cantidadPasajeros, diasDeAlquiler);

        // Imprime el precio total
        System.out.println(
                "\n\n \u001B[35m======================================================================\u001B[0m");
        System.out.println("\n\n\u001B[35m El precio total por " + diasDeAlquiler + " día/s para " + cantidadPasajeros
                + " pasajeros es: " + precioTotal + "\u001B[0m");
        System.out.println(
                "\n\n \u001B[35m======================================================================\u001B[0m");
    }

    // -------------------------------CÁLCULO DEL PRECIO
    // CARGA-------------------------------
    private void calcularPrecioCarga(int pesoMaximoAutorizado) {
        System.out.print("\u001B[33m\nIngrese el número de días del alquiler:\u001B[0m ");
        int diasDeAlquiler = leerOpcion(scanner); // Lee la cantidad de días

        // Llama al método de la clase CalculadoraDePrecios para calcular el precio del
        // camión
        double precioTotal = calculadora.calcularPrecioCamion(pesoMaximoAutorizado, diasDeAlquiler);

        // Imprime el precio total
        System.out.println(
                "\n\n \u001B[35m======================================================================\u001B[0m");
        System.out.println("\n\n\u001B[35m El precio total por " + diasDeAlquiler + " día/s para un camión de "
                + pesoMaximoAutorizado + " toneladas es: " + precioTotal + "\u001B[0m");
        System.out.println(
                "\n\n \u001B[35m======================================================================\u001B[0m");
    }

    // -------------------------------LIMPIAR PANTALLA-------------------------------
    private void limpiarPantalla() { // Imprimir varias líneas para limpiar la pantalla
        System.out.println("\n\n\n\n");

    }

    private void seleccionarPasajerosMinivan() {
        boolean subMenuMinivan = true;
        while (subMenuMinivan) {
            limpiarPantalla(); // Limpiar la pantalla
            System.out.println(
                    "\u001B[34m====================\u001B[0m \u001B[33mSeleccione la cantidad de pasajeros\u001B[0m \u001B[34m====================\u001B[0m");
            System.out.println("\u001B[32m16 - Pasajeros\u001B[0m");
            System.out.println("\u001B[32m19 - Pasajeros\u001B[0m");
            System.out.println("\u001B[32m22 - Pasajeros\u001B[0m");
            System.out.println("\u001B[32m0 - Regresar al menú de vehículos de pasajeros\u001B[0m");
            System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");

            int opcionMinivan = leerOpcion(scanner);
            int cantidadPasajeros = 0;

            switch (opcionMinivan) {
                case 16:
                    cantidadPasajeros = 16;
                    calcularPrecioMinivan(cantidadPasajeros); // Llama al método que usa la calculadora
                    break;
                case 19:
                    cantidadPasajeros = 19;
                    calcularPrecioMinivan(cantidadPasajeros);
                    break;
                case 22:
                    cantidadPasajeros = 22;
                    calcularPrecioMinivan(cantidadPasajeros);
                    break;
                case 0:
                    subMenuMinivan = false; // Regresar al menú de vehículos de pasajeros
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese 2, 5, 7 o 0.");
            }
        }
    }

    // Método para calcular el precio de la minivan
    private void calcularPrecioMinivan(int cantidadPasajeros) {
        System.out.print("\u001B[33m\nIngrese el número de días del alquiler:\u001B[0m ");
        int diasDeAlquiler = leerOpcion(scanner); // Lee la cantidad de días

        // Llama al método de la clase CalculadoraDePrecios
        double precioTotal = calculadora.calcularPrecioMinivan(cantidadPasajeros, diasDeAlquiler);

        // Imprime el precio total
        System.out.println(

                "\n\n \u001B[35m======================================================================\u001B[0m");
        System.out.println("\n\n\u001B[35m El precio total por " + diasDeAlquiler + " día/s para " + cantidadPasajeros
                + " pasajeros es: " + precioTotal + "\u001B[0m");
        System.out.println(
                "\n\n \u001B[35m======================================================================\u001B[0m");
    }
}
