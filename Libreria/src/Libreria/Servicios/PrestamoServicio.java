package Libreria.Servicios;

import Libreria.Entidades.Cliente;
import Libreria.Entidades.Libro;
import Libreria.Entidades.Prestamo;
import Libreria.Persistencia.PrestamoDAO;
import java.util.Date;
import java.util.List;

public final class PrestamoServicio {

    private final PrestamoDAO dao;

    public PrestamoServicio() {
        dao = new PrestamoDAO();
    }

    public Prestamo crearYGuardar(Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) throws Exception {
        Prestamo p = null;
        validar(fechaPrestamo, fechaDevolucion, libro, cliente);
        try {
            p = new Prestamo();
            p.setLibro(libro);
            p.setCliente(cliente);
            p.setFechaPrestamo(fechaPrestamo);
            p.setFechaDevolucion(fechaDevolucion);
        } catch (Exception e) {
            throw e;
        }
        return p;
    }

    public Prestamo editar(Prestamo p) throws Exception {
        if (p == null) {
            throw new Exception("Debe indicar un préstamo a editar");
        }
        return dao.editar(p);
    }

    public void eliminar(Prestamo p) throws Exception {
        if (p == null) {
            throw new Exception("Debe indicar un préstamo a eliminar");
        }
        dao.eliminar(p);
    }

    public List<Prestamo> listarTodos() throws Exception {
        return dao.listarTodos();
    }

    public List<Prestamo> listarPrestamoPorIdCliente(String id) throws Exception {
        return dao.listarPrestamosPorIdCliente(id);
    }

    private void validar(Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) throws Exception {
        if (fechaPrestamo == null) {
            throw new Exception("Debe indicar una fecha de préstamo");
        }
        if (fechaDevolucion == null) {
            throw new Exception("Debe indicar una fecha de devolución");
        }
        if (libro == null) {
            throw new Exception("Debe indicar un libro");
        }
        if (cliente == null) {
            throw new Exception("Debe indicar un cliente");
        }
    }
}
