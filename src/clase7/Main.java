package clase7;

import clase7.actividad1.Actividad1;
import clase7.actividad2.Actividad2;
import clase7.actividad3.Actividad3;
import clase7.actividad4.Actividad4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        // ACTIVIDAD 1
        System.out.println("------------");
        System.out.println("Actividad 1:");
        Actividad1 actividad1 = new Actividad1();
        int[] pesos = {1, 2, 3, 4};
        int[] valores = {7, 5, 10, 15};
        int capacidad = 4;

        System.out.println(actividad1.problemaMochila(pesos, valores, capacidad));

        //ACTIVIDAD 2
        System.out.println("------------");
        System.out.println("Actividad 2:");
        Actividad2 actividad2 = new Actividad2();
        int resultadoFuerzaBruta = actividad2.fuerzaBruta();
        int resultadoProgramacionDinamica = actividad2.programacionDinamica();
        System.out.println("Resultado por Fuerza Bruta: " + resultadoFuerzaBruta);
        System.out.println("Resultado por Programacion Dinamica: " + resultadoProgramacionDinamica);


        //ACTIVIDAD 3
        System.out.println("------------");
        System.out.println("Actividad 3:");
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        Actividad3 actividad3 = new Actividad3();
        int resultado = actividad3.maxBeneficio(costos, beneficios, presupuesto);
        System.out.println("Beneficio máximo obtenido: " + resultado); // Output esperado: 500


        //ACTIVIDAD 4
        System.out.println("------------");
        System.out.println("Actividad 4:");
        int[] costos2 = {12, 20, 15, 25};
        int[] ganancias2 = {150, 200, 100, 300};
        int presupuesto2 = 35;

        Actividad4 actividad4 = new Actividad4();
        int resultado2 = actividad4.maxGanancia(costos2, ganancias2, presupuesto2);
        System.out.println("Ganancia máxima obtenida: " + resultado2); // Output esperado: 350
        System.out.println("------------");
    }

}
