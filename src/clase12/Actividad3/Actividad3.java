package clase12.Actividad3;

import java.util.*;

public class Actividad3 {
    public static void main(String[] args) {
        Almacen a1 = new Almacen(1, "Almacen 1");
        Almacen a2 = new Almacen(2, "Almacen 2");
        Almacen a3 = new Almacen(3, "Almacen 3");
        Almacen a4 = new Almacen(4, "Almacen 4");

        Grafo grafo = new Grafo();
        grafo.agregarAlmacen(a1);
        grafo.agregarAlmacen(a2);
        grafo.agregarAlmacen(a3);
        grafo.agregarAlmacen(a4);

        grafo.conectar(a1, a2);
        grafo.conectar(a1, a3);
        grafo.conectar(a2, a4);
        grafo.conectar(a3, a4);

        System.out.println("DFS desde Almacen 1:");
        List<Almacen> dfsResult = grafo.DFS(a1);
        for (Almacen almacen : dfsResult) {
            System.out.println(almacen.getNombre());
        }

        System.out.println("\nBFS desde Almacen 1:");
        List<Almacen> bfsResult = grafo.BFS(a1);
        for (Almacen almacen : bfsResult) {
            System.out.println(almacen.getNombre());
        }
    }
}

class Almacen {
    private int id;
    private String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Almacen almacen = (Almacen) o;
        return id == almacen.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Grafo {
    private Map<Almacen, List<Almacen>> adjList;

    public Grafo() {
        adjList = new HashMap<>();
    }

    public void agregarAlmacen(Almacen almacen) {
        adjList.putIfAbsent(almacen, new ArrayList<>());
    }

    public void conectar(Almacen a1, Almacen a2) {
        if (adjList.containsKey(a1) && adjList.containsKey(a2)) {
            adjList.get(a1).add(a2);
            adjList.get(a2).add(a1);
        }
    }

    public List<Almacen> DFS(Almacen inicio) {
        List<Almacen> resultado = new ArrayList<>();
        Set<Almacen> visitados = new HashSet<>();
        Stack<Almacen> pila = new Stack<>();

        if (adjList.containsKey(inicio)) {
            pila.push(inicio);
            visitados.add(inicio);

            while (!pila.isEmpty()) {
                Almacen actual = pila.pop();
                resultado.add(actual);

                for (Almacen vecino : adjList.get(actual)) {
                    if (!visitados.contains(vecino)) {
                        visitados.add(vecino);
                        pila.push(vecino);
                    }
                }
            }
        }
        return resultado;
    }

    public List<Almacen> BFS(Almacen inicio) {
        List<Almacen> resultado = new ArrayList<>();
        Set<Almacen> visitados = new HashSet<>();
        Queue<Almacen> cola = new LinkedList<>();

        if (adjList.containsKey(inicio)) {
            cola.offer(inicio);
            visitados.add(inicio);

            while (!cola.isEmpty()) {
                Almacen actual = cola.poll();
                resultado.add(actual);

                for (Almacen vecino : adjList.get(actual)) {
                    if (!visitados.contains(vecino)) {
                        visitados.add(vecino);
                        cola.offer(vecino);
                    }
                }
            }
        }
        return resultado;
    }
}