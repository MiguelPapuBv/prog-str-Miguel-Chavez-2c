import java.util.Scanner;

public class Validator {

    public String leerNombreNoVacio(Scanner sc, String mensaje) {
        String nombre = "";
        do {
            System.out.print(mensaje);
            nombre = sc.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (nombre.isEmpty());
        return nombre;
    }

    public double leerDoubleParcial(Scanner sc, String mensaje, double min, double max) {
        double parcial = -1;
        do {
            System.out.print(mensaje);

            while (!sc.hasNextDouble()) {
                System.out.println("Por favor que el numero que ingreses un número entero");
                sc.next();
                System.out.print(mensaje);
            }

            parcial = sc.nextDouble();

            if (parcial < min || parcial > max) {
                System.out.println("El valor que ingresaste no esta en el rango de " + min + " y " + max);
            }

        } while (parcial < min || parcial > max);

        sc.nextLine();
        return parcial;
    }


    public int leerIntFaltas(Scanner sc, String mensaje, int min, int max) {
        int faltas = -1;
        do {
            System.out.print(mensaje);

            while (!sc.hasNextInt()) {
                System.out.println("Por favor que el numero que ingreses un número entero");
                sc.next();
                System.out.print(mensaje);
            }

            faltas = sc.nextInt();

            if (faltas < min || faltas > max) {
                System.out.println("El valor que ingresaste no esta en el rango de " + min + " y " + max);
            }

        } while (faltas < min || faltas > max);

        sc.nextLine();
        return faltas;
    }

    public boolean leerBooleanProyecto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextBoolean()) {
            System.out.println("Error por favor solo escribe true o false");
            sc.next();
            System.out.print(mensaje);
        }
        boolean proyecto = sc.nextBoolean();
        sc.nextLine();
        return proyecto;
    }
}