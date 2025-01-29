package clase2;

public class Actividad2 {
    public void multiplicarMatCuadrada(int[][] mat1, int[][] mat2) {
        // fila * columna
        int n = mat1.length;
        int[][] matriz_resultante = new int[n][n];
        int sumatoria = 0;
        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++) {
                for (int z = 0; z < n; z++) {
                    sumatoria += mat1[x][z] * mat2[z][y];
                }
                matriz_resultante[x][y] = sumatoria;
                sumatoria = 0;
            }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print(matriz_resultante[x][y] + " ");
            }
            System.out.print("\n");
        }
    }
}
