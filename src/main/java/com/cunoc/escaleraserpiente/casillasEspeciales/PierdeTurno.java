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
public class PierdeTurno extends Casilla{
    
    public PierdeTurno(int id, Ficha ficha, Color color) {
        super(id, ficha, color);
    }
    public PierdeTurno(int id) {
        super(id, null, Color.RED);
    }

}
