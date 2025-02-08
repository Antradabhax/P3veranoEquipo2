import java.util.Scanner;
public class Clase1_Act3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese dos numeros enteros");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        System.out.println("Que desea realizar?");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println(n1 + n2);
                break;
            case 2:
                System.out.println(n1 - n2);
                break;
            case 3:
                System.out.println(n1 * n2);
                break;
            case 4:
                System.out.println(n1 / n2);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}