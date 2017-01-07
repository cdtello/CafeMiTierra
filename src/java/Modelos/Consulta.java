/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Clases.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                
                usu.setId(respuesta.getString("id_usuario"));
                usu.setUsuario(respuesta.getString("nombres"));
                usu.setContraseña(respuesta.getString("contraseña"));
                return usu;            
            }
        }
        return usu;
    }
    

}

