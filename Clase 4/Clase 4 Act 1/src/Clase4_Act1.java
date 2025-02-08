import java.util.ArrayList;

public class Clase4_Act1 {
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
        clientes.add(new Cliente(6, 6, 91));
        clientes.add(new Cliente(7, 7, 101));
        clientes.add(new Cliente(8, 8, 2));
        clientes.add(new Cliente(9, 9, 35));
        clientes.add(new Cliente(10, 10, 11));

        Cliente mayorScoring = getHighestScoring(clientes, 0, clientes.size() - 1);

        System.out.println("El cliente con mayor Scoring es: " + mayorScoring.getNombre() + "\nCon un Scoring de: " + mayorScoring.getScoring());
    }

    private Cliente getHighestScoring(ArrayList<Cliente> clientes, int ini, int fin) {
        if (ini == fin) {
            return clientes.get(ini);
        }

        int mid = (ini + fin) / 2;
        Cliente izq = getHighestScoring(clientes, ini, mid);
        Cliente der = getHighestScoring(clientes, mid + 1, fin);

        return (izq.getScoring() >= der.getScoring()) ? izq : der;
    }
}