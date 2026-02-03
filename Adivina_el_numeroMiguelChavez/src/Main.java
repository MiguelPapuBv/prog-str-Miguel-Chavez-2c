import java.util.Random;
import java.util.Scanner;

public class Main {

    static int ERRORESRANGO = 0;
    static int ERRORESTIPODATO = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;

        int secreto = random.nextInt(100) + 1;
        System.out.println("=== BIENVENIDO AL ADIVINADOR ===");
        System.out.println("Adivina el numero (1-100). Tienes " + limiteIntentos + " intentos.");

        while (intentos < limiteIntentos) {
            int numero = obtenerNumeroValido("Intento " + (intentos + 1) + ": ", sc, min, max);
            intentos++;

            if (numero == secreto) {
                System.out.println("¡Ganaste! Lo lograste en " + intentos + " intentos.");
                gano = true;
                break;
            } else if (numero > secreto) {
                System.out.println("El numero secreto es MENOR.");
            } else {
                System.out.println("El numero secreto es MAYOR.");
            }
        }

        if (!gano) {
            System.out.println("Perdiste. El numero secreto era: " + secreto);
        }

        System.out.println("\n--- RESUMEN DE PARTIDA ---");
        System.out.println("Errores de rango (fuera de 1-100): " + ERRORESRANGO);
        System.out.println("Entradas no numéricas: " + ERRORESTIPODATO);
    }

    public static int obtenerNumeroValido(String mensaje, Scanner sc, int min, int max) {
        int entrada;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                entrada = sc.nextInt();
                if (entrada >= min && entrada <= max) {
                    return entrada;
                }

                ERRORESRANGO++;
                System.out.println("Error: El numero debe estar entre " + min + " y " + max);
            } else {

                ERRORESTIPODATO++;
                System.out.println("Error: El dato ingresado no es un número.");
                sc.next();
            }
        }
    }
}