import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Desarrolla una aplicación que permita modelar una red de almacenes interconectados.
El sistema debe permitir agregar almacenes, conectar almacenes entre sí mediante rutas directas,
y realizar recorridos en profundidad (DFS) y en anchura (BFS) para explorar la red de distribución.
Implementa una clase Almacen que represente un almacén. Cada almacén debe tener un identificador único y un nombre.
Implementa una clase Grafo que gestione la red de almacenes. Esta clase debe:
    Permitir agregar almacenes al grafo.
    Permitir conectar almacenes entre sí (crear rutas directas entre almacenes).
    Implementar un metodo DFS para realizar un recorrido en profundidad desde un almacén de inicio.
    Implementar un metodo BFS para realizar un recorrido en anchura desde un almacén de inicio.
El grafo debe estar representado utilizando una lista de adyacencia.
*/
public class Clase12_Act3 {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        redAlmacenes.agregarAlmacen(1, "Chevrolet");
        redAlmacenes.agregarAlmacen(2, "Fiat");
        redAlmacenes.agregarAlmacen(3, "Porsche");
        redAlmacenes.agregarAlmacen(4, "VolksWagen");
        redAlmacenes.agregarAlmacen(5, "Toyota");
        redAlmacenes.agregarAlmacen(6, "Nissan");
        redAlmacenes.agregarAlmacen(7, "Hyundai");

        redAlmacenes.agregarRuta(1, 2);
        redAlmacenes.agregarRuta(1, 3);
        redAlmacenes.agregarRuta(2, 4);
        redAlmacenes.agregarRuta(2, 7);
        redAlmacenes.agregarRuta(3, 6);
        redAlmacenes.agregarRuta(3, 5);
        redAlmacenes.agregarRuta(5, 4);

        redAlmacenes.mostrarRutas();
        System.out.println();
        redAlmacenes.listarAlmacenes();
        System.out.println();
        DFS(redAlmacenes, 1);
        System.out.println();
        BFS(redAlmacenes, 5);
    }
    private static void DFS(Grafo grafo, int idOrigen) {
        List<Integer> visitados = new ArrayList<>();
        List<Integer> noVisitados = new ArrayList<>();

        System.out.println("DFS desde " + grafo.almacenes.get(idOrigen-1).nombre + ": ");
        DFS_Recursivo(grafo, idOrigen, visitados);
        System.out.println(visitados);
    }

    private static void DFS_Recursivo(Grafo grafo, int nodo, List<Integer> visitados) {
        visitados.add(nodo);

        for(int i = 0; i < grafo.rutas.get(nodo-1).size(); i++) {
            if(!visitados.contains(grafo.rutas.get(nodo-1).get(i))) {
                DFS_Recursivo(grafo, grafo.rutas.get(nodo-1).get(i), visitados);
            }
        }
    }

    private static void BFS(Grafo grafo, int idOrigen) {
        Queue<Integer> cola = new LinkedList<>();
        Queue<Integer> visitados = new LinkedList<>();

        cola.add(idOrigen);
        visitados.add(idOrigen);

        System.out.println("BFS desde " + grafo.almacenes.get(idOrigen-1).nombre + ": ");

        while(!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.print(grafo.almacenes.get(nodo-1).nombre + " ");

            for(int vecino : grafo.rutas.get(nodo-1)) {
                if(!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }
}

class Almacen {
    int id;
    String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}

class Grafo {
    List<Almacen> almacenes;
    List<List<Integer>> rutas;

    public Grafo() {
        almacenes = new ArrayList<>();
        rutas = new ArrayList<>();
    }

    public void agregarAlmacen(int id, String nombre) {
        almacenes.add(new Almacen(id, nombre));
        rutas.add(new ArrayList<>());
    }

    public void agregarRuta(int idOrigen, int idDestino) {
        rutas.get(idOrigen-1).add(idDestino);
        rutas.get(idDestino-1).add(idOrigen);
    }

    public void mostrarRutas() {
        for (int i = 0; i < rutas.size(); i++) {
            System.out.println(almacenes.get(i).nombre + " -> "  + rutas.get(i));
        }
    }

    public void listarAlmacenes() {
        for (int i = 0; i < almacenes.size(); i++) {
            System.out.println("Almacen " + (i + 1) + ": " + almacenes.get(i).nombre);
        }
    }
}

