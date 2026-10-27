import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Agenda {

    // nombre -> Contacto. TreeMap: busqueda rapida y orden alfabetico por nombre.
    private Map<String, Contacto> contactos = new TreeMap<>();

    // Grupos unicos y ordenados alfabeticamente.
    private Set<String> grupos = new TreeSet<>();

    // grupo -> nombres de los contactos que pertenecen a el.
    private Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();

    // Historial en orden de insercion (independiente del TreeMap).
    private List<Contacto> historial = new ArrayList<>();


    public void agregarContacto(Contacto c) {
        if (contactos.containsKey(c.getNombre())) {
            System.out.println("Error: Ya existe un contacto con el nombre '" + c.getNombre() + "'");
            return;
        }
        contactos.put(c.getNombre(), c);
        historial.add(c);
        System.out.println("Contacto agregado: " + c.getNombre());
    }


    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }


    public boolean eliminarContacto(String nombre) {
        Contacto eliminado = contactos.remove(nombre);
        if (eliminado == null) {
            System.out.println("Contacto no encontrado: " + nombre);
            return false;
        }
        // Quitar del historial
        historial.remove(eliminado);
        // Quitar de todos los grupos
        for (Set<String> miembros : contactosPorGrupo.values()) {
            miembros.remove(nombre);
        }
        System.out.println("Contacto eliminado: " + nombre);
        return true;
    }


    public void listarContactos() {
        System.out.println("--- LISTA DE CONTACTOS (orden alfabetico) ---");
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados");
            return;
        }
        for (Contacto c : contactos.values()) {
            System.out.println(c);
        }
    }


    public void listarHistorial() {
        System.out.println("--- HISTORIAL (orden de insercion) ---");
        if (historial.isEmpty()) {
            System.out.println("El historial esta vacio");
            return;
        }
        for (Contacto c : historial) {
            System.out.println(c);
        }
    }
     public void agregarGrupo(String nombreGrupo) {

        if (!grupos.add(nombreGrupo)) {

            System.out.println("Error: El grupo '" + nombreGrupo + "' ya existe");
             return;
        }
        contactosPorGrupo.put(nombreGrupo, new TreeSet<>());
        System.out.println("Grupo '" + nombreGrupo + "' creado");}


      public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {

        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto '" + nombreContacto + "' no existe");
             return; }

         if (!grupos.contains(nombreGrupo)) {
             System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }
        contactosPorGrupo.get(nombreGrupo).add(nombreContacto);
        System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'");
    }


    public void listarGrupos() {
        System.out.println("--- GRUPOS (orden alfabetico) ---");
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos registrados");
            return;
        }
        for (String g : grupos) {
            System.out.println("- " + g);
        }
    }


    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");

            return;}
        Set<String> miembros = contactosPorGrupo.get(nombreGrupo);
        if (miembros.isEmpty()) {
             System.out.println("El grupo '" + nombreGrupo + "' no tiene contactos");
              return;
        }
        System.out.println("Contactos en '" + nombreGrupo + "':");
                  for (String nombre : miembros) {
               System.out.println("- " + contactos.get(nombre));
        }
    }
}