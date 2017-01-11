/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Compras;
import Clases.Producto;
import Clases.Usuario;
import Modelos.Consulta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "Calificar_Compras", urlPatterns = {"/calificacion"})
public class Calificar_Compras extends HttpServlet {

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
        HttpSession sesion = request.getSession(true);
        Usuario usu = sesion.getAttribute("Usuario") == null ? null : (Usuario) sesion.getAttribute("Usuario");
        
        
        String comentario = request.getParameter("comentario");
        int calificacion = Integer.parseInt(request.getParameter("seleccion_calificacion"));
        int producto_id = Integer.parseInt(request.getParameter("producto_id"));
        int compra_id = Integer.parseInt(request.getParameter("compra_id"));
        
        try (PrintWriter out = response.getWriter()) {
           Consulta consultica = new Consulta();
           consultica.ingresarRanking(producto_id, usu.getId_usuario(), comentario, calificacion);
           consultica.actualizarEstadoCompras(compra_id);
           
           out.println("<script type=\"text/javascript\">");
           //out.println("alert('Calificacion Satisfactoria');");
           out.println("location='calificar_compras.jsp';");
           out.println("</script>");
           
        }
        //response.sendRedirect("calificar_compras.jsp");
        
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
