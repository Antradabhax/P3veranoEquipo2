package clase15.Actividad4;

public class Nodo {
    private double transaction;
    private double tasaCambio;

    public Nodo(double transaction, double tasaCambio) {
        this.transaction = transaction;
        this.tasaCambio = tasaCambio;
    }

    public double getTransaction() {
        return transaction;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }
}