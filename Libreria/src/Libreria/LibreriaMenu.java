package Libreria;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Editorial;
import Libreria.Entidades.Libro;
import Libreria.Servicios.AutorServicio;
import Libreria.Servicios.EditorialServicio;
import Libreria.Servicios.LibroServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class LibreriaMenu {

    private final LibroServicio ls;
    private final AutorServicio as;
    private final EditorialServicio es;
    private List lista;
    private final Scanner input;

    public LibreriaMenu() {
        ls = new LibroServicio();
        as = new AutorServicio();
        es = new EditorialServicio();
        lista = new ArrayList<>();
        input = new Scanner(System.in).useDelimiter("\n");
    }

    public void menu() throws Exception {
        Autor a = null;
        Libro l = null;
        Editorial e = null;

        String nombre, titulo, editorial, id;
        Integer opcion, isbn, anio, ejemplares, ejPrestados, ejRestantes;
        do {
            menuContextual();
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Indique el nombre del Autor: ");
                    nombre = input.next();
                    lista = as.buscarPorNombre(nombre);
                    verificarLista(lista);
                    break;
                case 2:
                    System.out.print("Ingrese el código ISBN: ");
                    isbn = input.nextInt();
                    l = ls.buscarPorIsbn(isbn);
                    verificarObjetoYMostrar(l);
                    break;
                case 3:
                    System.out.print("Indique un título: ");
                    titulo = input.next();
                    l = ls.buscarPorTitulo(titulo);
                    verificarObjetoYMostrar(l);
                    break;
                case 4:
                    System.out.print("Indique el nombre: ");
                    nombre = input.next();
                    lista = ls.buscarPorAutor(nombre);
                    verificarLista(lista);
                    break;
                case 5:
                    System.out.print("Indique el nombre de la Editorial: ");
                    editorial = input.next();
                    lista = ls.buscarPorEditorial(editorial);
                    verificarLista(lista);
                    break;
                case 6:
                    System.out.print("Indique el nombre de la Editorial: ");
                    nombre = input.next();
                    es.crearYGuardar(nombre);
                    break;
                case 7:
                    System.out.print("Indique el nombre del Autor: ");
                    nombre = input.next();
                    as.crearYGuardar(nombre);
                    break;
                case 8:
                    System.out.println("Llene los siguiente datos");
                    System.out.print("ISBN: ");
                    isbn = input.nextInt();
                    System.out.print("Título: ");
                    titulo = input.next();
                    System.out.print("Año: ");
                    anio = input.nextInt();
                    System.out.print("Ejemplares Disponibles: ");
                    ejemplares = input.nextInt();
                    System.out.print("Ejemplares Prestados: ");
                    ejPrestados = input.nextInt();
                    System.out.print("Ejemplares Restantes: ");
                    ejRestantes = input.nextInt();

                    System.out.println("Selecctione un Autor de la lista (ID):");
                    lista = as.listarTodos();
                    visualizar(lista);
                    System.out.print("--> ");
                    id = input.next();
                    a = as.buscarPorId(id);

                    System.out.println("Seleccione una Editorial de la lista (ID):");
                    lista = es.listarTodos();
                    visualizar(lista);
                    System.out.print("--> ");
                    id = input.next();
                    e = es.buscarPorId(id);

                    ls.crearYGuardar(isbn, titulo, anio, ejemplares, ejPrestados, ejRestantes, a, e);
                    break;
                case 9:
                    System.out.print("Indique el ID del Autor a eliminar: ");
                    id = input.next();
                    a = as.buscarPorId(id);
                    if (a == null) {
                        System.out.println("No existe un Autor con ese ID");
                    } else {
                        as.eliminar(a);
                    }
                    break;
                case 10:
                    System.out.print("Indique el ID de la Editorial a eliminar: ");
                    id = input.next();
                    e = es.buscarPorId(id);
                    if (e == null) {
                        System.out.println("No existe una Editorial con ese ID");
                    } else {
                        es.eliminar(e);
                    }
                    break;
                case 11:
                    System.out.print("Indique el ISBN del Libro a eliminar: ");
                    isbn = input.nextInt();
                    l = ls.buscarPorIsbn(isbn);
                    if (l == null) {
                        System.out.println("No existe un Libro con ese ISBN");
                    } else {
                        ls.eliminar(l);
                    }
                    break;
                case 12:
                    lista = as.listarTodos();
                    verificarLista(lista);
                    break;
                case 13:
                    lista = es.listarTodos();
                    verificarLista(lista);
                    break;
                case 14:
                    lista = ls.listarTodos();
                    verificarLista(lista);
                    break;
                case 15:
                    System.out.print("Indique el ID del Autor a editar: ");
                    id = input.next();
                    a = as.buscarPorId(id);
                    if (a == null) {
                        System.out.println("La busqueda no lanzó ningún resultado");
                    } else {
                        System.out.print("Indique el nuevo nombre del Autor: ");
                        a.setNombre(input.next());
                        as.editar(a);
                    }
                    break;
                case 16:
                    System.out.print("Indique el ID de la Editorial a editar: ");
                    id = input.next();
                    e = es.buscarPorId(id);
                    if (e == null) {
                        System.out.println("La busqueda no lanzó ningún resultado");
                    } else {
                        System.out.print("Indique el nuevo nombre de la Editorial: ");
                        e.setNombre(input.next());
                        es.editar(e);
                    }
                    break;
                default:
                    System.out.println("Aisistente finalizado");
            }
        } while (opcion != 17);
    }

    private void visualizar(List l) {
        l.forEach((aux) -> {
            System.out.println(aux);
        });
    }

    private void verificarLista(List lista) {
        if (lista.isEmpty()) {
            System.out.println("La busqueda no lanzó ningún resultado");
        } else {
            System.out.println("Resultado de la búsqueda:");
            visualizar(lista);
        }
    }

    private void verificarObjetoYMostrar(Object ob) {
        if (ob == null) {
            System.out.println("La busqueda no lanzó ningún resultado");
        } else {
            System.out.println("Resultado de la búsqueda:\n" + ob);
        }
    }

    private void menuContextual() {
        System.out.println("*** LIBRERÍA VIRTUAL ***");
        System.out.println("1. Buscar un Autor por nombre");
        System.out.println("2. Buscar un Libro por ISBN");
        System.out.println("3. Buscar un Libro por título");
        System.out.println("4. Buscar Libro/s por Autor");
        System.out.println("5. Buscar Libro/s por Editorial");
        System.out.println("6. Agregar una Editorial");
        System.out.println("7. Agregar un Autor");
        System.out.println("8. Agregar un Libro");
        System.out.println("9. Eliminar un Autor");
        System.out.println("10. Eliminar una Editorial");
        System.out.println("11. Eliminar un Libro");
        System.out.println("12. Listar todos los Autores");
        System.out.println("13. Listar todos las Editoriales");
        System.out.println("14. Listar todos los Libros");
        System.out.println("15. Editar un Autor");
        System.out.println("16. Editar una Editorial");
        System.out.println("17. Salir");
        System.out.print("> ");
    }

}
