package clase11.Actividad1;

import java.util.ArrayList;
import java.util.List;

public class Actividad1 {
    public static List<String[]> resolver() {
        List<String[]> soluciones = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            int r1 = i / 4;
            int c1 = i % 4;
            for (int j = i + 1; j < 16; j++) {
                int r2 = j / 4;
                int c2 = j % 4;
                if (!mismaFila(r1, r2) && !mismaColumna(c1, c2) && !mismaDiagonal(r1, c1, r2, c2)) {
                    String[] board = crearTablero(r1, c1, r2, c2);
                    soluciones.add(board);
                }
            }
        }
        return soluciones;
    }

    private static boolean mismaFila(int r1, int r2) {
        return r1 == r2;
    }

    private static boolean mismaColumna(int c1, int c2) {
        return c1 == c2;
    }

    private static boolean mismaDiagonal(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) == Math.abs(c1 - c2);
    }

    private static String[] crearTablero(int r1, int c1, int r2, int c2) {
        String[] tablero = new String[4];
        for (int i = 0; i < 4; i++) {
            StringBuilder fila = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                if ((i == r1 && j == c1) || (i == r2 && j == c2)) {
                    fila.append('Q');
                } else {
                    fila.append('.');
                }
            }
            tablero[i] = fila.toString();
        }
        return tablero;
    }
}