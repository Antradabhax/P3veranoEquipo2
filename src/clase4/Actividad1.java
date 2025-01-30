package clase4;

import java.util.ArrayList;
import java.util.List;

public class Actividad1 {
    public Cliente mejorScoring(List<Cliente> clientes, int inicio, int fin){
        if(inicio == fin){
            return clientes.get(inicio);
        }
        int medio = (inicio + fin) / 2;
        Cliente maxIzquierda = mejorScoring(clientes, inicio, medio);
        Cliente maxDerecha = mejorScoring(clientes, medio+1, fin);

        if(maxIzquierda.getScoring() > maxDerecha.getScoring()){
            return maxIzquierda;
        } else {
            return maxDerecha;
        }
    }
}

class Cliente {
    private int id;
    private String nombre;
    private int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getScoring() {
        return scoring;
    }

    public void setScoring(int scoring) {
        this.scoring = scoring;
    }
}
