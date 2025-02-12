package clase8.Actividad1;

public class Actividad1 {
    public static void ejecutar() {
        final int INF = 99999;
        int[][] dist = new int[5][5]; // Usamos índices del 1 al 4

        // Inicializar la matriz de distancias
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // Definir las aristas del grafo
        dist[1][2] = 2;
        dist[2][4] = 4;
        dist[1][4] = 5;
        dist[4][3] = 2;

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 1; k <= 4; k++) {
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 4; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        System.out.println("Matriz de distancias más cortas:");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}