import java.util.Scanner;
public class Main {
    public static double IVA = 0.16;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = pedirDouble(scanner, "Subtotal: ");
        double total = subtotal;
        double totalIVA = calcularIVA(subtotal, total);

        System.out.printf("Total a pagar: %.2f%n", total);
    }

    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public static double calcularIVA(double total, double subtotal){

        return total = subtotal + (subtotal * IVA);
    }

}
