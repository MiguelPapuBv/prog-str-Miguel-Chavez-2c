import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Validar validar = new Validar();
        ShippingCalculator calc = new ShippingCalculator();

        System.out.println("--- SISTEMA DE ENVÍOS (POO) ---");

        double peso = validar.leerDoubleEnRango(sc, "Ingrese peso (0.1 - 50.0 kg): ", 0.1, 50.0);
        int distancia = validar.leerIntEnRango(sc, "Ingrese distancia (1 - 2000 km): ", 1, 2000);

        System.out.println("1) Estándar  2) Express");
        int servicio = validar.leerIntEnRango(sc, "Tipo de servicio: ", 1, 2);


        boolean esRemoto = validar.leerBoolean(sc, "¿Es zona remota? (true/false): ");

        double subtotal = calc.calcularSubtotal(peso, distancia, servicio, esRemoto);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        validar.imprimirTicket(servicio, peso, distancia, esRemoto, subtotal, iva, total);

        sc.close();
    }
}