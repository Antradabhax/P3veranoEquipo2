package clase5;

import clase5.Actividad1.Actividad1;
import clase5.Actividad2.Actividad2;
import clase5.Actividad4.Actividad4;

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

        //ACTIVIDAD 2
        System.out.println("Actividad 2:");
        Actividad2 actividad2 = new Actividad2();
        actividad2.resolver();


        //ACTIVIDAD 3 Y 4 - EJECUTAR DESDE SU ARCHIVO
        System.out.println();
        System.out.println("------------");
        System.out.println("Las Actividades 3 y 4 son ejecutadas desde su archivo correspondiente!");
        System.out.println("------------");
    }
}
