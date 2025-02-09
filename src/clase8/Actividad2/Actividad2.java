package clase8.Actividad2;

public class Actividad2 {

    public static void ejecutarFloydWarshall(int[][] grafo) {
        int n = grafo.length;
        int[][] distancias = new int[n][n];

        // Inicializar matriz de distancias
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distancias[i][j] = grafo[i][j];
            }
        }

        // Aplicar Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancias[i][k] != Integer.MAX_VALUE &&
                            distancias[k][j] != Integer.MAX_VALUE &&
                            distancias[i][j] > distancias[i][k] + distancias[k][j]) {

                        distancias[i][j] = distancias[i][k] + distancias[k][j];
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
            System.out.println("Cuidado, existen ciclos negativos en el grafo");
        } else {
            // Mostrar tiempos mínimos desde el centro principal (nodo 0)
            System.out.println("Tiempos mínimos desde el centro principal (0):");
            for (int j = 0; j < n; j++) {
                if (distancias[0][j] == Integer.MAX_VALUE) {
                    System.out.println("Hacia centro " + j + ": No alcanzable");
                } else {
                    System.out.println("Hacia centro " + j + ": " + distancias[0][j] + " minutos");
                }
            }
        }
    }
}