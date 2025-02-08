import java.util.ArrayList;
import java.util.Collections;

public class Clase4_Act4 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = cargarDatos();
        System.out.println("Actividad 4: ");
        System.out.println(obtenerMayores(numeros, 3));
    }

    public static ArrayList<Integer> obtenerMayores(ArrayList<Integer> numeros, int cantidad) {
        return obtenerMayoresSub(numeros, cantidad, 0, numeros.size());
    }

    private static ArrayList<Integer> obtenerMayoresSub(ArrayList<Integer> numeros, int cantidad, int inicio, int fin) {
        if (cantidad <= 0 || inicio >= fin) {
            return new ArrayList<>();
        }
        if (fin - inicio <= cantidad) {
            ArrayList<Integer> sublist = new ArrayList<>(numeros.subList(inicio, fin));
            Collections.sort(sublist, Collections.reverseOrder());
            return new ArrayList<>(sublist.subList(0, Math.min(cantidad, sublist.size())));
        }

        int mid = (inicio + fin) / 2;
        ArrayList<Integer> left = obtenerMayoresSub(numeros, cantidad, inicio, mid);
        ArrayList<Integer> right = obtenerMayoresSub(numeros, cantidad, mid, fin);

        ArrayList<Integer> result = new ArrayList<>(left);
        result.addAll(right);
        Collections.sort(result, Collections.reverseOrder());

        return new ArrayList<>(result.subList(0, Math.min(cantidad, result.size())));
    }

    public static ArrayList<Integer> cargarDatos() {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(12);
        numeros.add(20);
        numeros.add(10);
        numeros.add(15);
        numeros.add(9);
        return numeros;
    }
}