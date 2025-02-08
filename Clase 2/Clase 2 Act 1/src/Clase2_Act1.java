public class Clase2_Act1 {
    public static void main(String[] args) {
        int[][] mat = {{4,5,6}, {7,8,9}, {5,6,7}}; //1
        PromMat(mat);
    }

    static void PromMat(int[][] mat) {
        int suma = 0; //1
        int nums = 0; //1

        for (int i = 0; i < mat.length; i++) { //1 + n + 2n = 3n + 1
            for (int j = 0; j < mat[i].length; j++) { //3n + 1
                suma += mat[i][j]; //3n
                nums++; //2n
            }
        }

        int prom = suma / nums;
        System.out.print(prom);
    }
}

//f(n) = 1 + 1 + 3n + 1 + n (3n + 1 + 3n + 2n)
//f(n) = 8n^2 + 5n + 8

//8n^2 + 5n + 8/n^2 <= c n^2
//8 + 5/n + 8/n^2 <= c

//n = 1
//8 + 5 + 8 <= 21

//f(n) = 8n^2 + 5n + 8 pertenece a O(n^2) para c = 21 y n0 = 1