package clase2;

import java.math.BigInteger;

public class Actividad4 {

    // Método para calcular el factorial usando long
    public long factorialUsingLong(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Método para calcular el factorial usando BigInteger
    public BigInteger factorialUsingBigInteger(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Método para ejecutar y mostrar ambos cálculos
    public void ejecutar() {
        int smallNumber = 20; // Número pequeño para long
        int largeNumber = 100; // Número grande para BigInteger

        // Calcular y mostrar el factorial usando long
        System.out.println("Factorial de " + smallNumber + " usando long: " + factorialUsingLong(smallNumber));

        // Calcular y mostrar el factorial usando BigInteger
        System.out.println("Factorial de " + largeNumber + " usando BigInteger: " + factorialUsingBigInteger(largeNumber));
    }


}