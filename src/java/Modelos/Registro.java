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
    public void IngresoProductos (String id, String nom, String descri, String img, String costo, String precio, String descu, String cant, String id_u, String id_tip, String id_pres, String id_reg, String id_fin, String id_var, String id_perfil, String id_cos) throws SQLException
    {
        Connection con = conectar.conectarABD();
        instruccion = con.createStatement();
        
        String Consulta = "select IngresarProductos("+id+","+"'"+nom+"'"+","+"'"+descri+"'"+","+"'"+img+"'"+","+costo+","+precio+","+descu+","
               +cant+","+"'"+id_u+"'"+","+"'"+id_tip+"'"+","+"'"+id_pres+"'"+","+"'"+id_reg+"'"+","+id_fin+","+"'"+id_var+"'"+","+"'"+id_perfil+"'"+","+"'"+id_cos+"'"+")";
        instruccion.execute(Consulta);
        //Statement.executeQuery(Consulta);
        conectar.cerrarConexion(con);
    }
    

}

