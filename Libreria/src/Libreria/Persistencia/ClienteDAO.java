package Libreria.Persistencia;

import Libreria.Entidades.Cliente;
import java.util.List;

public final class ClienteDAO extends DAO<Cliente> {

    @Override
    public void eliminar(Cliente c) throws Exception {
        super.eliminar(c);
    }

    @Override
    public Cliente editar(Cliente c) throws Exception {
        return super.editar(c);
    }

    @Override
    public void guardar(Cliente c) throws Exception {
        super.guardar(c);
    }

    public Cliente buscarPorId(String id) throws Exception {
        conectar();
        Cliente c = (Cliente) EM.createQuery("SELECT c FROM Cliente c WHERE c.id LIKE :id")
                .setParameter("id", "%" + id + "%")
                .getSingleResult();
        desconectar();
        return c;
    }

    public List<Cliente> listarTodos() throws Exception {
        conectar();
        List<Cliente> lista = EM.createQuery("SELECT c FROM Cliente c")
                .getResultList();
        desconectar();
        return lista;
    }

    public List<Cliente> buscarPorTelefono(String telefono) throws Exception {
        conectar();
        List<Cliente> lista = EM.createQuery("SELECT c FROM Cliente c WHERE c.telefono LIKE :telefono")
                .setParameter("telefono", "%" + telefono + "%")
                .getResultList();
        desconectar();
        return lista;
    }

    public List<Cliente> buscarPorNombre(String nombre) throws Exception {
        conectar();
        List<Cliente> lista = EM.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre")
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
        desconectar();
        return lista;
    }

    public List<Cliente> buscarPorApellido(String apellido) throws Exception {
        conectar();
        List<Cliente> lista = EM.createQuery("SELECT c FROM Cliente c WHERE c.apellido LIKE :apellido")
                .setParameter("apellido", "%" + apellido + "%")
                .getResultList();
        desconectar();
        return lista;
    }

}
