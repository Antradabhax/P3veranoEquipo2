package clase5.Actividad2;

import java.util.Arrays;
import java.util.Scanner;

public class Actividad2 {
    public void resolver() {
        Scanner sc = new Scanner(System.in);

        // 1. Lectura de datos
        System.out.println("Ingrese el monto a pagar:");
        int monto = sc.nextInt();

        System.out.println("Ingrese la cantidad de tipos de comprobantes:");
        int n = sc.nextInt();

        int[] comprobantes = new int[n];
        System.out.println("Ingrese los valores de cada comprobante (uno por línea):");
        for (int i = 0; i < n; i++) {
            comprobantes[i] = sc.nextInt();
        }

        // 2. Ordenar los comprobantes en orden ascendente
        Arrays.sort(comprobantes);

        // 3. Aplicar el algoritmo Greedy para minimizar el número de comprobantes
        int totalUtilizados = 0;
        // Recorremos de mayor a menor
        for (int i = n - 1; i >= 0; i--) {
            if (comprobantes[i] <= monto) {
                // Cantidad de comprobantes de este tipo que podemos usar
                int cantidad = monto / comprobantes[i];
                totalUtilizados += cantidad;
                // Actualizar el monto restante
                monto = monto % comprobantes[i];
            }
        }

        // 4. Verificar si se pudo pagar el monto exacto
        if (monto != 0) {
            System.out.println("No se puede pagar exactamente con los comprobantes dados.");
        } else {
            System.out.println("Número mínimo de comprobantes utilizados: " + totalUtilizados);
        }

        sc.close();
    }
}
