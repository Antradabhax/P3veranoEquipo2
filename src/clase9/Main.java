package clase9;

import clase9.Actividad1.Actividad1;
import clase9.Actividad2.Actividad2;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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

        //ACTIVIDAD 2
        Scanner scanner = new Scanner(System.in);
        try {
            String apiKey = "LXH1PS3EG4SOCRT0";

            // Paso 1: Pedir símbolo de la acción
            System.out.print("Ingrese el símbolo de la acción (ej. IBM, AAPL): ");
            String symbol = scanner.nextLine().trim().toUpperCase();

            // Paso 2: Pedir número de transacciones
            System.out.print("Ingrese el número máximo de transacciones (K): ");
            int K = scanner.nextInt();

            List<Double> prices = Actividad2.fetchPrices(symbol, apiKey);
            if (prices.isEmpty()) {
                System.out.println("No se encontraron datos para el símbolo: " + symbol);
                return;
            }

            double maxProfit = Actividad2.maxProfit(K, prices);
            System.out.printf("\nGanancia máxima con %d transacciones en %s: $%.2f%n", K, symbol, maxProfit);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}