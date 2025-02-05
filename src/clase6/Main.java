package clase6;

import clase6.Actividad1.Actividad1;
import clase6.Actividad1.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // ejemplo en clase
        Ejemplo1 ejemplo1 = new Ejemplo1();
        List<List<Integer>> grafo = ejemplo1.crearGrafoVacio(6);

        grafo.get(0).add(1); // A - B
        grafo.get(0).add(2); // A - C
        grafo.get(1).add(3); // B - D
        grafo.get(2).add(3); // C - D

        ejemplo1.mostrarGrafo(grafo);

        System.out.println();
        // ACTIVIDAD 1
        Actividad1 actividad1 = new Actividad1();
        Map<Usuario, List<Usuario>> grafoUsuarios = actividad1.crearGrafoVacio();
        Usuario alice = new Usuario("Alice");
        Usuario bob = new Usuario("Bob");
        Usuario charlie = new Usuario("Charlie");
        Usuario david = new Usuario("David");

        grafoUsuarios.put(alice, new ArrayList<>(Arrays.asList(bob, charlie)));
        grafoUsuarios.put(bob, new ArrayList<>(Arrays.asList(david)));
        grafoUsuarios.put(charlie, new ArrayList<>(Arrays.asList(david)));
        grafoUsuarios.put(david, new ArrayList<>());

        actividad1.mostrarGrafo(grafoUsuarios);
    }
}
