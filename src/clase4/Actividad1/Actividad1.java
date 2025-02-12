package clase4.Actividad1;

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

