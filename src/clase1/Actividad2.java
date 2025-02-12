package clase1;

public class Actividad2 {
    private int edad;
    private double altura;
    private char incial_nombre;
    private String ciudad_residencia;

    public void act2(){
        System.out.println(this.edad+2);
        System.out.println(this.altura*2);
        System.out.println("Tu inical es " + this.incial_nombre);

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public char getIncial_nombre() {
        return incial_nombre;
    }

    public void setIncial_nombre(char incial_nombre) {
        this.incial_nombre = incial_nombre;
    }

    public String getCiudad_residencia() {
        return ciudad_residencia;
    }

    public void setCiudad_residencia(String ciudad_residencia) {
        this.ciudad_residencia = ciudad_residencia;
    }
}
