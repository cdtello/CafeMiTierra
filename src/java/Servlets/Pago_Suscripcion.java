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
//pagar
/**
 *
 * @author Carlos
 */
@WebServlet(name = "Pago_Suscripcion", urlPatterns = {"/pagar"})
public class Pago_Suscripcion extends HttpServlet {

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
        HttpSession sesion = request.getSession(true);   
        Usuario usu = sesion.getAttribute("Usuario") == null ? null : (Usuario) sesion.getAttribute("Usuario");
        Usuario usuario=new Usuario();
        if(usu.getId_suscripcion().compareTo("1")==0)
        {
            Consulta consultica = new Consulta();
            consultica.actualizarEstado(usu.getId_usuario());
            consultica.actualizarPeriodicidad("0", usu.getId_usuario()); 
            usuario = consultica.Autentificacion(usu.getId_usuario(), usu.getContraseña());
            
        }
        else if(usu.getId_suscripcion().compareTo("2")==0)
        {
            Consulta consultica = new Consulta();
            String id_periodicidad = request.getParameter("select-periodicidad");
            consultica.actualizarPeriodicidad(id_periodicidad, usu.getId_usuario()); 
            consultica.actualizarEstado(usu.getId_usuario()); 
            usuario = consultica.Autentificacion(usu.getId_usuario(), usu.getContraseña());
        }
       
        sesion.setAttribute("Usuario", usuario);
        response.sendRedirect("Principal.jsp");
        
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
            Logger.getLogger(Pago_Suscripcion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Pago_Suscripcion.class.getName()).log(Level.SEVERE, null, ex);
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
