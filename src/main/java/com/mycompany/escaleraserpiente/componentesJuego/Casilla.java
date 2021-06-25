/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escaleraserpiente.componentesJuego;

/**
 *
 * @author drymnz
 */
public abstract class Casilla {
    private int id;
    private Ficha ficha;
    // constructor
    public Casilla(int id,Ficha ficha){
        this.id = id;
        this.ficha = ficha;
    }
    public Casilla(int id){
        this(id, null);
    }
    // fin constructor
    public abstract void cambiarColor();
}
