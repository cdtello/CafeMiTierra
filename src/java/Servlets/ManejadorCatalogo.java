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
@WebServlet(name = "ManejadorCatalogo", urlPatterns = {"/ManejadorCatalogo"})
public class ManejadorCatalogo extends HttpServlet {

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
        
        String id_producto = request.getParameter("EditIdProducto");
        String nombre = request.getParameter("EditNombreProducto");
        String precio = request.getParameter("EditPrecioProducto");
        String cantidad = request.getParameter("EditCantidadProducto");
        String costo = request.getParameter("EditCostoProducto");
        String descuento = request.getParameter("EditDescuentoProducto");
        String id_finca = request.getParameter("EditFinca");
        String imagen = request.getParameter("Ruta");
        String id_categoria = request.getParameter("SeleccionTipo");
        String id_region = request.getParameter("SeleccionRegion");
        String id_variedad = request.getParameter("SeleccionVariedad");
        String id_cosecha = request.getParameter("SeleccionCosecha");       
        String id_perfil = request.getParameter("SeleccionPerfil");
        String descripcion = request.getParameter("AreaDescripcion");
         
        
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
            if((id_producto.compareTo("")==0   )||(nombre.compareTo("")==0   )||(precio.compareTo("")==0)||(cantidad.compareTo("")==0   )||(costo.compareTo("")==0   )
                    ||(descuento.compareTo("")==0   )||(id_finca.compareTo("")==0)||(imagen.compareTo("")==0)||(id_categoria.compareTo("")==0 || (id_region.compareTo("")==0))
                    ||(id_variedad.compareTo("")==0   )||(id_cosecha.compareTo("")==0)||(id_perfil.compareTo("")==0 || (descripcion.compareTo("")==0)))
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Todos Los Campos Deben Estar LLenos');");
                out.println("location='catalogo.jsp';");
                out.println("</script>");
                //response.sendRedirect("registro.jsp");
            }

            else 
            {
                
                Registro reg = new Registro();
                //EnviarCorreo correito = new EnviarCorreo();
                reg.IngresoProductos (id_producto, nombre, descripcion, imagen, precio);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Registro Correcto');");
                out.println("location='crear_productos.jsp';");
                out.println("</script>");
                //correito.emailRegistro(usuario, correo, pass, suscripcion);
                
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
