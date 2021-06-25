/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escaleraserpiente.Usuario;

/**
 *
 * @author drymnz
 */
public class Usuario {
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
    
}
