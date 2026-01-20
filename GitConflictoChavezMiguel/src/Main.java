import java.util.Scanner;
public class Main {
<<<<<<< HEAD
    public static double DESCUENTO = 0.10;
    public static double UMBRAL_DESCUENTO = 1000.0;
=======
    public static double IVA = 0.16;
>>>>>>> feature/iva

    double subtotal = pedirDouble(scanner, "Subtotal: ");


    double total = calcularIVA(subtotal);


    double  total = condicionDescuento(total, subtotal);

        System.out.printf("Total a pagar: %.2f%n", total);

    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }
<<<<<<< HEAD
    public static double condicionDescuento(double subtotal, double total){
        total = subtotal;
        if(subtotal > UMBRAL_DESCUENTO) return total = total - (total * DESCUENTO);
        else
        return 0;
    }
=======

    public static double calcularIVA( double subtotal){

        return subtotal + (subtotal * IVA);
    }

>>>>>>> feature/iva
}
