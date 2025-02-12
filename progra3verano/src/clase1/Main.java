package clase1;


import clase1.actividad5.Auto;
import clase1.actividad5.Camion;
import clase1.actividad5.Moto;
import clase1.actividad5.TipoDeMoto;

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
        // ##############

        // ACTIVIDAD 4 - ATENCION: Para probarlo, por favor deshabilitar la Actividad 3
        System.out.println("\n");
        System.out.println("Actividad 4:");
        Actividad4 actividad4 = new Actividad4();
        actividad4.ejecutarPrograma();
        // ##############

        // ACTIVIDAD 5
        System.out.println("\n");
        System.out.println("Actividad 5:");
        Auto auto = new Auto();
        auto.setCantidad_de_puertas(2);
        auto.setMarca("Mitsubishi");
        auto.setModelo("Lancer GT 2.O");
        auto.setNumero_matricula("ABC 123 90");

        auto.obtenerInfoVehiculo();
        System.out.println(auto.getCantidad_de_puertas() + " ruedas.");
        // ##############

        Camion camion = new Camion();
        camion.setMarca("IVECO");
        camion.setModelo("CGT Moyaneitor");
        camion.setNumero_matricula("CGT 666 69");
        camion.setCapacidad_de_carga(300.33);
        camion.obtenerInfoVehiculo();
        System.out.println(camion.getCapacidad_de_carga() + " toneladas.");

        Moto moto = new Moto();
        moto.setMarca("Harley Davison");
        moto.setModelo("Super");
        moto.setNumero_matricula("TTP 321 99");
        moto.setTipoDeMoto(TipoDeMoto.DEPORTIVA);
        moto.obtenerInfoVehiculo();
        System.out.println("De tipo: " + moto.getTipoDeMoto());
    }
}
