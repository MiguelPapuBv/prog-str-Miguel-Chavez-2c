import java.util.Scanner;
public class Main {

    public static double DESCUENTO = 0.10;
    public static double UMBRAL_DESCUENTO = 1000.0;
    public static double IVA = 0.16;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = pedirDouble(scanner, "Subtotal: ");


        double total;
        total = calcularIVA(subtotal);


        total = condicionDescuento(total, subtotal);

        System.out.printf("Total a pagar: %.2f%n", total);
    }

    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public static double condicionDescuento(double total, double subtotal) {
        if (subtotal > UMBRAL_DESCUENTO) {
            // Aplicamos el descuento al total que ya tiene IVA
            return total - (total * DESCUENTO);
        } else {
            return total;


        }
    }

    public static double calcularIVA(double subtotal) {

        return subtotal + (subtotal * IVA);
    }
}
