package clase4.Actividad4;

import java.util.Arrays;

public class Actividad4 {

    /**
     * Actividad 4 Clase 4: Encuentra los n elementos más grandes de un arreglo 'arr' usando divide y conquer.
     * @param arr Arreglo de enteros
     * @param n   Cantidad de elementos más grandes que se desean
     * @return    Arreglo de tamaño n con los elementos más grandes
     */
    public static int[] encontrarNMasGrandes(int[] arr, int n) {
        // Caso base: si el arreglo tiene n o menos elementos, se devuelven todos
        if (arr.length <= n) {
            // Retornamos una copia para no modificar el original
            return arr.clone();
        }

        // Dividir el arreglo en dos partes
        int mid = arr.length / 2;
        int[] izquierda = new int[mid];
        int[] derecha = new int[arr.length - mid];

        // Copiar datos a los subarreglos
        System.arraycopy(arr, 0, izquierda, 0, mid);
        System.arraycopy(arr, mid, derecha, 0, arr.length - mid);

        // Llamadas recursivas para encontrar los n más grandes en cada mitad
        int[] topIzquierda = encontrarNMasGrandes(izquierda, n);
        int[] topDerecha   = encontrarNMasGrandes(derecha, n);

        // Combinar resultados parciales
        int[] combinado = new int[topIzquierda.length + topDerecha.length];
        System.arraycopy(topIzquierda, 0, combinado, 0, topIzquierda.length);
        System.arraycopy(topDerecha, 0, combinado, topIzquierda.length, topDerecha.length);

        // Ordenar el arreglo combinado (ascendente, por defecto en Java)
        Arrays.sort(combinado);

        // Los n más grandes estarán al final si está ordenado ascendente
        int start = Math.max(0, combinado.length - n);
        int[] resultado = new int[n];
        for (int i = start; i < combinado.length; i++) {
            resultado[i - start] = combinado[i];
        }

        return resultado;
    }
}
