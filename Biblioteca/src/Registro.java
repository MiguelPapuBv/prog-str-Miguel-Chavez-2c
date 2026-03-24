public class Registro {
    private String codigo;
    private int hora;
    private boolean alumnoSN;

    public Registro(String codigo, int hora, boolean alumnoSN) {
        this.codigo = codigo;
        this.hora = hora;
        this.alumnoSN = alumnoSN;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public boolean isAlumnoSN() {
        return alumnoSN;
    }

    public void setAlumnoSN(boolean alumnoSN) {
        this.alumnoSN = alumnoSN;
    }
}
