package clase5.Actividad1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Actividad1 {

    public static List<Integer> obtenerCambio(List<Integer> monedas, int importe) {
        Collections.sort(monedas, Collections.reverseOrder());
        List<Integer> resultado = new ArrayList<>();
        int suma = 0;

        for (int i = 0; i < monedas.size(); i++) {
            int moneda = monedas.get(i);
            while (suma + moneda <= importe) {
                resultado.add(moneda);
                suma += moneda;
                monedas.remove(i);
                i--; // Ajustar el índice después de eliminar
                if (i < 0) break; // Evitar índice negativo
            }
            if (suma == importe) {
                return resultado;
            }
        }

        throw new IllegalArgumentException("No se puede dar el cambio exacto con las monedas disponibles.");
    }
}
