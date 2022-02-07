package Libreria.Persistencia;

import Libreria.Entidades.Editorial;

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
        return EM.find(Editorial.class, id);
    }

}
