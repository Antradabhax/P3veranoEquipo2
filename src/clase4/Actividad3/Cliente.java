package clase4.Actividad3;

public class Cliente {
    int id;
    String nombre;
    int scoring;

    // Constructor
    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    // Método toString para imprimir el objeto
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", scoring=" + scoring +
                '}';
    }
}