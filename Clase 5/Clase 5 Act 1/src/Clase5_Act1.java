import java.util.ArrayList;
import java.util.Collections;

public class Clase5_Act1 {
    public static void main(String[] args) {
        ArrayList<Integer> monedas = new ArrayList<Integer>();
        crearMonedas(monedas);
        Collections.sort(monedas, Collections.reverseOrder());

        int cambio = 69;

        System.out.println(cambioExacto(monedas, cambio));
    }

    private static ArrayList<Integer> cambioExacto(ArrayList<Integer> monedas, int cambio){
        int suma = suma(monedas);
        if (cambio > suma) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> monedasCambio = new ArrayList<Integer>();
        int i = 0;
        while (cambio > 0 && !monedas.isEmpty()) {
            if (cambio >= monedas.get(i)) {
                monedasCambio.add(monedas.get(i));
                cambio -= monedas.get(i);
            }
            i++;
        }
        return monedasCambio;
    }

    private static int suma(ArrayList<Integer> monedas){
        int suma = 0;
        for (int i = 0; i < monedas.size(); i++) {
            suma += monedas.get(i);
        }
        return suma;
    }

    private static void crearMonedas(ArrayList<Integer> monedas){
        monedas.add(10);
        monedas.add(1);
        monedas.add(5);
        monedas.add(2);
        monedas.add(10);
        monedas.add(10);
        monedas.add(5);
        monedas.add(2);
        monedas.add(5);
        monedas.add(5);
        monedas.add(5);
        monedas.add(5);
        monedas.add(5);
        monedas.add(5);
        monedas.add(10);
    }
}