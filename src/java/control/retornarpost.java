/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TPost;
import model.TUsuario;

/**
 *
 * @author marvin
 */
@WebServlet(name = "retornarpost", urlPatterns = {"/Publicaciones"})
public class retornarpost extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        int offset;
        try {
            offset = Integer.parseInt(request.getParameter("pag"));
        } catch (NumberFormatException e) {
            offset = 0;
        }

        offset = (offset <= 1) ? 0 : (offset - 1) * 8;
        TUsuario u = (TUsuario) request.getSession().getAttribute("usuario");
        List<TPost> lista = (List<TPost>) em.createNamedQuery("TPost.findByTipoOrderDesc").setParameter("tipo", false).setFirstResult(offset).setMaxResults(8).getResultList();

        this.getServletContext().log("tamaño de la lista:" + lista.size());
//        this.getServletContext().log("elemento 1:" + lista.get(0));
//        this.getServletContext().log("elemento 2:" + lista.get(1));
        out.print("[");

//        SimpleDateFormat pars = new SimpleDateFormat("yyyy-MM-dd");
//
//        for (Iterator it = lista.iterator(); it.hasNext();) {
//            Object[] obj = (Object[]) it.next();
//            out.print("{\"title\": \"" + (Long) obj[0] + " Eventos\",");
//            out.print("\"start\": \"" + pars.format((Date) obj[1]) + "\",");
//            out.print("\"url\": \"http://www.google.com/your_feed_url/" + pars.format((Date) obj[1]) + "\"}");
//            if (it.hasNext()) {
//                out.print(",");
//            }
//        }
        if (u == null) {
            u = new TUsuario();
        }
        for (Iterator<TPost> it = lista.iterator(); it.hasNext();) {
            TPost tPost = it.next();

            out.print("{\"id\": " + tPost.getId() + ",");
            out.print("\"content\": \"" + tPost.getContenido() + "\",");
            out.print("\"img\": \"" + tPost.getImagen() + "\",");
            out.print("\"username\": " + (tPost.getUsuario().getId() == u.getId()) + "}");
            if (it.hasNext()) {
                out.print(",");
            }
        }

        out.print("]");
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
