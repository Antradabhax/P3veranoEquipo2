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

        actividad1.agregarUsuario(grafoUsuarios,alice);
        actividad1.agregarUsuario(grafoUsuarios, bob);
        actividad1.agregarUsuario(grafoUsuarios, charlie);
        actividad1.agregarUsuario(grafoUsuarios, david);

        actividad1.seguirUsuario(alice,bob,grafoUsuarios);
        actividad1.seguirUsuario(alice,charlie,grafoUsuarios);
        actividad1.seguirUsuario(bob,alice,grafoUsuarios);
        actividad1.seguirUsuario(bob,charlie,grafoUsuarios);
        actividad1.seguirUsuario(david, charlie,grafoUsuarios);

        actividad1.listarSeguidos(bob,grafoUsuarios);
        actividad1.listarSeguidos(alice,grafoUsuarios);
        actividad1.listarSeguidos(david,grafoUsuarios);
        actividad1.listarSeguidos(charlie,grafoUsuarios);

        actividad1.listarSeguidores(bob,grafoUsuarios);
        actividad1.listarSeguidores(alice,grafoUsuarios);
        actividad1.listarSeguidores(david,grafoUsuarios);
        actividad1.listarSeguidores(charlie,grafoUsuarios);
    }
}
