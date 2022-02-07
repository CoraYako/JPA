package Libreria.Persistencia;

import Libreria.Entidades.Libro;
import java.util.List;

public final class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro l) throws Exception {
        super.guardar(l);
    }

    public void eliminar(Long isbn) throws Exception {
        Libro l = buscarPorIsbn(isbn);
        super.eliminar(l);
    }

    public Libro editar(Long isbn) throws Exception {
        Libro l = buscarPorIsbn(isbn);
        return super.editar(l);
    }

    public Libro buscarPorIsbn(Long isbn) throws Exception {
        conectar();
        Libro l = (Libro) EM.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn")
                .setParameter("isbn", isbn).getSingleResult();
        return l;
    }

    public Libro buscarPorTitulo(String titulo) throws Exception {
        conectar();
        Libro l = (Libro) EM.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                .setParameter("titulo", "%" + titulo + "%")
                .getSingleResult();
        desconectar();
        return l;
    }

    public List<Libro> buscarPorAutor(String autor) throws Exception {
        conectar();
        List<Libro> libros = EM.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :autor")
                .setParameter("autor", "%" + autor + "%")
                .getResultList();
        desconectar();
        return libros;
    }

    public List<Libro> buscarPorEditorial(String editorial) throws Exception {
        conectar();
        List<Libro> libros = EM.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :editorial")
                .setParameter("editorial", "%" + editorial + "%")
                .getResultList();
        desconectar();
        return libros;
    }

    public List<Libro> listarTodos() throws Exception {
        conectar();
        List<Libro> libros = EM.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();
        return libros;
    }

}
