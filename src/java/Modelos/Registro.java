/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Carlos
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */
public class Registro extends Conexion{
    
    Conexion conectar = new Conexion();
    ResultSet respuesta;
    Statement instruccion;
    public void Ingreso (String usuario,String password,String nombre,String apellido,String id,String correo,String direccion,String domicilio,String suscripcion) throws SQLException
    {
        Connection con = conectar.conectarABD();
        instruccion = con.createStatement();
        
        String Consulta = "select RegistrarCliente("+"'"+usuario+"'"+","+"'"+password+"'"+","+"'"+nombre+"'"+","+"'"+apellido+"'"+","+"'"+id+"'"+","+"'"+correo+"'"+","+"'"+direccion+"'"+","
               +"'"+domicilio+"'"+","+"'"+suscripcion+"'"+")";
        instruccion.execute(Consulta);
        //Statement.executeQuery(Consulta);
        conectar.cerrarConexion(con);
    }
    public void IngresoProductos (String id_producto, String nombre, String descripcion, String imagen, String precio) throws SQLException
    {
        Connection con = conectar.conectarABD();
        instruccion = con.createStatement();
        
        String Consulta = "insert into productos(id_producto, nombre, descripcion, imagen, precio, fecha_creacion, estado)\n" +
                          "values ("+id_producto+", '"+nombre+"', '"+descripcion+"', 'css/images/productos/"+imagen+"', "+precio+", now(), true)";
        instruccion.execute(Consulta);
        //Statement.executeQuery(Consulta);
        conectar.cerrarConexion(con);
    }
    

}

