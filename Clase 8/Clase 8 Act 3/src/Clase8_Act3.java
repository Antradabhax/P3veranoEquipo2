import java.util.Scanner;

public class Clase8_Act3 {
    final static int INF = 99999;  //usamos un valor grande para representar el infinito

    public static void main(String[] args) {
        Clase8_Act3 fw = new Clase8_Act3();
        int graph[][] = {
                {0, 8, 5},
                {3, 0, INF},
                {INF, 2, 0}
        };
        int V = graph.length;
        fw.floydWarshall(graph, V);

        //se piden los vértices de origen y destino
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el vértice de origen (0 a " + (V-1) + "): ");
        int origen = sc.nextInt();
        if (origen < 0 || origen >= V) { //validacion del vertice ingresado
            System.out.println("El número debe estar entre 0 y " + (V-1));
            System.out.println("Vuelva a ingresar el vertice de origen: ");
            origen = sc.nextInt();
        }
        System.out.print("Ingrese el vértice de destino (0 a " + (V-1) + "): ");
        int destino = sc.nextInt();
        if (destino < 0 || destino >= V) { //validacion del vertice ingresado
            System.out.println("El numero debe estar entre 0 y " + (V-1));
            System.out.println("Vuelva a ingresar el vertice de destino: ");
            destino = sc.nextInt();
        }

        //imprimimos el camino más corto entre el origen y el destino
        System.out.print("El camino más corto desde " + origen + " hasta " + destino + " es: ");
        fw.imprimirCamino(origen, destino);
        sc.close();
    }

    //variables de instancia para la matriz de distancias y la matriz de recuperación de caminos
    int[][] dist;
    int[][] P; //matriz de recuperación de caminos

    //algortimo de Floyd-Warshall
    void floydWarshall(int graph[][], int V) {
        dist = new int[V][V];
        P = new int[V][V]; //se inicializa la matriz P

        //se inicializan las matrices de distancias y recuperación de caminos
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i != j && graph[i][j] != INF) {
                    P[i][j] = i; //si hay un camino directo entre i y j, el antecesor es i
                } else {
                    P[i][j] = -1; //si no hay camino, se inicializa como -1
                }
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        P[i][j] = P[k][j]; // Guardamos el vértice intermedio que permitió reducir la distancia
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);
    }

    // Función para imprimir el camino más corto usando la matriz P
    void imprimirCamino(int origen, int destino) {
        if (P[origen][destino] == -1) {
            System.out.println("No hay camino entre " + origen + " y " + destino);
            return;
        }
        imprimirCaminoRecursivo(origen, destino);
        System.out.println(destino); // Finalmente imprimimos el destino
    }

    // Método recursivo para reconstruir el camino desde origen hasta destino
    void imprimirCaminoRecursivo(int origen, int destino) {
        if (P[origen][destino] == origen) {
            System.out.print(origen + " -> ");
            return;
        }
        imprimirCaminoRecursivo(origen, P[origen][destino]);
        System.out.print(P[origen][destino] + " -> ");
    }

    // Función para imprimir la matriz de distancias
    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}