/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Carlos
 */
public class Usuario {
    
    private String id_suscripcion;
    private String id_periodicidad;
    private String id_usuario;
    private String id_identificacion;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private String correo;
    private String direccion;
    private String domicilio;
    private boolean estado;
    private String fecha_creacion;
    private String ultimo_ingreso;

    public Usuario(String id_suscripcion, String id_periodicidad, String id_usuario, String id_identificacion, String contraseña, String nombres, String apellidos, String correo, String direccion, String domicilio, boolean estado, String fecha_creacion, String ultimo_ingreso) {
        this.id_suscripcion = id_suscripcion;
        this.id_periodicidad = id_periodicidad;
        this.id_usuario = id_usuario;
        this.id_identificacion = id_identificacion;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.domicilio = domicilio;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.ultimo_ingreso = ultimo_ingreso;
    }
    public Usuario() {
        this.id_suscripcion = "";
        this.id_periodicidad = "";
        this.id_usuario = "";
        this.id_identificacion = "";
        this.contraseña = "";
        this.nombres = "";
        this.apellidos = "";
        this.correo = "";
        this.direccion = "";
        this.domicilio = "";
        this.estado = false;
        this.fecha_creacion = "";
        this.ultimo_ingreso = "";
    }

    public String getId_suscripcion() {
        return id_suscripcion;
    }

    public void setId_suscripcion(String id_suscripcion) {
        this.id_suscripcion = id_suscripcion;
    }

    public String getId_periodicidad() {
        return id_periodicidad;
    }

    public void setId_periodicidad(String id_periodicidad) {
        this.id_periodicidad = id_periodicidad;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_identificacion() {
        return id_identificacion;
    }

    public void setId_identificacion(String id_identificacion) {
        this.id_identificacion = id_identificacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getUltimo_ingreso() {
        return ultimo_ingreso;
    }

    public void setUltimo_ingreso(String ultimo_ingreso) {
        this.ultimo_ingreso = ultimo_ingreso;
    }
    
}