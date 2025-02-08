public class Clase8_Act1 {

    public static void main(String[] args) {
        Grafo g = new Grafo(4);

        g.agregarArista(1, 2, 2);
        g.agregarArista(2, 4, 4);
        g.agregarArista(1, 4, 5);
        g.agregarArista(4, 3, 2);

        g.floydWarshall();
    }
}

class Grafo {
    int[][] grafo;
    int numVertices;
    final int INF = 99999;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        grafo = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    grafo[i][j] = 0;
                } else {
                    grafo[i][j] = INF;
                }
            }
        }
    }

    public void agregarArista(int v1, int v2, int peso) {
        grafo[v1-1][v2-1] = peso;
    }

    public void verificarArista(int v1, int v2) {
        if (grafo[v1][v2] != 0) {
            System.out.println("La arista existe");
        }
        else {
            System.out.println("La arista no existe");
        }

    }

    public void eliminarArista(int v1, int v2) {
        grafo[v1][v2] = 0;
    }

    public void listarAdyacentes(int v) {
        for (int i = 0; i < numVertices; i++) {
            if (grafo[v][i] != 0) {
                System.out.print(i + " ");
            }
        }
    }

    public void gradoEntrada(int v) {
        int grado = 0;

        for (int i = 0; i < numVertices; i++) {
            if (grafo[i][v] > 0) {
                grado++;
            }
        }
        System.out.println("El grado de entrada del vértice " + v + " es: " + grado);
    }

    public void gradoSalida(int v) {
        int grado = 0;

        for (int i = 0; i < numVertices; i++) {
            if (grafo[v][i] > 0) {
                grado++;
            }
        }
        System.out.println("El grado de salida del vértice " + v + " es: " + grado);
    }



    public void mostrarGrafo() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(grafo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void floydWarshall() {
        int[][] dist = new int[numVertices][numVertices];

        //inicializamos la matriz de distancias con los valores actuales del grafo
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                dist[i][j] = grafo[i][j];
            }
        }

        //algoritmo de Floyd-Warshall
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }


        //mostramos la matriz de distancias más cortas
        System.out.println("Matriz de distancias mínimas:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                }
                else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}