import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opc;
        int contador = 0;
        Scanner sc = new Scanner(System.in);
        Validator validator = new Validator();
        //Arreglo
        Alumnos[] alumnos = new Alumnos[25];
        Alumnos alumno = new Alumnos();

        do {
            System.out.println("Menu");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja la logica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar promedio por ID (solo activas)");
            System.out.println("6) Reportes");
            System.out.println("7) Salir");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    int id = validator.Id("Ingresa el ID:", sc, alumnos, contador);
                    String name = validator.name("Ingresa el nombre:", sc);
                    boolean isactive = validator.isActivo("Esta activo?", sc);
                    double promedio = validator.Promedio("Ingresa el promedio", sc, 0, 10);
                    //Objeto, persona
                    Alumnos alumnoNuevo = new Alumnos(id, name, isactive, promedio);
                    //Contador que guarda los valores que ingresamos en el arreglo
                    // sirve tambien para quie no guarde todo en una misma posicion del arreglo
                    alumnos[contador] = alumnoNuevo;
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
                        if (alumnos[i].isActive()) {
                            if (alumnos[i].getId() == buscarid) {
                                System.out.println("ID: " + alumnos[i].getId());
                                System.out.println("Nombre: " + alumnos[i].getName());
                                System.out.println("Activo: " + alumnos[i].isActive());
                                System.out.println("Promedio: " + alumnos[i].getPromedio());
                            }
                        } else {
                            System.out.println("Inactiva");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el ID que daras de baja");
                    buscarid = sc.nextInt();
                    for (int i = 0; i < contador; i++) {
                        if (alumnos[i].getId() == buscarid) {
                            //Aqui cambia su estado a false y "desaparece" de la lista
                            alumnos[i].setActive(false);
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
                        if (alumnos[i].isActive()) {
                            System.out.println("ID: " + alumnos[i].getId());
                            System.out.println("Nombre: " + alumnos[i].getName());
                            System.out.println("Activo: " + alumnos[i].isActive());
                            System.out.println("Promedio: " + alumnos[i].getPromedio());

                        }
                    }
                    break;

                case 5:
                    System.out.println("Actualizar promedio por ID");
                    System.out.println("Ingresa el  ID que quieres buscar");
                    int actid = sc.nextInt();
                    for (int i = 0; i < contador; i++) {
                        if (alumnos[i].getId() == actid) {
                            //pide el nombre
                            double nuevoPromedio = validator.Promedio("Ingresa el nuevo promedio", sc, 0, 10);
                            //actualiza el nombre con la variablñe que ocupamos
                            alumnos[i].setPromedio(nuevoPromedio);
                        }
                    }
                    break;

                case 6:
                    System.out.println("---- Reportes ----");
                    double suma = 0;
                    double PromedioMayor = 0;
                    double PromedioMenor = 10;
                    int contadorpromedio = 0;
                    int contadoralumnos = 0;
                    for (int i = 0; i < contador; i++) {
                        if (alumnos[i].isActive()) {
                            suma += alumnos[i].getPromedio();
                            contadorpromedio++;
                            if (alumnos[i].getPromedio() > PromedioMayor) {
                                PromedioMayor = alumnos[i].getPromedio();
                            }
                            if (alumnos[i].getPromedio() < PromedioMenor) {
                                PromedioMenor = alumnos[i].getPromedio();
                            }
                            if (alumnos[i].getPromedio() >= 8) {
                                contadoralumnos++;
                            }
                        }
                    }
                    System.out.println("promedio General De Alumnos es: " + suma / contadorpromedio);
                    System.out.println("El promedio mayor es: " + PromedioMayor);
                    System.out.println("El promedio menor es: " + PromedioMenor);
                    System.out.println("Los Alumnos que tienen promedio mayor igual a 8: " + contadoralumnos);
                    break;

                case 7:
                    System.out.println("vuelva pronto :)");
                    System.exit(0);
            }

        } while (opc != 0);

        System.out.println(alumnos[0]);
    }
}