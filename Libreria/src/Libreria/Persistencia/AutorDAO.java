package Libreria.Persistencia;

import Libreria.Entidades.Autor;
import java.util.List;

public final class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor a) throws Exception {
        super.guardar(a);
    }

    @Override
    public void eliminar(Autor a) throws Exception {
        super.eliminar(a);
    }

    @Override
    public Autor editar(Autor a) throws Exception {
        return super.editar(a);
    }

    public Autor buscarPorId(String id) throws Exception {
        conectar();
        Autor a = (Autor) EM.find(Autor.class, id);
        desconectar();
        return a;
    }

    public List<Autor> buscarPorNombre(String nombre) throws Exception {
        conectar();
        List<Autor> autores = EM.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
        desconectar();
        return autores;
    }

    public List<Autor> listarTodos() throws Exception {
        conectar();
        List<Autor> autores = EM.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autores;
    }

}
