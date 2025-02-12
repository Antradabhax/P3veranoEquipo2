package clase2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

class Cliente {
    int idCliente;
    String nombre;

    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}

class Resultado {
    int idCliente;
    String nombreCliente;
    double sumaImportes;

    public Resultado(int idCliente, String nombreCliente, double sumaImportes) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.sumaImportes = sumaImportes;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombreCliente + " (ID: " + idCliente + "), Suma de importes: " + sumaImportes;
    }
}

public class Actividad3 {
    public static void main(String[] args) {
        // Datos comunes para ambas implementaciones
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 101, 150.0));
        facturas.add(new Factura(2, 102, 200.0));
        facturas.add(new Factura(3, 101, 300.0));
        facturas.add(new Factura(4, 103, 100.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(101, "Cliente A"));
        clientes.add(new Cliente(102, "Cliente B"));
        clientes.add(new Cliente(103, "Cliente C"));

        // Ejecutar la implementación sin Maps
        System.out.println("Resultados sin usar Maps:");
        List<Resultado> resultadosSinMaps = calcularSumaImportesSinMaps(facturas, clientes);
        for (Resultado resultado : resultadosSinMaps) {
            System.out.println(resultado);
        }

        // Ejecutar la implementación con Maps
        System.out.println("\nResultados usando Maps:");
        List<Resultado> resultadosConMaps = calcularSumaImportesConMaps(facturas, clientes);
        for (Resultado resultado : resultadosConMaps) {
            System.out.println(resultado);
        }
    }

    // Método para calcular la suma de importes sin usar Maps
    public static List<Resultado> calcularSumaImportesSinMaps(List<Factura> facturas, List<Cliente> clientes) {
        List<Resultado> resultados = new ArrayList<>();

        for (Cliente cliente : clientes) {
            double suma = 0.0;

            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    suma += factura.importe;
                }
            }

            resultados.add(new Resultado(cliente.idCliente, cliente.nombre, suma));
        }

        return resultados;
    }

    // Método para calcular la suma de importes usando Maps
    public static List<Resultado> calcularSumaImportesConMaps(List<Factura> facturas, List<Cliente> clientes) {
        Map<Integer, Double> sumaImportesPorCliente = new HashMap<>();

        for (Factura factura : facturas) {
            sumaImportesPorCliente.put(
                    factura.idCliente,
                    sumaImportesPorCliente.getOrDefault(factura.idCliente, 0.0) + factura.importe
            );
        }

        List<Resultado> resultados = new ArrayList<>();

        for (Cliente cliente : clientes) {
            double suma = sumaImportesPorCliente.getOrDefault(cliente.idCliente, 0.0);
            resultados.add(new Resultado(cliente.idCliente, cliente.nombre, suma));
        }

        return resultados;
    }
}