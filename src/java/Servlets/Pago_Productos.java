/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Articulo;
import Clases.Producto;
import Clases.Usuario;
import Controladores.ControladorProductos;
import Modelos.Consulta;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//pagar_pedido
/**
 *
 * @author Carlos
 */
@WebServlet(name = "Pago_Productos", urlPatterns = {"/pagar_pedido"})
public class Pago_Productos extends HttpServlet {

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
        ArrayList <Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
        Usuario usu = sesion.getAttribute("Usuario") == null ? null : (Usuario) sesion.getAttribute("Usuario");
        
        ControladorProductos cp = new ControladorProductos();
        Consulta con = new Consulta();
        int total = 0;
        for(Articulo a : articulos)
        {
            Producto producto = cp.getProducto(a.getIdProducto());
            total = total + (a.getCantidad() * producto.getPrecio());
        }
        con.ingresarFactura(usu.getId_usuario(), total);
        int factura = con.obtenerUltimaFactura(usu.getId_usuario());
        for(Articulo a : articulos)
        {
            Producto producto = cp.getProducto(a.getIdProducto());
            con.ingresarCompra(factura, a.getIdProducto(), usu.getId_usuario(), a.getCantidad(), a.getCantidad()*producto.getPrecio());
        }
        sesion.setAttribute("carrito", null);
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
