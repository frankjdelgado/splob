/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TUsuario;

/**
 *
 * @author marvin
 */
public class recuperacion extends HttpServlet {

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
        if (request.getParameter("email") == null) {
            this.getServletContext().getRequestDispatcher("/recuperar.jsp").forward(request, response);
        } else {
            ServletContext context = getServletContext();
            EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
            EntityManager em = emf.createEntityManager();
            String passtem = Herramientas.generatePswd(6);
            if (request.getParameter("email").matches("^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$")) {

                TUsuario temp = Herramientas.BuscarPorEmail(em, request.getParameter("email"));
                if (temp != null) {
                    context.log("resultado de busqueda: " + temp);
                    context.log("clave generada: " + passtem);
                    try {
                        em.getTransaction().begin();
                        temp.setPassword(Herramientas.Sha256(passtem));
                        em.getTransaction().commit();

                        request.getServletContext().log("el usuario actualizado es:" + temp.toString());
                        request.setAttribute("exito", "<strong>Clave generada exitosamente. Clave temporal: " + passtem + ".</strong>");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    } catch (ServletException e) {
                        request.getServletContext().log("fallo en registro ", e);
                        request.setAttribute("myerror", "<strong>Error al generar clave de recuperación.</strong>");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);

                    } catch (IOException e) {
                        request.getServletContext().log("fallo en registro ", e);
                        request.setAttribute("myerror", "<strong>Error al generar clave de recuperación.</strong>");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                } else {

                }

            } else {
                request.setAttribute("myerror", "<strong>Error en recuperacion de cLave, email invalido.</strong> Debe ingresar un email valido.");
                request.getRequestDispatcher("/perfil.jsp").forward(request, response);
            }

        }
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
