package clase7.actividad2;

public class Actividad2 {
    private static final int[] PESOS = {2, 5, 6, 7};
    private static final int[] VALORES = {4, 2, 1, 6};
    private static final int CAPACIDAD = 10;
    private static final int N = PESOS.length;

    public static int fuerzaBruta() {
        int valorMax = 0;
        int totalSubsets = 1 << N; // 2^N

        for (int subset = 0; subset < totalSubsets; subset++) {
            int pesoActual = 0;
            int valorActual = 0;
            for (int i = 0; i < N; i++) {
                if ((subset & (1 << i)) != 0) {
                    pesoActual += PESOS[i];
                    valorActual += VALORES[i];
                }
            }
            if (pesoActual <= CAPACIDAD && valorActual > valorMax) {
                valorMax = valorActual;
            }
        }
        return valorMax;
    }

    public static int programacionDinamica() {
        int[][] dp = new int[N + 1][CAPACIDAD + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= CAPACIDAD; j++) {
                int pesoActual = PESOS[i - 1];
                int valorActual = VALORES[i - 1];
                if (pesoActual > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - pesoActual] + valorActual);
                }
            }
        }
        return dp[N][CAPACIDAD];
    }
}