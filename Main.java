import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creo instancia de la flor
        Flor flor = new Flor("Alegre", "Colorida");

        // Creo instancia del principito
        Principito principito = new Principito("Optimista", "Joven", "Curioso", flor);

        // muestro los valores iniciales de la flor
        System.out.println(); // Salto de línea
        System.out.println("Valores iniciales de la flor:");
        System.out.println("===============================");
        System.out.println("Flor:");
        System.out.println("Actitud: " + flor.getActitud());
        System.out.println("Apariencia: " + flor.getApariencia());
        System.out.println("===============================");
        System.out.println(); // Salto de línea

        // Leo la actitud desde la consola
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el nuevo valor para actitud: ");
        String actitudInput = scanner.nextLine();

        // Leo la apariencia desde la consola
        System.out.print("Introduzca el nuevo valor para apariencia: ");
        String aparienciaInput = scanner.nextLine();

        flor.setActitud(actitudInput);
        flor.setApariencia(aparienciaInput);

        System.out.println("--------------------------------");
        // Mostrar los valores introducidos
        System.out.println("Actitud cambiada a: " + actitudInput);
        System.out.println("Apariencia cambiada a: " + aparienciaInput);

        // Cierro el scanner
        scanner.close();

        System.out.println("------------------------------------------------------Texto con los valores cambiados------------------------------------------------------");
        System.out.println(); // Salto de línea
        // Imprimir el texto con los valores cambiados
        System.out.println("Tenía una flor que amaba mucho. " +
        "Cuidaba de ella todos los días, la regaba y le quitaba las orugas. " +
        "La flor, aunque un poco " + flor.getActitud() + ", era muy " + flor.getApariencia() + 
        " y agradecía al Principito por su dedicación. " +
        "Un día, el Principito decidió explorar otros planetas y, aunque no quería dejar sola a su flor, sabía que debía continuar su viaje para aprender más sobre el universo.");

        // Imprimo la info del principito y su flor
        infoPrincipito(principito);
    }

    // Metodo para imprimir la info del Principito y su flor
    public static void infoPrincipito(Principito principito) {
        System.out.println("---------- Principito ----------");
        System.out.println("Actitud: " + principito.getActitud());
        System.out.println("Apariencia: " + principito.getApariencia());
        System.out.println("Personalidad: " + principito.getPersonalidad());
        System.out.println("Su flor es:");
        System.out.println("Actitud: " + principito.getMiFlor().getActitud());
        System.out.println("Apariencia: " + principito.getMiFlor().getApariencia());
    }
}
