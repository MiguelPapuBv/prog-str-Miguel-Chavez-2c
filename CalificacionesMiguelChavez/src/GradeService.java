public class GradeService {

    private final double VALOR_DE_PARCIAL = 0.70;
    private final double VALOR_DE_ASISTENCIA = 0.30;
    private final int ASISTENCIA_MINIMA = 80;
    private final double CALIFICACION_MINIMA_APROBATORIA = 70.0;


    public double calcularPromedio(double p1, double p2, double p3) {
        return (p1 + p2 + p3) / 3.0;
    }


    public double calcularPromedioFinal(double promedio, int asistencia) {
        double calif_parcial = promedio * VALOR_DE_PARCIAL;
        double calif_asistencia = asistencia * VALOR_DE_ASISTENCIA;

        return calif_parcial + calif_asistencia;
    }

    public String CalcularSiAprobo(double califFinal, int asistencia, boolean entregoProyecto) {


        if (asistencia < ASISTENCIA_MINIMA) {
            return "Lo siento estas reprobado por asistencia :c";
        }

        if (entregoProyecto == false) {
            return "Lo siento estas reprobado por proyecto :c";
        }

        if (califFinal >= CALIFICACION_MINIMA_APROBATORIA) {
            return "!Felicidades¡ Aprobaste :)";
        } else {
            return "Lo siento reprobaste por calificación :c";
        }
    }
}

