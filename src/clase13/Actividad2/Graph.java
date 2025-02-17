package clase13.Actividad2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(String source, String destination, int cost) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, cost));
    }

    public List<Edge> getEdges(String city) {
        return adjacencyList.getOrDefault(city, new ArrayList<>());
    }

    public static class Edge {
        public final String destination;
        public final int cost;

        public Edge(String destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }
}