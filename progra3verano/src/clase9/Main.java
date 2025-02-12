package clase9;

import clase9.Actividad1.Actividad1;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String apiKey = "LXH1PS3EG4SOCRT0";
            String symbol = "IBM";
            int K = 2;

            List<Double> prices = Actividad1.fetchPrices(symbol, apiKey);
            if (prices.isEmpty()) {
                System.out.println("No se encontraron precios para el símbolo proporcionado.");
                return;
            }

            double maxProfit = Actividad1.maxProfit(K, prices);
            System.out.printf("La ganancia máxima con %d transacciones es: %.2f%n", K, maxProfit);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}