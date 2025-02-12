package clase9.Actividad1;

import com.google.gson.*;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Actividad1 {

    public static double maxProfit(int K, List<Double> prices) {
        int n = prices.size();
        if (n <= 1 || K == 0) return 0.0;

        // Si K es mayor o igual a n/2, se realizan todas las transacciones posibles
        if (K >= n / 2) {
            double maxProfit = 0.0;
            for (int i = 1; i < n; i++) {
                if (prices.get(i) > prices.get(i - 1)) {
                    maxProfit += prices.get(i) - prices.get(i - 1);
                }
            }
            return maxProfit;
        }

        // Tabla DP para almacenar los beneficios máximos
        double[][] dp = new double[K + 1][n];

        for (int k = 1; k <= K; k++) {
            double maxDiff = -prices.get(0);
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices.get(i) + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k - 1][i] - prices.get(i));
            }
        }

        return dp[K][n - 1];
    }

    public static List<Double> fetchPrices(String symbol, String apiKey) throws IOException {
        String urlString = String.format(
                "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=%s",
                symbol, apiKey
        );
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(response.toString()).getAsJsonObject();

        // Verificar si hay un error en la respuesta
        if (jsonResponse.has("Error Message")) {
            throw new IOException("Error en la respuesta de la API: " + jsonResponse.get("Error Message").getAsString());
        }

        JsonObject timeSeries = jsonResponse.getAsJsonObject("Time Series (Daily)");
        TreeMap<String, Double> sortedPrices = new TreeMap<>();

        for (Map.Entry<String, JsonElement> entry : timeSeries.entrySet()) {
            String date = entry.getKey();
            JsonObject dayData = entry.getValue().getAsJsonObject();
            double closePrice = dayData.get("4. close").getAsDouble();
            sortedPrices.put(date, closePrice);
        }

        return new ArrayList<>(sortedPrices.values());
    }
}