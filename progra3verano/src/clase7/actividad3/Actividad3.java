package clase7.actividad3;

public class Actividad3 {
    public static int maxBeneficio(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            int costoActual = costos[i - 1];
            int beneficioActual = beneficios[i - 1];
            for (int j = 0; j <= presupuesto; j++) {
                if (costoActual > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costoActual] + beneficioActual);
                }
            }
        }
        return dp[n][presupuesto];
    }
}