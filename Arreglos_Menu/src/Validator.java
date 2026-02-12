import java.util.Scanner;

public class Validator {
    //Validar el id
    public int Id(String message, Scanner sc, Persona[] personas, int contador){
        int id;
        while(true){
            System.out.println(message);
            if(sc.hasNextInt()){
                id = sc.nextInt();
                sc.nextLine();
                if(id <= 0){
                    System.out.println("El id no puede ser negativo o cero");
                }
                // booleano para saber si es esta repetido
                boolean repetido = false;
                for(int i = 0; i < contador; i++){
                    //if que compara si son iguales los id
                    if(personas[i].getId() == id){
                        //Si si es repetido , la variable repetido cambia a true
                        repetido = true;
                        break;
                    }
                }
                if(repetido){
                    System.out.println("El id ya está registrado, intenta otro.");
                } else {
                    return id;
                }
            } else {
                System.out.println("El valor no es numérico");
                sc.nextLine();
            }
        }
    }
    //Metodo que leera el nombre
    public String name(String message, Scanner sc){
        String name;
        while(true){
            System.out.println(message);
            name = sc.nextLine();
            //Este if comprueba que el texto no este vacio
            if(name.trim().isEmpty()){
                System.out.println("El texto está vacío, intenta de nuevo.");
            } else {
                return name;
            }
        }
    }
    //Este metodo para leer el estado true/false
    public boolean isActivo (String message, Scanner sc){
        boolean isactivo;
        while(true){
            System.out.println(message + " (true/false)");
            //Este if compara que el valor sea booleano
            if(sc.hasNextBoolean()){
                isactivo = sc.nextBoolean();
                sc.nextLine();
                return isactivo;
            } else {
                System.out.println("El valor no es booleano");
                sc.nextLine();
            }
        }
    }
}