import java.util.Scanner;
public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad = obtenerEdad(sc, "Ingresa tu edad");
        if(edad <0 || edad >120){
            System.out.println("Edad invalida");
            return;
        }
        boolean estudiantes = obtenerEstudiante(sc, "Ingresa si eres estudiante (true = si, false = no");
        double tarifa;
        if (edad <12){
            tarifa =50;
        }
        else if(edad >=12 && edad <= 17){
            if(estudiantes){
                tarifa=60;
            } else{
                tarifa=80;
            }
        } else {
            if (estudiantes){
                tarifa = 90;
            } else {
                tarifa =120;
            }
        }
        System.out.println("Tu edad es: " +edad);
        System.out.println("Tu rol si eres estudiante o no: " +estudiantes);
        System.out.println("Tu tarifa es de: " +tarifa);



    }
    public static int obtenerEdad(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();

    }

    public static boolean obtenerEstudiante(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextBoolean();
    }



}
