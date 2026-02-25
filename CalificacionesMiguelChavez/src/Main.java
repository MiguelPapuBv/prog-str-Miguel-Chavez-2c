import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            Validator validador = new Validator();
            GradeService gradeservice = new GradeService();

            String nombre = validador.leerNombreNoVacio(sc, "Ingresa el nombre del alumno: ");
            double p1 = validador.leerDoubleParcial(sc, "Por favor ingresa la calificacion del parcial 1, El rango es de 0-100: ", 0, 100);
            double p2 = validador.leerDoubleParcial(sc, "Por favor ingresa la calificacion del parcial 2, El rango es de 0-100: ", 0, 100);
            double p3 = validador.leerDoubleParcial(sc, "Por favor ingresa la calificacion del parcial 3, El rango es de 0-100: ", 0, 100);

            int asistencia = validador.leerIntFaltas(sc, "Ingresa tu asistencia total, El rango es de 0-100: ", 0, 100);

            boolean proyecto = validador.leerBooleanProyecto(sc, "¿Enregaste el proyecto final? Debes respondertrue/false: ");

            double promedio = gradeservice.calcularPromedio(p1, p2, p3);
            double promedioFinal = gradeservice.calcularPromedioFinal(promedio, asistencia);
            String apr_noapr = gradeservice.CalcularSiAprobo(promedioFinal, asistencia, proyecto);
            imprimirBoleta(nombre, p1, p2, p3, promedio, asistencia, proyecto, promedioFinal, apr_noapr);

            sc.close();
        }

        public static void imprimirBoleta(String nombre, double n1, double n2, double n3,
                                           double prom, int asistencia, boolean proyecto, double promfin, String aprbnoaprb) {
            System.out.println("------Boleta-----");
            System.out.println("EL alumno: " + nombre);
            System.out.println("Sus calificaciones de los tres parciales fueron : " + n1 +","   + n2 +","   + n3 );
            System.out.println("tu promedio de tus tres parciales: " +prom);
            System.out.println("TU porcentaje total de asistencia fue : " + asistencia );
            System.out.println("¿Entregaste proyecto? " + proyecto);
            System.out.println("Tu calificacion final fue de: " +promfin);
            System.out.println("Aprobado/reprobado: " +aprbnoaprb);

        }
    }
