package testingMarcos;

public class Main {
    public static void main(String[] args) {
        Car auto = new Car("ABC 123 79", TipoRodado.COMPETIZIONE, "Lancer GT", "Mitsubishi", 4);

        System.out.println(auto.getMarca());
        System.out.println(auto.getModelo());
        System.out.println(auto.getCantPuertas());
        System.out.println(auto.getMatricula());
        System.out.println(auto.getTipoRodado());

        auto.acelerar(12);
        auto.pasarTiempo(3);
    }
}
