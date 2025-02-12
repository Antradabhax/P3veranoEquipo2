package clase6.Actividad1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actividad1 {
    public Map<Usuario, List<Usuario>> crearGrafoVacio() {
        return new HashMap<>();
    } // Mapa para los usuarios con lista de asociado.

    public void mostrarGrafo(Map<Usuario, List<Usuario>> grafo) {
        for(Map.Entry<Usuario, List<Usuario>> entry : grafo.entrySet()) {
            System.out.print(entry.getKey().getNombre_usuario() + " sigue a ");
                    for(Usuario usuario : entry.getValue()) {
                        System.out.print(usuario.getNombre_usuario() + " ");
                    }
                    System.out.println();
        }
    }

    public void agregarUsuario(Map<Usuario, List<Usuario>> grafo, Usuario usuario){
        grafo.put(usuario, new ArrayList<>());
    }

    public void listarSeguidores(Usuario usuario, Map<Usuario, List<Usuario>> grafo) {
        System.out.println(usuario.getNombre_usuario() + " es seguido por: ");
        for (Map.Entry<Usuario, List<Usuario>> entry : grafo.entrySet()) {
            if (entry.getValue().contains(usuario)) {
               System.out.print(entry.getKey().getNombre_usuario() + " | ");
            }
        }System.out.println();
    }

    public void seguirUsuario(Usuario seguidor, Usuario seguido, Map<Usuario, List<Usuario>> grafo){
        if(!grafo.get(seguidor).contains(seguido)) {
            grafo.get(seguidor).add(seguido);
            System.out.print(seguidor.getNombre_usuario() + " empezo a seguir a " + seguido.getNombre_usuario());
        }else{
            System.out.println(seguidor.getNombre_usuario() + "ya sigue a "  + seguido.getNombre_usuario());
        }
    }

    public void dejarDeSeguirUsuario(Usuario seguidor, Usuario seguido, Map<Usuario, List<Usuario>> grafo) {
        if(!grafo.get(seguidor).contains(seguido)){
            System.out.println(seguidor.getNombre_usuario() + " no sigue a " + seguido);
        } else {
            grafo.get(seguidor).remove(seguido);
            System.out.println(seguidor.getNombre_usuario() + " dejo de seguir a " + seguido.getNombre_usuario());
        }
    }

    public void listarSeguidos(Usuario usuario, Map<Usuario, List<Usuario>> grafo) {
        System.out.println("Listando seguidos por: " + usuario.getNombre_usuario() + "\n");
        if (grafo.get(usuario).isEmpty()) {
            System.out.println(usuario.getNombre_usuario() + " no sigue a nadie.");
        }else {
        int seguidos = grafo.get(usuario).size();
        for(int i = 0; i <= seguidos - 1; i++){
            System.out.print("Seguido numero: " + (i+1) + " | " + grafo.get(usuario).get(i).getNombre_usuario());
            System.out.println();
        } System.out.println();}
    }
}
