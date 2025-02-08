public class Camion extends Vehiculo{
    private int capacidadDeCarga;

    public Camion(int matricula, String marca, String modelo, int capacidadDeCarga) {
        super(matricula, marca, modelo);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    public int getCapacidadDeCarga() {
        return capacidadDeCarga;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Matricula: " + super.getMatricula() + "\nMarca: " + super.getMarca() + "\nModelo: " + super.getModelo() + "\nCapacidad de carga: " + capacidadDeCarga);
    }
}
