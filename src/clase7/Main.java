package clase7;

import clase7.actividad1.Actividad1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        // ACTIVIDAD 1
        Actividad1 actividad1 = new Actividad1();
        int[] pesos = {1, 2, 3, 4};
        int[] valores = {7, 5, 10, 15};
        int capacidad = 4;

        System.out.println(actividad1.problemaMochila(pesos, valores, capacidad));
    }

}
