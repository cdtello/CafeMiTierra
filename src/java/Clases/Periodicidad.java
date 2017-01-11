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
public class Periodicidad {
    
    private String id_periodicidad;
    private String nombre;
    private int costo;

    public Periodicidad(String id_periodicidad, String nombre, int costo) {
        this.id_periodicidad = id_periodicidad;
        this.nombre = nombre;
        this.costo = costo;
    }
    public Periodicidad() {
        this.id_periodicidad = "";
        this.nombre = "";
        this.costo = 0;
    }

    public String getId_periodicidad() {
        return id_periodicidad;
    }

    public void setId_periodicidad(String id_periodicidad) {
        this.id_periodicidad = id_periodicidad;
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
