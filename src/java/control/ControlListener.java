/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import model.TEquipo;

/**
 * Web application lifecycle listener.
 *
 * @author marvin
 */
@WebListener()
public class ControlListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("splobPU");
        
 
        EntityManager em = emf.createEntityManager();
        List<TEquipo> equipos = em.createNamedQuery("TEquipo.findAll").getResultList();
        sce.getServletContext().setAttribute("emf", emf);
        sce.getServletContext().setAttribute("equipos", equipos);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactory emf = (EntityManagerFactory)sce.getServletContext().getAttribute("emf");
        emf.close();
    }
    
}
