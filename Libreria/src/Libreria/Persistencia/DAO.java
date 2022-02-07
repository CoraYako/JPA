package Libreria.Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> {

    protected EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
    protected EntityManager EM = EMF.createEntityManager();

    protected void conectar() throws Exception {
        if (!EM.isOpen()) {
            EM = EMF.createEntityManager();
        }
    }

    protected void desconectar() throws Exception {
        if (EM.isOpen()) {
            EM.close();
        }
    }

    protected void guardar(T objeto) throws Exception {
        conectar();
        EM.getTransaction().begin();
        EM.persist(objeto);
        EM.getTransaction().commit();
        desconectar();
    }

    protected T editar(T objeto) throws Exception {
        conectar();
        EM.getTransaction().begin();
        T ob = EM.merge(objeto);
        EM.getTransaction().commit();
        desconectar();

        return ob;
    }

    protected void eliminar(T objeto) throws Exception {
        conectar();
        EM.getTransaction().begin();
        EM.remove(objeto);
        EM.getTransaction().commit();
        desconectar();
    }

}
