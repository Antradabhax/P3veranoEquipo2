import java.util.ArrayList;
import java.util.List;

public class Clase7_Act2 {
    public static void main(String[] args) {
        Mochila mochila = new Mochila(10);

        //agregamos los objetos a la mochila
        mochila.agregarObjeto(new Objeto(2, 6));
        mochila.agregarObjeto(new Objeto(3, 10));
        mochila.agregarObjeto(new Objeto(5, 12));
        mochila.agregarObjeto(new Objeto(6, 14));

        //resolvemos por fuerza bruta
        int maxValor = mochila.resolverFuerzaBruta();
        System.out.println("El valor máximo que se puede obtener es: " + maxValor);
    }
}

class Objeto {
    int peso;

    int valor;
    public Objeto(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }

}

class Mochila {
    private int capacidad;

    private List<Objeto> objetos;

    public Mochila(int capacidad) {
        this.capacidad = capacidad;
        this.objetos = new ArrayList<>();
    }

    public void agregarObjeto(Objeto obj) {
        objetos.add(obj);
    }

    public int resolverFuerzaBruta() {
        return maximizarValor(0, 0, 0);
    }
    private int maximizarValor(int indice, int pesoActual, int valorActual) {
        if (indice == objetos.size()) {
            return (pesoActual <= capacidad) ? valorActual : 0;
        }

        //no se incluye el objeto actual
        int sinIncluir = maximizarValor(indice + 1, pesoActual, valorActual);

        //incluimos el objeto actual (siempre y cuando no se supere la capacidad)
        int conIncluir = 0;
        if (pesoActual + objetos.get(indice).peso <= capacidad) {
            conIncluir = maximizarValor(indice + 1,
                    pesoActual + objetos.get(indice).peso,
                    valorActual + objetos.get(indice).valor);
        }

        // Retornar el máximo valor obtenido
        return Math.max(sinIncluir, conIncluir);
    }

}
