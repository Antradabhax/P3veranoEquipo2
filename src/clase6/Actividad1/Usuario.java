package clase6.Actividad1;

import java.util.*;

public class Usuario {
    private String nombre_usuario;

    public Usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void listarSeguidores(Usuario usuario, Map<Usuario, List<Usuario>> grafo){

    }

    public void seguirUsuario(Usuario seguidor, String usuario, Map<Usuario, List<Usuario>> grafo){
        grafo.put(seguidor, new ArrayList<>());
    }

    public void dejarDeSeguirUsuario(Usuario seguidor, String usuario, Map<Usuario, List<Usuario>> grafo){

    }

    public void agregarUsuario(Map<Usuario, List<Usuario>> grafo, Usuario usuario){
        grafo.put(usuario, new ArrayList<>(Collections.emptyList()));
    }

    public void listarSeguidoresDe(String usuario, Map<Usuario, List<Usuario>> grafo) {

    }
}
