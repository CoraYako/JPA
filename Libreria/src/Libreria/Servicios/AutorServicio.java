package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Persistencia.AutorDAO;
import java.util.List;

public final class AutorServicio {

    private final AutorDAO dao;

    public AutorServicio() {
        dao = new AutorDAO();
    }

    public Autor crearYGuardar(String nombre) throws Exception {
        if (nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre válido");
        }

        Autor a = new Autor();

        a.setNombre(nombre);
        a.setAlta(true);

        dao.guardar(a);
        return a;
    }

    public void eliminar(Autor a) throws Exception {
        if (a == null) {
            throw new Exception("Debe indicar un Autor válido");
        }
        dao.eliminar(a);
    }

    public Autor editar(Autor a) throws Exception {
        if (a == null) {
            throw new Exception("Debe indicar un Autor válido");
        }
        return dao.editar(a);
    }

    public Autor buscarPorId(String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Debe indicar un id válido");
        }
        return dao.buscarPorId(id);
    }

    public List<Autor> buscarPorNombre(String nombre) throws Exception {
        if (nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre válido");
        }
        return dao.buscarPorNombre(nombre);
    }

    public List<Autor> listarTodos() throws Exception {
        return dao.listarTodos();
    }

}
