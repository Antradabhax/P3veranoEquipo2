package clase2;

public class Main {
    public static void main(String[] args) {
        // ACTIVIDAD 1
        System.out.println("Actividad 1:");
        Actividad1 actividad1 = new Actividad1();
        System.out.print("Promedio: " + actividad1.calcularPromedio());

        // ACTIVIDAD 2
        System.out.println("\n");
        System.out.println("Actividad 2:");
        Actividad2 actividad2 = new Actividad2();
        int[][] matriz1 = {{2,4},{4,8}};
        int[][] matriz2 = {{1,3},{5,7}};
        actividad2.multiplicarMatCuadrada(matriz1,matriz2);

        // ACTIVIDAD 3 - Ejecutar en su archivo propietario
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Para ver la actividad 3, por favor ejecutar desde el archivo Actividad3.java");
        System.out.println("----------------------------------------------------------------------------");

        // ACTIVIDAD 4
        System.out.println("\n");
        System.out.println("Actividad 4:");
        Actividad4 actividad4 = new Actividad4();
        actividad4.ejecutar();

        // ACTIVIDAD 5
        System.out.println("\n");
        System.out.println("Actividad 5:");
        Actividad5 actividad5 = new Actividad5();
        actividad5.ejecutar();

        //ACTIVIDAD 6: Branches subidas en imagen junto a la carpeta contenedora
    }
}
