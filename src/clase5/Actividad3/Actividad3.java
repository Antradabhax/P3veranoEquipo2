package clase5.Actividad3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Actividad3 {

    // Clase interna para representar cada elemento (item)
    static class Item {
        int id;          // identificador del item
        double weight;   // peso del item
        double value;    // valor del item
        double ratio;    // valor/peso, para determinar su "rentabilidad"

        public Item(int id, double weight, double value) {
            this.id = id;
            this.weight = weight;
            this.value = value;
            this.ratio = value / weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la capacidad del camión:");
        double capacity = sc.nextDouble();

        System.out.println("Ingrese el número de elementos disponibles:");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        // Lectura de cada elemento (peso y valor)
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el peso y el valor del elemento " + (i + 1) + " (separados por un espacio):");
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            items[i] = new Item(i + 1, weight, value);
        }

        // Ordenar los items por ratio (valor/peso) de mayor a menor
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                return Double.compare(b.ratio, a.ratio);
            }
        });

        double totalValue = 0.0;
        List<String> selectedItems = new ArrayList<>();

        // Recorrer la lista y tomar elementos completos o fraccionados según la capacidad restante
        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }
            if (item.weight <= capacity) {
                // Se puede tomar el item completo
                capacity -= item.weight;
                totalValue += item.value;
                selectedItems.add("Item " + item.id + " (completo)");
            } else {
                // Tomar solo la fracción posible del item
                double fraction = capacity / item.weight;
                totalValue += item.value * fraction;
                selectedItems.add("Item " + item.id + " (" + String.format("%.2f", fraction * 100) + "%)");
                capacity = 0;  // se agota la capacidad
            }
        }

        // Mostrar resultados
        System.out.println("Valor total máximo obtenido: " + totalValue);
        System.out.println("Elementos seleccionados:");
        for (String s : selectedItems) {
            System.out.println(s);
        }

        sc.close();
    }
}
