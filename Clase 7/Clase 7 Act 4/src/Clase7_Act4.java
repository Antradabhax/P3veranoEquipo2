public class Clase7_Act4 {
    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        int maxGanancia = calcularMaxGanancia(costos, ganancias, presupuesto);
        System.out.println("La ganancia máxima que se puede obtener es: " + maxGanancia);
    }

    public static int calcularMaxGanancia(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        //llenamos la tabla DP
        for (int i = 1; i <= n; i++) {
            for (int b = 0; b <= presupuesto; b++) {
                //no se incluye el paquete i-1
                dp[i][b] = dp[i - 1][b];

                //incluimos el paquete siempre y cuando entre dentro del presupuesto
                if (costos[i - 1] <= b) {
                    dp[i][b] = Math.max(dp[i][b], ganancias[i - 1] + dp[i - 1][b - costos[i - 1]]);
                }
            }
        }
        return dp[n][presupuesto];
    }
}