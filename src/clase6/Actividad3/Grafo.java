package clase6.Actividad3;

import java.util.*;

public class Grafo {
    private int numNodos;
    private List<List<Arista>> listaAdyacencia;

    public Grafo(int numNodos) {
        this.numNodos = numNodos;
        this.listaAdyacencia = new ArrayList<>(numNodos);
        for (int i = 0; i < numNodos; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        validarNodo(origen);
        validarNodo(destino);
        // Agregar arista en ambas direcciones (grafo no dirigido)
        listaAdyacencia.get(origen).add(new Arista(origen, destino, peso)); // Origen explícito
        listaAdyacencia.get(destino).add(new Arista(destino, origen, peso)); // Origen = destino original
    }

    public List<Arista> primMST() {
        PriorityQueue<Arista> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));
        boolean[] enMST = new boolean[numNodos];
        List<Arista> resultado = new ArrayList<>();

        cola.addAll(listaAdyacencia.get(0));
        enMST[0] = true;

        while (!cola.isEmpty()) {
            Arista arista = cola.poll();
            if (enMST[arista.destino]) continue;

            enMST[arista.destino] = true;
            resultado.add(arista);

            for (Arista vecino : listaAdyacencia.get(arista.destino)) {
                if (!enMST[vecino.destino]) {
                    cola.add(vecino);
                }
            }
        }
        return resultado;
    }

    private void validarNodo(int nodo) {
        if (nodo < 0 || nodo >= numNodos) {
            throw new IllegalArgumentException("Nodo inválido: " + nodo);
        }
    }

    static class Arista {
        int origen; // <- Nuevo campo
        int destino;
        int peso;

        Arista(int origen, int destino, int peso) { // <- Modificar constructor
            this.origen = origen;
            this.destino = destino;
            this.peso = peso;
        }
    }

    public void imprimirGrafo() {
        System.out.println("--- Representación del Grafo ---");
        for (int origen = 0; origen < numNodos; origen++) {
            System.out.print("Nodo " + origen + " -> ");
            for (Arista arista : listaAdyacencia.get(origen)) {
                System.out.print(arista.destino + " (Peso: " + arista.peso + ") ");
            }
            System.out.println();
        }
    }
}