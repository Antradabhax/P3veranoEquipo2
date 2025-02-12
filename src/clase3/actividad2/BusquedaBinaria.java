package clase3.actividad2;

public class BusquedaBinaria {
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        return busquedaBinariaRecursiva(arreglo, objetivo, 0, arreglo.length - 1);
    }

    private static int busquedaBinariaRecursiva(int[] arreglo, int objetivo, int izquierda, int derecha) {
        // Caso base: si los límites se cruzan, el elemento no está en el arreglo
        if (izquierda > derecha) {
            return -1;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        // Si el objetivo está en el medio, devolver el índice
        if (arreglo[medio] == objetivo) {
            return medio;
        }

        // Si el objetivo es menor, buscar en la mitad izquierda
        if (arreglo[medio] > objetivo) {
            return busquedaBinariaRecursiva(arreglo, objetivo, izquierda, medio - 1);
        }

        // Si el objetivo es mayor, buscar en la mitad derecha
        return busquedaBinariaRecursiva(arreglo, objetivo, medio + 1, derecha);
    }

    public static void main(String[] args) {
        System.out.println("Actividad 2:");
        int[] arreglo = {2, 5, 7, 9, 11, 21, 23};
        int objetivo = 17;
        int resultado = busquedaBinaria(arreglo, objetivo);
        System.out.println("Índice del objetivo: " + resultado);
    }
}
