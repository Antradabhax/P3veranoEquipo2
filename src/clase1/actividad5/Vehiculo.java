package clase1.actividad5;

public abstract class Vehiculo {
    private String numero_matricula;
    private String marca;
    private String modelo;
    public String getNumero_matricula() {
        return numero_matricula;
    }

    public void setNumero_matricula(String numero_matricula) {
        this.numero_matricula = numero_matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void obtenerInfoVehiculo(){
        System.out.print(this.getModelo() + " | " + this.getMarca() + " | " + this.getNumero_matricula() + "\n");
    }


}
