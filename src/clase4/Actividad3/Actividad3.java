package clase4.Actividad3;

public class Actividad3 {

    // Método para encontrar los dos clientes con los scoring máximos
    public static Cliente[] encontrarDosMaximosScoring(Cliente[] clientes, int inicio, int fin) {
        // Caso base: si hay un solo cliente
        if (inicio == fin) {
            return new Cliente[]{clientes[inicio], clientes[inicio]};
        }

        // Caso base: si hay dos clientes
        if (fin - inicio == 1) {
            if (clientes[inicio].scoring > clientes[fin].scoring) {
                return new Cliente[]{clientes[inicio], clientes[fin]};
            } else {
                return new Cliente[]{clientes[fin], clientes[inicio]};
            }
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;

        // Conquistar: encontrar los dos máximos en cada mitad
        Cliente[] maximosIzquierda = encontrarDosMaximosScoring(clientes, inicio, medio);
        Cliente[] maximosDerecha = encontrarDosMaximosScoring(clientes, medio + 1, fin);

        // Combinar: encontrar los dos máximos entre los cuatro clientes
        return combinarMaximos(maximosIzquierda, maximosDerecha);
    }

    // Método para combinar los dos máximos de cada mitad
    private static Cliente[] combinarMaximos(Cliente[] maximosIzquierda, Cliente[] maximosDerecha) {
        Cliente[] candidatos = new Cliente[4];
        candidatos[0] = maximosIzquierda[0];
        candidatos[1] = maximosIzquierda[1];
        candidatos[2] = maximosDerecha[0];
        candidatos[3] = maximosDerecha[1];

        // Encontrar los dos clientes con los scoring más altos
        Cliente primero = candidatos[0];
        Cliente segundo = candidatos[1];

        for (Cliente cliente : candidatos) {
            if (cliente.scoring > primero.scoring) {
                segundo = primero;
                primero = cliente;
            } else if (cliente.scoring > segundo.scoring) {
                segundo = cliente;
            }
        }

        return new Cliente[]{primero, segundo};
    }
}
