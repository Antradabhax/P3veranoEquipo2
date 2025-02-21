import java.util.*;

public class Clase13_Act2 {
    public static void main(String[] args) {
        UCS ucs = new UCS();
        Scanner sc = new Scanner(System.in);

        ucs.agregarViaje("Paris", "Madrid", 6);
        ucs.agregarViaje("Madrid", "Barcelona", 2);
        ucs.agregarViaje("Buenos  Aires", "Washington", 10);
        ucs.agregarViaje("Buenos  Aires", "Montevideo", 2);
        ucs.agregarViaje("Madrid", "Sao Paulo", 5);
        ucs.agregarViaje("Sao Paulo", "Buenos  Aires", 2);
        ucs.agregarViaje("Barcelona", "Paris", 3);
        ucs.agregarViaje("Washington", "Madrid", 3);
        ucs.agregarViaje("Montevideo", "Paris", 3);

        //mostamos las ciudades disponibles
        System.out.println("Ciudades disponibles: ");
        System.out.println(ucs.toString());

        //solicitamos las ciudades a las que se quiere viajar
        System.out.println("Ingresa la ciudad de origen: ");
        String origen = sc.nextLine();
        System.out.println("Ingresa la ciudad de destino: ");
        String destino = sc.nextLine();

        //metodo para realizar la búsqueda UCS
        int cost = ucs.minimoCostoViaje(origen, destino);
        if (cost == -1) {
            System.out.println("No se encontraron viajes entre las dos ciudades");
        } else {
            System.out.println("El costo minimo desde " + origen + " hasta " + destino + " es: " + cost);
        }
    }
}

class Node {
    String name;
    int cost;

    public Node(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

class UCS {
    private final Map<String, List<Node>> graph = new HashMap<>();

    //agregamos conexiones al grafo
    public void agregarViaje(String from, String to, int cost) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Node(to, cost));
    }

    //metodo para realizar la búsqueda UCS
    public int minimoCostoViaje(String start, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        priorityQueue.add(new Node(start, 0));
        Set<String> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            //si alcanzamos el nodo objetivo, retornamos el costo
            if (current.name.equals(goal)) {
                return current.cost;
            }

            //si ya habiamos visitado este nodo, lo ignoramos
            if (visited.contains(current.name)) continue;
            visited.add(current.name);

            //exploramos los vecinos
            for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) {
                if (!visited.contains(neighbor.name)) {
                    priorityQueue.add(new Node(neighbor.name, current.cost + neighbor.cost));
                }
            }
        }

        return -1; //retornamos -1 si no se encuentra un camino
    }

    @Override
    public String toString() {
        return graph.keySet().toString();
    }
}
