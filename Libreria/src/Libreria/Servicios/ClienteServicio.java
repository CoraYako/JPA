package Libreria.Servicios;

import Libreria.Entidades.Cliente;
import Libreria.Persistencia.ClienteDAO;
import java.util.List;

public final class ClienteServicio {

    private final ClienteDAO dao;

    public ClienteServicio() {
        dao = new ClienteDAO();
    }

    public Cliente crearYGuardar(Integer documento, String nombre, String apellido, String telefono) throws Exception {
        Cliente c = null;
        validarDatos(documento, nombre, apellido, telefono);
        try {
            c = new Cliente();
            c.setDocumento(documento);
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setTelefono(telefono);
            dao.guardar(c);
        } catch (Exception e) {
            throw e;
        }
        return c;
    }

    public void eliminar(Cliente c) throws Exception {
        if (c == null) {
            throw new Exception("Debe indicar un Cliente válido a eliminar");
        }
        dao.eliminar(c);
    }

    public Cliente editar(Cliente c) throws Exception {
        if (c == null) {
            throw new Exception("Debe indicar un Cliente válido para editar");
        }
        return dao.editar(c);
    }

    public Cliente buscarPorId(String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Debe indicar un ID válido para buscar un Cliente");
        }
        return dao.buscarPorId(id);
    }

    public List<Cliente> listarTodos() throws Exception {
        return dao.listarTodos();
    }

    public List<Cliente> buscarPorTelefono(String telefono) throws Exception {
        if (telefono.trim().isEmpty()) {
            throw new Exception("Debe indicar un teléfono válido para el Cliente a buscar");
        }
        return dao.buscarPorTelefono(telefono);
    }

    public List<Cliente> buscarPorNombre(String nombre) throws Exception {
        if (nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre válido para buscar al Cliente");
        }
        return dao.buscarPorNombre(nombre);
    }

    public List<Cliente> buscarPorApellido(String apellido) throws Exception {
        if (apellido.trim().isEmpty()) {
            throw new Exception("Debe indicar un apellido válido para buscar al Cliente");
        }
        return dao.buscarPorApellido(apellido);
    }

    private void validarDatos(Integer documento, String nombre, String apellido, String telefono) throws Exception {
        if (documento == null || documento < 1) {
            throw new Exception("Debe indicar un DNI válido");
        }
        if (nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre válido");
        }
        if (apellido.trim().isEmpty()) {
            throw new Exception("Debe indicar un apellido válido");
        }
        if (telefono.trim().isEmpty()) {
            throw new Exception("Debe indicar un telefono válido");
        }
    }

}
