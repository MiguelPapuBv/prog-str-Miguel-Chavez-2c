import java.util.Scanner;

public class Main {
    public static double PI = 3.1416;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("Menu de operaciones.");
            System.out.println("1. Calcular el IMC");
            System.out.println("2. Calcular el area del rectangulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular el area de  un circulo");
            System.out.println("5. salir del menu");
            System.out.print("Elije la opcion que necesites: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Calcularemos el IMC");
                    double peso = obtenerDatos(sc, "Ingresa el peso en KG");
                    double altura = obtenerDatos(sc, "Ingresa la  altura en metros");
                    double IMC = obtenerIMC(peso,altura);
                    System.out.println("El IMC es: " +IMC);

                    break;
                case 2:
                    System.out.println("Calcularemos el area de un rectangulo.");
                    double base = obtenerDatos(sc, "Ingresa la base del rectangulo");
                    double alturaRec = obtenerDatos(sc, "Ingresa la altura del rectangulo");
                    double area = obtenerAreaRec(base, alturaRec);
                    System.out.println("El area del rectangulo es " +area);

                    break;
                case 3:
                    System.out.println("Convertiremos grados °C a °F");
                    double c = obtenerDatos(sc, "Ingresa la temperatura en grados °C");
                    double temf = convertirCaF(c);
                    System.out.println("La temperaura en grados °F es: " +temf);
                    break;
                case 4:
                    System.out.println("Calcularemos el area de un circulo");
                    double radio = obtenerDatos(sc, "Ingresa el radio del circulo");
                    double areacir = obtenerAreacir(PI, radio);
                    System.out.println("El area del circulo es: " +areacir);
                    break;
                case 5:
                    System.out.println("salir del menu");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida ");
            }
            System.out.println();

        } while (choice != 5);

    }

    /**
     * Herramienta para que nos ayude a solicitar los datos
     * @param sc Scanner que leera los datos que solicitemos
     * @param mensaje Texto que aparecera en la consola donde solicite los datos
     * @return El valor de lo que solicitemos
     */
    public static double obtenerDatos(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }





    /**
     * Operacion para calcular el IMC
     * @param peso
     * @param altura
     * @return El resultado de la operacion
     */
    public static double obtenerIMC(double peso, double altura){

        return peso/(altura*altura);
    }






    /**
     * Operacion para calcular el area del rectangulo
     * @param base
     * @param alturaRec
     * @return El valor area del rectangulo
     */
    public static double obtenerAreaRec(double base, double alturaRec ){

        return (base*alturaRec);
    }





    /**
     * Operacion para convertir la temperatura en grados °C a gardos °F
     * @param c
     * @return El valor de la temperatura en grados °F
     */
    public static double convertirCaF(double c){

        return (c*1.8)+32;
    }






    /**
     * Operacion que calculara el area del circulo
     * @param PI
     * @param radio
     * @return El valor del area calculada
     */
    public static double obtenerAreacir(double PI, double radio){

        return PI*(radio*radio);
    }

}
