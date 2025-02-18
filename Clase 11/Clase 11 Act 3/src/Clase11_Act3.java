import java.util.ArrayList;
import java.util.List;

public class Clase11_Act3 {
    //definición de las soluciones de 4 reinas (computadoras e impresoras)
    private static final int[][] SOLUCION1 = {{0, 1}, {1, 3}, {2, 0}, {3, 2}};
    private static final int[][] SOLUCION2 = {{0, 2}, {1, 0}, {2, 3}, {3, 1}};

    public static List<String[]> resolver() {
        List<String[]> soluciones = new ArrayList<>();
        //combinamos Solución1 para C y Solución2 para I
        soluciones.add(crearTablero(SOLUCION1, SOLUCION2));
        //combinamos Solución2 para C y Solución1 para I
        soluciones.add(crearTablero(SOLUCION2, SOLUCION1));
        return soluciones;
    }

    private static String[] crearTablero(int[][] computadoras, int[][] impresoras) {
        String[] tablero = new String[4];
        for (int i = 0; i < 4; i++) {
            char[] fila = new char[4];
            //inicializamos todas las celdas como vacías (.)
            java.util.Arrays.fill(fila, '.');
            //colocamos computadoras (C)
            for (int[] pos : computadoras) {
                if (pos[0] == i) {
                    fila[pos[1]] = 'C';
                }
            }
            //colocamos impresoras (I)
            for (int[] pos : impresoras) {
                if (pos[0] == i) {
                    fila[pos[1]] = 'I';
                }
            }
            tablero[i] = new String(fila);
        }
        return tablero;
    }
}