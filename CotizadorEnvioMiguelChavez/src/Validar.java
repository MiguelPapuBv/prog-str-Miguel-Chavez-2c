import java.util.Scanner;
public class Validar {
    Scanner sc = new Scanner(System.in);

    public int getValDis(Scanner sc, String mensaje) {
        int dis;
        int totdis;
        while (true) {
            if (sc.hasNextInt()) {
                dis = sc.nextInt();
                if (dis<0){
                    System.out.println("El numero no es positivo");
                }

                else if (dis <= 50) {
                    totdis = 20;
                    return totdis;

                } else if (dis > 50 && dis <= 200) {
                    totdis = 60;
                    return totdis;
                } else if (dis > 200) {
                    totdis = 120;
                    return totdis;
                }
            } else{
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }


    }

    public int getValOpc(Scanner sc, String mensaje){
        int opc;
        int viaje;
        while (true) {
            if (sc.hasNextInt()) {
                opc = sc.nextInt();
                if (opc<0){
                    System.out.println("El numero no es positivo");
                }

                else if (opc == 1) {
                    viaje = 50;
                    return viaje;

                } else if (opc == 2) {
                    viaje = 90;
                    return viaje;
                }
            } else{
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }


    }
}
