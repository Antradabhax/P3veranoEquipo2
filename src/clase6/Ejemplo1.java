package clase6;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo1 {
    int numVertices;

    public List<List<Integer>> crearGrafoVacio(int vertices){
        List<List<Integer>> grafo = new ArrayList<>();

        for(int i=0; i<vertices;i++){
            grafo.add(new ArrayList<>());
        }
        return grafo;
    }

    public void mostrarGrafo(List<List<Integer>> grafo) {
        for (int i = 0; i < grafo.size()-1; i++) {
            System.out.print("Nodo " + i + " conectado a: ");
            for (int vecino : grafo.get(i)) {
                System.out.print(vecino + " ");
            }
            System.out.println();
        }
    }
}
