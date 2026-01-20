import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = obtenerNumeros(scanner,  "Ingresa El primer numero entero");
        int num2 = obtenerNumeros(scanner,  "Ingresa El segundo numero entero");
        int num3 = obtenerNumeros(scanner,  "Ingresa El tercer numero entero");

        int suma = obtenerSuma(num1,  num2, num3);
        double prom = obtenerPromedio(suma);
        System.out.println("suma=" + suma);
        System.out.println("prom=" + prom);
    }

    /**
     * Metodo para obtener los numeros
     * @param sc scanner que leera los numeros
     * @param mensaje Texto que aparecera en consola
     * @return los numeros enteros
     */
    public static int obtenerNumeros(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     * Metod para calcular el resultado de la suma
     * @param num1
     * @param num2
     * @param num3
     * @return El resultado de la suma
     */
    public static int obtenerSuma(int num1, int num2, int num3){

        return num1+num2+num3;
    }

    /**
     * Metodo para obtener el promedio
     * @param suma
     * @return El total del promedio
     */
    public static double obtenerPromedio(int suma){

        return (suma/3.0);
    }

}
