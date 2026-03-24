public class Padre {
    protected String name;

    public Padre(String name) {
        this.name = name;
    }

    public void comer(){


        System.out.println(name + "Esta comiendo ");
    }

    public void HacerSonido(){
        System.out.println(name+ "Esta haciendo Sonido x");
    }
}
