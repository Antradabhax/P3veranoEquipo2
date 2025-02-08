public class Clase6_Act2 {
    public static void main(String[] args) {

        Grafo redSocial = new Grafo(5);

        redSocial.agregarArista(0, 1);
        redSocial.agregarArista(1, 2);
        redSocial.agregarArista(2, 0);
        redSocial.agregarArista(1, 0);
        redSocial.agregarArista(1, 4);
        redSocial.agregarArista(3, 4);
        redSocial.agregarArista(2, 1);


        redSocial.mostrarGrafo();
        redSocial.gradoEntrada(1);
        redSocial.gradoSalida(1);
        redSocial.verificarArista(0, 2);
        redSocial.verificarArista(0, 1);
        redSocial.eliminarArista(0, 1);
        redSocial.mostrarGrafo();
    }
}

class Grafo {
    int[][] grafo;
    int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        grafo = new int[numVertices][numVertices];
    }

    public void agregarArista(int v1, int v2) {
        grafo[v1][v2] = 1;
    }

    public void verificarArista(int v1, int v2) {
        if (grafo[v1][v2] == 1) {
            System.out.println("La arista existe");
        } else {
            System.out.println("La arista no existe");
        }
    }

    public void eliminarArista(int v1, int v2) {
        grafo[v1][v2] = 0;
    }

    public void listarAdyacentes(int v) {
        for (int i = 0; i < numVertices; i++) {
            if (grafo[v][i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public void gradoEntrada(int v) {
        int grado = 0;
        for (int i = 0; i < numVertices; i++) {
            if (grafo[i][v] == 1) {
                grado++;
            }
        }
        System.out.println("El grado de entrada del vértice " + v + " es: " + grado);
    }

    public void gradoSalida(int v) {
        int grado = 0;
        for (int i = 0; i < numVertices; i++) {
            if (grafo[v][i] == 1) {
                grado++;
            }
        }
        System.out.println("El grado de salida del vértice " + v + " es: " + grado);
    }

    public void mostrarGrafo() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(grafo[i][j] + " ");
            }
            System.out.println();
        }
    }
}