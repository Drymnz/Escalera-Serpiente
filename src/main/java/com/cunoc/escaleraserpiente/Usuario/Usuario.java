/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.Usuario;

import java.io.Serializable;

/**
 *
 * @author drymnz
 */
public class Usuario implements Serializable{
    private int id;
    private String nombre;
    private String apellido;
    private int cantidadPartidad;
    private int perdida;
    private int victoria;
    // construtores
    public Usuario (int id,String nombre,String apellido, int cantidadPartidad,int perdida,int victoria) {
        this.id =  id;
        this.nombre =  nombre;
        this.apellido =  apellido;
        this.cantidadPartidad =  cantidadPartidad;
        this.perdida =  perdida;
        this.victoria =  victoria;
    }
    public Usuario (int id,String nombre,String apellido) {
        this(id, nombre, apellido, 0, 0, 0);
    }
    //fin construtores

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCantidadPartidad() {
        return cantidadPartidad;
    }

    public void setCantidadPartidad(int cantidadPartidad) {
        this.cantidadPartidad = cantidadPartidad;
    }

    public int getPerdida() {
        return perdida;
    }

    public void setPerdida(int perdida) {
        this.perdida = perdida;
    }

    public int getVictoria() {
        return victoria;
    }

    public void setVictoria(int victoria) {
        this.victoria = victoria;
    }
    
}
