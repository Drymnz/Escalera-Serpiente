/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author drymnz
 */
public  class Casilla extends JPanel{
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
    // que cambie de color
    //public abstract void cambiarColor();
    public void pintar(Graphics G) {
        G.fillRect(0, 0, 10, 10);
    }
}
