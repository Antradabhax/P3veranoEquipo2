package clase11;

import clase11.Actividad1.Actividad1;
import clase11.Actividad2.Actividad2;
import clase11.Actividad3.Actividad3;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Actividad 1: 2 Reinas
        List<String[]> solucionesReinas = Actividad1.resolver();
        System.out.println("----------------------------------------");

        System.out.println("Actividad 1: 2 Reinas");
        System.out.println("Número de soluciones: " + solucionesReinas.size());
        imprimirTableros(solucionesReinas);

        // Actividad 2: Escritorio y Silla
        List<String[]> solucionesMuebles = Actividad2.resolver();
        System.out.println("\n----------------------------------------");
        System.out.println("Actividad 2: Escritorio y Silla");
        System.out.println("Número de soluciones: " + solucionesMuebles.size());
        imprimirTableros(solucionesMuebles);

        // Actividad 3: Computadoras e Impresoras
        List<String[]> solucionesElectro = Actividad3.resolver();
        System.out.println("\n----------------------------------------");
        System.out.println("Actividad 3: Computadoras e Impresoras");
        System.out.println("Número de soluciones: " + solucionesElectro.size());
        imprimirTableros(solucionesElectro);
        System.out.println("----------------------------------------");

    }

    private static void imprimirTableros(List<String[]> tableros) {
        for (String[] tablero : tableros) {
            for (String fila : tablero) {
                System.out.println(fila);
            }
            System.out.println();
        }
    }
}