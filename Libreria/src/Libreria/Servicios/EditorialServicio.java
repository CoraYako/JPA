package Libreria.Servicios;

import Libreria.Entidades.Editorial;
import Libreria.Persistencia.EditorialDAO;
import java.util.List;

public final class EditorialServicio {

    private final EditorialDAO dao;

    public EditorialServicio() {
        dao = new EditorialDAO();
    }

    public Editorial guardar(String nombre) throws Exception {
        if (nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre válido");
        }
        Editorial e = new Editorial();

        e.setNombre(nombre);
        e.setAlta(true);

        dao.guardar(e);
        return e;
    }

    public void eliminar(String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Debe indicar un id válido");
        }
        dao.eliminar(id);
    }

    public Editorial editar(String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Debe indicar un id válido");
        }
        return dao.editar(id);
    }

    public Editorial buscarPorId(String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Debe indicar un id válido");
        }
        return dao.buscarPorId(id);
    }

    public List<Editorial> listarTodos() throws Exception {
        return dao.listarTodos();
    }

}
