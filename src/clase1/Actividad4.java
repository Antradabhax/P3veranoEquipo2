package clase1;

import java.util.Scanner;

public class Actividad4 {
    public void ejecutarPrograma() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            for (int i = 1; i <= n; i++) {
                String tipo = (i % 2 == 0) ? "par" : "impar";
                System.out.println(i + " es " + tipo);
            }
        } else {
            System.out.println("Error: Debe ingresar un número entero válido.");
        }

        scanner.close();
    }
}
