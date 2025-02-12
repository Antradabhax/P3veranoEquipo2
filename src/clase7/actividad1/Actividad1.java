package clase7.actividad1;

import java.util.ArrayList;
import java.util.List;

public class Actividad1 {
    public int problemaMochila(int[] pesos, int[] valores, int capacidad) {
        int n = pesos.length;

        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (pesos[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i - 1][j - pesos[i - 1]] + valores[i - 1]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= n; i++){
            for(int j = 0; j<= capacidad; j++){
                System.out.print(dp[i][j] + " | ");
            }
            System.out.println();
        }
        return dp[n][capacidad];
    }
}
