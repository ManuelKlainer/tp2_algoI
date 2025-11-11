package aed;

import java.util.Arrays;

public class MiTest {
    
    public static void main() {
        Edr edr;
        int d_aula;
        int cant_alumnos;
        int[] solucion;
        d_aula = 5;
        cant_alumnos = 4;
        solucion = new int[]{0,1,2,3,4,5,6,7,8,9};

        edr = new Edr(d_aula, cant_alumnos, solucion);
        double[] notas;
        double[] notas_esperadas;
        int[] resolucion_dark = new int[]{0,0,2,2,5,6,7,0,0,9};
        //todes resuelven bien un ejercicio excepto el estudiante 0
        for(int estudiante = 1; estudiante < 4; estudiante++){
            edr.resolver(estudiante, estudiante, estudiante);
        }

        //alguien sube la solución con acceso para una persona, debe acceder el alumno 0
        edr.consultarDarkWeb(1, resolucion_dark);

        notas = edr.notas();
        notas_esperadas = new double[]{30.0, 10.0, 10.0, 10.0};

        //al cambiar la resolución, no debería cambiar la nota ni el resultado del examen
        resolucion_dark[1] = 1;
        resolucion_dark[3] = 3;

        notas = edr.notas();
        double[] notas_erroneas = new double[]{50.0, 10.0, 10.0, 10.0};

        for(int estudiante = 0; estudiante < 4; estudiante++){
            edr.entregar(estudiante);
        }

        int[] copiones = edr.chequearCopias();
        int[] copiones_esperados = new int[]{2};

        NotaFinal[] notas_finales = edr.corregir();
        NotaFinal[] notas_finales_esperadas = new NotaFinal[]{
            new NotaFinal(30.0, 0),
            new NotaFinal(10.0, 3),
            new NotaFinal(10.0, 1),
        };

        for (int i = 0; i < notas_finales.length; i++) {
            System.out.println("Nota Final: " + notas_finales[i]._nota + " Id: " + notas_finales[i]._id);
        }
    }
}