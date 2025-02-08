public class Auto extends Vehiculo {
    private int cantidadDePuertas;

    public Auto(int matricula, String marca, String modelo, int cantidadDePuertas) {
        super(matricula, marca, modelo);
        this.cantidadDePuertas = cantidadDePuertas;
    }

    public int getCantidadDePuertas() {
        return cantidadDePuertas;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Matricula: " + super.getMatricula() + "\nMarca: " + super.getMarca() + "\nModelo: " + super.getModelo() + "\nCantidad de puertas: " + cantidadDePuertas);
    }
}
