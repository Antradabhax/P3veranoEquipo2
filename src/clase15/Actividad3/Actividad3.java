package clase15.Actividad3;

import java.util.ArrayList;
import java.util.List;

public class Actividad3 {

    public static List<Integer> planificarRecorrido(List<Integer> sucursales, int dineroInicial) {
        // Clonamos la lista de sucursales para no modificar la original
        List<Integer> pendientes = new ArrayList<>(sucursales);
        List<Integer> recorrido = new ArrayList<>();

        int dineroActual = dineroInicial;

        // Mientras haya sucursales pendientes
        while (!pendientes.isEmpty()) {
            // Buscar las sucursales factibles (que no lleven a dinero < 0)
            List<Integer> factibles = new ArrayList<>();
            for (Integer sucursal : pendientes) {
                if (dineroActual + sucursal >= 0) {
                    factibles.add(sucursal);
                }
            }

            // Si no hay sucursales factibles, se rompe el bucle
            if (factibles.isEmpty()) {
                System.out.println("No se puede continuar. No hay sucursales factibles para visitar.");
                break;
            }

            // Elegir la sucursal con el monto más alto dentro de las factibles
            // (en caso de varios montos iguales, tomará la primera que encuentre).
            int mejorSucursal = factibles.get(0);
            for (Integer sucursal : factibles) {
                if (sucursal > mejorSucursal) {
                    mejorSucursal = sucursal;
                }
            }

            // Visitar esa sucursal (sumar o restar el monto)
            dineroActual += mejorSucursal;
            recorrido.add(mejorSucursal);

            // Quitarla de la lista de pendientes
            pendientes.remove(Integer.valueOf(mejorSucursal));
        }

        return recorrido;
    }
}
