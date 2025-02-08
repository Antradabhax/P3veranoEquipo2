import java.util.ArrayList;

public class Clase4_Act3 {
    class Cliente {
        private int nombre;
        private int id;
        private int scoring;

        public Cliente(int nombre, int id, int scoring) {
            this.nombre = nombre;
            this.id = id;
            this.scoring = scoring;
        }

        public int getNombre() {
            return nombre;
        }
        public void setNombre(int nombre) {
            this.nombre = nombre;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getScoring() {
            return scoring;
        }
        public void setScoring(int scoring) {
            this.scoring = scoring;
        }
    }

    public void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList();

        clientes.add(new Cliente(1, 1, 155));
        clientes.add(new Cliente(2, 2, 34));
        clientes.add(new Cliente(3, 3, 67));
        clientes.add(new Cliente(4, 4, 90));
        clientes.add(new Cliente(5, 5, 45));
        clientes.add(new Cliente(6, 6, 913));
        clientes.add(new Cliente(7, 7, 101));
        clientes.add(new Cliente(8, 8, 2));
        clientes.add(new Cliente(9, 9, 35));
        clientes.add(new Cliente(10, 10, 11));

        ArrayList<Cliente> mayoresScoring = getTwoHighestScoring(clientes, 0, clientes.size() - 1);

        System.out.println("Los clientes con mayor scoring son: " +
                mayoresScoring.get(0).getNombre() + " (Scoring: " + mayoresScoring.get(0).getScoring() + ") y " +
                mayoresScoring.get(1).getNombre() + " (Scoring: " + mayoresScoring.get(1).getScoring() + ")");
    }

    private static ArrayList<Cliente> getTwoHighestScoring(ArrayList<Cliente> clientes, int ini, int fin) {
        if (ini == fin) {
            ArrayList<Cliente> base = new ArrayList<>();
            base.add(clientes.get(ini));
            return base;
        }

        int mid = (ini + fin) / 2;
        ArrayList<Cliente> izquierda = getTwoHighestScoring(clientes, ini, mid);
        ArrayList<Cliente> derecha = getTwoHighestScoring(clientes, mid + 1, fin);

        return combinarMejores(izquierda, derecha);
    }

    private static ArrayList<Cliente> combinarMejores(ArrayList<Cliente> lista1, ArrayList<Cliente> lista2) {
        ArrayList<Cliente> resultado = new ArrayList<>();
        resultado.addAll(lista1);
        resultado.addAll(lista2);

        resultado.sort((c1, c2) -> Integer.compare(c2.getScoring(), c1.getScoring()));

        ArrayList<Cliente> topDos = new ArrayList<>();
        topDos.add(resultado.get(0));
        topDos.add(resultado.get(1));

        return topDos;
    }
}