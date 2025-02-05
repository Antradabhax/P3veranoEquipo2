package clase6.Actividad1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actividad1 {
    public Map<Usuario, List<Usuario>> crearGrafoVacio() {
        return new HashMap<>();
    }

    public void mostrarGrafo(Map<Usuario, List<Usuario>> grafo) {
        for(Map.Entry<Usuario, List<Usuario>> entry : grafo.entrySet()) {
            System.out.print(entry.getKey().getNombre_usuario() + " sigue a ");
                    for(Usuario usuario : entry.getValue()) {
                        System.out.print(usuario.getNombre_usuario() + " ");
                    }
                    System.out.println();
        }
    }

}
