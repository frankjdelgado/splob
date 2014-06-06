package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TPost;
import model.TUsuario;

/**
 *
 * @author marvin
 */
public class crearevento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //this.getServletContext().log("log");
        if (!request.getParameter("contenido").isEmpty()) {
            try {
                Date dia = new Date();
                TPost post = new TPost();
                
                //this.getServletContext().log("fecha: " + (new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fecha"))));
                post.setFechaCreacion(dia);
                post.setContenido(request.getParameter("contenido"));
                post.setImagen(request.getParameter("imagen"));
                post.setUsuario((TUsuario) request.getSession().getAttribute("usuario"));
                //this.getServletContext().log("fecha antes : " + request.getParameter("fecha"));
                String tem = request.getParameter("fecha");
                //this.getServletContext().log("fecha despues : " + tem);
                post.setFechaCalendario(new SimpleDateFormat("yyyy-MM-dd").parse(tem));
                post.setTipo(true);
                
                EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
                EntityManager em = emf.createEntityManager();
                
                em.getTransaction().begin();
                em.persist(post);
                em.getTransaction().commit();
            } catch (ParseException ex) {
                Logger.getLogger(crearevento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("Calendario");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
