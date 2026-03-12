import java.util.Scanner;

public class Validator {

    public String leerUsuarioNoVacio(Scanner sc, String mensaje) {
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

    public int leerIntHoras(Scanner sc, String mensaje, int min, int max) {
        int horas = -1;
        do {
            System.out.print(mensaje);

            while (!sc.hasNextInt()) {
                System.out.println("Por favor que el numero que ingreses un número entero");
                sc.next();
                System.out.print(mensaje);
            }

            horas = sc.nextInt();

            if (horas < min || horas > max) {
                System.out.println("El valor que ingresaste no esta en el rango de " + min + " y " + max);
            }

        } while (horas < min || horas > max);

        sc.nextLine();
        return horas;
    }

    public boolean leerBooleanAlumno(Scanner sc, String mensaje) {
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
