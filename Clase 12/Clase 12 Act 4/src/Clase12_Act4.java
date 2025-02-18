import java.util.*;

public class Clase12_Act4 {
    public static void main(String[] args) {
        Usuario u1 = new Usuario(1, "Agustin");
        Usuario u2 = new Usuario(2, "Lucca");
        Usuario u3 = new Usuario(3, "Julian");
        Usuario u4 = new Usuario(4, "Conrado");

        GrafoRedSocial red = new GrafoRedSocial();
        red.agregarUsuario(u1);
        red.agregarUsuario(u2);
        red.agregarUsuario(u3);
        red.agregarUsuario(u4);

        red.conectarUsuarios(u1, u2);
        red.conectarUsuarios(u1, u3);
        red.conectarUsuarios(u2, u4);
        red.conectarUsuarios(u3, u4);

        System.out.println("DFS desde Agustin:");
        List<Usuario> dfs = red.DFS(u1);
        dfs.forEach(user -> System.out.println(user.getNombre()));

        System.out.println("\nBFS desde Agustin:");
        List<Usuario> bfs = red.BFS(u1);
        bfs.forEach(user -> System.out.println(user.getNombre()));
    }
}

class Usuario {
    private int id;
    private String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class GrafoRedSocial {
    private Map<Usuario, List<Usuario>> listaAdyacencia;

    public GrafoRedSocial() {
        listaAdyacencia = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        listaAdyacencia.putIfAbsent(usuario, new ArrayList<>());
    }

    public void conectarUsuarios(Usuario u1, Usuario u2) {
        if (listaAdyacencia.containsKey(u1) && listaAdyacencia.containsKey(u2)) {
            listaAdyacencia.get(u1).add(u2);
            listaAdyacencia.get(u2).add(u1);
        }
    }

    public List<Usuario> DFS(Usuario inicio) {
        List<Usuario> resultado = new ArrayList<>();
        Set<Usuario> visitados = new HashSet<>();
        Stack<Usuario> pila = new Stack<>();

        pila.push(inicio);
        visitados.add(inicio);

        while (!pila.isEmpty()) {
            Usuario actual = pila.pop();
            resultado.add(actual);

            for (Usuario amigo : listaAdyacencia.get(actual)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    pila.push(amigo);
                }
            }
        }
        return resultado;
    }

    public List<Usuario> BFS(Usuario inicio) {
        List<Usuario> resultado = new ArrayList<>();
        Set<Usuario> visitados = new HashSet<>();
        Queue<Usuario> cola = new LinkedList<>();

        cola.offer(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            Usuario actual = cola.poll();
            resultado.add(actual);

            for (Usuario amigo : listaAdyacencia.get(actual)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.offer(amigo);
                }
            }
        }
        return resultado;
    }
}