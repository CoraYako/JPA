package Libreria.Persistencia;

import Libreria.Entidades.Prestamo;
import java.util.List;

public final class PrestamoDAO extends DAO<Prestamo> {

    @Override
    public void guardar(Prestamo p) throws Exception {
        super.guardar(p);
    }

    @Override
    public Prestamo editar(Prestamo p) throws Exception {
        return super.editar(p);
    }

    @Override
    public void eliminar(Prestamo p) throws Exception {
        super.eliminar(p);
    }

    public List<Prestamo> listarPrestamosPorIdCliente(String id) throws Exception {
        conectar();
        List<Prestamo> lista = EM.createQuery("SELECT p.libro FROM Prestamo p WHERE p.cliente.id LIKE :id")
                .setParameter("id", id)
                .getResultList();
        desconectar();
        return lista;
    }

    public List<Prestamo> listarTodos() throws Exception {
        conectar();
        List<Prestamo> lista = EM.createQuery("SELECT p FROM Prestamo p")
                .getResultList();
        desconectar();
        return lista;
    }

}
