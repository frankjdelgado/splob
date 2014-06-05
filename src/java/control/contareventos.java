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

/**
 *
 * @author marvin
 */
@WebServlet(name = "contareventos", urlPatterns = {"/ContarEventos"})
public class contareventos extends HttpServlet {

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

        List lista = em.createNativeQuery("SELECT COUNT(id) as total, fecha_calendario from t_post WHERE tipo=1 GROUP BY DAY(fecha_calendario)").
                getResultList();
        this.getServletContext().log("tamaño de la lista:" + lista.size());
        out.print("[");

        SimpleDateFormat pars = new SimpleDateFormat("yyyy-MM-dd");

        for (Iterator it = lista.iterator(); it.hasNext();) {
            Object[] obj = (Object[]) it.next();
            if (((Long) obj[0])>1)
                out.print("{\"title\": \"" + (Long) obj[0] + " Eventos\",");
            else
                out.print("{\"title\": \"" + (Long) obj[0] + " Evento\",");
            out.print("\"start\": \"" + pars.format((Date) obj[1]) + "\",");
            out.print("\"url\": \"Eventos?fecha=" + pars.format((Date) obj[1]) + "\"}");
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
