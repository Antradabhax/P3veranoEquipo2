package clase4.Actividad2;

public class Actividad2 {

    // Método para encontrar los dos números mayores en una lista
    public int[] encontrarDosMayores(int[] numeros, int inicio, int fin) {
        // Caso base: si hay dos elementos, retornarlos ordenados
        if (fin - inicio == 1) {
            if (numeros[inicio] > numeros[fin]) {
                return new int[]{numeros[inicio], numeros[fin]};
            } else {
                return new int[]{numeros[fin], numeros[inicio]};
            }
        }

        // Caso base: si hay un solo elemento, retornarlo dos veces
        if (inicio == fin) {
            return new int[]{numeros[inicio], numeros[inicio]};
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;

        // Conquistar: encontrar los dos mayores en cada mitad
        int[] mayoresIzquierda = encontrarDosMayores(numeros, inicio, medio);
        int[] mayoresDerecha = encontrarDosMayores(numeros, medio + 1, fin);

        // Combinar: encontrar los dos mayores entre los cuatro números
        return combinarMayores(mayoresIzquierda, mayoresDerecha);
    }

    // Método para combinar los dos mayores de cada mitad
    private static int[] combinarMayores(int[] mayoresIzquierda, int[] mayoresDerecha) {
        int[] mayores = new int[4];
        mayores[0] = mayoresIzquierda[0]; // Mayor de la izquierda
        mayores[1] = mayoresIzquierda[1]; // Segundo mayor de la izquierda
        mayores[2] = mayoresDerecha[0];   // Mayor de la derecha
        mayores[3] = mayoresDerecha[1];   // Segundo mayor de la derecha

        // Encontrar los dos mayores manualmente
        int primero = mayores[0];
        int segundo = mayores[1];

        for (int i = 2; i < 4; i++) {
            if (mayores[i] > primero) {
                segundo = primero;
                primero = mayores[i];
            } else if (mayores[i] > segundo) {
                segundo = mayores[i];
            }
        }

        // Retornar los dos mayores
        return new int[]{primero, segundo};
    }
}