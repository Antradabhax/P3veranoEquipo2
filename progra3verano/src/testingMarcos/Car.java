package testingMarcos;

public class Car extends AbstractVehicle {
    private int cantRuedas = 4;
    private int cantPuertas;
    public Car(String matricula, TipoRodado tipoRodado, String modelo, String marca, int cantPuertas){
      setMatricula(matricula);
      setMarca(marca);
      setModelo(modelo);
      setTipoRodado(tipoRodado);
      setCantPuertas(cantPuertas);
    }

    public int getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }
}
