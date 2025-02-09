package clase8;

import clase8.Actividad2.Actividad2;
import clase8.Actividad3.Actividad3;

public class Main {
    public static void main(String[] args) {
        //ACTIVIDAD 2
        System.out.println("-------------");
        System.out.println("Actividad 2: ");
        // Ejemplo de grafo (centro principal = 0)
        int INF = Integer.MAX_VALUE;
        int[][] grafo = {
                {0, 3, 6, 15},
                {INF, 0, -2, INF},
                {INF, INF, 0, 2},
                {INF, 1, INF, 0}
        };

        Actividad2.ejecutarFloydWarshall(grafo);
        System.out.println("-------------");

        //ACTIVIDAD 3
        System.out.println("-------------");
        System.out.println("Actividad 3: ");
        // Ejemplo de grafo (mismo grafo que el de la Actividad 2)
        int[][] grafo2 = {
                {0, 3, 6, 15},
                {INF, 0, -2, INF},
                {INF, INF, 0, 2},
                {INF, 1, INF, 0}
        };

        Actividad3.ejecutarFloydWarshallConRutas(grafo2);
    }
    }

