package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Editorial;
import Libreria.Entidades.Libro;
import Libreria.Persistencia.LibroDAO;
import java.util.List;

public final class LibroServicio {

    private final LibroDAO dao;

    public LibroServicio() {
        dao = new LibroDAO();
    }

    public Libro guardar(Long isbn, String titulo, Integer anio, Integer ejemplares,
            Integer ejemplaresPrestados, Integer ejemplaresRestantes, Autor autor, Editorial editorial) throws Exception {

        Libro l = null;

        try {
            validar(isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, autor, editorial);

            l = new Libro();

            l.setIsbn(isbn);
            l.setTitulo(titulo);
            l.setAnio(anio);
            l.setEjemplares(ejemplares);
            l.setEjemplaresPrestados(ejemplaresPrestados);
            l.setEjemplaresRestantes(ejemplaresRestantes);
            l.setAutor(autor);
            l.setEditorial(editorial);
            l.setAlta(true);

            dao.guardar(l);

        } catch (Exception e) {
            throw e;
        }

        return l;
    }

    public void eliminar(Long isbn) throws Exception {
        if (isbn == null || isbn < 0) {
            throw new Exception("Debe indicar un código ISBN a buscar");
        }

        dao.eliminar(isbn);
    }

    public Libro editar(Long isbn) throws Exception {
        if (isbn == null || isbn < 0) {
            throw new Exception("Debe indicar un código ISBN a buscar");
        }

        return dao.editar(isbn);
    }

    public Libro buscarPorIsbn(Long isbn) throws Exception {
        if (isbn == null || isbn < 0) {
            throw new Exception("Debe indicar un código ISBN a buscar");
        }

        return dao.buscarPorIsbn(isbn);
    }

    public Libro buscarPorTitulo(String titulo) throws Exception {
        if (titulo.trim().isEmpty()) {
            throw new Exception("Debe indicar un título a buscar");
        }

        return dao.buscarPorTitulo(titulo);
    }

    public List<Libro> buscarPorAutor(String autor) throws Exception {
        if (autor.trim().isEmpty()) {
            throw new Exception("Debe indicar un autor a buscar");
        }

        return dao.buscarPorAutor(autor);
    }

    public List<Libro> buscarPorEditorial(String editorial) throws Exception {
        if (editorial.trim().isEmpty()) {
            throw new Exception("Debe indicar una editorial a buscar");
        }

        return dao.buscarPorEditorial(editorial);
    }
    
    public List<Libro> listarTodos() throws Exception {
        return dao.listarTodos();
    }

    public void validar(Long isbn, String titulo, Integer anio, Integer ejemplares,
            Integer ejemplaresPrestados, Integer ejemplaresRestantes, Autor autor, Editorial editorial) throws Exception {

        if (isbn == null) {
            throw new Exception("Debe indicar un código ISBN");
        }
        if (titulo.trim().isEmpty()) {
            throw new Exception("Debe indicar un título");
        }
        if (anio == null || anio < 1) {
            throw new Exception("Debe indicar un año válido");
        }
        if (ejemplares == null || ejemplares < 0) {
            throw new Exception("Debe indicar la cantidad de ejemplares disponible");
        }
        if (ejemplaresPrestados == null || ejemplaresPrestados < 0) {
            throw new Exception("Debe indicar un valor de ejemplares prestados válido");
        }
        if (ejemplaresRestantes == null || ejemplaresRestantes < 0) {
            throw new Exception("Debe indicar una cantidad de ejemplares válida");
        }
        if (autor == null) {
            throw new Exception("Debe indicar un autor");
        }
        if (editorial == null) {
            throw new Exception("Debe indicar una editorial");
        }
    }

}
