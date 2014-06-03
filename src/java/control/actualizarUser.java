/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
public class actualizarUser extends HttpServlet {

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
        //obtengo el em
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        //creo al ususario
        TUsuario u = new TUsuario();
        String error;

        if (request.getParameter("password") == null) {
            if (request.getParameter("username").matches("[a-zA-z0-9][a-zA-z0-9]{3,}")) {
                u.setAlias(request.getParameter("username"));
            } else {
                error = "<strong>Error de Registro, apodo invalido.</strong> Debe ser de empezar con una letra y tener un largo mayor o igual a 3.";
                request.setAttribute("myerror", error);
                request.getRequestDispatcher("/perfil.jsp").forward(request, response);
                return;
            }
            if (request.getParameter("email").matches("^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$")) {
                u.setEmail(request.getParameter("email"));
            } else {
                error = "<strong>Error de Registro, email invalido.</strong> Debe ingresar un email valido.";
                request.setAttribute("myerror", error);
                request.getRequestDispatcher("/perfil.jsp").forward(request, response);
                return;
            }

            try {
                TUsuario aux = em.find(TUsuario.class, ((TUsuario) request.getSession().getAttribute("usuario")).getId());

                em.getTransaction().begin();
                //em.merge(u); //em.merge(u); for updates
                //em.flush();
                aux.setAlias(u.getAlias());
                aux.setEmail(u.getEmail());
                em.getTransaction().commit();

                //aca mandar a
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", aux);
                //response.sendRedirect("AdministracionUsuario.mvc");
                request.getServletContext().log("el usuario insertado es:" + u);
                request.setAttribute("exito", "Exito");
                request.getRequestDispatcher("/perfil.jsp").forward(request, response);
            } catch (ServletException e) {
                error = "<strong>Error de Registro, fallo al guardar.</strong>";
                request.setAttribute("myerror", error);
                request.getRequestDispatcher("/perfil.jsp").forward(request, response);
                request.getServletContext().log("fallo en registro ", e);
            } catch (IOException e) {
                error = "<strong>Error de Registro, fallo al guardar.</strong>";
                request.setAttribute("myerror", error);
                request.getRequestDispatcher("/perfil.jsp").forward(request, response);
                request.getServletContext().log("fallo en registro ", e);
            }
        } else {
            if (request.getParameter("password").equals(request.getParameter("password2")) && request.getParameter("password").length()>0) {
                u.setPassword(Herramientas.Sha256(request.getParameter("password")));
            } else {
                error = "<strong>Error de Registro, fallo confirmación de contraseña.</strong>";
                request.setAttribute("myerror", error);
                request.getRequestDispatcher("/perfil.jsp").forward(request, response);
                return;
            }
            try {
                String newpass = Herramientas.Sha256(request.getParameter("password"));
                TUsuario aux = em.find(TUsuario.class, ((TUsuario) request.getSession().getAttribute("usuario")).getId());

                em.getTransaction().begin();
                //em.merge(u); //em.merge(u); for updates
                //em.flush();
                aux.setPassword(newpass);
                em.getTransaction().commit();

                //aca mandar a
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", aux);
                //response.sendRedirect("AdministracionUsuario.mvc");
                request.getServletContext().log("el usuario insertado es:" + u);
                request.setAttribute("exito", "<strong>Cambios realizada satisfactoriamente.</strong>");
                request.getRequestDispatcher("/perfil.jsp").forward(request, response);
            } catch (Exception e) {
                error = "<strong>Error de Registro, fallo al guardar.</strong>";
                request.setAttribute("myerror", error);
                request.getRequestDispatcher("/perfil.jsp").forward(request, response);
                request.getServletContext().log("fallo en registro ", e);
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
