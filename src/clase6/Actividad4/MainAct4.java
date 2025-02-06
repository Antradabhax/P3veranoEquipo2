package clase6.Actividad4;

public class MainAct4 {
    public static void main(String[] args) {
        // Crear grafo con 5 centros (0: Centro principal)
        Actividad4 grafo = new Actividad4(5);

        // Agregar carreteras (origen, destino, tiempo en minutos)
        grafo.agregarCarretera(0, 1, 4);  // 0 -> 1 (4 min)
        grafo.agregarCarretera(0, 2, 2);  // 0 -> 2 (2 min)
        grafo.agregarCarretera(1, 3, 5);  // 1 -> 3 (5 min)
        grafo.agregarCarretera(2, 1, 1);  // 2 -> 1 (1 min)
        grafo.agregarCarretera(2, 3, 8);  // 2 -> 3 (8 min)
        grafo.agregarCarretera(2, 4, 10); // 2 -> 4 (10 min)
        grafo.agregarCarretera(3, 4, 2);  // 3 -> 4 (2 min)

        // Calcular tiempos mínimos desde el centro principal (0)
        int[] tiempos = grafo.dijkstra(0);

        // Mostrar resultados
        System.out.println("Tiempos mínimos desde el centro principal (0):");
        for (int i = 0; i < tiempos.length; i++) {
            System.out.printf("Centro %d: %d minutos\n", i, tiempos[i]);
        }
    }
}