package Libreria.Servicios;

import Libreria.Entidades.Cliente;
import Libreria.Entidades.Libro;
import Libreria.Entidades.Prestamo;
import Libreria.Persistencia.PrestamoDAO;
import java.util.Date;

public final class PrestamoServicio {
    
    private final PrestamoDAO dao;

    public PrestamoServicio() {
        dao = new PrestamoDAO();
    }
    
    public Prestamo crearYGuardar() {
        
    }
    
    private void validar(Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) throws Exception {
        if (fechaPrestamo == null) {
            throw new Exception("Debe indicar una fecha de préstamo");
        }
        if (fechaDevolucion == null) {
            throw new Exception("Debe indicar una fecha de devolucion");
        }
        if (true) {
            
        }
    }
}
