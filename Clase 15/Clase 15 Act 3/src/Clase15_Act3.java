import java.util.ArrayList;
import java.util.List;

public class Clase15_Act3 {

    public static List<Integer> planificarRecorrido(List<Integer> sucursales, int dineroInicial) {
        //clonamos la lista de sucursales para no modificar la original
        List<Integer> pendientes = new ArrayList<>(sucursales);
        List<Integer> recorrido = new ArrayList<>();

        int dineroActual = dineroInicial;

        //mientras haya sucursales pendientes
        while (!pendientes.isEmpty()) {
            //buscamos las sucursales factibles (que no nos dejen en dinero < 0)
            List<Integer> factibles = new ArrayList<>();
            for (Integer sucursal : pendientes) {
                if (dineroActual + sucursal >= 0) {
                    factibles.add(sucursal);
                }
            }

            //si no hay sucursales factibles, se rompe el bucle
            if (factibles.isEmpty()) {
                System.out.println("No se puede continuar. No hay sucursales factibles para visitar.");
                break;
            }

            //elegimos la sucursal con el monto más alto dentro de las factibles
            //(en caso de varios montos iguales, tomará la primera que encuentre).
            int mejorSucursal = factibles.get(0);
            for (Integer sucursal : factibles) {
                if (sucursal > mejorSucursal) {
                    mejorSucursal = sucursal;
                }
            }

            //se visita esa sucursal (se suma o resta el monto)
            dineroActual += mejorSucursal;
            recorrido.add(mejorSucursal);

            //quitamos la sucursal visitada de la lista de pendientes
            pendientes.remove(Integer.valueOf(mejorSucursal));
        }

        return recorrido;
    }
}