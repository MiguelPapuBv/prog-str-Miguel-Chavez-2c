import java.util.Scanner;

public class Validar {

    public double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            while (!sc.hasNextDouble()) {
                System.out.println("Error: Ingrese un número válido.");
                System.out.print(msg);
                sc.next();
            }
            valor = sc.nextDouble();
            if (valor < min || valor > max) {
                System.out.println("Error: Rango inválido (" + min + " - " + max + ")");
            }
        } while (valor < min || valor > max);
        return valor;
    }

    public int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            while (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese un número entero.");
                System.out.print(msg);
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < min || valor > max) {
                System.out.println("Error: Opción inválida.");
            }
        } while (valor < min || valor > max);
        return valor;
    }

    public boolean leerBoolean(Scanner sc, String msg) {
        System.out.print(msg);
        while (!sc.hasNextBoolean()) {
            System.out.println("Error: Escriba 'true' o 'false'.");
            System.out.print(msg);
            sc.next();
        }
        return sc.nextBoolean();
    }

    public void imprimirTicket(int serv, double peso, int dist, boolean rem, double sub, double iva, double tot) {
        System.out.println("==================================");
        System.out.println("       TICKET DE ENVÍO");
        System.out.println("Servicio:      " + (serv == 1 ? "Estándar" : "Express"));
        System.out.println("Peso:          " + peso + " kg");
        System.out.println("Distancia:     " + dist + " km");
        System.out.println("Zona Remota:   " + (rem ? "SÍ (+10%)" : "NO"));
        System.out.println("Subtotal:      $ " +sub+ " (Antes de IVA)");
        System.out.println("IVA (16%%):     $ " +iva);
        System.out.println("TOTAL FINAL:   $ %.2f%n" +tot);

    }
}