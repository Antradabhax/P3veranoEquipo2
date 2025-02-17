package clase13;

import clase13.Actividad2.Graph;
import clase13.Actividad2.UCS;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ciudad origen: ");
        String start = scanner.nextLine().trim();
        System.out.print("Ingrese ciudad destino: ");
        String end = scanner.nextLine().trim();

        Graph graph = buildGraph();

        UCS.Result result = UCS.findCheapestPath(graph, start, end);

        if (result != null) {
            System.out.println("Costo mínimo: " + result.cost);
            System.out.println("Itinerario: " + String.join(" -> ", result.path));
        } else {
            System.out.println("No hay ruta disponible entre " + start + " y " + end);
        }
    }

    private static Graph buildGraph() {
        Graph graph = new Graph();
        // Ejemplo de rutas
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 15);
        graph.addEdge("B", "D", 12);
        graph.addEdge("B", "F", 15);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);
        graph.addEdge("D", "F", 1);
        graph.addEdge("F", "E", 5);
        return graph;
    }
}