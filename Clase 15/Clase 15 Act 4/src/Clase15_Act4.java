import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clase15_Act4 {
    public static double calcularMaximoSaldoDolares(double saldoInicial, List<Nodo> nodos) {
        List<Nodo> cobros = new ArrayList<>();
        List<Nodo> pagos = new ArrayList<>();

        for (Nodo nodo : nodos) {
            if (nodo.getTransaction() > 0) {
                cobros.add(nodo);
            } else {
                pagos.add(nodo);
            }
        }

        Collections.sort(cobros, Comparator.comparingDouble(Nodo::getTransaction).reversed()
                .thenComparingDouble(Nodo::getTasaCambio).reversed());

        Collections.sort(pagos, Comparator.comparingDouble(Nodo::getTasaCambio));

        double saldoCripto = saldoInicial;
        double saldoDolares = 0.0;

        for (Nodo cobro : cobros) {
            saldoCripto += cobro.getTransaction();
            saldoDolares += cobro.getTransaction() * cobro.getTasaCambio();
        }

        for (Nodo pago : pagos) {
            double montoPago = -pago.getTransaction();
            if (saldoCripto >= montoPago) {
                saldoCripto += pago.getTransaction();
                saldoDolares += pago.getTransaction() * pago.getTasaCambio();
            }
        }

        return saldoDolares;
    }
}

class Nodo {
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