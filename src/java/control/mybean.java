/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.TUsuario;

/**
 * clase de prueba luego veo cuando la elimino
 * @author Marvin
 */
public class mybean {

    private static final String PERSISTENCE_UNIT_NAME = "splobPU";
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public List<TUsuario> getImagenes() {
        return users;
    }
    @PersistenceContext
    private EntityManager em = factory.createEntityManager();
    private TUsuario user;
    private int size;
    List<TUsuario> users;
    
    public mybean() {
    }

    public Long getId() {
        return user.getId();
    }

    public String getAlias() {
        return user.getAlias();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public int getSize() {
        return users.size();
    }

    public void setSize(int size) {
        
        Query query = em.createNamedQuery("Usuarios.findAll");
        users = query.getResultList();
        this.size = users.size();
    }
    
    public void setId(Long id) {
        user = em.find(TUsuario.class, id);
        if (user == null) {
            user = new TUsuario(id);
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            user = em. find(TUsuario.class, id);
        }
        
    }

    public void setAlias(String alias) throws IOException {
        em.getTransaction().begin();
        user.setAlias(alias);
        em.getTransaction().commit();
    }

    public void setPassword(String password) throws IOException {
        em.getTransaction().begin();
        user.setPassword(password);
        em.getTransaction().commit();
    }

    public void setEmail(String email) throws IOException {
        em.getTransaction().begin();
        user.setEmail(email);
        em.getTransaction().commit();
    }

    public void remove() {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }
}
