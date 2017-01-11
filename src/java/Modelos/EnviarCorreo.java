/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class EnviarCorreo {

  public void SendMail(String id) throws SQLException {
      
      //OBTENER CORREO TENIENDO PRIMERO EL ID
        Conexion conectar = new Conexion();
        ResultSet respuesta;
        Statement instruccion;
        String correo = "";
        String pass = "";
        String usuario = "";
        String mensaje = "";
        Connection con = conectar.conectarABD();
        instruccion = con.createStatement();
        
        String Consulta = "Select * from usuarios where id_identificacion="+"'"+id+"'";
        //System.out.print("buscando");
        respuesta = instruccion.executeQuery(Consulta);
        conectar.cerrarConexion(con);
        while(respuesta.next())
        {
            if(id.equals(respuesta.getString("id_identificacion")) )
            {
                 correo = respuesta.getString("correo");
                 pass = respuesta.getString("contraseña");   
                 usuario = respuesta.getString("id_usuario");
            }

        }
        if(correo.equals(""))
        {
            System.out.println("No encontrado");
        }
        else
        {  
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            //props.put("mail.smtp.port", "465");
            props.put("mail.smtp.port", "587");
        
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("cafe.mi.tierra.univalle@gmail.com", "cafemitierra");
                        }
                    });
 
            try {
 
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("cafe.mi.tierra.univalle@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(correo));
                message.setSubject("Recuperar Contraseña");
                mensaje = "USUARIO :       " + usuario
                          +"\nCONTRASEÑA :   " + pass;
                        
                message.setText(mensaje);
                
 
                Transport.send(message);
                System.out.println("Correo Enviado");
 
            } catch (MessagingException e) {
            
            }
    }

  }
  //********************************************************
  //********************************************************
    public void emailRegistro(String usuario, String correo, String pass,String suscripcion) throws SQLException {
      
      //OBTENER CORREO TENIENDO PRIMERO EL ID


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("cafe.mi.tierra.univalle@gmail.com", "cafemitierra");
                    }
                });
 
        try {
            String sus = "N/A";
            if(suscripcion.compareTo("3")==0)
            {
                sus = "NINGUNA";
            }
            else if(suscripcion.compareTo("1")==0)
            {
                sus = "PROBADITA";
            }
            else if(suscripcion.compareTo("2")==0)
            {
                sus = "CAFE MI TIERRA";
            }
         
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("cafe.mi.tierra.univalle@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo));
            message.setSubject("REGISTRO SATISFACTORIO");
            //MENSAJE QUE SE ENVIARA EN ESTA  LINEA
            
            String mensaje="Se ha registrado satisfactoriamente\n"
                    + "USUARIO :         "+usuario
                    + "\nCONTRASEÑA :    "+pass
                    + "\nSUSCRIPCION :   "+sus;
            message.setText(mensaje);
 
            Transport.send(message);
            System.out.println("Correo Enviado");
 
        } catch (MessagingException e) {   
        }
  }
  //********************************************************
  //********************************************************
  
    /*  public static void main(String[] args) throws SQLException 
    {
       EnviarCorreo envio = new EnviarCorreo();
       envio.SendMail("1144066632");
    }*/
}