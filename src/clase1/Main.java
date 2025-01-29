package clase1;


public class Main {
    public static void main(String[] args) {
        // ACTIVIDAD 2
        System.out.println("Actividad 2:");
        Actividad2 actividad2 = new Actividad2();
        actividad2.setEdad(23);
        actividad2.setAltura(1.68);
        actividad2.setIncial_nombre('M');
        actividad2.setCiudad_residencia("Castelar");
        actividad2.act2();
        // ##############

        // ACTIVIDAD 3
        System.out.println("\n");
        System.out.println("Actividad 3:");
        Actividad3 actividad3 = new Actividad3();
        actividad3.calculadora();

        // ACTIVIDAD 4 - ATENCION: Para probarlo, por favor deshabilitar la Actividad 3
        System.out.println("\n");
        System.out.println("Actividad 4:");
        Actividad4 actividad4 = new Actividad4();
        actividad4.ejecutarPrograma();


        // ACTIVIDAD 5
        System.out.println("\n");
        System.out.println("Actividad 5:");
        Auto auto = new Auto();
    }
}
