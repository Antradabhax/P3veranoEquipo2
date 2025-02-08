public class Clase8_Act2 {
    static final int INF = 99999; //elegimos un valor muy grande para representar el infinito

    public static void main(String[] args) {
        int[][] grafo = {
                {  0,   3, INF,   7},
                {  8,   0,   2, INF},
                {  5, INF,   0,   1},
                {  2, INF, INF,   0}
        };

        floydWarshall(grafo);
    }

    public static void floydWarshall(int[][] grafo) {
        int n = grafo.length;
        int[][] dist = new int[n][n];

        //inicializamos la matriz de distancias con los valores del grafo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = grafo[i][j];
            }
        }

        //Floyd-Warshall
        for (int k = 0; k < n; k++) { //nodo intermedio
            for (int i = 0; i < n; i++) { //nodo de origen
                for (int j = 0; j < n; j++) { //nodo de destino
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        //verificamos los ciclos negativos
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Ciclo negativo encontrado, ahorro infinito");
                return;
            }
        }

        //imprimimos la matriz de distancias mínimas
        System.out.println("Matriz de tiempos mínimos entre centros de distribución:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}