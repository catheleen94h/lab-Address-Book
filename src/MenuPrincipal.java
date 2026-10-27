import java.util.Scanner;


public class MenuPrincipal {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            // Validar que la entrada sea un numero antes de leerla
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Opcion invalida, intenta de nuevo");
                continue;
            }
            int opcion = scanner.nextInt();
            scanner.nextLine();

       switch (opcion) {
         case 1:
                 System.out.println("--- AGREGAR CONTACTO ---");
                  System.out.print("Nombre: ");
                 String nombre = scanner.nextLine();
                   System.out.print("Telefono: ");
                   String telefono = scanner.nextLine();
                  System.out.print("Email: ");
                 String email = scanner.nextLine();
                   agenda.agregarContacto(new Contacto(nombre, telefono, email));
                    break;
                case 2:
                    System.out.print("Nombre a buscar: ");
                    String buscado = scanner.nextLine();
                    Contacto encontrado = agenda.buscarContacto(buscado);
                     if (encontrado != null) {
                        System.out.println(encontrado);}
                      else {
                        System.out.println("Contacto no encontrado: " + buscado);
                    }
                    break;
           case 3:
                   System.out.print("Nombre a eliminar: ");
                    agenda.eliminarContacto(scanner.nextLine());
                    break;
           case 4:
                  agenda.listarContactos();
                  break;
           case 5:
                  agenda.listarHistorial();
                     break;
           case 6:
                  System.out.print("Nombre del grupo: ");
                  agenda.agregarGrupo(scanner.nextLine());
                   break;
           case 7:
                   System.out.print("Nombre del contacto: ");
                     String nombreContacto = scanner.nextLine();
                   System.out.print("Nombre del grupo: ");
                    String nombreGrupo = scanner.nextLine();
                   agenda.agregarContactoAGrupo(nombreContacto, nombreGrupo);
                    break;
           case 8:
                    agenda.listarGrupos();
                    break;
           case 9:
                    System.out.print("Nombre del grupo: ");
                    agenda.mostrarContactosPorGrupo(scanner.nextLine());
                    break;
           case 10:
                    System.out.println("Saliendo de la agenda...");
                    salir = true;
                    break;
              default:

                    System.out.println("Opcion invalida, intenta de nuevo");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("=== AGENDA DE CONTACTOS ===");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Listar contactos (orden alfabetico)");
        System.out.println("5. Listar historial (orden de insercion)");
        System.out.println("6. Agregar grupo");
        System.out.println("7. Agregar contacto a grupo");
        System.out.println("8. Listar grupos");
        System.out.println("9. Mostrar contactos por grupo");
        System.out.println("10. Salir");
        System.out.println("=======================");
        System.out.print("Elige una opcion: ");
    }
}