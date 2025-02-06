package clase6.Actividad2;

public class MainAct2 {
    public static void main(String[] args) {
        // Crear grafo con 4 nodos (0-3 representan los nodos 1-4 de la actividad)
        Actividad2 grafo = new Actividad2(4);

        // Agregar aristas según la actividad 1 (ajustando a índices 0-based)
        grafo.agregarArista(0, 1);  // 1 -> 2
        grafo.agregarArista(1, 3);  // 2 -> 4
        grafo.agregarArista(0, 3);  // 1 -> 4
        grafo.agregarArista(3, 2);  // 4 -> 3

        // Pruebas
        System.out.println("--- Pruebas del Grafo ---");
        System.out.println("Existe 1->2? " + grafo.verificarArista(0, 1)); // true
        System.out.println("Existe 3->1? " + grafo.verificarArista(2, 0)); // false

        System.out.println("\nAdyacentes del nodo 1 (0-based): " + grafo.listarAdyacentes(0)); // [1, 3]
        System.out.println("Adyacentes del nodo 4 (3): " + grafo.listarAdyacentes(3)); // [2]

        System.out.println("\nGrado de salida del nodo 1: " + grafo.gradoSalida(0)); // 2
        System.out.println("Grado de entrada del nodo 4: " + grafo.gradoEntrada(3)); // 2

        // Eliminar arista 2->4 (1->3 en 0-based) y verificar
        grafo.eliminarArista(1, 3);
        System.out.println("\nDespués de eliminar 2->4:");
        System.out.println("Existe 2->4? " + grafo.verificarArista(1, 3)); // false
        System.out.println("Grado de salida del nodo 2: " + grafo.gradoSalida(1)); // 0
    }
}