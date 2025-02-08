import java.util.ArrayList;
import java.util.List;

public class Clase6_Act1 {
    public static void main(String[] args) {
        List<Usuario> redSocial = new ArrayList<>();

        Usuario agustin = new Usuario("Agustin");
        Usuario carlos = new Usuario("Carlos");
        Usuario daniela = new Usuario("Daniela");

        redSocial.add(agustin);
        redSocial.add(carlos);
        redSocial.add(daniela);

        agustin.seguir(carlos);
        agustin.seguir(daniela);
        carlos.seguir(agustin);
        daniela.seguir(agustin);

        for (Usuario usuario : redSocial) {
            System.out.println("Seguidores de " + usuario.getNombre() + ":");
            for (Usuario seguidor : usuario.getSeguidores()) {
                System.out.println(seguidor.getNombre());
            }
            System.out.println("Seguidos por " + usuario.getNombre() + ":");
            for (Usuario seguido : usuario.getSeguidos()) {
                System.out.println(seguido.getNombre());
            }
            System.out.println();
        }
    }
}
class Usuario {
    private String nombre;
    private List<Usuario> seguidores;
    private List<Usuario> seguidos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.seguidores = new ArrayList<>();
        this.seguidos = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Usuario> getSeguidores() {
        return this.seguidores;
    }

    public List<Usuario> getSeguidos() {
        return this.seguidos;
    }

    public void nuevoSeguidor(Usuario usuario) {
        this.seguidores.add(usuario);
    }

    public void seguir(Usuario usuario) {
        this.seguidos.add(usuario);
        usuario.nuevoSeguidor(this);
    }

    public void dejarDeSeguir(Usuario usuario) {
        this.seguidos.remove(usuario);
        usuario.seguidores.remove(this);
    }
}