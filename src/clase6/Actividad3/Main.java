package clase6.Actividad3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo redElectrica = new Grafo(4);

        redElectrica.agregarArista(0, 1, 5);
        redElectrica.agregarArista(0, 2, 10);
        redElectrica.agregarArista(1, 3, 8);
        redElectrica.agregarArista(2, 3, 15);
        redElectrica.agregarArista(1, 2, 4);
        redElectrica.imprimirGrafo();
        System.out.println("\n-------------------");
        // Corregir: Usar tipo explícito en lugar de 'var'
        List<Grafo.Arista> mst = redElectrica.primMST();

        System.out.println("Conexiones óptimas:");
        int costoTotal = 0;
        for (Grafo.Arista arista : mst) {
            // Mostrar origen y destino correctamente
            System.out.printf("%d - %d (Costo: %d)\n",
                    arista.origen,
                    arista.destino,
                    arista.peso);
            costoTotal += arista.peso;
        }
        System.out.println("\nCosto total: " + costoTotal);
    }
}