import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("Calculadora: Selecciona una de las operaciones  que quieras realizar");
        System.out.println("1.- Sumar, 2.- Restar, 3.-Multiplicar, 4.-Dividir");
        opcion = sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Elegiste Suma");
                double a  = obtenerDatoss(sc, "Ingresa el nuemro");
                double b = obtenerDatoss(sc, "Ingresa el segundo numero");
                double suma = obtenerSuma(a, b);
                System.out.println(a+ " + " +b);
                System.out.println("Resultado: " +suma);
                break;
            case 2:
                System.out.println("Elegiste Suma");
                 a  = obtenerDatoss(sc, "Ingresa el nuemro");
                 b = obtenerDatoss(sc, "Ingresa el segundo numero");
                double resta = obtenerResta(a, b);
                System.out.println(a+ " - " +b);
                System.out.println("Resultado: " +resta);

                break;
            case 3:
                System.out.println("Elegiste Multiplicacion");
                a  = obtenerDatoss(sc, "Ingresa el nuemro");
                b = obtenerDatoss(sc, "Ingresa el segundo numero");
                double multiplicacion = obtenerMultiplicacion(a, b);
                System.out.println(a+ " * " +b);
                System.out.println("Resultado: " +multiplicacion);
                break;
            case 4:
                System.out.println("Elegiste Division");
                a  = obtenerDatoss(sc, "Ingresa el nuemro");
                b = obtenerDatoss(sc, "Ingresa el segundo numero");
                if(b == 0){
                    System.out.println("No se puede dividir entre cero");
                } else {
                    double division = obtenerDivision(a, b);
                    System.out.println(a+ " / " +b);
                    System.out.println("Resultado: " +division);

                }
                break;
            default :
                System.out.println("Opcion no valida");

                break;
        }
    }
    public static double obtenerDatoss(Scanner sc, String mensaje){
        System.out.println(mensaje);

        return sc.nextDouble();
    }
    public static double obtenerSuma(double a, double b){

        return (a + b);
    }

    public static double obtenerResta(double a, double b){

        return (a - b);
    }

    public static double obtenerMultiplicacion(double a, double b){

        return (a * b);
    }
    public static double obtenerDivision(double a, double b){


        return a/b;
    }



}
