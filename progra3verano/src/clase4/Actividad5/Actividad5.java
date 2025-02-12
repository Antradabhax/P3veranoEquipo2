package clase4.Actividad5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que contiene la lógica para encontrar los mejores (menores) tiempos
 * por categoría usando la técnica de Divide y Vencerás.
 */
public class Actividad5 {

    /**
     * Clase interna para representar a un corredor.
     */
    public static class Corredor {
        private String nombre;
        private String categoria;
        private double tiempo; // se asume que es en segundos

        public Corredor(String nombre, String categoria, double tiempo) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.tiempo = tiempo;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCategoria() {
            return categoria;
        }

        public double getTiempo() {
            return tiempo;
        }
    }

    /**
     * Encuentra los mejores tiempos (mínimos) por categoría en una lista de corredores,
     * utilizando la técnica de Divide y Vencerás.
     *
     * @param corredores Lista de corredores
     * @return Un mapa de la forma: categoria -> Corredor (con el mejor tiempo)
     */
    public static Map<String, Corredor> encontrarMejoresTiemposPorCategoria(List<Corredor> corredores) {
        // Caso base: si solo hay un corredor, devolver un mapa con su categoría
        if (corredores.size() == 1) {
            Map<String, Corredor> mapaBase = new HashMap<>();
            Corredor c = corredores.get(0);
            mapaBase.put(c.getCategoria(), c);
            return mapaBase;
        }
        // Caso base 2: si la lista está vacía, devolver un mapa vacío
        if (corredores.isEmpty()) {
            return new HashMap<>();
        }

        // Dividir la lista en dos partes
        int mid = corredores.size() / 2;
        List<Corredor> izquierda = corredores.subList(0, mid);
        List<Corredor> derecha = corredores.subList(mid, corredores.size());

        // Llamadas recursivas
        Map<String, Corredor> mapaIzq = encontrarMejoresTiemposPorCategoria(izquierda);
        Map<String, Corredor> mapaDer = encontrarMejoresTiemposPorCategoria(derecha);

        // Combinar resultados
        return combinarMapas(mapaIzq, mapaDer);
    }

    /**
     * Combina dos mapas de la forma categoria -> Corredor,
     * eligiendo siempre el corredor con el menor tiempo por categoría.
     *
     * @param mapaIzq Mapa parcial izquierdo
     * @param mapaDer Mapa parcial derecho
     * @return Mapa combinado con los mejores (menores) tiempos por categoría
     */
    private static Map<String, Corredor> combinarMapas(Map<String, Corredor> mapaIzq,
                                                       Map<String, Corredor> mapaDer) {
        Map<String, Corredor> mapaCombinado = new HashMap<>();

        // Primero copiamos todas las categorías del mapaIzq
        for (String categoria : mapaIzq.keySet()) {
            mapaCombinado.put(categoria, mapaIzq.get(categoria));
        }

        // Ahora, para cada categoría del mapaDer, comparamos (si ya existe) o agregamos (si no existe)
        for (String categoria : mapaDer.keySet()) {
            Corredor corredorDer = mapaDer.get(categoria);
            if (mapaCombinado.containsKey(categoria)) {
                // Comparar tiempos
                Corredor corredorIzq = mapaCombinado.get(categoria);
                if (corredorDer.getTiempo() < corredorIzq.getTiempo()) {
                    mapaCombinado.put(categoria, corredorDer);
                }
            } else {
                // No existe la categoría en el mapaCombinado, se agrega
                mapaCombinado.put(categoria, corredorDer);
            }
        }

        return mapaCombinado;
    }
}
