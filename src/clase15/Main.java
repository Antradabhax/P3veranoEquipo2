package clase15;

import clase15.Actividad3.Actividad3;
import clase15.Actividad4.Actividad4;
import clase15.Actividad4.Nodo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ejecución de la Actividad 3 desde el paquete clase15.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("------------");
        System.out.println("Actividad 3:");
        // Ejemplo de montos en las sucursales (positivos = cobros, negativos = pagos)
        List<Integer> sucursales = Arrays.asList(+500, -100, +200, -50, +100, -300, +400);

        // Dinero inicial del cobrador
        int dineroInicial = 100;

        // Llamamos al método del algoritmo
        List<Integer> recorrido = Actividad3.planificarRecorrido(sucursales, dineroInicial);

        // Mostramos el resultado
        System.out.println("Recorrido planificado: " + recorrido);
        System.out.println("Número de sucursales visitadas: " + recorrido.size());

        double saldoInicial = 10.0;
        List<Nodo> nodos = new ArrayList<>();

        // Agregamos nodos de ejemplo
        nodos.add(new Nodo(5.0, 2.0));   // Cobro
        nodos.add(new Nodo(-3.0, 1.5));  // Pago
        nodos.add(new Nodo(4.0, 3.0));   // Cobro
        nodos.add(new Nodo(-2.0, 2.0));  // Pago

        double saldoFinal = Actividad4.calcularMaximoSaldoDolares(saldoInicial, nodos);
        System.out.println("------------");
        System.out.println("Actividad 4:");
        System.out.println("Saldo final en dólares: " + saldoFinal);
        System.out.println("------------");
    }
}
