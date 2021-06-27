/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.casillasEspeciales;

import com.cunoc.escaleraserpiente.componentesJuego.Casilla;
import com.cunoc.escaleraserpiente.componentesJuego.Ficha;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author drymnz
 */
public class Serpiente extends Casilla{
    private Casilla cola;
    public Serpiente(int id, Ficha ficha, Color color) {
        super(id, ficha, color);
    }
    public Serpiente(int id, Ficha ficha) {
        this(id, ficha, Color.GREEN);
    }
    public Serpiente(int id) {
        this(id, null, Color.GREEN);
    }
  
    
}
