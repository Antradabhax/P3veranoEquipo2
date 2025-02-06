package clase6.Actividad4;

import java.util.*;

public class Actividad4 {
    private int numNodos;
    private List<List<Nodo>> listaAdyacencia;

    public Actividad4(int numNodos) {
        this.numNodos = numNodos;
        this.listaAdyacencia = new ArrayList<>(numNodos);
        for (int i = 0; i < numNodos; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarCarretera(int origen, int destino, int tiempo) {
        validarNodo(origen);
        validarNodo(destino);
        listaAdyacencia.get(origen).add(new Nodo(destino, tiempo));
        // Para grafos no dirigidos, agregar también la inversa:
        // listaAdyacencia.get(destino).add(new Nodo(origen, tiempo));
    }

    public int[] dijkstra(int origen) {
        int[] distancias = new int[numNodos];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origen] = 0;

        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.tiempo));
        cola.add(new Nodo(origen, 0));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            for (Nodo vecino : listaAdyacencia.get(actual.id)) {
                int nuevaDistancia = distancias[actual.id] + vecino.tiempo;
                if (nuevaDistancia < distancias[vecino.id]) {
                    distancias[vecino.id] = nuevaDistancia;
                    cola.add(new Nodo(vecino.id, nuevaDistancia));
                }
            }
        }
        return distancias;
    }

    private void validarNodo(int nodo) {
        if (nodo < 0 || nodo >= numNodos) {
            throw new IllegalArgumentException("Nodo inválido: " + nodo);
        }
    }

    static class Nodo implements Comparable<Nodo> {
        int id;
        int tiempo;

        Nodo(int id, int tiempo) {
            this.id = id;
            this.tiempo = tiempo;
        }

        @Override
        public int compareTo(Nodo otro) {
            return Integer.compare(this.tiempo, otro.tiempo);
        }
    }
}