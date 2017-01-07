/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Clases.Producto;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Carlos
 */
public class ModeloProducto extends Conexion{
    public ArrayList <Producto> getAllProductos(){
        ArrayList <Producto> productos = new ArrayList();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String sql = "select * from productos";
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                productos.add(new Producto(rs.getInt("id_producto"),rs.getString("nombre"),
                rs.getString("descripcion"),rs.getString("imagen"),rs.getInt("costo"),
                rs.getInt("precio"),rs.getInt("descuento"),rs.getInt("cantidad"),
                rs.getString("fecha_creacion"),rs.getString("id_categoria"),rs.getString("id_region"),
                rs.getString("id_finca"),rs.getString("id_variedad"),rs.getString("id_perfil"),
                rs.getString("id_cosecha"),rs.getBoolean("estado")));
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        
        return productos;
    }
    
    public Producto getProducto(int id){
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String sql = "select * from productos where id_producto = "+id;
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                producto =new Producto(rs.getInt("id_producto"),rs.getString("nombre"),
                rs.getString("descripcion"),rs.getString("imagen"),rs.getInt("costo"),
                rs.getInt("precio"),rs.getInt("descuento"),rs.getInt("cantidad"),
                rs.getString("fecha_creacion"),rs.getString("id_categoria"),rs.getString("id_region"),
                rs.getString("id_finca"),rs.getString("id_variedad"),rs.getString("id_perfil"),
                rs.getString("id_cosecha"),rs.getBoolean("estado"));
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        
        return producto;
    }
    
    public static void main(String[] args){
        ModeloProducto mp = new ModeloProducto();
        
        for(Producto p : mp.getAllProductos())
        {
            System.out.println(p.getNombre());
        } 
    }
}
