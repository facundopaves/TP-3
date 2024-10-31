import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void iniciar() {
        boolean menu = true;

        while (menu) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion(scanner);
            switch (opcion) {
                case 1:
                    Menu_Vehiculos_Pasajeros();
                    break;
                case 2:
                    Menu_Vehiculos_Carga();
                    break;
                case 0:
                    menu = false;
                    String mensajeSalida = "\n\n\u001B[31mSaliendo del programa...\u001B[0m";
                    for (char letra : mensajeSalida.toCharArray()) {
                        System.out.print(letra);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese 1, 2 o 0.");
            }
            System.out.println();
        }
    }

    private void mostrarMenuPrincipal() {
        String mensajeBienvenida = "\n                \u001B[32m==========================================\n" +
                "                \u001B[32mBienvenido al Menú de Alquiler de Vehículos\u001B[0m\n" +
                "                \u001B[32m==========================================\n\u001B[0m";
        for (char letra : mensajeBienvenida.toCharArray()) {
            System.out.print(letra);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "\n\n\u001B[34m====================\u001B[0m \u001B[33mMENÚ DE ALQUILER DE VEHÍCULOS\u001B[0m \u001B[34m====================\u001B[0m\n");
        System.out.println("\u001B[32m1- Vehículos de Pasajeros\u001B[0m");
        System.out.println("\u001B[32m2- Vehículos de Carga\u001B[0m");
        System.out.println("\u001B[32m0- Salir\u001B[0m\n");
        System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");
    }

    private void Menu_Vehiculos_Pasajeros() {
        boolean subMenuPasajeros = true;
        while (subMenuPasajeros) {
            limpiarPantalla();
            System.out.println("\u001B[34m====================\u001B[0m \u001B[33mVehículos de Pasajeros\u001B[0m \u001B[34m====================\u001B[0m");
            System.out.println("\u001B[32m1- Auto (5 pasajeros)\u001B[0m");
            System.out.println("\u001B[32m2- Minivan (16 pasajeros)\u001B[0m");
            System.out.println("\u001B[32m0- Regresar al menú principal\u001B[0m");
            System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");
            
            int opcionPasajeros = leerOpcion(scanner);
            switch (opcionPasajeros) {
                case 1:
                    seleccionarPasajerosAuto();
                    break;
                case 2:
                    seleccionarPasajerosMinivan();
                    break;
                case 0:
                    subMenuPasajeros = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese 1, 2 o 0.");
            }
        }
    }

    private void Menu_Vehiculos_Carga() {
        boolean subMenuCarga = true;

        while (subMenuCarga) {
            limpiarPantalla();
            System.out.println("\u001B[34m====================\u001B[0m \u001B[33mVehículos de Carga\u001B[0m \u001B[34m====================\u001B[0m");
            System.out.println("\u001B[32m1- Camión\u001B[0m");
            System.out.println("\u001B[32m2- Furgoneta\u001B[0m");
            System.out.println("\u001B[32m0- Regresar al menú principal\u001B[0m");
            System.out.print("\u001B[33mSeleccione una opción:\u001B[0m ");

            int opcionCarga = leerOpcion(scanner);
            switch (opcionCarga) {
                case 1:
                    seleccionarCargaCamion();
                    break;
                case 2:
                    menuCargaFurgoneta();
                    break;
                case 0:
                    subMenuCarga = false;
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
                scanner.next();
            }
        }
    }

    private void seleccionarCargaCamion() {
        System.out.print("\u001B[33m\nIngrese el número de días del alquiler:\u001B[0m ");
        int diasDeAlquiler = leerOpcion(scanner);
        Camion camion = new Camion("DEF456", diasDeAlquiler, 10); 
        double precioTotal = camion.calcularPrecio();

        System.out.println("\n\n \u001B[35m======================================================================\u001B[0m");
        System.out.println("\n\n\u001B[35m El precio total por " + diasDeAlquiler + " día/s para un camión de 10 toneladas es: " + precioTotal + "\u001B[0m");
        System.out.println("\n\n \u001B[35m======================================================================\u001B[0m");
    }

    private void menuCargaFurgoneta() {
        System.out.print("\u001B[33m\nIngrese el número de días del alquiler:\u001B[0m ");
        int diasDeAlquiler = leerOpcion(scanner);
        Furgoneta furgoneta = new Furgoneta("GHI789", diasDeAlquiler, 5); 
        double precioTotal = furgoneta.calcularPrecio();

        System.out.println("\n\n \u001B[35m======================================================================\u001B[0m");
        System.out.println("\n\n\u001B[35m El precio total por " + diasDeAlquiler + " día/s para una furgoneta de 5 toneladas es: " + precioTotal + "\u001B[0m");
        System.out.println("\n\n \u001B[35m======================================================================\u001B[0m");
    }

    private void seleccionarPasajerosAuto() {
        System.out.print("\u001B[33m\nIngrese el número de días del alquiler:\u001B[0m ");
        int diasDeAlquiler = leerOpcion(scanner);
        Auto auto = new Auto("ABC123", diasDeAlquiler, 5); 
        double precioTotal = auto.calcularPrecio();

        System.out.println("\n\n \u001B[35m======================================================================\u001B[0m");
        System.out.println("\n\n\u001B[35m El precio total por " + diasDeAlquiler + " día/s para 5 pasajeros es: " + precioTotal + "\u001B[0m");
        System.out.println("\n\n \u001B[35m======================================================================\u001B[0m");
    }

    private void seleccionarPasajerosMinivan() {
        System.out.print("\u001B[33m\nIngrese el número de días del alquiler:\u001B[0m ");
        int diasDeAlquiler = leerOpcion(scanner);
        Minivan minivan = new Minivan("JKL012", diasDeAlquiler, 16); 
        double precioTotal = minivan.calcularPrecio();

        System.out.println("\n\n \u001B[35m======================================================================\u001B[0m");
        System.out.println("\n\n\u001B[35m El precio total por " + diasDeAlquiler + " día/s para 16 pasajeros es: " + precioTotal + "\u001B[0m");
        System.out.println("\n\n \u001B[35m======================================================================\u001B[0m");
    }

    private void limpiarPantalla() {
        System.out.println("\n\n\n\n");
    }
}
