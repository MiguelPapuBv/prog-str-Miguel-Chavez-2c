import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opc;
        int contador = 0;
        Scanner sc = new Scanner(System.in);
        Validator vaidator = new Validator();
        //Arreglo
        Persona[] personas = new Persona[20];
        Persona persona = new Persona();

        do {
            System.out.println("Menu");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja la logica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID (solo activas)");
            System.out.println("6) Salir");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    int id = vaidator.Id("Ingresa el ID:", sc, personas, contador);
                    String name = vaidator.name("Ingresa el nombre:", sc);
                    boolean isactive = vaidator.isActivo("Esta activo?", sc);
                    //Objeto, persona
                    persona = new Persona(id, name, isactive);
                    //Contador que guarda los valores que ingresamos en el arreglo
                    // sirve tambien para quie no guarde todo en una misma posicion del arreglo
                    personas[contador] = persona;
                    //Contador
                    contador++;
                    System.out.println("Persona registrada correctamente.");
                    break;
                case 2:
                    System.out.println("Buscar por ID");
                    System.out.println("Ingresa el  ID que quieres buscar");
                    int buscarid = sc.nextInt();
                    //ciclo que muestra los datos existentes mientras se desplaza
                    for (int i = 0; i < contador; i++) {
                        //if que busca y compara el id que ingresas
                        if(personas[i].isActive()){
                        if (personas[i].getId() == buscarid) {
                            System.out.println("ID: " + personas[i].getId());
                            System.out.println("Nombre: " + personas[i].getName());
                            System.out.println("Activo: " + personas[i].isActive());
                        } }else {
                            System.out.println("Inactiva");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el ID que daras de baja");
                    buscarid = sc.nextInt();
                    for (int i = 0; i < contador; i++) {
                        if (personas[i].getId() == buscarid){
                            //Aqui cambia su estado a false y "desaparece" de la lista
                            personas[i].setActive(false);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Listas Activas");
                    //ciclo for que ayuda a mostar solo las personas activas
                    //si ingresamos 3 personas solo mostrara esas tres
                    for (int i = 0; i < contador; i++) {
                        //If que busca si la persona esta activa
                        //La i busca la posicion del arreglo ydonde esta registrada la persona
                        if (personas[i].isActive()) {
                            System.out.println("ID: " + personas[i].getId());
                            System.out.println("Nombre: " + personas[i].getName());
                            System.out.println("Activo: " + personas[i].isActive());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Actualizar nombre por ID");
                    System.out.println("Ingresa el  ID que quieres buscar");
                    int actid = sc.nextInt();
                    for (int i = 0; i < contador; i++){
                        if (personas[i].getId() == actid) {
                            //pide el nombre
                            name = vaidator.name("Ingresa el nuevo nombre:", sc);
                            //actualiza el nombre con la variablñe que ocupamos
                            personas[i].setName(name);
                        }
                    }
                    break;
                case 6:
                    System.out.println("vuelva pronto :)");
                    System.exit(0);
            }

        }while(opc != 0);

        System.out.println(personas[0]);
    }
}