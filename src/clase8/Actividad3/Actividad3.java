package clase8.Actividad3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actividad3 {

    public static void ejecutarFloydWarshallConRutas(int[][] grafo) {
        int n = grafo.length;
        int[][] distancias = new int[n][n];
        int[][] predecesores = new int[n][n];

        // Inicializar matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distancias[i][j] = grafo[i][j];
                predecesores[i][j] = (i == j || grafo[i][j] == Integer.MAX_VALUE) ? -1 : i;
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancias[i][k] != Integer.MAX_VALUE &&
                            distancias[k][j] != Integer.MAX_VALUE &&
                            distancias[i][j] > distancias[i][k] + distancias[k][j]) {

                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        predecesores[i][j] = predecesores[k][j];
                    }
                }
            }
        }

        // Verificar ciclos negativos
        boolean cicloNegativo = false;
        for (int i = 0; i < n; i++) {
            if (distancias[i][i] < 0) {
                cicloNegativo = true;
                break;
            }
        }

        if (cicloNegativo) {
            System.out.println("¡Advertencia: Existen ciclos negativos en el grafo!");
        } else {
            // Solicitar origen y destino al usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nodo origen (0 a " + (n-1) + "): ");
            int origen = scanner.nextInt();
            System.out.print("Ingrese el nodo destino (0 a " + (n-1) + "): ");
            int destino = scanner.nextInt();

            // Validar entrada
            if (origen < 0 || origen >= n || destino < 0 || destino >= n) {
                System.out.println("Nodo inválido.");
                return;
            }

            // Mostrar resultados
            if (distancias[origen][destino] == Integer.MAX_VALUE) {
                System.out.println("No hay camino entre " + origen + " y " + destino);
            } else {
                System.out.println("\nTiempo mínimo: " + distancias[origen][destino] + " minutos");
                List<Integer> camino = reconstruirCamino(predecesores, origen, destino);
                System.out.println("Camino: " + camino);
            }
        }
    }

    private static List<Integer> reconstruirCamino(int[][] predecesores, int origen, int destino) {
        List<Integer> camino = new ArrayList<>();
        if (predecesores[origen][destino] == -1) return camino;

        int actual = destino;
        while (actual != origen) {
            camino.add(0, actual);
            actual = predecesores[origen][actual];
        }
        camino.add(0, origen);
        return camino;
    }
}