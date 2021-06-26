/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import com.cunoc.escaleraserpiente.Usuario.Usuario;
import java.awt.Color;

/**
 *
 * @author drymnz
 */
public class Ficha {

    private Color color;
    private Usuario usuario;
    private Casilla ubicacion;
    
    // constructor
    public Ficha(Color color, Usuario usuario,Casilla ubicacion) {
        this.color = color;
        this.usuario = usuario;
        this.ubicacion = ubicacion;
    }
    // fin constructor

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Casilla getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Casilla ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}
