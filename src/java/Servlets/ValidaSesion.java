/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Usuario;
import Modelos.Consulta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//validar
/**
 *
 * @author Carlos
 */
@WebServlet(name = "ValidaSesion", urlPatterns = {"/validar"})
public class ValidaSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String Usuario = request.getParameter("EditUsuario");
        String Password = request.getParameter("EditPass");
                try (PrintWriter out = response.getWriter()) {
            Usuario u;
            Consulta consultica = new Consulta(); 
            u = consultica.Autentificacion(Usuario, Password);

            
            if (u.getId_usuario().compareTo("")==0 || (u.getContraseña().compareTo(""))==0)
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Acceso Denegado');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }
            
            else if (u.getId_usuario().compareTo(Usuario)==0 && (u.getContraseña().compareTo(Password))==0)
            {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("Usuario", u);   
                if(u.getEstado()==false && u.getId_suscripcion().compareTo("3")!=0 )
                {
                    response.sendRedirect("pago-suscripcion.jsp");
                }
                else 
                {
                    response.sendRedirect("Principal.jsp");                
                }
                

            }

            else
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Acceso Denegado');");
                out.println("location='index.jsp';");
                out.println("</script>");
                //response.sendRedirect("index.html");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidaSesion.class.getName()).log(Level.SEVERE, null, ex);
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
