package Libreria.Persistencia;

import Libreria.Entidades.Autor;
import java.util.List;

public final class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor a) throws Exception {
        super.guardar(a);
    }

    public void eliminar(String id) throws Exception {
        Autor a = buscarPorId(id);
        super.eliminar(a);
    }

    public Autor editar(String id) throws Exception {
        Autor a = buscarPorId(id);
        return super.editar(a);
    }

    public Autor buscarPorId(String id) throws Exception {
        conectar();
        Autor a = (Autor) EM.find(Autor.class, id);
        desconectar();
        return a;
    }

    public List<Autor> listarTodos() throws Exception {
        conectar();
        List<Autor> autores = EM.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autores;
    }

}
