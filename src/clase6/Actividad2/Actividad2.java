package clase6.Actividad2;

import java.util.ArrayList;
import java.util.List;

public class Actividad2 {
    private boolean[][] matrizAdyacencia;
    private int numNodos;

    public Actividad2(int numNodos) {
        this.numNodos = numNodos;
        this.matrizAdyacencia = new boolean[numNodos][numNodos];
    }

    public void agregarArista(int origen, int destino) {
        validarIndice(origen);
        validarIndice(destino);
        matrizAdyacencia[origen][destino] = true;
    }

    public void eliminarArista(int origen, int destino) {
        validarIndice(origen);
        validarIndice(destino);
        matrizAdyacencia[origen][destino] = false;
    }

    public boolean verificarArista(int origen, int destino) {
        validarIndice(origen);
        validarIndice(destino);
        return matrizAdyacencia[origen][destino];
    }

    public List<Integer> listarAdyacentes(int nodo) {
        validarIndice(nodo);
        List<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < numNodos; i++) {
            if (matrizAdyacencia[nodo][i]) {
                adyacentes.add(i);
            }
        }
        return adyacentes;
    }

    public int gradoSalida(int nodo) {
        validarIndice(nodo);
        int contador = 0;
        for (int i = 0; i < numNodos; i++) {
            if (matrizAdyacencia[nodo][i]) {
                contador++;
            }
        }
        return contador;
    }

    public int gradoEntrada(int nodo) {
        validarIndice(nodo);
        int contador = 0;
        for (int i = 0; i < numNodos; i++) {
            if (matrizAdyacencia[i][nodo]) {
                contador++;
            }
        }
        return contador;
    }

    private void validarIndice(int indice) {
        if (indice < 0 || indice >= numNodos) {
            throw new IllegalArgumentException("Nodo inválido: " + indice);
        }
    }
}