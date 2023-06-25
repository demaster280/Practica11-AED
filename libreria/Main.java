


package libreria;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("---- Menú de opciones ----");
            System.out.println("1. Agregar libro");
            System.out.println("2. Modificar libro");
            System.out.println("3. Compra segura");
            System.out.println("4. Listado por especialidad");
            System.out.println("5. Salir");
            System.out.print("Ingrese el número de opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese las ventas del libro: ");
                    int ventas = scanner.nextInt();
                    System.out.print("Ingrese la calificación de la crítica del libro: ");
                    int calificacionCritica = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingrese la especialidad del libro: ");
                    String especialidad = scanner.nextLine();
                    System.out.print("Ingrese los comentarios del libro: ");
                    String comentarios = scanner.nextLine();

                    Libro libro = new Libro(titulo, autor, ventas, calificacionCritica, especialidad, comentarios);
                    libreria.agregarLibro(libro);
                    System.out.println("Libro agregado correctamente.");
                    break;

                case 2:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingrese el título del libro a modificar: ");
                    String tituloModificar = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro a modificar: ");
                    String autorModificar = scanner.nextLine();
                    System.out.print("Ingrese las ventas del libro a modificar: ");
                    int ventasModificar = scanner.nextInt();
                    System.out.print("Ingrese la calificación de la crítica del libro a modificar: ");
                    int calificacionCriticaModificar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingrese los comentarios del libro a modificar: ");
                    String comentariosModificar = scanner.nextLine();

                    Libro libroModificar = new Libro(tituloModificar, autorModificar, ventasModificar,
                            calificacionCriticaModificar, "", comentariosModificar);
                    libreria.modificarLibro(libroModificar);
                    System.out.println("Libro modificado correctamente.");
                    break;

                case 3:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingrese el autor: ");
                    String autorCompraSegura = scanner.nextLine();
                    Libro libroCompraSegura = libreria.compraSegura(autorCompraSegura);
                    if (libroCompraSegura != null) {
                        System.out.println("El libro con mejor crítica del autor " + autorCompraSegura + " es:");
                        System.out.println(libroCompraSegura);
                    } else {
                        System.out.println("No se encontraron libros del autor " + autorCompraSegura);
                    }
                    break;

                case 4:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Ingrese la especialidad: ");
                    String especialidadListado = scanner.nextLine();
                    List<Libro> librosEspecialidad = libreria.listado(especialidadListado);
                    if (!librosEspecialidad.isEmpty()) {
                        System.out.println("Listado de libros de la especialidad " + especialidadListado + ":");
                        for (Libro libroListado : librosEspecialidad) {
                            System.out.println(libroListado);
                        }
                    } else {
                        System.out.println("No se encontraron libros de la especialidad " + especialidadListado);
                    }
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
            System.out.println();
        } while (opcion != 5);
    }
}
