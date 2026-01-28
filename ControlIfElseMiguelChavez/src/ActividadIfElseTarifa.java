import java.util.Scanner;
public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        boolean estudiantes;


    }
    public static int ObtenerEdad(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();

    }

    public static boolean ObtenerEstudiante(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextBoolean();
    }

    public static double ObtenerTarifa(int edad, boolean estudaintes){
        double tarifa;
        if (edad <12){
            tarifa =50;
        }
        else if(edad >=12 && edad <= 17){
            if(estudaintes){
                tarifa=60;
            } else{
                tarifa=80;
            }
        } else if ()
    }


}
