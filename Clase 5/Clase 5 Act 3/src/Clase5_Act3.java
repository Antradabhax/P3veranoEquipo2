import java.util.Arrays;
import java.util.Comparator;

class Item {
    int peso;
    int valor;

    public Item(int weight, int value) {
        this.peso = weight;
        this.valor = value;
    }
}

public class Clase5_Act3 {
    //función para calcular el valor máximo
    public static double getValorMax(Item[] items, int capacidad) {
        //ordenamos los elementos por valor/peso en orden descendente
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double ratio1 = (double) o1.valor / o1.peso;
                double ratio2 = (double) o2.valor / o2.peso;
                return Double.compare(ratio2, ratio1);
            }
        });

        double valorTotal = 0.0;
        int capacidadRestante = capacidad;

        //seleccionar los items
        for (Item item : items) {
            if (capacidadRestante >= item.peso) {
                //colocamos el item entero
                valorTotal += item.valor;
                capacidadRestante -= item.peso;
            } else {
                //fraccionamos el item
                double fraccion = (double) capacidadRestante / item.peso;
                valorTotal += item.valor * fraccion;
                break; //se lleno el camion
            }
        }

        return valorTotal;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        int capacidadCamion = 50;

        double maxValue = getValorMax(items, capacidadCamion);
        System.out.println("El valor máximo que se puede obtener es: $" + maxValue);
    }
}