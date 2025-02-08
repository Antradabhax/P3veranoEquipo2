public class Moto extends Vehiculo{
    private String tipoDeMoto;

    public Moto(int matricula, String marca, String modelo, String tipoDeMoto) {
        super(matricula, marca, modelo);
        this.tipoDeMoto = tipoDeMoto;
    }

    public String getTipoDeMoto() {
        return tipoDeMoto;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Matricula: " + super.getMatricula() + "\nMarca: " + super.getMarca() + "\nModelo: " + super.getModelo() + "\nTipo de moto: " + tipoDeMoto);
    }
}
