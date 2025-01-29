package clase2;

public class Actividad2 {

    // Método para multiplicar dos matrices cuadradas
    public int[][] multiplicarMatrices(int[][] A, int[][] B) {
        int n = A.length; // Tamaño de las matrices (n x n)
        int[][] C = new int[n][n]; // Matriz resultado

        // Multiplicación de matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0; // Inicializar el elemento C[i][j]
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    // Método para imprimir una matriz
    public void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    // Método para ejecutar y mostrar el resultado
    public void ejecutar() {
        // Ejemplo de matrices 3x3
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] B = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        // Multiplicar matrices
        int[][] C = multiplicarMatrices(A, B);

        // Mostrar resultado
        System.out.println("Matriz A:");
        imprimirMatriz(A);

        System.out.println("Matriz B:");
        imprimirMatriz(B);

        System.out.println("Matriz C (A x B):");
        imprimirMatriz(C);
    }


}