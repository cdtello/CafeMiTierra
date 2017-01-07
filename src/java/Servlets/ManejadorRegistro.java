/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.EnviarCorreo;
import Modelos.Registro;
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


/**
 *
 * @author Carlos
 */
@WebServlet(name = "ManejadorRegistro", urlPatterns = {"/ManejadorRegistro"})
public class ManejadorRegistro extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nombre = request.getParameter("EditNombre");
        String apellido = request.getParameter("EditApellido");
        String id = request.getParameter("EditIdentificacion");
        String usuario = request.getParameter("EditUsuario");
        String pass = request.getParameter("EditPass");
        String Cpass = request.getParameter("EditCPass");
        String correo = request.getParameter("EditCorreo");
        String direccion = request.getParameter("EditDireccion");
        String domicilio = request.getParameter("EditDomicilio");
        String suscripcion = request.getParameter("ComboSuscripcion");
        
        try (PrintWriter out = response.getWriter()) {
          /* out.println(nombre);
           out.println(apellido);
           out.println(id);
           out.println(usuario);
           out.println(pass);
           out.println(Cpass);
           out.println(correo);
           out.println(direccion);
           out.println(domicilio);
           out.println(suscripcion);*/
            if((nombre.compareTo("")==0   )||(apellido.compareTo("")==0   )||(usuario.compareTo("")==0)||(id.compareTo("")==0   )||(pass.compareTo("")==0   )
                    ||(correo.compareTo("")==0   )||(direccion.compareTo("")==0)||(domicilio.compareTo("")==0)||(suscripcion.compareTo("")==0 || (Cpass.compareTo("")==0)))
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Todos Los Campos Deben Estar LLenos');");
                out.println("location='registro.jsp';");
                out.println("</script>");
                //response.sendRedirect("registro.jsp");
            }
            else if(Cpass.compareTo(pass)!=0)
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('No Coincide Password');");
                out.println("location='registro.jsp';");
                out.println("</script>");
            }
            else 
            {
                
                Registro reg = new Registro();
                EnviarCorreo correito = new EnviarCorreo();
                reg.Ingreso(usuario,pass,nombre,apellido,id,correo,direccion,domicilio,suscripcion);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Registro Correcto');");
                out.println("location='Login.jsp';");
                out.println("</script>");
                correito.emailRegistro(usuario, correo, pass, suscripcion);
                
                //response.sendRedirect("index.html");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
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
