package Libreria.Persistencia;

import Libreria.Entidades.Editorial;
import java.util.List;

public final class EditorialDAO extends DAO<Editorial> {

    @Override
    public void guardar(Editorial e) throws Exception {
        super.guardar(e);
    }

    public void eliminar(String id) throws Exception {
        Editorial e = buscarPorId(id);
        super.eliminar(e);
    }

    public Editorial editar(String id) throws Exception {
        Editorial e = buscarPorId(id);
        return super.editar(e);
    }

    public Editorial buscarPorId(String id) throws Exception {
        conectar();
        Editorial e = (Editorial) EM.find(Editorial.class, id);
        desconectar();
        return e;
    }

    public List<Editorial> listarTodos() throws Exception {
        conectar();
        List<Editorial> editoriales = EM.createQuery("SELECT e FROM Editorial e")
                .getResultList();
        desconectar();
        return editoriales;
    }

}
