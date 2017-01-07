/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Producto;
import Modelos.ModeloProducto;
import java.text.DecimalFormat;

/**
 *
 * @author Carlos
 */
public class ControladorProductos {
    public String getProductos()
    {
        ModeloProducto mp = new ModeloProducto();
        String htmlcodigo = "";
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        for(Producto producto : mp.getAllProductos())
        {
            htmlcodigo += "<div class=\"col-sm-4\">\n" +
"				<div class=\"product-image-wrapper\">\n" +
"					<div class=\"single-products\">\n" +
"                               		<div class=\"productinfo text-center\">\n" +
"							<img src=\""+producto.getImagen()+"\" alt=\"\" width=\"120\" height=\"150\" />\n" +
"							<h2>"+"$ "+formatea.format(producto.getPrecio())+"</h2>\n" +
"							<p>"+producto.getNombre()+"</p>\n" +
"							<a href=\"product-details.jsp?id="+producto.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalle</a>\n" +
"						</div>\n" +
"						<div class=\"product-overlay\">\n" +
"							<div class=\"overlay-content\">\n" +
"								<h2>"+"$ "+formatea.format(producto.getPrecio())+"</h2>\n" +
"								<p>"+producto.getNombre()+"</p>\n" +
"								<a href=\"product-details.jsp?id="+producto.getId()+"\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalle</a>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +				
"				</div>\n" +
"			</div>" ;
        }
        return htmlcodigo;
    }
    
    public Producto getProducto(int id){
    return new ModeloProducto().getProducto(id);
    }
    
}
