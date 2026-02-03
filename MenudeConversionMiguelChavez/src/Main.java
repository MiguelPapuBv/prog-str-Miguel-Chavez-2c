import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");

            opcion = validarOpcionMenu(sc);

            switch (opcion) {
                case 1:
                    double tempc = obtenerDatos(sc, "Ingresa la temperatura en °C:");
                    System.out.println("Resultado: " + obtenerTempF(tempc) + " °F");
                    c1++;
                    break;
                case 2:
                    double tempf = obtenerDatos(sc, "Ingresa la temperatura en °F:");
                    System.out.println("Resultado: " + obtenerTempC(tempf) + " °C");
                    c2++;
                    break;
                case 3:
                    double km = obtenerDatos(sc, "Ingresa los km:");
                    System.out.println("Resultado: " + obtenerMI(km) + " millas");
                    c3++;
                    break;
                case 4:
                    double mi = obtenerDatos(sc, "Ingresa las millas:");
                    System.out.println("Resultado: " + obtenerKM(mi) + " km");
                    c4++;
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
            }
            System.out.println();

        } while (opcion != 5);

        int total = c1 + c2 + c3 + c4;
        System.out.println("Conversiones °C a °F: " + c1);
        System.out.println("Conversiones °F a °C: " + c2);
        System.out.println("Conversiones Km a Mi: " + c3);
        System.out.println("Conversiones Mi a Km: " + c4);
        System.out.println("TOTAL DE CONVERSIONES: " + total);
    }

    public static int validarOpcionMenu(Scanner sc) {
        int opt;
        while (true) {
            System.out.print("Selecciona una opción (1-5): ");
            if (sc.hasNextInt()) {
                opt = sc.nextInt();
                if (opt >= 1 && opt <= 5) return opt;
                System.out.println("Error: Opción fuera de rango (1-5).");
            } else {
                System.out.println("Error: Debes ingresar un número entero.");
                sc.next();
            }
        }
    }

    public static double obtenerDatos(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Error: El dato debe ser numérico.");
                sc.next();
            }
        }
    }

    public static double obtenerTempF(double tempc) { return (tempc * 1.8) + 32; }
    public static double obtenerTempC(double tempf) { return (tempf - 32) / 1.8; }
    public static double obtenerMI(double km) { return km * 0.6214; }
    public static double obtenerKM(double mi) { return mi * 1.609; }
}
