import java.util.ArrayList;
import java.util.HashMap;

public class Clase4_Act5 {
    public static void main(String[] args) {
        ArrayList<Corredor> corredores = new ArrayList();
        corredores.add(new Corredor("Junior", "Juan", 1.278));
        corredores.add(new Corredor("Senior", "Pedro", 1.137));
        corredores.add(new Corredor("Senior", "Maria", 1.278));
        corredores.add(new Corredor("Junior", "Luis", 1.345));
        corredores.add(new Corredor("Master", "Ricardo", 1.045));
        corredores.add(new Corredor("Master", "Agustin", 1.658));

        HashMap<String, ArrayList<Corredor>> corredoresPorCategoria = new HashMap();

        for (Corredor corredor : corredores) {
            if (!corredoresPorCategoria.containsKey(corredor.categoria)) {
                ArrayList<Corredor> lista = new ArrayList();
                corredoresPorCategoria.put(corredor.categoria, lista);
            }
            corredoresPorCategoria.get(corredor.categoria).add(corredor);
        }

        for (ArrayList<Corredor> corredor : corredoresPorCategoria.values()) {
            System.out.println(buscarMejorCorredor(corredor));
        }
    }

    private static Corredor buscarMejorCorredor (ArrayList<Corredor> corredores) {
        return buscarMejorCorredor(corredores, 0, corredores.size() - 1);
    }
    private static Corredor buscarMejorCorredor (ArrayList<Corredor> corredores, int ini, int fin) {
        if (ini == fin) {
            return corredores.get(ini);
        }

        int mitad = (ini + fin) / 2;
        Corredor mejor = buscarMejorCorredor(corredores, ini, mitad);
        Corredor mejor2 = buscarMejorCorredor(corredores, mitad + 1, fin);

        if (mejor.tiempo < mejor2.tiempo) {
            return mejor;
        } else {
            return mejor2;
        }
    }
}

class Corredor {
    String categoria;
    String nombre;
    double tiempo;
    public Corredor(String categoria, String nombre, double tiempo) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Corredor{" +
                "categoria='" + categoria + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tiempo=" + tiempo +
                '}';
    }
}