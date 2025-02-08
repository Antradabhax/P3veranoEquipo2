public class Clase2_Act2 {
    public static void main(String[] args) {
        int[][] mat1 = {{1,2}, {3,4}};
        int[][] mat2 = {{5,6}, {7,8}};

        MultiplicarMats(mat1, mat2);
    }

    static void MultiplicarMats (int[][] mat1, int[][] mat2) {

        //verificamos si son multiplicables
        int filas1 = mat1.length;
        int columnas1 = mat1[0].length;
        int filas2 = mat2.length;
        int columnas2 = mat2[0].length;

        if (columnas1 != filas2) {
            System.out.println("No son multiplicables");
            return;
        }

        //matriz resultante
        int[][] mat3 = new int[filas1][columnas2];

        //multiplicamos las matrices
        for (int i = 0; i < filas1; i++) { //1 + n + 1 + 2n = 2 + 3n
            for (int j = 0; j < columnas2; j++) { //2 + 3n
                for (int k = 0; k < columnas1; k++) { //2 + 3n
                    mat3[i][j] += mat1[i][k] * mat2[k][j]; //3n
                }
            }
        }

        //2 + 3n + n * (2 + 3n + n * (2 + 3n + 3n))
        //2 + 3n + n * (2 + 3n + 2n + 3n^2 + 3n^2)
        //2 + 3n + 2n + 3n^2 + 2n^2 + 3n^3 + 3n^3
        //2 + 5n + 5n^2 + 6n^3
        //f(n) = 2 + 5n + 5n^2 + 6n^3

        //Demonstramos que pertenece a O(n^3)
        //2 + 5n + 5n^2 + 6n^3 <= c * n^3
        //2/n^3 + 5n/n^3 + 5 n^2/n^3 + 6n^3/n^3 <= c * n^3/n^3
        //2/n^3 + 5n/n^3 + 5n^2/n^3 + 6 <= c
        //n0 = 1
        //2 + 5 + 5 + 6 <= c
        //2 + 5 + 5 + 6 <= 18

        //f(n) = 2 + 5n + 5n^2 + 6n^3 pertenece a O(n^3) para c = 18 y n0= 1

        //imprimimos la matriz resultante
        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                System.out.print(mat3[i][j] + " ");
            }
            System.out.println();
        }
    }
}