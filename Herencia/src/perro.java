public class perro extends Padre{
    public perro(String name) {
        super(name);
    }

    @Override
    public void HacerSonido() {
        super.HacerSonido();
    }

    public void MArcarTerritorio(){
        System.out.println( name+ " Esta alzando la patita");
    }
}
