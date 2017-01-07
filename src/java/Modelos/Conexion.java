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
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class Conexion {
    private final String url, usuario, pwd;
    private Connection conexion;
    public java.sql.Connection con;
    public Conexion(){
        url = "jdbc:postgresql://localhost:5432/Proyecto";
        usuario="postgres";
        pwd ="abcd1234";
        //url = "jdbc:postgresql://172.16.7.114:5432/postgres";
        //usuario="webadmin";
        //pwd ="QDScnk12333";
    }
    
    public Connection conectarABD(){
        
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println( "Driver Cargado" );
        
        } catch(ExceptionInInitializerError e){
            System.out.println(" the initialization provoked by this method fails"+e);
        }
        catch (ClassNotFoundException ex) {
            System.out.println( "No se pudo cargar el driver, no se encontró la clase."+ex );
        }
              
        try{
            conexion = DriverManager.getConnection(url, usuario, pwd);
            System.out.println( "Conexion Abierta" );
            return conexion;
        } catch( SQLException e ) {
            System.out.println( "No se pudo abrir."+e );
            return null;
        }
        
    }//fin metodo conectarABD
    
    public void cerrarConexion(Connection c){
            try{
                 c.close();
            } catch( SQLException e ) {
                System.out.println( "No se pudo cerrar."+e );
            }
        }//fin metodo cerrarConexion
       /* public static void main(String[] args) throws SQLException 
    {

        Conexion con = new Conexion();
        con.conectarABD();
        
            
    }*/

}
