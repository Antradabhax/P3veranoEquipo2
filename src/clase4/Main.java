package clase4;

import clase4.Actividad1.Actividad1;
import clase4.Actividad1.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ACTIVIDAD 1
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(1, "Pepe", 99));
        clientes.add(new Cliente(2, "Pedro", 11));
        clientes.add(new Cliente(3, "George", 120));
        clientes.add(new Cliente(4, "Floyd", 111));
        clientes.add(new Cliente(5, "Propylon", 76));
        clientes.add(new Cliente(6, "LinkAI", 29));
        clientes.add(new Cliente(7, "Jose", 38));
        clientes.add(new Cliente(8, "Alfredo", 65));

        Actividad1 actividad1 = new Actividad1();

        Cliente mejor = actividad1.mejorScoring(clientes, 0, clientes.size() - 1);
        System.out.println(mejor.getScoring());


        // ACTIVIDAD 2
        int[] numeros = {3, 7, 1, 9, 5, 8, 2};

        // Llamar al método de Actividad2 para encontrar los dos números mayores
        Actividad2 actividad2 = new Actividad2();
        int[] dosMayores = actividad2.encontrarDosMayores(numeros, 0, numeros.length - 1);

        // Imprimir los dos números mayores
        System.out.println("Los dos números mayores son: " + dosMayores[0] + " y " + dosMayores[1]);
    }
}
