import java.util.Arrays;
import java.util.Scanner;

public class Clase5_Act4 {
    public static void main(String[] args) {
        Clase5_Act4 a = new Clase5_Act4();
        a.solve();
    }
    public void solve() {
        Scanner in = new Scanner(System.in);

        //se pide la cantidad de flores y amigos
        System.out.println("Ingrese la cantidad de flores y la cantidad de amigos (n k, escribirlos con un espacio en el medio):");
        int n = in.nextInt();
        int k = in.nextInt();

        //se piden los costos de cada flor
        System.out.println("Ingrese los costos de las " + n + " flores (ingrese un valor por cada flor, separado de un espacio):");
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = in.nextInt();
        }

        //ordenamos el arreglo de costos de forma ascendente para luego procesar de las más caras a las más baratas
        Arrays.sort(costs);
        long totalCost = 0;

        //recorremos el arreglo desde el final (flores más caras primero)
        for (int i = 0; i < n; i++) {
            int multiplier = i / k; //calculamos cuántas veces ya se ha comprado una flor por ese amigo
            totalCost += (long)(multiplier + 1) * costs[n - 1 - i];
        }

        System.out.println("Costo total: " + totalCost);
        in.close();
    }
}