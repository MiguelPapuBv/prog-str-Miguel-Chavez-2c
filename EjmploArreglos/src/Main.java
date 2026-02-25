//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //Sintaxis
        //declaracion
        int[] arr = new int[4];//inicializacion
        int[] arr2 = {1,2,3,4};

        //acceso get
        System.out.println(arr[0]);
        System.out.println(arr2[1]);
        System.out.println("---------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[1]);
        }

        System.out.println("--------------------------");
        for(int numero : arr){
            System.out.println(numero);
        }
        System.out.println("---------------------------");
        personas[] personas = new personas[3];
        personas persona1 = new personas();
        persona1.setId(1);
        persona1.setName("Miguel");
        persona1.setActive(true);
        personas persona2 = new personas(2, "Miguel");
        personas persona3 = new personas(3, "Miguel");
        personas[0] =persona1;
        personas[1] =persona2;
        personas[2] =persona3;
        personas[0]=null;

        for (personas persona : personas){

            System.out.println(persona.getId());
            System.out.println(persona.getName());
            System.out.println(persona.getisActive());
        }


    }

}