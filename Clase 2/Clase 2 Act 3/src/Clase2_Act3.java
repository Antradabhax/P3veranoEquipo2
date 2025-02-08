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
        return "Cliente ID: " + idCliente + ", Nombre: " + nombreCliente + ", Suma de Importes: " + sumaImportes;
    }
}

public class Clase2_Act3 {
    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 101, 100.0));
        facturas.add(new Factura(2, 102, 200.0));
        facturas.add(new Factura(3, 101, 150.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(101, "Cliente A"));
        clientes.add(new Cliente(102, "Cliente B"));

        Map<Integer, Resultado> mapaResultados = new HashMap<>();

        //Acceso a cada cliente del Map mediante clave, se realiza en tiempo constante,
        //lo que acelera mucho mas la busqueda que con un ArrayList anidando los for
        for (Cliente cliente : clientes) {
            mapaResultados.put(cliente.idCliente, new Resultado(cliente.idCliente, cliente.nombre, 0));
        }

        for (Factura factura : facturas) {
            Resultado resultado = mapaResultados.get(factura.idCliente);
            if (resultado != null) {
                resultado.sumaImportes += factura.importe;
            }
        }

        for (Resultado resultado : mapaResultados.values()) {
            System.out.println(resultado);
        }
    }
}