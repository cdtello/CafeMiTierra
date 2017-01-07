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
public class Producto {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private int costo;
    private int precio;
    private int descuento;
    private int cantidad;
    private String fecha;
    private String categoria;
    private String region;
    private String finca;
    private String variedad;
    private String perfil;
    private String cosecha;
    private boolean estado;

    public Producto(int id, String nombre, String descripcion, String imagen, int costo, int precio, int descuento, int cantidad, String fecha, String categoria, String region, String finca, String variedad, String perfil, String cosecha, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.costo = costo;
        this.precio = precio;
        this.descuento = descuento;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.categoria = categoria;
        this.region = region;
        this.finca = finca;
        this.variedad = variedad;
        this.perfil = perfil;
        this.cosecha = cosecha;
        this.estado = estado;
    }
    public Producto()
    {}
  
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getDescuento() {
        return descuento;
    }
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getFinca() {
        return finca;
    }
    public void setFinca(String finca) {
        this.finca = finca;
    }
    public String getVariedad() {
        return variedad;
    }
    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public String getCosecha() {
        return cosecha;
    }
    public void setCosecha(String cosecha) {
        this.cosecha = cosecha;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
