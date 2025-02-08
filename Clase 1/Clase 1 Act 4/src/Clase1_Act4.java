import java.util.Scanner;
public class Clase1_Act4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero entero: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " es par");
            }
            else {
                System.out.println(i + " es impar");
            }
        }
    }
}