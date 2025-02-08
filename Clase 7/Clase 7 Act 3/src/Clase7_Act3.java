public class Clase7_Act3 {
    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int maxBeneficio = calcularMaxBeneficio(costos, beneficios, presupuesto);
        System.out.println("El beneficio máximo que se puede obtener es: " + maxBeneficio);
    }

    public static int calcularMaxBeneficio(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        //llenamos la tabla DP
        for (int i = 1; i <= n; i++) {
            for (int b = 0; b <= presupuesto; b++) {
                //no se incluye el proyecto i-1
                dp[i][b] = dp[i - 1][b];

                //inluimos el proyecto si el presupuesto lo permite
                if (costos[i - 1] <= b) {
                    dp[i][b] = Math.max(dp[i][b], beneficios[i - 1] + dp[i - 1][b - costos[i - 1]]);
                }
            }
        }
        return dp[n][presupuesto];
    }
}

//complejidad: O(n**2) por el doble "for" dentro de la funcion "calcularMaxBeneficio"