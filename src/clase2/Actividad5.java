package clase2;

public class Actividad5 {

    // Método recursivo para sumar los primeros n números enteros
    public int sumarRecursivo(int n) {
        // Caso base: si n es 0, la suma es 0
        if (n == 0) {
            return 0;
        }
        // Caso recursivo: suma n + (n-1) + (n-2) + ... + 1
        return n + sumarRecursivo(n - 1);
    }

    // Método para ejecutar y mostrar el resultado
    public void ejecutar() {
        int n = 10; // Ejemplo: suma de los primeros 10 números
        System.out.println("La suma de los primeros " + n + " números enteros es: " + sumarRecursivo(n));
    }
}