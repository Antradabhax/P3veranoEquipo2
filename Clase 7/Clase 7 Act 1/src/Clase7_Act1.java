public class Clase7_Act1 {
    public static void main(String[] args) {
        int[] pesos = {2, 3, 4, 5};   //pesos de los objetos
        int[] valores = {3, 4, 5, 6}; //valores de los objetos

        Mochila mochila = new Mochila(pesos, valores, 6);
        int valorMaximo = mochila.llenarMochila();
        System.out.println("Valor máximo: " + valorMaximo);
    }
}
class Mochila {
    int[] pesos;
    int[] valores;
    int capacidad;
    public Mochila(int[] pesos, int[] valores, int capacidad) {
        this.pesos = pesos;
        this.valores = valores;
        this.capacidad = capacidad;
    }

    public int llenarMochila() {
        int n = pesos.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                if (pesos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], valores[i - 1] + dp[i - 1][j - pesos[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacidad];
    }
}