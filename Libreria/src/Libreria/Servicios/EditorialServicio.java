package Libreria.Servicios;

import Libreria.Entidades.Editorial;
import Libreria.Persistencia.EditorialDAO;
import java.util.List;

public final class EditorialServicio {

    private final EditorialDAO dao;

    public EditorialServicio() {
        dao = new EditorialDAO();
    }

    public Editorial crearYGuardar(String nombre) throws Exception {
        if (nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre válido");
        }
        Editorial e = new Editorial();

        e.setNombre(nombre);
        e.setAlta(true);

        dao.guardar(e);
        return e;
    }

    public void eliminar(Editorial e) throws Exception {
        if (e == null) {
            throw new Exception("Debe indicar un Editorial válido");
        }
        dao.eliminar(e);
    }

    public Editorial editar(Editorial e) throws Exception {
        if (e == null) {
            throw new Exception("Debe indicar un Editorial válido");
        }
        return dao.editar(e);
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
