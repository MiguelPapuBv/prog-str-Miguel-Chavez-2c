import java.util.Scanner;
public class inputValidator {
    public int getValdInt(String mensaje, Scanner sc){
        int value;
        while(true){
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                value = sc.nextInt();
                if(value > 0){
                    return value;
                }
                System.out.println("El numero no es positivo");
            } else{
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }
}
