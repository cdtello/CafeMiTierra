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
public class Ranking {
    
    private int id_ranking;
    private int id_producto;
    private String id_usuario;
    private String comentario;
    private int calificacion;

    public Ranking(int id_ranking, int id_producto, String id_usuario, String comentario, int calificacion) {
        this.id_ranking = id_ranking;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public Ranking() {
        this.id_ranking = 0;
        this.id_producto = 0;
        this.id_usuario = "";
        this.comentario = "";
        this.calificacion = 0;
    }

    public int getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(int id_ranking) {
        this.id_ranking = id_ranking;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
}
