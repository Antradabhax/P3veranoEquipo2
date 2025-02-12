import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        int primer_numero = input.nextInt();

        System.out.print("Ingrese el segundo numero: ");
        int segundo_numero = input.nextInt();

        System.out.print("Ingrese el numero de operacion que desea realizar: \n 1. Suma \n 2. Resta \n 3. Multiplicacion \n 4. Division \n");
        int numero_operacion = input.nextInt();

        double resultado;

        switch (numero_operacion) {
            case 1:
                resultado = primer_numero + segundo_numero;
                System.out.print(resultado);
                break;

            case 2:
                resultado = primer_numero - segundo_numero;
                System.out.print(resultado);
                break;

            case 3:
                resultado = primer_numero * segundo_numero;
                System.out.print(resultado);
                break;

            case 4:
                resultado = primer_numero / segundo_numero;
                System.out.print(resultado);
                break;
        }
    }
}
