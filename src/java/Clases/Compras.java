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
public class Compras {
    
    private int id_compra;
    private int id_factura;
    private int id_producto;
    private String id_usuario;
    private int cantidad;
    private int total;
    private boolean estado;

    public Compras(int id_compra, int id_factura, int id_producto, String id_usuario, int cantidad, int total, boolean estado) {
        this.id_compra = id_compra;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
    }
        public Compras() {
        this.id_compra = 0;
        this.id_factura = 0;
        this.id_producto = 0;
        this.id_usuario = "";
        this.cantidad = 0;
        this.total = 0;
        this.estado = false;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
        

}
