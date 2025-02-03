package clase4;

import clase4.Actividad1.Actividad1;
import clase4.Actividad1.Cliente;
import clase4.Actividad2.Actividad2;
import clase4.Actividad3.Actividad3;
import clase4.Actividad4.Actividad4;
import clase4.Actividad5.Actividad5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // ACTIVIDAD 1
        System.out.println("------------");
        System.out.println("Actividad 1:");
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
        System.out.println("------------");
        System.out.println("\n");
        System.out.println("------------");
        System.out.println("Actividad 2:");
        System.out.println("Los dos números mayores son: " + dosMayores[0] + " y " + dosMayores[1]);

        
        //ACTIVIDAD 3
        System.out.println("------------");
        System.out.println("\n");
        System.out.println("------------");
        System.out.println("Actividad 3:");
        clase4.Actividad3.Cliente[] clientesAct3 = {
                new clase4.Actividad3.Cliente(1, "Cliente A", 85),
                new clase4.Actividad3.Cliente(2, "Cliente B", 90),
                new clase4.Actividad3.Cliente(3, "Cliente C", 78),
                new clase4.Actividad3.Cliente(4, "Cliente D", 95),
                new clase4.Actividad3.Cliente(5, "Cliente E", 88)
        };

        // Encontrar los dos clientes con los scoring máximos
        clase4.Actividad3.Cliente[] dosMaximos = Actividad3.encontrarDosMaximosScoring(clientesAct3, 0, clientesAct3.length - 1);

        // Imprimir los dos clientes con los scoring máximos
        System.out.println("Los dos clientes con los scoring máximos son:");
        System.out.println(dosMaximos[0]);
        System.out.println(dosMaximos[1]);


        //ACTIVIDAD 4
        System.out.println("------------");
        System.out.println("\n");
        System.out.println("------------");
        System.out.println("Actividad 4:");
//        int[] arreglo = { 5, 1, 9, 3, 7, 2, 10, 4, 8, 6 };
//        int n = 3;
//
//        int[] resultado = Actividad4.encontrarNMasGrandes(arreglo, n);
//
//        System.out.println("Los " + n + " elementos más grandes son: " + Arrays.toString(resultado));
//
        Actividad4.main(args);

        //ACTIVIDAD 5
        System.out.println("------------");
        System.out.println("\n");
        System.out.println("------------");
        System.out.println("Actividad 5:");
        // Corredores de ejemplo
        List<Actividad5.Corredor> corredores = new ArrayList<>();
        corredores.add(new Actividad5.Corredor("Derek",  "Infantil", 15.2));
        corredores.add(new Actividad5.Corredor("George",    "Infantil", 14.8));
        corredores.add(new Actividad5.Corredor("Floyd",  "Juvenil",  13.9));
        corredores.add(new Actividad5.Corredor("Pepe",  "Infantil", 16.0));
        corredores.add(new Actividad5.Corredor("Maximus",  "Juvenil",  12.5));
        corredores.add(new Actividad5.Corredor("Propylon",  "Senior",   11.7));
        corredores.add(new Actividad5.Corredor("Droid", "Senior",   12.1));
        corredores.add(new Actividad5.Corredor("Helena",  "Master",   10.5));
        corredores.add(new Actividad5.Corredor("Irene",  "Master",   10.2));

        // Obtener los mejores tiempos por categoría
        Map<String, Actividad5.Corredor> mejoresTiempos = Actividad5.encontrarMejoresTiemposPorCategoria(corredores);

        // Mostrar resultados
        System.out.println("Mejores tiempos por categoría:");
        for (String categoria : mejoresTiempos.keySet()) {
            Actividad5.Corredor c = mejoresTiempos.get(categoria);
            System.out.println("- " + categoria + ": "
                    + c.getNombre() + " con " + c.getTiempo() + "s");
        }
        System.out.println("------------");
    }
}
