package clase2;

public class Main {
    public static void main(String[] args) {
        // ACTIVIDAD 1
        System.out.println("Actividad 1:");
        Actividad1 actividad1 = new Actividad1();
        System.out.print(actividad1.calcularPromedio());


        // ACTIVIDAD 2 - Se pueden modificar los valores de las matrices
        System.out.println("\n");
        System.out.println("Actividad 2:");
        Actividad2 actividad2 = new Actividad2();
        actividad2.ejecutar();

        // ACTIVIDAD 3

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
    }
}
