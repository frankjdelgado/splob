/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
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
public class ingresar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        TUsuario u = new TUsuario();
        context.log("verificar el email");
        if (request.getParameter("email").matches("^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$")) {
            context.log("Buscando por email");
            u = Herramientas.BuscarPorEmail(em, request.getParameter("email"));
            if (u != null) {context.log("encontro algo");
                if (u.getPassword().equalsIgnoreCase(Herramientas.Sha256(request.getParameter("password")))) {context.log("deberia ingresar");
                    //creo HttpSession para el manejo de la session
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("usuario", u);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {context.log("no da la clave igual");
                    request.setAttribute("myerror", "<strong>Error al iniciar sesión, Clave incorrecta.</strong>");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } else {context.log("no se encontro nada");
                //redirir a inicio o mandar un json con error
                request.setAttribute("myerror", "<strong>Error al iniciar sección, correo no valido.</strong>");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } else {context.log("email malo");
            request.setAttribute("myerror", "<strong>Error al iniciar sesión, correo invalido.</strong> Debe ingresar un correo valido.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
        return "Info del servlet de ingreso";
    }// </editor-fold>

}
