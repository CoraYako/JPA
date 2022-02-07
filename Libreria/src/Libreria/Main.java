package Libreria;

import Libreria.Entidades.Libro;
import Libreria.Servicios.LibroServicio;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LibroServicio ls = new LibroServicio();

        try {
            List<Libro> libros = ls.listarTodos();
            
            if (libros.isEmpty()) {
                System.out.println("La lista está vacía");
            }
        } catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
        }

    }

}
