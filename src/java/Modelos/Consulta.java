/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Clases.Compras;
import Clases.Periodicidad;
import Clases.Puntuacion;
import Clases.Ranking;
import Clases.Suscripcion;
import Clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Consulta extends Conexion{
    
    Conexion conectar = new Conexion();
    ResultSet respuesta;
    Statement instruccion;
    public Usuario Autentificacion (String user,String pass) throws SQLException
    {
        Connection con = conectar.conectarABD();
        instruccion = con.createStatement();
        Usuario usu = new Usuario();
        String Consulta = "Select * from usuarios";
        respuesta = instruccion.executeQuery(Consulta);
        conectar.cerrarConexion(con);
        while(respuesta.next())
        {
            if(user.equals(respuesta.getString("id_usuario")) && pass.equals(respuesta.getString("contraseña")))
            {
                usu.setId_suscripcion(respuesta.getString("id_suscripcion"));
                usu.setId_periodicidad(respuesta.getString("id_periodicidad"));
                usu.setId_usuario(respuesta.getString("id_usuario"));
                usu.setId_identificacion(respuesta.getString("id_identificacion"));
                usu.setContraseña(respuesta.getString("contraseña"));
                usu.setNombres(respuesta.getString("nombres"));
                usu.setApellidos(respuesta.getString("apellidos"));
                usu.setCorreo(respuesta.getString("correo"));
                usu.setDireccion(respuesta.getString("direccion"));
                usu.setDomicilio(respuesta.getString("domicilio"));
                usu.setEstado(respuesta.getBoolean("estado"));
                usu.setFecha_creacion(respuesta.getString("fecha_creacion"));
                usu.setUltimo_ingreso(respuesta.getString("ultimo_ingreso"));
         
                return usu;            
            }
        }
        return usu;
    }
    
     public Suscripcion obtenerSuscripcion(String id_suscripcion){
        Suscripcion suscripcion = new Suscripcion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String sql = "select * from suscripcion where id_suscripcion = '"+id_suscripcion+"'";
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                //System.out.println(suscripcion.getNombre());
                       
                    suscripcion =new Suscripcion(rs.getString("id_suscripcion"),rs.getString("nombre"),rs.getInt("costo"));
                    
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        return suscripcion;
    }
         public Periodicidad obtenerPeriodicidad(String id_periodicidad){
        Periodicidad periodicidad = new Periodicidad();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String sql = "select * from suscripcion where id_suscripcion = '"+id_periodicidad+"'";
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                //System.out.println(suscripcion.getNombre());
                       
                    periodicidad =new Periodicidad(rs.getString("id_periodicidad"),rs.getString("nombre"),rs.getInt("costo"));
                    
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        return periodicidad;
    }
     
    public void actualizarSuscripcion(String suscripcion, String id_usuario) {
        try {
            String createTable = "update usuarios set id_suscripcion = '"+suscripcion+"'\n" +
                                 "where id_usuario = '"+id_usuario+"'";
            Statement statement = conectarABD().createStatement();
            boolean rs = statement.execute(createTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void actualizarEstado(String id_usuario) {
        try {
            String createTable = "update usuarios set estado = True\n" +
                                 "where id_usuario = '"+id_usuario+"'";
            Statement statement = conectarABD().createStatement();
            boolean rs = statement.execute(createTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void actualizarPeriodicidad(String periodicidad,String id_usuario) {
        try {
            String createTable = "update usuarios set id_periodicidad = '"+periodicidad+"'\n" +
                                 "where id_usuario = '"+id_usuario+"'";
            Statement statement = conectarABD().createStatement();
            boolean rs = statement.execute(createTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ingresarCompra(int id_factura,int id_producto, String id_usuario, int cantidad, int total) {
        try {
            String createTable = "insert into compras(id_factura, id_producto, id_usuario, cantidad, total, estado)\n" +
                                 "values("+id_factura+","+id_producto+",'"+id_usuario+"',"+cantidad+","+total+",False)";
            Statement statement = conectarABD().createStatement();
            boolean rs = statement.execute(createTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    public void ingresarFactura(String id_usuario,int total) {
        try {
            String createTable = "insert into facturas(id_usuario, total, fecha)\n" +
                                 "values ('"+id_usuario+"',"+total+",now())";
            Statement statement = conectarABD().createStatement();
            boolean rs = statement.execute(createTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
    public int obtenerUltimaFactura(String id_usuario){
        Periodicidad periodicidad = new Periodicidad();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int resultado = 0;
        try{
            String sql = "SELECT id_factura FROM facturas\n" +
                         "where id_usuario = '"+id_usuario+"'\n" +
                         "ORDER BY fecha desc LIMIT 1;";
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {              
                resultado = rs.getInt("id_factura");                   
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        return resultado;
    }
    public void ingresarRanking(int id_producto, String id_usuario, String comentario, int calificacion) {
        try {
            String createTable = "insert into ranking(id_producto, id_usuario, comentario, calificacion)\n" +
                                "values("+id_producto+",'"+id_usuario+"','"+comentario+"',"+calificacion+")";
            Statement statement = conectarABD().createStatement();
            boolean rs = statement.execute(createTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }   
    public int obtenerPromedioRanking(int id_producto){
        Periodicidad periodicidad = new Periodicidad();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int resultado = 0;
        try{
            String sql = "select * from\n" +
                         "(select id_producto, avg(calificacion) calificacion from ranking\n" +
                         "group by id_producto)as resultado\n" +
                         "where id_producto = "+id_producto+"";
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {              
                resultado = rs.getInt("calificacion");                   
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        return resultado;
    }
    public ArrayList <Compras> comprasNoCalificadas(String id_usuario){
        ArrayList <Compras> compras = new ArrayList();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String sql = "select * from compras\n" +
                         "where id_usuario = '"+id_usuario+"' and estado = false";
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                compras.add(new Compras(rs.getInt("id_compra"), rs.getInt("id_factura"), rs.getInt("id_producto"), rs.getString("id_usuario"), rs.getInt("cantidad"), rs.getInt("total"), rs.getBoolean("estado")));
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        
        return compras;
    }

    public ArrayList <Ranking> obtenerRankingProducto(int id_producto){
        ArrayList <Ranking> ranking = new ArrayList();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String sql = "select * from ranking\n" +
                         "where id_producto = "+id_producto+"";
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                ranking.add(new Ranking(rs.getInt("id_ranking"), rs.getInt("id_producto"), rs.getString("id_usuario"), rs.getString("comentario"), rs.getInt("calificacion")));
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        
        return ranking;
    }
    public ArrayList <Puntuacion> obtenerRanking(){
        ArrayList <Puntuacion> puntuacion = new ArrayList();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String sql = "select id_producto,avg(calificacion) calificacion from ranking\n" +
                         "group by id_producto\n" +
                         "order by calificacion desc";
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                puntuacion.add(new Puntuacion(rs.getInt("id_producto"), rs.getInt("calificacion")));
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        
        return puntuacion;
    }
    public ArrayList <Usuario> obtenerUsuarios(){
        ArrayList <Usuario> usuarios = new ArrayList();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String sql = "select * from usuarios";
            pst = conectarABD().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {  
                usuarios.add(new Usuario(rs.getString("id_suscripcion"),rs.getString("id_periodicidad"),rs.getString("id_usuario"),rs.getString("id_identificacion"),
                rs.getString("contraseña"),rs.getString("nombres"),rs.getString("apellidos"),rs.getString("correo"),rs.getString("direccion"),
                rs.getString("domicilio"),rs.getBoolean("estado"),rs.getString("fecha_creacion"),rs.getString("ultimo_ingreso")));
            }
        }catch(Exception e){}
        finally{
            try{
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(conectarABD() != null) conectarABD().close();
            }catch(Exception e){}
        }
        return usuarios;
    }
    
    public void actualizarEstadoCompras(int id_compra) {
        try {
            String createTable = "update compras set estado = true\n" +
                                 "where id_compra = "+id_compra+"";
            Statement statement = conectarABD().createStatement();
            boolean rs = statement.execute(createTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void actualizarFechaUsuarios(String id_usuario) {
        try {
            String createTable = "update usuarios set ultimo_ingreso = now()\n" +
                                 "where id_usuario = '"+id_usuario+"'";
            Statement statement = conectarABD().createStatement();
            boolean rs = statement.execute(createTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
       public static void main(String[] args){
        Consulta con = new Consulta();
        
        //con.actualizarSuscripcion("1", "cdtello");
        //int resultado = con.obtenerPromedioRanking(1);
        //int resultado = con.obtenerUltimaFactura("cdtello");
        Compras compras = con.comprasNoCalificadas("cdtello").get(0);
        Compras compra1 = con.comprasNoCalificadas("cdtello").get(1);
        System.out.println(compras.getId_producto());
        System.out.println(compra1.getId_producto());
    }

}

