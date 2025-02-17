package clase13.Actividad2;

import java.util.*;

public class UCS {
    public static Result findCheapestPath(Graph graph, String start, String end) {
        PriorityQueue<PathNode> queue = new PriorityQueue<>();
        Map<String, Integer> costSoFar = new HashMap<>();

        PathNode startNode = new PathNode(start, 0, new ArrayList<>());
        queue.add(startNode);
        costSoFar.put(start, 0);

        while (!queue.isEmpty()) {
            PathNode currentNode = queue.poll();

            if (currentNode.currentCity.equals(end)) {
                return new Result(currentNode.cost, currentNode.path);
            }

            if (currentNode.cost > costSoFar.get(currentNode.currentCity)) {
                continue;
            }

            for (Graph.Edge edge : graph.getEdges(currentNode.currentCity)) {
                String neighbor = edge.destination;
                int newCost = currentNode.cost + edge.cost;

                if (!costSoFar.containsKey(neighbor) || newCost < costSoFar.get(neighbor)) {
                    costSoFar.put(neighbor, newCost);
                    PathNode neighborNode = new PathNode(neighbor, newCost, currentNode.path);
                    queue.add(neighborNode);
                }
            }
        }

        return null;
    }

    public static class Result {
        public final int cost;
        public final List<String> path;

        public Result(int cost, List<String> path) {
            this.cost = cost;
            this.path = path;
        }
    }

    private static class PathNode implements Comparable<PathNode> {
        String currentCity;
        int cost;
        List<String> path;

        PathNode(String currentCity, int cost, List<String> path) {
            this.currentCity = currentCity;
            this.cost = cost;
            this.path = new ArrayList<>(path);
            this.path.add(currentCity);
        }

        @Override
        public int compareTo(PathNode other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}