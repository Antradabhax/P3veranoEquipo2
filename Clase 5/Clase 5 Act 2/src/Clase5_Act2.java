import java.util.*;


public class Clase5_Act2 {
    public static List<Comprobante> obtenerComprobantesMinimos(List<Comprobante> comprobantes, int montoObjetivo) {
        //ordenamos los comprobantes en orden descendente por valor
        comprobantes.sort((a, b) -> Integer.compare(b.valor, a.valor));

        List<Comprobante> seleccionados = new ArrayList<>();
        int total = 0;

        for (Comprobante comprobante : comprobantes) {
            while (total + comprobante.valor <= montoObjetivo) {
                seleccionados.add(comprobante);
                total += comprobante.valor;
            }

            if (total == montoObjetivo) {
                return seleccionados; //se encontró la combinación exacta
            }
        }

        throw new IllegalArgumentException("No es posible alcanzar el monto exacto con los comprobantes disponibles.");
    }

    public static void main(String[] args) {
        List<Comprobante> comprobantes = Arrays.asList(
                new Comprobante("Billete de 10", 10),
                new Comprobante("Moneda de 1", 1),
                new Comprobante("Billete de 5", 5),
                new Comprobante("Moneda de 2", 2)
        );

        int montoObjetivo = 109;

        try {
            List<Comprobante> resultado = obtenerComprobantesMinimos(comprobantes, montoObjetivo);
            System.out.println("Comprobantes seleccionados: " + resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static class Comprobante {
        String descripcion;
        int valor;

        public Comprobante(String descripcion, int valor) {
            this.descripcion = descripcion;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return descripcion + " ($" + valor + ")";
        }
    }
}