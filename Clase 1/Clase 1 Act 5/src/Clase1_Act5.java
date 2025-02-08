import java.util.ArrayList;

public class Clase1_Act5 {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList();

        vehiculos.add(new Moto(1, "Honda", "CBR", "Deportiva"));
        vehiculos.add(new Auto(2, "VolksWagen", "Golf", 4));
        vehiculos.add(new Camion(3, "Mercedes", "Actros", 1000));

        for (Vehiculo v : vehiculos) {
            v.mostrarDatos();
            System.out.println();
        }
    }
}