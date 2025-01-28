package testingMarcos;

public abstract class AbstractVehicle {
    private TipoRodado tipoRodado;
    private String matricula;
    private String modelo;
    private String marca;

    private double velocidad = 0;

    private double aceleracion = 0;

    public void acelerar(double aceleracion){
        double nueva_aceleracion = this.aceleracion + aceleracion;
        this.aceleracion = nueva_aceleracion;
    }

    private void establecerVelocidad(){
        double nueva_velocidad = this.aceleracion * 1 +  this.velocidad;
        this.velocidad = nueva_velocidad;
    }

    public void pasarTiempo(int segundos){
        for (int i = 0; i<=segundos; i++){
            System.out.println(getVelocidad() + "km/h");
            establecerVelocidad();
            disminuirAceleracion();
        }
    }

    private void disminuirAceleracion(){
        double rozamiento = 0.2;
        double nueva_aceleracion = this.aceleracion - rozamiento;
        this.aceleracion = nueva_aceleracion;
    }

    public void frenar(double freno){
        double nueva_aceleracion = this.aceleracion - freno;
        this.aceleracion = nueva_aceleracion;
    }

    public TipoRodado getTipoRodado() {
        return tipoRodado;
    }

    public void setTipoRodado(TipoRodado tipoRodado) {
        this.tipoRodado = tipoRodado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }
}
