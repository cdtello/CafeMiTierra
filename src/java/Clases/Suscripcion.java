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
public class Suscripcion {
    private String id_suscripcion;
    private String nombre;
    private int costo;

    public Suscripcion(String id_suscripcion, String nombre, int costo) {
        this.id_suscripcion = id_suscripcion;
        this.nombre = nombre;
        this.costo = costo;
    }
    
    public Suscripcion() {
        this.id_suscripcion = "";
        this.nombre = "";
        this.costo = 0;
    }

    public String getId_suscripcion() {
        return id_suscripcion;
    }

    public void setId_suscripcion(String id_periodicidad) {
        this.id_suscripcion = id_periodicidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
     
}
