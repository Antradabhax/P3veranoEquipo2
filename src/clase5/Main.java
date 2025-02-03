package clase5;

import clase5.Actividad1.Actividad1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //ACTIVIDAD 1
        System.out.println("------------");
        System.out.println("Actividad 1:");
        List<Integer> monedas = new ArrayList<>(Arrays.asList(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 10));
        int importe = 33;

        try {
            List<Integer> cambio = Actividad1.obtenerCambio(monedas, importe);
            System.out.println("Cambio para $" + importe + ": " + cambio);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------");
    }
}
