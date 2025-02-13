package clase11.Actividad2;

import java.util.ArrayList;
import java.util.List;

public class Actividad2 {
    public static List<String[]> resolver() {
        List<String[]> soluciones = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            int r1 = i / 4;
            int c1 = i % 4;
            for (int j = 0; j < 16; j++) {
                if (i == j) continue;
                int r2 = j / 4;
                int c2 = j % 4;
                if (r1 != r2 && c1 != c2) {
                    String[] board = crearTablero(r1, c1, r2, c2);
                    soluciones.add(board);
                }
            }
        }
        return soluciones;
    }

    private static String[] crearTablero(int r1, int c1, int r2, int c2) {
        String[] tablero = new String[4];
        for (int i = 0; i < 4; i++) {
            StringBuilder fila = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                if (i == r1 && j == c1) {
                    fila.append('E');
                } else if (i == r2 && j == c2) {
                    fila.append('S');
                } else {
                    fila.append('.');
                }
            }
            tablero[i] = fila.toString();
        }
        return tablero;
    }
}