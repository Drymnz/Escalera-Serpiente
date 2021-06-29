/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.casillasEspeciales;

import com.cunoc.escaleraserpiente.componentesJuego.Casilla;
import com.cunoc.escaleraserpiente.componentesJuego.Ficha;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author drymnz
 */
public class Serpiente extends Casilla{
    private Casilla cola;
    
    public Serpiente(int id, Ficha ficha, Color color,Casilla cola) {
        super(id, ficha, color);
        this.cola = cola;
    }
    public Serpiente(int id,Casilla cola) {
        this(id, null, Color.WHITE,cola);
    }
    public Serpiente(int id) {
        this(id, null, Color.WHITE,null);
    }
  
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(new Color(30, 223, 49));
        g.setFont(new Font("Time new Roman", Font.PLAIN, this.getHeight()));
        g.drawString(" |-|", 10, this.getHeight());
    }

    public Casilla getCola() {
        return cola;
    }
    
}
