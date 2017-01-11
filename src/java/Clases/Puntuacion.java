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
public class Puntuacion {
    private int id_producto;
    private int calificacion;

    public Puntuacion(int id_producto, int calificacion) {
        this.id_producto = id_producto;
        this.calificacion = calificacion;
    }
    public Puntuacion() {
        this.id_producto = 0;
        this.calificacion = 0;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
}
