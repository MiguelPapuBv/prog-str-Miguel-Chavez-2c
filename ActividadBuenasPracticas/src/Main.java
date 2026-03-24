import java.util.Scanner;
public class Main{

    public static void main(String[]a){
        Scanner sc = new Scanner(System.in);
        int numero = obtenerInt(sc, "Ingresa un numero entero");
        int s= obtenerSuma(numero);
        System.out.println("resultado:"+s);
    }

    /**
     *
     * @param sc leera el numero numero entero
     * @param mensaje le pide al usuario que ingrese el numero
     * @return el numero entero
     */
    public static int  obtenerInt(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     *
     * @param
     * @return El resultado
     */
    public static int obtenerSuma(int num){
        int s=0;
        for(int i =1; i<=num; i++){
            s+=i;
        }
        return s;
    }
}
