package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Persistencia.AutorDAO;
import java.util.List;

public class AutorServicio {

    private final AutorDAO dao;

    public AutorServicio() {
        dao = new AutorDAO();
    }

    public Autor guardar(String nombre) throws Exception {
        if (nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre válido");
        }

        Autor a = new Autor();

        a.setNombre(nombre);
        a.setAlta(true);

        dao.guardar(a);
        return a;
    }

    public void eliminar(String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Debe indicar un id válido");
        }
        dao.eliminar(id);
    }

    public Autor editar(String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Debe indicar un id válido");
        }
        return dao.editar(id);
    }

    public Autor buscarPorId(String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Debe indicar un id válido");
        }
        return dao.buscarPorId(id);
    }

    public List<Autor> listarTodos() throws Exception {
        return dao.listarTodos();
    }

}
